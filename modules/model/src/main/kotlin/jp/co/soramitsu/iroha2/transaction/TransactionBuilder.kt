@file:Suppress("ktlint:standard:no-wildcard-imports")

package jp.co.soramitsu.iroha2.transaction

import jp.co.soramitsu.iroha2.*
import jp.co.soramitsu.iroha2.generated.*
import java.math.BigInteger
import java.security.KeyPair
import java.time.Duration
import java.time.Instant
import java.util.UUID

class TransactionBuilder(var chain: UUID, var authority: AccountId) {
    val instructions: Lazy<ArrayList<InstructionBox>> = lazy { ArrayList() }
    var creationTimeMillis: BigInteger? = null
    var timeToLiveMillis: BigInteger? = null
    var nonce: Long? = null
    var metadata: Lazy<HashMap<Name, Json>> = lazy { HashMap() }

    fun withChainId(uuid: UUID) = this.apply { chain = uuid }

    fun withAuthority(accountId: AccountId) = this.apply { this.authority = accountId }

    fun addInstructions(vararg instructions: InstructionBox) = this.apply { this.instructions.value.addAll(instructions) }

    fun addInstructions(instructions: Iterable<InstructionBox>) = this.apply { this.instructions.value.addAll(instructions) }

    fun addInstruction(instruction: InstructionBox) = this.apply { this.instructions.value.add(instruction) }

    fun creationTime(creationTimeMillis: BigInteger) = this.apply { this.creationTimeMillis = creationTimeMillis }

    fun creationTime(creationTime: Instant) = this.apply { this.creationTime(creationTime.toEpochMilli()) }

    fun creationTime(creationTimeMillis: Long) = this.apply { this.creationTime(creationTimeMillis.toBigInteger()) }

    fun timeToLive(ttlMillis: BigInteger) = this.apply { this.timeToLiveMillis = ttlMillis }

    fun timeToLive(ttl: Duration) = this.apply { this.timeToLive(ttl.toMillis()) }

    fun timeToLive(ttlMillis: Long) = this.apply { this.timeToLive(ttlMillis.toBigInteger()) }

    fun buildSigned(keyPair: KeyPair): SignedTransaction {
        val payload = TransactionPayload(
            ChainId(chain.toString()),
            authority,
            creationTimeMillis ?: fallbackCreationTime(),
            Executable.Instructions(instructions.value),
            NonZeroOfu64(timeToLiveMillis?.takeIf { it > BigInteger.ZERO } ?: Companion.DURATION_OF_24_HOURS_IN_MILLIS),
            nonce?.takeIf { it > 0 }?.let(::NonZeroOfu32),
            Metadata(metadata.value),
        )
        val encodedPayload = TransactionPayload.encode(payload)
        val signature = Signature(keyPair.private.sign(encodedPayload)).asSignatureOf<TransactionPayload>()

        return SignedTransaction.V1(
            SignedTransactionV1(TransactionSignature(signature), payload),
        )
    }

    private fun fallbackCreationTime() = System.currentTimeMillis().toBigInteger()

    companion object {
        private val DURATION_OF_24_HOURS_IN_MILLIS = Duration.ofHours(24).toMillis().toBigInteger()
    }
}
