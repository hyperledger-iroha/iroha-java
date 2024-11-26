package jp.co.soramitsu.iroha2

import io.ktor.client.call.body
import io.ktor.client.plugins.websocket.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.websocket.*
import jp.co.soramitsu.iroha2.client.Iroha2Client
import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.BlockEventFilter
import jp.co.soramitsu.iroha2.generated.BlockStatus
import jp.co.soramitsu.iroha2.generated.BurnOfNumericAndAsset
import jp.co.soramitsu.iroha2.generated.BurnOfu32AndTrigger
import jp.co.soramitsu.iroha2.generated.EventBox
import jp.co.soramitsu.iroha2.generated.EventFilterBox
import jp.co.soramitsu.iroha2.generated.EventMessage
import jp.co.soramitsu.iroha2.generated.EventSubscriptionRequest
import jp.co.soramitsu.iroha2.generated.ExecuteTrigger
import jp.co.soramitsu.iroha2.generated.GrantOfPermissionAndAccount
import jp.co.soramitsu.iroha2.generated.GrantOfPermissionAndRole
import jp.co.soramitsu.iroha2.generated.GrantOfRoleIdAndAccount
import jp.co.soramitsu.iroha2.generated.InstructionBox
import jp.co.soramitsu.iroha2.generated.MintOfNumericAndAsset
import jp.co.soramitsu.iroha2.generated.MintOfu32AndTrigger
import jp.co.soramitsu.iroha2.generated.PipelineEventBox
import jp.co.soramitsu.iroha2.generated.PipelineEventFilterBox
import jp.co.soramitsu.iroha2.generated.RegisterOfAccount
import jp.co.soramitsu.iroha2.generated.RegisterOfAsset
import jp.co.soramitsu.iroha2.generated.RegisterOfAssetDefinition
import jp.co.soramitsu.iroha2.generated.RegisterOfDomain
import jp.co.soramitsu.iroha2.generated.RegisterOfPeer
import jp.co.soramitsu.iroha2.generated.RegisterOfRole
import jp.co.soramitsu.iroha2.generated.RegisterOfTrigger
import jp.co.soramitsu.iroha2.generated.RemoveKeyValueOfAccount
import jp.co.soramitsu.iroha2.generated.RemoveKeyValueOfAsset
import jp.co.soramitsu.iroha2.generated.RemoveKeyValueOfAssetDefinition
import jp.co.soramitsu.iroha2.generated.RemoveKeyValueOfDomain
import jp.co.soramitsu.iroha2.generated.RemoveKeyValueOfTrigger
import jp.co.soramitsu.iroha2.generated.RevokeOfPermissionAndAccount
import jp.co.soramitsu.iroha2.generated.RevokeOfPermissionAndRole
import jp.co.soramitsu.iroha2.generated.RevokeOfRoleIdAndAccount
import jp.co.soramitsu.iroha2.generated.SetKeyValueOfAccount
import jp.co.soramitsu.iroha2.generated.SetKeyValueOfAsset
import jp.co.soramitsu.iroha2.generated.SetKeyValueOfAssetDefinition
import jp.co.soramitsu.iroha2.generated.SetKeyValueOfDomain
import jp.co.soramitsu.iroha2.generated.SetKeyValueOfTrigger
import jp.co.soramitsu.iroha2.generated.SignedTransaction
import jp.co.soramitsu.iroha2.generated.TransactionEventFilter
import jp.co.soramitsu.iroha2.generated.TransactionRejectionReason
import jp.co.soramitsu.iroha2.generated.TransactionStatus
import jp.co.soramitsu.iroha2.generated.TransferOfAccountAndAssetDefinitionIdAndAccount
import jp.co.soramitsu.iroha2.generated.TransferOfAccountAndDomainIdAndAccount
import jp.co.soramitsu.iroha2.generated.TransferOfAssetAndMetadataAndAccount
import jp.co.soramitsu.iroha2.generated.TransferOfAssetAndNumericAndAccount
import jp.co.soramitsu.iroha2.generated.UnregisterOfAccount
import jp.co.soramitsu.iroha2.generated.UnregisterOfAsset
import jp.co.soramitsu.iroha2.generated.UnregisterOfAssetDefinition
import jp.co.soramitsu.iroha2.generated.UnregisterOfDomain
import jp.co.soramitsu.iroha2.generated.UnregisterOfPeer
import jp.co.soramitsu.iroha2.generated.UnregisterOfRole
import jp.co.soramitsu.iroha2.generated.UnregisterOfTrigger
import jp.co.soramitsu.iroha2.transaction.Instruction
import jp.co.soramitsu.iroha2.transaction.TransactionBuilder
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import java.math.BigInteger
import java.security.KeyPair

