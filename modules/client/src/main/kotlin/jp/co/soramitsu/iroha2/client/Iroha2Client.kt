@file:Suppress("UNCHECKED_CAST")

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
import io.ktor.client.plugins.websocket.webSocket
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.jackson.jackson
import io.ktor.websocket.Frame
import io.ktor.websocket.readBytes
import jp.co.soramitsu.iroha2.IrohaClientException
import jp.co.soramitsu.iroha2.TransactionRejectedException
import jp.co.soramitsu.iroha2.WebSocketProtocolException
import jp.co.soramitsu.iroha2.cast
import jp.co.soramitsu.iroha2.client.balancing.RoundRobinStrategy
import jp.co.soramitsu.iroha2.client.blockstream.BlockStreamContext
import jp.co.soramitsu.iroha2.client.blockstream.BlockStreamStorage
import jp.co.soramitsu.iroha2.client.blockstream.BlockStreamSubscription
import jp.co.soramitsu.iroha2.extract
import jp.co.soramitsu.iroha2.extractBlock
import jp.co.soramitsu.iroha2.generated.BlockMessage
import jp.co.soramitsu.iroha2.generated.EventBox
import jp.co.soramitsu.iroha2.generated.EventMessage
import jp.co.soramitsu.iroha2.generated.EventSubscriptionRequest
import jp.co.soramitsu.iroha2.generated.ForwardCursor
import jp.co.soramitsu.iroha2.generated.PipelineEventBox
import jp.co.soramitsu.iroha2.generated.QueryResponse
import jp.co.soramitsu.iroha2.generated.SignedQuery
import jp.co.soramitsu.iroha2.generated.SignedTransaction
import jp.co.soramitsu.iroha2.generated.TransactionRejectionReason
import jp.co.soramitsu.iroha2.generated.TransactionStatus
import jp.co.soramitsu.iroha2.hash
import jp.co.soramitsu.iroha2.height
import jp.co.soramitsu.iroha2.model.IrohaUrls
import jp.co.soramitsu.iroha2.query.QueryAndExtractor
import jp.co.soramitsu.iroha2.toHex
import jp.co.soramitsu.iroha2.transaction.Filters
import jp.co.soramitsu.iroha2.transaction.TransactionBuilder
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.math.BigInteger
import java.net.URI
import java.net.URL
import java.time.Duration
import kotlin.coroutines.CoroutineContext

/**
 * Iroha2 Client
 *
 * @param credentials <username>:<password>
 */
