package jp.co.soramitsu.iroha2.client.blockstream

import io.ktor.client.plugins.websocket.webSocket
import io.ktor.http.HttpMethod
import io.ktor.websocket.close
import io.ktor.websocket.readBytes
import jp.co.soramitsu.iroha2.IrohaSdkException
import jp.co.soramitsu.iroha2.SingletonHolder
import jp.co.soramitsu.iroha2.cast
import jp.co.soramitsu.iroha2.client.Iroha2Client
import jp.co.soramitsu.iroha2.generated.BlockMessage
import jp.co.soramitsu.iroha2.generated.BlockSubscriptionRequest
import jp.co.soramitsu.iroha2.generated.NonZeroOfu64
import jp.co.soramitsu.iroha2.toFrame
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.math.BigInteger
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.coroutines.CoroutineContext

open class BlockStreamSubscription private constructor(
    private val context: BlockStreamContext,
) : CoroutineScope, AutoCloseable {

    override val coroutineContext: CoroutineContext = Dispatchers.IO

    open val logger: Logger = LoggerFactory.getLogger(javaClass)
    private val source: ConcurrentHashMap<UUID, BlockStreamStorage> = ConcurrentHashMap()
    private val running: AtomicBoolean = AtomicBoolean(false)
    private val stopped: AtomicBoolean = AtomicBoolean(false)

    private lateinit var runJob: Job

    init {
        subscribe(context.storages)
    }

    fun start(): BlockStreamSubscription {
        if (!running.getAndSet(true)) {
            runJob = run()
        }
        return this
    }

    fun subscribe(storage: BlockStreamStorage) = subscribe(listOf(storage))

    @Synchronized
    fun subscribe(storages: Iterable<BlockStreamStorage>) {
        logger.debug("Expanding subscription with ${storages.count()} storages")
        storages.forEach {
            source.putIfAbsent(it.id, it)?.run {
                logger.warn("Given id $id is already present in the subscription, not being added repeatedly")
            }
        }
        logger.debug("Block stream subscription has been expanded. Updated number of channels is ${source.size}")
    }

    fun <T> subscribeAndReceive(storage: BlockStreamStorage, collector: FlowCollector<T>) {
        subscribe(storage)
        receive(storage.id, collector)
    }

    fun <T> receive(actionId: UUID, collector: FlowCollector<T>) = launch {
        receive<T>(actionId).collect(collector)
    }

    fun <T> receive(actionId: UUID): Flow<T> {
        val storage = source[actionId] ?: throw IrohaSdkException("Flow#$actionId not found")
        return storage.channel.value.cast<Channel<T>>().receiveAsFlow().catch {
            storage.onFailure?.let { method -> method(it) }
        }
    }

    suspend fun stop() = withContext(NonCancellable) {
        if (!stopped.getAndSet(true)) {
            runJob.cancelAndJoin()
            destroy() // singleton instance of subscription
            logger.info("Unsubscribed from block streaming")
        }
        logger.warn("Block streaming is already closed")
    }

    override fun close() = runBlocking { stop() }

    @OptIn(DelicateCoroutinesApi::class)
    private fun run() = launch {
        val request = BlockSubscriptionRequest(
            NonZeroOfu64(
                BigInteger.valueOf(context.from),
            ),
        )
        context.client.webSocket(
            host = context.apiUrl.host,
            port = context.apiUrl.port,
            path = Iroha2Client.WS_ENDPOINT_BLOCK_STREAM,
            method = HttpMethod.Get,
        ) {
            try {
                logger.debug("WebSocket opened")
                send(BlockSubscriptionRequest.encode(request).toFrame())
                val idsToRemove = mutableListOf<UUID>()

                for (frame in incoming) {
                    logger.debug("Received frame: {}", frame)

                    val block = BlockMessage.decode(frame.readBytes())
                    source.forEach { (id, storage) ->
                        logger.debug("Executing {} action", id)
                        val result = storage.onBlock(block)
                        logger.debug("{} action result: {}", id, result)

                        val channel = storage.channel.value
                        when (channel.isClosedForSend) {
                            true -> logger.warn("Block stream channel#{} is already closed, not sending the action result", id)
                            false -> channel.send(result)
                        }
                        if (storage.cancelIf?.let { it(block) } == true) {
                            // idempotent
                            channel.close()
                            idsToRemove.add(id)
                            logger.info("Block stream channel#{} is closed and scheduled for removal", id)
                        }
                    }
                    if (idsToRemove.isNotEmpty()) {
                        idsToRemove.forEach {
                            source.remove(it)
                            logger.info("Block stream channel#{} is removed", it)
                        }
                        idsToRemove.clear()
                    }
                }
            } catch (e: CancellationException) {
                logger.info("Closing subscription WS")
                this.close()
                source.values.forEach { it.channel.value.close() }
                return@webSocket
            } finally {
                context.onClose()
            }
        }
    }

    companion object : SingletonHolder<BlockStreamSubscription, BlockStreamContext>(::BlockStreamSubscription)
}