/**
 * Send a transaction to an Iroha peer without waiting for the final transaction status (committed or rejected).
 *
 * With this method, the state of the transaction is not tracked after the peer responses with 2xx status code,
 * which means that the peer accepted the transaction and the transaction passed the stateless validation.
 */
private suspend fun Iroha2Client.fireAndForget(signedTransaction: SignedTransaction): ByteArray {
    val hash = signedTransaction.hash()
    logger.debug("Sending transaction with hash {}", hash.toHex())
    val response: HttpResponse = client.post("${getApiURL()}${Iroha2Client.TRANSACTION_ENDPOINT}") {
        setBody(SignedTransaction.encode(signedTransaction))
    }
    response.body<Unit>()
    return hash
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
    listOf(
        EventFilterBox.Pipeline(PipelineEventFilterBox.Transaction(TransactionEventFilter(hash.asHashOf()))),
        EventFilterBox.Pipeline(PipelineEventFilterBox.Block(BlockEventFilter(status = BlockStatus.Applied()))),
    ),
)

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
 * @param hash - Signed transaction hash
 * @param afterSubscription - Expression that is invoked after subscription
 */
private fun Iroha2Client.subscribeToTransactionStatus(hash: ByteArray, afterSubscription: (() -> Unit)? = null): Deferred<ByteArray> {
    val hexHash = hash.toHex()
    logger.debug("Creating subscription to transaction status: {}", hexHash)

    val subscriptionRequest = eventSubscriberMessageOf(hash)
    val payload = EventSubscriptionRequest.encode(subscriptionRequest)
    val result: CompletableDeferred<ByteArray> = CompletableDeferred()
    val currApiURL = getApiURL()

    launch {
        client.webSocket(
            host = currApiURL.host,
            port = currApiURL.port,
            path = Iroha2Client.WS_ENDPOINT,
        ) {
            logger.debug("WebSocket opened")
            send(Frame.Binary(true, payload))

            afterSubscription?.invoke()
            logger.debug("Subscription was accepted by peer")

            var blockHeight: BigInteger? = null
            for (i in 1..eventReadMaxAttempts) {
                try {
                    val event = (readMessage(incoming.receive()).eventBox as EventBox.Pipeline).pipelineEventBox

                    if (event is PipelineEventBox.Block) {
                        if (event.blockEvent.status is BlockStatus.Applied && blockHeight == event.blockEvent.header.height.u64) {
                            logger.debug("Transaction {} applied", hexHash)
                            result.complete(hash)
                            break
                        }
                    } else if (event is PipelineEventBox.Transaction) {
                        when (val status = event.transactionEvent.status) {
                            is TransactionStatus.Queued -> logger.debug("Transaction {} is queued", hexHash)

                            is TransactionStatus.Rejected -> {
                                val reason = status.transactionRejectionReason.message()
                                logger.error("Transaction {} was rejected by reason: `{}`", hexHash, reason)
                                throw TransactionRejectedException("$hexHash: $reason")
                            }

                            is TransactionStatus.Approved -> {
                                if (hash.contentEquals(event.transactionEvent.hash.hash.arrayOfU8)) {
                                    blockHeight = event.transactionEvent.blockHeight!!.u64
                                    logger.debug("Transaction {} approved", hexHash)
                                }
                            }

                            is TransactionStatus.Expired -> throw TransactionRejectedException("Transaction expired")
                        }
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

suspend fun executeAs(
    isi: InstructionBox,
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = TransactionBuilder(client.chain, authority).addInstruction(isi).buildSigned(keyPair).executeAs(client)

suspend fun List<Instruction>.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun List<Instruction>.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = TransactionBuilder(client.chain, authority).addInstructions(this.map { it.asInstructionBox() }).buildSigned(keyPair).executeAs(client)

suspend fun SignedTransaction.execute(client: Iroha2Client) = this.executeAs(client)
suspend fun SignedTransaction.executeAs(client: Iroha2Client): Deferred<ByteArray> {
    val lock = Mutex(locked = true)

    return client.subscribeToTransactionStatus(this.hash()) {
        lock.unlock() // 2. unlock after subscription
    }.also {
        lock.lock() // 1. waiting for unlock
        client.fireAndForget(this)
    }
}

suspend fun RegisterOfPeer.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun RegisterOfPeer.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun RegisterOfDomain.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun RegisterOfDomain.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun RegisterOfAssetDefinition.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun RegisterOfAssetDefinition.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun RegisterOfAccount.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun RegisterOfAccount.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun RegisterOfAsset.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun RegisterOfAsset.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun RegisterOfRole.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun RegisterOfRole.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun RegisterOfTrigger.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun RegisterOfTrigger.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)

suspend fun UnregisterOfPeer.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun UnregisterOfPeer.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun UnregisterOfDomain.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun UnregisterOfDomain.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun UnregisterOfAssetDefinition.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun UnregisterOfAssetDefinition.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun UnregisterOfAccount.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun UnregisterOfAccount.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun UnregisterOfAsset.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun UnregisterOfAsset.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun UnregisterOfRole.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun UnregisterOfRole.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun UnregisterOfTrigger.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun UnregisterOfTrigger.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)

suspend fun SetKeyValueOfDomain.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun SetKeyValueOfDomain.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun SetKeyValueOfAssetDefinition.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun SetKeyValueOfAssetDefinition.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun SetKeyValueOfAccount.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun SetKeyValueOfAccount.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun SetKeyValueOfAsset.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun SetKeyValueOfAsset.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun SetKeyValueOfTrigger.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun SetKeyValueOfTrigger.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)

suspend fun RemoveKeyValueOfDomain.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun RemoveKeyValueOfDomain.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun RemoveKeyValueOfAssetDefinition.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun RemoveKeyValueOfAssetDefinition.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun RemoveKeyValueOfAccount.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun RemoveKeyValueOfAccount.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun RemoveKeyValueOfAsset.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun RemoveKeyValueOfAsset.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun RemoveKeyValueOfTrigger.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun RemoveKeyValueOfTrigger.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)

suspend fun MintOfNumericAndAsset.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun MintOfNumericAndAsset.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun MintOfu32AndTrigger.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun MintOfu32AndTrigger.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)

suspend fun BurnOfNumericAndAsset.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun BurnOfNumericAndAsset.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun BurnOfu32AndTrigger.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun BurnOfu32AndTrigger.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)

suspend fun TransferOfAccountAndAssetDefinitionIdAndAccount.execute(client: Iroha2Client) =
    this.executeAs(client.authority, client.keyPair, client)
suspend fun TransferOfAccountAndAssetDefinitionIdAndAccount.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun TransferOfAssetAndNumericAndAccount.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun TransferOfAssetAndNumericAndAccount.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun TransferOfAssetAndMetadataAndAccount.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun TransferOfAssetAndMetadataAndAccount.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun TransferOfAccountAndDomainIdAndAccount.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun TransferOfAccountAndDomainIdAndAccount.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)

suspend fun GrantOfPermissionAndAccount.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun GrantOfPermissionAndAccount.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun GrantOfRoleIdAndAccount.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun GrantOfRoleIdAndAccount.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun GrantOfPermissionAndRole.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun GrantOfPermissionAndRole.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)

suspend fun RevokeOfPermissionAndAccount.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun RevokeOfPermissionAndAccount.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun RevokeOfRoleIdAndAccount.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun RevokeOfRoleIdAndAccount.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
suspend fun RevokeOfPermissionAndRole.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun RevokeOfPermissionAndRole.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)

suspend fun ExecuteTrigger.execute(client: Iroha2Client) = this.executeAs(client.authority, client.keyPair, client)
suspend fun ExecuteTrigger.executeAs(
    authority: AccountId,
    keyPair: KeyPair,
    client: Iroha2Client,
) = executeAs(this.asInstructionBoxExt(), authority, keyPair, client)
