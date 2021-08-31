package jp.co.soramitsu.iroha2

import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.logging.Logging
import io.ktor.client.features.websocket.ClientWebSocketSession
import io.ktor.client.features.websocket.WebSockets
import io.ktor.client.features.websocket.webSocket
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse
import io.ktor.http.cio.websocket.Frame
import io.ktor.http.cio.websocket.close
import io.ktor.http.cio.websocket.readBytes
import io.ktor.http.cio.websocket.send
import jp.co.soramitsu.iroha2.generated.crypto.Hash
import jp.co.soramitsu.iroha2.generated.datamodel.events.Event
import jp.co.soramitsu.iroha2.generated.datamodel.events.EventFilter.Pipeline
import jp.co.soramitsu.iroha2.generated.datamodel.events.EventSocketMessage
import jp.co.soramitsu.iroha2.generated.datamodel.events.EventSocketMessage.SubscriptionAccepted
import jp.co.soramitsu.iroha2.generated.datamodel.events.SubscriptionRequest
import jp.co.soramitsu.iroha2.generated.datamodel.events.VersionedEventSocketMessage
import jp.co.soramitsu.iroha2.generated.datamodel.events._VersionedEventSocketMessageV1
import jp.co.soramitsu.iroha2.generated.datamodel.events.pipeline.BlockRejectionReason
import jp.co.soramitsu.iroha2.generated.datamodel.events.pipeline.EntityType.Transaction
import jp.co.soramitsu.iroha2.generated.datamodel.events.pipeline.RejectionReason
import jp.co.soramitsu.iroha2.generated.datamodel.events.pipeline.Status
import jp.co.soramitsu.iroha2.generated.datamodel.events.pipeline.TransactionRejectionReason
import jp.co.soramitsu.iroha2.generated.datamodel.query.QueryResult
import jp.co.soramitsu.iroha2.generated.datamodel.query.VersionedSignedQueryRequest
import jp.co.soramitsu.iroha2.generated.datamodel.transaction.VersionedTransaction
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import java.net.URL
import java.util.concurrent.CompletableFuture
import jp.co.soramitsu.iroha2.generated.datamodel.events.pipeline.EventFilter as Filter

class Iroha2Client(private val peerUrl: URL, log: Boolean = false) : AutoCloseable {

    private val logger = LoggerFactory.getLogger(javaClass)

    private val client = lazy {
        HttpClient(CIO) {
            expectSuccess = true
            if (log) { install(Logging) }
            install(WebSockets)
        }
    }

    fun sendTransaction(transaction: TransactionBuilder.() -> VersionedTransaction): ByteArray {
        val signedTransaction = transaction(TransactionBuilder.builder())
        val hash = signedTransaction.hash()
        logger.debug("Sending transaction with hash {}", hash.hex())
        runBlocking {
            val response: HttpResponse = client.value.post("$peerUrl$INSTRUCTION_ENDPOINT") {
                body = signedTransaction.encode(VersionedTransaction)
            }
            response.receive<Unit>()
        }
        return hash
    }

    fun sendTransactionAsync(transaction: TransactionBuilder.() -> VersionedTransaction): CompletableFuture<ByteArray> {
        val signedTransaction = transaction(TransactionBuilder())
        return subscribeToTransactionStatus(signedTransaction.hash())
            .also { sendTransaction { signedTransaction } }
    }

    fun sendQuery(query: QueryBuilder.() -> VersionedSignedQueryRequest): QueryResult = sendQuery(AsIs, query)

    /**
     * Sends request to Iroha2 and extract payload.
     * {@see Extractors}
     */
    fun <T> sendQuery(extractor: ResultExtractor<T>, query: QueryBuilder.() -> VersionedSignedQueryRequest): T {
        logger.debug("Sending query")
        val signedQuery = query(QueryBuilder.builder())

        val rawBody = runBlocking {
            val response: HttpResponse = client.value.post("$peerUrl$QUERY_ENDPOINT") {
                this.body = signedQuery.encode(VersionedSignedQueryRequest)
            }
            response.receive<ByteArray>()
        }
        logger.debug("Received binary query: {}", rawBody.hex())
        return rawBody.decode(QueryResult).let(extractor::extract)
    }

