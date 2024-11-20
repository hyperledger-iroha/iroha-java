@file:Suppress("ktlint:standard:no-wildcard-imports")

package jp.co.soramitsu.iroha2.transaction

import jp.co.soramitsu.iroha2.*
import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.AssetId
import jp.co.soramitsu.iroha2.generated.AssetType
import jp.co.soramitsu.iroha2.generated.AssetValue
import jp.co.soramitsu.iroha2.generated.ChainId
import jp.co.soramitsu.iroha2.generated.DomainId
import jp.co.soramitsu.iroha2.generated.EventFilterBox
import jp.co.soramitsu.iroha2.generated.Executable
import jp.co.soramitsu.iroha2.generated.InstructionBox
import jp.co.soramitsu.iroha2.generated.IpfsPath
import jp.co.soramitsu.iroha2.generated.Json
import jp.co.soramitsu.iroha2.generated.Metadata
import jp.co.soramitsu.iroha2.generated.Mintable
import jp.co.soramitsu.iroha2.generated.Name
import jp.co.soramitsu.iroha2.generated.NonZeroOfu32
import jp.co.soramitsu.iroha2.generated.NonZeroOfu64
import jp.co.soramitsu.iroha2.generated.PeerId
import jp.co.soramitsu.iroha2.generated.PublicKey
import jp.co.soramitsu.iroha2.generated.Repeats
import jp.co.soramitsu.iroha2.generated.RoleId
import jp.co.soramitsu.iroha2.generated.Signature
import jp.co.soramitsu.iroha2.generated.SignedTransaction
import jp.co.soramitsu.iroha2.generated.SignedTransactionV1
import jp.co.soramitsu.iroha2.generated.TransactionPayload
import jp.co.soramitsu.iroha2.generated.TransactionSignature
import jp.co.soramitsu.iroha2.generated.TriggerId
import java.math.BigDecimal
import java.math.BigInteger
import java.security.KeyPair
import java.time.Duration
import java.time.Instant
import java.util.UUID
import kotlin.random.Random
import kotlin.random.nextLong

class TransactionBuilder(builder: TransactionBuilder.() -> Unit = {}) {

    var chainId: ChainId?
    var accountId: AccountId?
    val instructions: Lazy<ArrayList<InstructionBox>>
    var creationTimeMillis: BigInteger?
    var timeToLiveMillis: BigInteger?
    var nonce: Long?
    var metadata: Lazy<HashMap<Name, Json>>

    init {
        chainId = ChainId("00000000-0000-0000-0000-000000000000")
        accountId = null
        instructions = lazy { ArrayList() }
        creationTimeMillis = null
        timeToLiveMillis = null
        nonce = Random.nextLong(0..U32_MAX_VALUE) // UInt32 max value
        metadata = lazy { HashMap() }
        builder(this)
    }

    fun chainId(uuid: UUID) = this.apply { chainId = ChainId(uuid.toString()) }

    fun account(accountId: AccountId) = this.apply { this.accountId = accountId }

    fun account(signatory: PublicKey, domainId: DomainId) = this.account(AccountId(domainId, signatory))

    fun instructions(vararg instructions: InstructionBox) = this.apply { this.instructions.value.addAll(instructions) }

    fun instructions(instructions: Iterable<InstructionBox>) = this.apply { this.instructions.value.addAll(instructions) }

    fun instruction(instruction: InstructionBox) = this.apply { this.instructions.value.add(instruction) }

    fun creationTime(creationTimeMillis: BigInteger) = this.apply { this.creationTimeMillis = creationTimeMillis }

    fun creationTime(creationTime: Instant) = this.apply { this.creationTime(creationTime.toEpochMilli()) }

    fun creationTime(creationTimeMillis: Long) = this.apply { this.creationTime(creationTimeMillis.toBigInteger()) }

    fun timeToLive(ttlMillis: BigInteger) = this.apply { this.timeToLiveMillis = ttlMillis }

    fun timeToLive(ttl: Duration) = this.apply { this.timeToLive(ttl.toMillis()) }

    fun timeToLive(ttlMillis: Long) = this.apply { this.timeToLive(ttlMillis.toBigInteger()) }

    fun buildSigned(keyPair: KeyPair): SignedTransaction {
        val payload = TransactionPayload(
            checkNotNull(chainId) { "Chain ID is required" },
            checkNotNull(accountId) { "Account Id is required" },
            creationTimeMillis ?: fallbackCreationTime(),
            Executable.Instructions(instructions.value),
            NonZeroOfu64(timeToLiveMillis ?: DURATION_OF_24_HOURS_IN_MILLIS),
            NonZeroOfu32(nonce ?: throw IrohaClientException("Nonce must not be null")),
            Metadata(metadata.value),
        )
        val encodedPayload = TransactionPayload.encode(payload)
        val signature = Signature(keyPair.private.sign(encodedPayload)).asSignatureOf<TransactionPayload>()

        return SignedTransaction.V1(
            SignedTransactionV1(TransactionSignature(signature), payload),
        )
    }

    @JvmOverloads
    fun register(
        triggerId: TriggerId,
        isi: List<InstructionBox>,
        repeats: Repeats,
        accountId: AccountId,
        filter: EventFilterBox,
        metadata: Metadata = Metadata(mapOf()),
    ) = this.apply {
        instructions.value.add(
            Instructions.register(
                triggerId,
                isi,
                repeats,
                accountId,
                metadata,
                filter,
            ),
        )
    }

    @JvmOverloads
    fun register(
        triggerId: TriggerId,
        wasm: ByteArray,
        repeats: Repeats,
        accountId: AccountId,
        filter: EventFilterBox,
        metadata: Metadata = Metadata(mapOf()),
    ) = this.apply {
        instructions.value.add(
            Instructions.register(
                triggerId,
                wasm,
                repeats,
                accountId,
                metadata,
                filter,
            ),
        )
    }

