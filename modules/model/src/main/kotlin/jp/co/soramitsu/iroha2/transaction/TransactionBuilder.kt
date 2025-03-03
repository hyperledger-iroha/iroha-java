@file:Suppress("ktlint:standard:no-wildcard-imports")

package jp.co.soramitsu.iroha2.transaction

import jp.co.soramitsu.iroha2.*
import jp.co.soramitsu.iroha2.generated.*
import java.math.BigInteger
import java.security.KeyPair
import java.time.Duration
import java.util.UUID

class TransactionBuilder(
    var chain: UUID,
) {
    private val instructions: Lazy<ArrayList<InstructionBox>> = lazy { ArrayList() }
    private var timeToLiveMillis: BigInteger = DURATION_OF_24_HOURS_IN_MILLIS
    private var nonce: Long? = null
    private var metadata: Lazy<HashMap<Name, Json>> = lazy { HashMap() }

    companion object {
        val DURATION_OF_24_HOURS_IN_MILLIS = Duration.ofHours(24).toMillis().toBigInteger()
    }

    fun addInstructions(vararg instructions: Instruction) =
        this.apply {
            this.instructions.value.addAll(
                instructions.map {
                    it.asInstructionBox()
                },
            )
        }

    fun addInstructions(instructions: Iterable<Instruction>) =
        this.apply {
            this.instructions.value.addAll(
                instructions.map {
                    it.asInstructionBox()
                },
            )
        }

    fun addInstruction(instruction: Instruction) = this.apply { this.instructions.value.add(instruction.asInstructionBox()) }

    fun timeToLive(ttl: Duration) = this.apply { this.timeToLiveMillis = ttl.toMillis().toBigInteger() }

    fun signAs(
        accountId: AccountId,
        keyPair: KeyPair,
    ): SignedTransaction {
        val payload =
            TransactionPayload(
                ChainId(chain.toString()),
                accountId,
                System.currentTimeMillis().toBigInteger(),
                Executable.Instructions(instructions.value),
                NonZeroOfu64(timeToLiveMillis),
                nonce?.takeIf { it > 0 }?.let(::NonZeroOfu32),
                Metadata(metadata.value),
            )
        val encodedPayload = TransactionPayload.encode(payload)
        val signature = Signature(keyPair.private.signAs(encodedPayload)).asSignatureOf<TransactionPayload>()

        return SignedTransaction.V1(
            SignedTransactionV1(TransactionSignature(signature), payload),
        )
    }
}
