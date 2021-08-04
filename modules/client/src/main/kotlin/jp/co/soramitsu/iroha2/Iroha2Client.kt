package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.generated.crypto.Hash
import jp.co.soramitsu.iroha2.generated.datamodel.events.Event
import jp.co.soramitsu.iroha2.generated.datamodel.events.EventFilter.Pipeline
import jp.co.soramitsu.iroha2.generated.datamodel.events.EventSocketMessage
import jp.co.soramitsu.iroha2.generated.datamodel.events.SubscriptionRequest
import jp.co.soramitsu.iroha2.generated.datamodel.events.VersionedEventSocketMessage
import jp.co.soramitsu.iroha2.generated.datamodel.events._VersionedEventSocketMessageV1
import jp.co.soramitsu.iroha2.generated.datamodel.events.pipeline.EntityType.Transaction
import jp.co.soramitsu.iroha2.generated.datamodel.events.pipeline.Status
import jp.co.soramitsu.iroha2.generated.datamodel.transaction.VersionedTransaction
import jp.co.soramitsu.iroha2.utils.decode
import jp.co.soramitsu.iroha2.utils.encode
import jp.co.soramitsu.iroha2.utils.hash
import jp.co.soramitsu.iroha2.utils.hex
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString
import okio.ByteString.Companion.toByteString
import org.slf4j.LoggerFactory
import java.net.URL
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit
import jp.co.soramitsu.iroha2.generated.datamodel.events.pipeline.EventFilter as Filter

class Iroha2Client(private val peerUrl: URL) : AutoCloseable {

    private val logger = LoggerFactory.getLogger(javaClass)

    private val client = lazy {
        OkHttpClient.Builder()
            .connectTimeout(0, TimeUnit.SECONDS)
            .build()
    }

    fun sendTransaction(transaction: TransactionBuilder.() -> VersionedTransaction): ByteArray {
        val signedTransaction = transaction(TransactionBuilder.builder())
        val hash = signedTransaction.hash()
        logger.debug("Sending transaction with hash ${hex(hash)}")
        val encoded = encode(VersionedTransaction, signedTransaction)
        val request = Request.Builder()
            .url("$peerUrl$INSTRUCTION_ENDPOINT")
            .post(encoded.toRequestBody())
            .build()
        return client.value.newCall(request)
            .execute()
            .body!!
            .bytes()
    }

    fun sendTransactionAsync(transaction: TransactionBuilder.() -> VersionedTransaction): CompletableFuture<ByteArray> {
        val signedTransaction = transaction(TransactionBuilder.builder())
        val result = subscribeToTransactionStatus(signedTransaction.hash())
        sendTransaction { signedTransaction }
        return result
    }

    fun subscribeToTransactionStatus(hash: ByteArray): CompletableFuture<ByteArray> {
        val hexHash = hex(hash)
        logger.debug("Creating subscription to transaction status: $hexHash")
        val subscriptionRequest = VersionedEventSocketMessage.V1(
            _VersionedEventSocketMessageV1(
                EventSocketMessage.SubscriptionRequest(SubscriptionRequest(Pipeline(Filter(Transaction(), Hash(hash)))))
            )
        )
        val payload = encode(VersionedEventSocketMessage, subscriptionRequest)
        val result: CompletableFuture<ByteArray> = CompletableFuture()
        val request = Request.Builder()
            .url("$peerUrl$WS_ENDPOINT")
            .get()
            .build()
        client.value.newWebSocket(request, object : WebSocketListener() {
            override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
                logger.debug("WebSocket closed")
                super.onClosed(webSocket, code, reason)
            }

            override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                logger.debug("WebSocket is closing")
                super.onClosing(webSocket, code, reason)
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                logger.error("WebSocket error", t)
                result.completeExceptionally(t)
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                logger.debug("Received text message")
            }

            override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
                logger.debug("Received binary message: {}", bytes.hex())
                when (val event = tryReadEventSocketMessage(bytes.toByteArray())) {
                    is EventSocketMessage.SubscriptionAccepted -> {
                        logger.debug("Subscription was accepted")
                    }
                    is EventSocketMessage.Event -> {
                        when (event.event) {
                            is Event.Pipeline -> {
                                val event3 = event.event.event
                                if (event3.entityType is Transaction && hash.contentEquals(event3.hash.array)) {
                                    when (event3.status) {
                                        is Status.Committed -> {
                                            logger.debug("Transaction $hexHash committed")
                                            result.complete(hash)
                                            ack(webSocket)
                                            webSocket.close(1000, null)
                                        }
                                        is Status.Rejected -> {
                                            logger.debug("Transaction $hexHash was rejected by reason: ${event3.status.rejectionReason}")
                                            result.completeExceptionally(RuntimeException("Transaction rejected"))
                                            ack(webSocket)
                                            webSocket.close(1000, null)
                                        }
                                        is Status.Validating -> {
                                            logger.debug("Transaction $hexHash is validating")
                                            ack(webSocket)
                                        }
                                    }
                                }
                            }
                            else -> result.completeExceptionally(java.lang.RuntimeException("Expected message with type ${Event.Pipeline::class.qualifiedName} but got ${event.event::class.qualifiedName}"))
                        }
                    }
                }
            }

            override fun onOpen(webSocket: WebSocket, response: Response) {
                logger.error("WebSocket opened")
                webSocket.send(payload.toByteString())
            }
        })
        return result;
    }

    fun ack(ws: WebSocket) {
        val eventReceived = VersionedEventSocketMessage.V1(
            _VersionedEventSocketMessageV1(
                EventSocketMessage.EventReceived()
            )
        )
        ws.send(encode(VersionedEventSocketMessage, eventReceived).toByteString())
    }
    companion object {
        const val INSTRUCTION_ENDPOINT = "/instruction"
        const val QUERY_ENDPOINT = "/query"
        const val WS_ENDPOINT = "/events"
    }

    override fun close() {
       client.value.dispatcher.executorService.shutdown()
       client.value.connectionPool.evictAll()
    }
}

private fun tryReadEventSocketMessage(message: ByteArray): EventSocketMessage {
    val versionedMessage = decode(VersionedEventSocketMessage, message)
    if (versionedMessage is VersionedEventSocketMessage.V1) {
        return versionedMessage._VersionedEventSocketMessageV1.eventSocketMessage
    } else {
        throw RuntimeException("Expected '${VersionedEventSocketMessage.V1::class.qualifiedName}', but got '${versionedMessage::class.qualifiedName}'")
    }
}