    fun unregister(id: AssetId) = this.apply {
        instructions.value.add(Instructions.unregister(id))
    }

    fun unregister(id: AssetDefinitionId) = this.apply {
        instructions.value.add(Instructions.unregister(id))
    }

    fun unregisterTrigger(id: TriggerId) = this.apply {
        instructions.value.add(
            Instructions.unregister(id),
        )
    }

    fun unregister(id: AccountId) = this.apply {
        instructions.value.add(
            Instructions.unregister(id),
        )
    }

    fun unregister(id: DomainId) = this.apply {
        instructions.value.add(
            Instructions.unregister(id),
        )
    }

    fun grantRole(roleId: RoleId, accountId: AccountId) = this.apply { instructions.value.add(Instructions.grant(roleId, accountId)) }

    fun register(
        grantTo: AccountId,
        id: RoleId,
        vararg tokens: ModelPermission,
    ) = this.apply {
        instructions.value.add(Instructions.register(grantTo, id, *tokens))
    }

    fun unregisterRole(id: RoleId) = this.apply { instructions.value.add(Instructions.unregister(id)) }

    @JvmOverloads
    fun register(id: AccountId, metadata: Metadata = Metadata(mapOf())) =
        this.apply { instructions.value.add(Instructions.register(id, metadata)) }

    @JvmOverloads
    fun register(
        id: AssetDefinitionId,
        assetValueType: AssetType,
        metadata: Metadata = Metadata(mapOf()),
        mintable: Mintable = Mintable.Infinitely(),
    ) = this.apply {
        instructions.value.add(
            Instructions.register(id, assetValueType, metadata, mintable),
        )
    }

    @JvmOverloads
    fun register(
        name: Name,
        domainId: DomainId,
        assetValueType: AssetType,
        metadata: Metadata = Metadata(mapOf()),
        mintable: Mintable = Mintable.Infinitely(),
    ) = this.apply {
        instructions.value.add(
            Instructions.register(AssetDefinitionId(domainId, name), assetValueType, metadata, mintable),
        )
    }

    fun register(id: AssetId, assetValue: AssetValue) = this.apply { instructions.value.add(Instructions.register(id, assetValue)) }

    fun <V> setKeyValue(
        assetId: AssetId,
        key: Name,
        value: V,
    ) = this.apply { instructions.value.add(Instructions.setKeyValue(assetId, key, value)) }

    fun <V> setKeyValue(
        accountId: AccountId,
        key: Name,
        value: V,
    ) = this.apply { instructions.value.add(Instructions.setKeyValue(accountId, key, value)) }

    fun <V> setKeyValue(
        definitionId: AssetDefinitionId,
        key: Name,
        value: V,
    ) = this.apply { instructions.value.add(Instructions.setKeyValue(definitionId, key, value)) }

    fun <V> setKeyValue(
        triggerId: TriggerId,
        key: Name,
        value: V,
    ) = this.apply { instructions.value.add(Instructions.setKeyValue(triggerId, key, value)) }

    fun <V> setKeyValue(
        domainId: DomainId,
        key: Name,
        value: V,
    ) = this.apply { instructions.value.add(Instructions.setKeyValue(domainId, key, value)) }

    fun removeKeyValue(assetId: AssetId, key: Name) = this.apply { instructions.value.add(Instructions.removeKeyValue(assetId, key)) }

    fun <V> executeTrigger(triggerId: TriggerId, args: V) = this.apply {
        instructions.value.add(Instructions.executeTrigger(triggerId, args))
    }

    fun mint(assetId: AssetId, quantity: Int) = this.apply { instructions.value.add(Instructions.mint(assetId, quantity)) }

    fun mint(assetId: AssetId, quantity: BigDecimal) = this.apply { instructions.value.add(Instructions.mint(assetId, quantity)) }

    @JvmOverloads
    fun register(
        domainId: DomainId,
        metadata: Map<Name, Json> = mapOf(),
        logo: IpfsPath? = null,
    ) = this.apply {
        instructions.value.add(
            Instructions.register(
                domainId,
                metadata.mapValues { it.value },
                logo,
            ),
        )
    }

    fun register(peerId: PeerId) = this.apply { instructions.value.add(Instructions.register(peerId)) }

    fun unregister(peerId: PeerId) = this.apply { instructions.value.add(Instructions.unregister(peerId)) }

    fun <P : ModelPermission> grant(permission: P, target: AccountId) = this.apply {
        instructions.value.add(Instructions.grant(permission, target))
    }

    fun burn(assetId: AssetId, value: Int) = this.apply {
        instructions.value.add(Instructions.burn(assetId, value))
    }

    fun burn(assetId: AssetId, value: BigDecimal) = this.apply {
        instructions.value.add(Instructions.burn(assetId, value))
    }

    fun transfer(
        sourceId: AssetId,
        value: Int,
        destinationId: AccountId,
    ) = this.apply {
        instructions.value.add(Instructions.transfer(sourceId, value, destinationId))
    }

    fun transfer(
        sourceId: AccountId,
        value: DomainId,
        destinationId: AccountId,
    ) = this.apply {
        instructions.value.add(Instructions.transfer(sourceId, value, destinationId))
    }

    fun revoke(roleId: RoleId, accountId: AccountId) = this.apply { instructions.value.add(Instructions.revoke(roleId, accountId)) }

    private fun fallbackCreationTime() = System.currentTimeMillis().toBigInteger()

    companion object {
        fun builder() = TransactionBuilder()

        val DURATION_OF_24_HOURS_IN_MILLIS = Duration.ofHours(24).toMillis().toBigInteger()
    }
}