    fun subscribeToTransactionStatus(hash: ByteArray): CompletableFuture<ByteArray> {
        val hexHash = hash.hex()
        logger.debug("Creating subscription to transaction status: {}", hexHash)
        val subscriptionRequest = VersionedEventSocketMessage.V1(
            _VersionedEventSocketMessageV1(
                EventSocketMessage.SubscriptionRequest(
                    SubscriptionRequest(
                        Pipeline(
                            Filter(Transaction(), Hash(hash))
                        )
                    )
                )
            )
        )
        val payload = subscriptionRequest.encode(VersionedEventSocketMessage)
        val result: CompletableFuture<ByteArray> = CompletableFuture()

        // todo use local scope instead
        GlobalScope.launch {
            client.value.webSocket(
                host = peerUrl.host,
                port = peerUrl.port,
                path = WS_ENDPOINT
            ) {
                logger.debug("WebSocket opened")
                send(payload)
                tryReadMessage<SubscriptionAccepted>(incoming.receive())
                logger.debug("Subscription was accepted by peer")
                while (true) {
                    when (val event = tryReadMessage<EventSocketMessage.Event>(incoming.receive()).event) {
                        is Event.Pipeline -> {
                            val eventInner = event.event
                            if (eventInner.entityType is Transaction && hash.contentEquals(eventInner.hash.array)) {
                                when (val status = eventInner.status) {
                                    is Status.Committed -> {
                                        logger.debug("Transaction {} committed", hexHash)
                                        result.complete(hash)
                                        ack(this)
                                        break
                                    }
                                    is Status.Rejected -> {
                                        logger.error(
                                            "Transaction {} was rejected by reason: `{}`",
                                            hexHash, getRejectionReason(status.rejectionReason)
                                        )
                                        result.completeExceptionally(RuntimeException("Transaction rejected"))
                                        ack(this)
                                        break
                                    }
                                    is Status.Validating -> {
                                        logger.debug("Transaction {} is validating", hexHash)
                                        ack(this)
                                    }
                                }
                            }
                        }
                        else -> result.completeExceptionally(RuntimeException("Expected message with type ${Event.Pipeline::class.qualifiedName} but was ${event::class.qualifiedName}"))
                    }
                    logger.debug("WebSocket is closing")
                    this.close()
                    logger.debug("WebSocket closed")
                }
            }
        }
        return result
    }

    /**
     * Sends message to peer event was accepted
     */
    private suspend fun ack(webSocket: ClientWebSocketSession) {
        val eventReceived = VersionedEventSocketMessage.V1(
            _VersionedEventSocketMessageV1(
                EventSocketMessage.EventReceived()
            )
        )
        webSocket.send(eventReceived.encode(VersionedEventSocketMessage))
    }

    /**
     * Extract rejection reason
     */
    private fun getRejectionReason(rejectionReason: RejectionReason): String {
        return when (rejectionReason) {
            is RejectionReason.Block -> when (rejectionReason.blockRejectionReason) {
                is BlockRejectionReason.ConsensusBlockRejection -> "Block was rejected during consensus"
            }
            is RejectionReason.Transaction -> when (val reason = rejectionReason.transactionRejectionReason) {
                is TransactionRejectionReason.InstructionExecution -> {
                    val details = reason.instructionExecutionFail
                    "Failed: `${details.reason}` during execution of instruction: ${details.instruction::class.qualifiedName}"
                }
                is TransactionRejectionReason.NotPermitted -> reason.notPermittedFail.reason
                is TransactionRejectionReason.SignatureVerification -> reason.signatureVerificationFail.reason
                is TransactionRejectionReason.UnexpectedGenesisAccountSignature -> "Genesis account can sign only transactions in the genesis block"
                is TransactionRejectionReason.UnsatisfiedSignatureCondition -> reason.unsatisfiedSignatureConditionFail.reason
            }
        }
    }

    /**
     * Tries to read message from the frame
     */
    private inline fun <reified T : EventSocketMessage> tryReadMessage(frame: Frame): T {
        return when (frame) {
            is Frame.Binary -> {
                when (val versionedMessage = frame.readBytes().decode(VersionedEventSocketMessage)) {
                    is VersionedEventSocketMessage.V1 -> {
                        val actualMessage = versionedMessage._VersionedEventSocketMessageV1.eventSocketMessage
                        actualMessage as? T
                            ?: throw RuntimeException("Expected `${T::class.qualifiedName}`, but was ${actualMessage::class.qualifiedName}")
                    }
                    else -> throw RuntimeException("Expected `${VersionedEventSocketMessage.V1::class.qualifiedName}`, but was `${versionedMessage::class.qualifiedName}`")
                }
            }
            else -> throw RuntimeException("Expected server will `${Frame.Binary::class.qualifiedName}` frame, but was `${frame::class.qualifiedName}`")
        }
    }

    companion object {
        const val INSTRUCTION_ENDPOINT = "/transaction"
        const val QUERY_ENDPOINT = "/query"
        const val WS_ENDPOINT = "/events"
    }

    override fun close() = client.value.close()
}