@Suppress("unused")
open class Iroha2Client(
    open val urls: List<IrohaUrls>,
    open val log: Boolean = false,
    open val credentials: String? = null,
    open val eventReadTimeoutInMills: Long = 250,
    open val eventReadMaxAttempts: Int = 10,
    override val coroutineContext: CoroutineContext = Dispatchers.IO + SupervisorJob(),
) : RoundRobinStrategy(urls),
    AutoCloseable,
    CoroutineScope {

    constructor(
        url: IrohaUrls,
        log: Boolean = false,
        credentials: String? = null,
        eventReadTimeoutInMills: Long = 250,
        eventReadMaxAttempts: Int = 10,
    ) : this(mutableListOf(url), log, credentials, eventReadTimeoutInMills, eventReadMaxAttempts)

    constructor(
        apiUrl: URL,
        peerUrl: URL,
        log: Boolean = false,
        credentials: String? = null,
        eventReadTimeoutInMills: Long = 250,
        eventReadMaxAttempts: Int = 10,
    ) : this(
        IrohaUrls(apiUrl, peerUrl),
        log,
        credentials,
        eventReadTimeoutInMills,
        eventReadMaxAttempts,
    )

    constructor(
        apiUrl: String,
        peerUrl: String,
        log: Boolean = true,
        credentials: String? = null,
        eventReadTimeoutInMills: Long = 250,
        eventReadMaxAttempts: Int = 10,
    ) : this(
        URI(apiUrl).toURL(),
        URI(peerUrl).toURL(),
        log,
        credentials,
        eventReadTimeoutInMills,
        eventReadMaxAttempts,
    )

    companion object {
        const val TRANSACTION_ENDPOINT = "/transaction"
        const val PENDING_TRANSACTIONS_ENDPOINT = "/pending_transactions"
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
     * Send a transaction to an Iroha peer without waiting for the final transaction status (committed or rejected).
     *
     * With this method, the state of the transaction is not tracked after the peer responses with 2xx status code,
     * which means that the peer accepted the transaction and the transaction passed the stateless validation.
     */
    suspend fun fireAndForget(transaction: TransactionBuilder.() -> SignedTransaction): ByteArray {
        val signedTransaction = transaction(TransactionBuilder.builder())
        val hash = signedTransaction.hash()
        logger.debug("Sending transaction with hash {}", hash.toHex())
        val response: HttpResponse = client.post("${getApiUrl()}$TRANSACTION_ENDPOINT") {
            setBody(SignedTransaction.encode(signedTransaction))
        }
        response.body<Unit>()
        return hash
    }

    /**
     * Send a transaction to an Iroha peer and wait until it is committed or rejected.
     */
    suspend fun sendTransaction(transaction: TransactionBuilder.() -> SignedTransaction): CompletableDeferred<ByteArray> = coroutineScope {
        val signedTransaction = transaction(TransactionBuilder())

        val lock = Mutex(locked = true)
        subscribeToTransactionStatus(signedTransaction.hash()) {
            lock.unlock() // 2. unlock after subscription
        }.also {
            lock.lock() // 1. waiting for unlock
            fireAndForget { signedTransaction }
        }
    }

    /**
     * @see subscribeToBlockStream below
     */
    @JvmOverloads
    fun subscribeToBlockStream(
        from: Long = 1,
        count: Long,
        autoStart: Boolean = true,
    ): Pair<Iterable<BlockStreamStorage>, BlockStreamSubscription> = subscribeToBlockStream(
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
    fun subscribeToBlockStream(
        from: Long = 1,
        onBlock: (block: BlockMessage) -> Any,
        onFailure: suspend (t: Throwable) -> Unit = { throwable ->
            logger.error("Block stream was closed with an exception: {}", throwable.message)
        },
        cancelIf: suspend (block: BlockMessage) -> Boolean = { false },
        onClose: () -> Unit = { logger.info("Block stream subscription execution was finished") },
        autoStart: Boolean = true,
    ): Pair<Iterable<BlockStreamStorage>, BlockStreamSubscription> = subscribeToBlockStream(
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
    fun subscribeToBlockStream(
        from: Long = 1,
        blockStreamStorages: Iterable<BlockStreamStorage>,
        onClose: () -> Unit = { logger.info("Block stream subscription execution was finished") },
        autoStart: Boolean = true,
    ): Pair<Iterable<BlockStreamStorage>, BlockStreamSubscription> {
        val context = BlockStreamContext(
            getApiUrl(),
            client,
            from,
            blockStreamStorages,
            onClose,
        )
        return blockStreamStorages to BlockStreamSubscription.getInstance(context)
            .apply { if (autoStart) start() }
    }

    /**
     * Subscribe to track the transaction status
     */
    fun subscribeToTransactionStatus(hash: ByteArray) = subscribeToTransactionStatus(hash, null)

    private suspend fun sendQueryRequest(query: SignedQuery, cursor: ForwardCursor? = null): QueryResponse {
        val response: HttpResponse = client.post("${getApiUrl()}$QUERY_ENDPOINT") {
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

    /**
     * @param hash - Signed transaction hash
     * @param afterSubscription - Expression that is invoked after subscription
     */
    private fun subscribeToTransactionStatus(hash: ByteArray, afterSubscription: (() -> Unit)? = null): CompletableDeferred<ByteArray> {
        val hexHash = hash.toHex()
        logger.debug("Creating subscription to transaction status: {}", hexHash)

        val subscriptionRequest = eventSubscriberMessageOf(hash)
        val payload = EventSubscriptionRequest.encode(subscriptionRequest)
        val result: CompletableDeferred<ByteArray> = CompletableDeferred()
        val apiUrl = getApiUrl()

        launch {
            client.webSocket(
                host = apiUrl.host,
                port = apiUrl.port,
                path = WS_ENDPOINT,
            ) {
                logger.debug("WebSocket opened")
                send(Frame.Binary(true, payload))

                afterSubscription?.invoke()
                logger.debug("Subscription was accepted by peer")

                for (i in 1..eventReadMaxAttempts) {
                    try {
                        val income = readMessage(incoming.receive())
                        val processed = pipelineEventProcess(income, hash, hexHash)
                        if (processed != null) {
                            result.complete(processed)
                            break
                        }
                    } catch (e: TransactionRejectedException) {
                        result.completeExceptionally(e)
                        break
                    }
                    delay(eventReadTimeoutInMills)
                }
            }
        }
        return result
    }

    private fun pipelineEventProcess(
        eventPublisherMessage: EventMessage,
        hash: ByteArray,
        hexHash: String,
    ): ByteArray? {
        when (val event = eventPublisherMessage.eventBox) {
            is EventBox.Pipeline -> {
                val eventBox = event.pipelineEventBox
                if (eventBox is PipelineEventBox.Transaction && hash.contentEquals(eventBox.transactionEvent.hash.hash.arrayOfU8)) {
                    when (val status = eventBox.transactionEvent.status) {
                        is TransactionStatus.Approved -> {
                            logger.debug("Transaction {} approved", hexHash)
                            return hash
                        }

                        is TransactionStatus.Rejected -> {
                            val reason = status.transactionRejectionReason.message()
                            logger.error("Transaction {} was rejected by reason: `{}`", hexHash, reason)
                            throw TransactionRejectedException("Transaction rejected with reason '$reason'")
                        }

                        is TransactionStatus.Expired -> logger.debug("Transaction {} is expired", hexHash)
                        is TransactionStatus.Queued -> logger.debug("Transaction {} is queued", hexHash)
                    }
                }
                return null
            }

            else -> throw WebSocketProtocolException(
                "Expected message with type ${EventBox.Pipeline::class.qualifiedName}, " +
                    "but was ${event::class.qualifiedName}",
            )
        }
    }

    /**
     * Extract the rejection reason
     */
    private fun TransactionRejectionReason.message(): String = when (this) {
        is TransactionRejectionReason.InstructionExecution -> this.instructionExecutionFail.reason
        is TransactionRejectionReason.WasmExecution -> this.wasmExecutionFail.reason
        is TransactionRejectionReason.LimitCheck -> this.transactionLimitError.reason
        is TransactionRejectionReason.AccountDoesNotExist -> this.findError.extract()
        is TransactionRejectionReason.Validation -> this.validationFail.toString()
    }

    /**
     * Read the message from the frame
     */
    private fun readMessage(frame: Frame): EventMessage = when (frame) {
        is Frame.Binary -> {
            frame.readBytes().let {
                EventMessage.decode(it)
            }
        }

        else -> throw WebSocketProtocolException(
            "Expected server will `${Frame.Binary::class.qualifiedName}` frame, but was `${frame::class.qualifiedName}`",
        )
    }

    private fun eventSubscriberMessageOf(hash: ByteArray) = EventSubscriptionRequest(
        listOf(Filters.pipelineTransaction(hash)),
    )

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
