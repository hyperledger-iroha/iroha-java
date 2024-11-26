package jp.co.soramitsu.iroha2.client

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.module.SimpleModule
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BasicAuthCredentials
import io.ktor.client.plugins.auth.providers.basic
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.jackson.jackson
import jp.co.soramitsu.iroha2.IrohaClientException
import jp.co.soramitsu.iroha2.cast
import jp.co.soramitsu.iroha2.client.balancing.RoundRobinStrategy
import jp.co.soramitsu.iroha2.client.blockstream.BlockStreamContext
import jp.co.soramitsu.iroha2.client.blockstream.BlockStreamStorage
import jp.co.soramitsu.iroha2.client.blockstream.BlockStreamSubscription
import jp.co.soramitsu.iroha2.extractBlock
import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.BlockMessage
import jp.co.soramitsu.iroha2.generated.ForwardCursor
import jp.co.soramitsu.iroha2.generated.QueryResponse
import jp.co.soramitsu.iroha2.generated.SignedQuery
import jp.co.soramitsu.iroha2.height
import jp.co.soramitsu.iroha2.query.QueryAndExtractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.math.BigInteger
import java.net.URL
import java.security.KeyPair
import java.time.Duration
import java.util.UUID
import kotlin.coroutines.CoroutineContext

/**
 * Iroha2 Client
 *
 * @param credentials <username>:<password>
 */
open class Iroha2Client(
    open val apiURL: List<URL>,
    open val chain: UUID,
    open val authority: AccountId,
    open val keyPair: KeyPair,
    open val credentials: String? = null,
    open val log: Boolean = true,
    open val eventReadTimeoutInMills: Long = 250,
    open val eventReadMaxAttempts: Int = 10,
    override val coroutineContext: CoroutineContext = Dispatchers.IO + SupervisorJob(),
) : RoundRobinStrategy(apiURL),
    AutoCloseable,
    CoroutineScope {
    companion object {
        const val TRANSACTION_ENDPOINT = "/transaction"
        const val QUERY_ENDPOINT = "/query"
        const val WS_ENDPOINT = "/events"
        const val WS_ENDPOINT_BLOCK_STREAM = "/block/stream"
        const val HEALTH_ENDPOINT = "/health"
        const val STATUS_ENDPOINT = "/status"
        const val PEERS_ENDPOINT = "/peers"
        const val SCHEMA_ENDPOINT = "/schema"
        const val METRICS_ENDPOINT = "/metrics"
        const val CONFIGURATION_ENDPOINT = "/configuration"
    }

    open val logger: Logger = LoggerFactory.getLogger(javaClass)

    open val client by lazy {
        HttpClient(CIO) {
            expectSuccess = true
            if (log) {
                install(Logging)
            }
            install(WebSockets)
            install(ContentNegotiation) {
                jackson {
                    registerModule(
                        SimpleModule().apply {
                            addDeserializer(Duration::class.java, DurationDeserializer)
                        },
                    )
                }
            }
            credentials?.split(":")?.takeIf { it.size == 2 }?.let { pair ->
                install(Auth) {
                    basic {
                        credentials {
                            BasicAuthCredentials(pair[0], pair[1])
                        }
                        sendWithoutRequest {
                            true
                        }
                    }
                }
            }
            HttpResponseValidator {
                handleResponseExceptionWithRequest { exception, _ ->
                    val err = exception.takeIf { it is ClientRequestException }?.cast<ClientRequestException>()
                    val status = err?.response?.status
                    throw IrohaClientException(cause = exception, status = status)
                }
            }
        }
    }

    /**
     * Send a request to Iroha2 and extract paginated payload
     */
    suspend fun <T> sendQuery(queryAndExtractor: QueryAndExtractor<T>, cursor: ForwardCursor? = null): T {
        logger.debug("Sending query")
        val query = queryAndExtractor.query
        val extractor = queryAndExtractor.extractor

        val responseDecoded = sendQueryRequest(query, cursor)
        val finalResult = responseDecoded.let { extractor.extract(it) }
        return finalResult
    }

    /**
     * @see blocks below
     */
    @JvmOverloads
    fun blocks(
        from: Long = 1,
        count: Long,
        autoStart: Boolean = true,
    ): Pair<Iterable<BlockStreamStorage>, BlockStreamSubscription> = blocks(
        from,
        onBlock = { block -> block },
        cancelIf = { block -> block.extractBlock().height().u64 == BigInteger.valueOf(from + count - 1) },
        autoStart = autoStart,
    )

    /**
     * Subscribe to block streaming. Returns null if the subscription has already been received
     *
     * @param from - block number to start from
     * @param onBlock - the code that will be invoked after a new block received
     * @param onFailure - the code that will be invoked on exception throwing
     * @param cancelIf - if the condition returns true then the channel will be closed
     * @param onClose - the code that will be invoked right before closing
     */
    @JvmOverloads
    fun blocks(
        from: Long = 1,
        onBlock: (block: BlockMessage) -> Any,
        onFailure: suspend (t: Throwable) -> Unit = { throwable ->
            logger.error("Block stream was closed with an exception: {}", throwable.message)
        },
        cancelIf: suspend (block: BlockMessage) -> Boolean = { false },
        onClose: () -> Unit = { logger.info("Block stream subscription execution was finished") },
        autoStart: Boolean = true,
    ): Pair<Iterable<BlockStreamStorage>, BlockStreamSubscription> = blocks(
        from,
        listOf(
            BlockStreamStorage(
                onBlock,
                cancelIf,
                onFailure,
            ),
        ),
        onClose,
        autoStart,
    )

    /**
     * Subscribe to block streaming. Returns null if the subscription has already been received
     *
     * @param from - block number to start from
     * @param blockStreamStorages - wrapper for the code blocks that represent logic
     * of a block received processing, cancellation condition and error processing
     * @param onClose - the code that will be invoked right before closing
     * @param autoStart - whether websocket is going to be receiving blocks immediately,
     * otherwise calling 'start' method required
     */
    @JvmOverloads
    fun blocks(
        from: Long = 1,
        blockStreamStorages: Iterable<BlockStreamStorage>,
        onClose: () -> Unit = { logger.info("Block stream subscription execution was finished") },
        autoStart: Boolean = true,
    ): Pair<Iterable<BlockStreamStorage>, BlockStreamSubscription> {
        val context = BlockStreamContext(
            getApiURL(),
            client,
            from,
            blockStreamStorages,
            onClose,
        )
        return blockStreamStorages to BlockStreamSubscription.getInstance(context)
            .apply { if (autoStart) start() }
    }

    private suspend fun sendQueryRequest(query: SignedQuery, cursor: ForwardCursor? = null): QueryResponse {
        val response: HttpResponse = client.post("${getApiURL()}$QUERY_ENDPOINT") {
            if (cursor != null) {
                parameter("query", cursor.query)
                parameter("cursor", cursor.cursor.u64)
            } else {
                setBody(SignedQuery.encode(query))
            }
        }
        return response.body<ByteArray>().let { QueryResponse.decode(it) }.cast<QueryResponse>()
    }

//    private suspend fun <T> getQueryResultWithCursor(
//        queryAndExtractor: QueryAndExtractor<T>,
//        queryCursor: ForwardCursor? = null,
//    ): MutableList<QueryOutputBatchBox> {
//        val resultList = mutableListOf<QueryOutputBatchBox>()
//        val responseDecoded = sendQueryRequest(queryAndExtractor.query, queryCursor)
//        resultList.addAll(
//            queryAndExtractor.extractor.extract(responseDecoded.cast<QueryResponse.Iterable>()),
//        )
//        val cursor = responseDecoded.cast<QueryResponse.Iterable>().queryOutput.continueCursor
//        return when (cursor?.cursor) {
//            null -> resultList
//            else -> {
//                resultList.addAll(getQueryResultWithCursor(queryAndExtractor, cursor))
//                resultList
//            }
//        }
//    }

    object DurationDeserializer : JsonDeserializer<Duration>() {
        override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Duration {
            val pairs: Map<String, Long> =
                p.readValueAs(object : TypeReference<Map<String, Long>>() {})
            val seconds = pairs["secs"] ?: throw JsonMappingException.from(
                p,
                "Expected `secs` item for duration deserialization",
            )
            val nanos = pairs["nanos"] ?: throw JsonMappingException.from(
                p,
                "Expected `nanos` item for duration deserialization",
            )
            return Duration.ofSeconds(seconds, nanos)
        }
    }

    override fun close() = client.close()
}
