package jp.co.soramitsu.iroha2.transaction

import jp.co.soramitsu.iroha2.IrohaClientException
import jp.co.soramitsu.iroha2.Permissions
import jp.co.soramitsu.iroha2.U32_MAX_VALUE
import jp.co.soramitsu.iroha2.asName
import jp.co.soramitsu.iroha2.asSignatureOf
import jp.co.soramitsu.iroha2.generated.* // ktlint-disable no-wildcard-imports
import jp.co.soramitsu.iroha2.sign
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
    var metadata: Lazy<HashMap<Name, String>>

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

    fun instructions(instructions: Iterable<InstructionBox>) =
        this.apply { this.instructions.value.addAll(instructions) }

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
    fun registerTimeTrigger(
        triggerId: TriggerId,
        isi: List<InstructionBox>,
        repeats: Repeats,
        accountId: AccountId,
        filter: TimeEventFilter,
        metadata: Metadata = Metadata(mapOf()),
    ) = this.apply {
        instructions.value.add(
            Instructions.registerTrigger(
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
    fun registerExecutableTrigger(
        triggerId: TriggerId,
        isi: List<InstructionBox>,
        repeats: Repeats,
        accountId: AccountId,
        metadata: Metadata = Metadata(mapOf()),
    ) = this.apply {
        instructions.value.add(
            Instructions.registerTrigger(
                triggerId,
                isi,
                repeats,
                accountId,
                metadata,
            ),
        )
    }

    @JvmOverloads
    fun registerEventTrigger(
        triggerId: TriggerId,
        isi: List<InstructionBox>,
        repeats: Repeats,
        accountId: AccountId,
        metadata: Metadata = Metadata(mapOf()),
        filter: EventFilterBox,
    ) = this.apply {
        instructions.value.add(
            Instructions.registerTrigger(
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
    fun registerWasmTrigger(
        triggerId: TriggerId,
        wasm: ByteArray,
        repeats: Repeats,
        accountId: AccountId,
        metadata: Metadata = Metadata(mapOf()),
        filter: EventFilterBox,
    ) = this.apply {
        instructions.value.add(
            Instructions.registerTrigger(
                triggerId,
                wasm,
                repeats,
                accountId,
                metadata,
                filter,
            ),
        )
    }

    @JvmOverloads
    fun registerPreCommitTrigger(
        triggerId: TriggerId,
        isi: List<InstructionBox>,
        repeats: Repeats,
        accountId: AccountId,
        metadata: Metadata = Metadata(mapOf()),
        filter: EventFilterBox = EventFilterBox.Time(TimeEventFilter(ExecutionTime.PreCommit())),
    ) = this.apply {
        instructions.value.add(
            Instructions.registerTrigger(
                triggerId,
                isi,
                repeats,
                accountId,
                metadata,
                filter,
            ),
        )
    }

    fun unregisterAsset(id: AssetId) = this.apply {
        instructions.value.add(Instructions.unregisterAsset(id))
    }

    fun unregisterAssetDefinition(id: AssetDefinitionId) = this.apply {
        instructions.value.add(Instructions.unregisterAssetDefinition(id))
    }

    fun unregisterTrigger(id: TriggerId) = this.apply {
        instructions.value.add(
            Instructions.unregisterTrigger(id),
        )
    }

    fun unregisterTrigger(triggerName: String, domainId: DomainId? = null) = this.apply {
        instructions.value.add(
            Instructions.unregisterTrigger(triggerName, domainId),
        )
    }

    fun unregisterAccount(id: AccountId) = this.apply {
        instructions.value.add(
            Instructions.unregisterAccount(id),
        )
    }

    fun unregisterDomain(id: DomainId) = this.apply {
        instructions.value.add(
            Instructions.unregisterDomain(id),
        )
    }

    fun grantRole(
        roleId: RoleId,
        accountId: AccountId,
    ) = this.apply { instructions.value.add(Instructions.grantRole(roleId, accountId)) }

    fun registerRole(
        id: RoleId,
        vararg tokens: Permission,
    ) = this.apply { instructions.value.add(Instructions.registerRole(id, *tokens)) }

    fun unregisterRole(
        id: RoleId,
    ) = this.apply { instructions.value.add(Instructions.unregisterRole(id)) }

    @JvmOverloads
    fun registerAccount(
        id: AccountId,
        metadata: Metadata = Metadata(mapOf()),
    ) = this.apply { instructions.value.add(Instructions.registerAccount(id, metadata)) }

    @JvmOverloads
    fun registerAssetDefinition(
        id: AssetDefinitionId,
        assetValueType: AssetType,
        metadata: Metadata = Metadata(mapOf()),
        mintable: Mintable = Mintable.Infinitely(),
    ) = this.apply {
        instructions.value.add(
            Instructions.registerAssetDefinition(id, assetValueType, metadata, mintable),
        )
    }

    @JvmOverloads
    fun registerAssetDefinition(
        name: Name,
        domainId: DomainId,
        assetValueType: AssetType,
        metadata: Metadata = Metadata(mapOf()),
        mintable: Mintable = Mintable.Infinitely(),
    ) = this.apply {
        instructions.value.add(
            Instructions.registerAssetDefinition(AssetDefinitionId(domainId, name), assetValueType, metadata, mintable),
        )
    }

    fun registerAsset(
        id: AssetId,
        assetValue: AssetValue,
    ) = this.apply { instructions.value.add(Instructions.registerAsset(id, assetValue)) }

    fun setKeyValue(
        assetId: AssetId,
        key: String,
        value: String,
    ) = this.apply { instructions.value.add(Instructions.setKeyValue(assetId, key.asName(), value)) }

    fun setKeyValue(
        assetId: AssetId,
        key: Name,
        value: String,
    ) = this.apply { instructions.value.add(Instructions.setKeyValue(assetId, key, value)) }

    fun setKeyValue(
        accountId: AccountId,
        key: Name,
        value: String,
    ) = this.apply { instructions.value.add(Instructions.setKeyValue(accountId, key, value)) }

    fun setKeyValue(
        definitionId: AssetDefinitionId,
        key: Name,
        value: String,
    ) = this.apply { instructions.value.add(Instructions.setKeyValue(definitionId, key, value)) }

    fun setKeyValue(
        triggerId: TriggerId,
        key: Name,
        value: String,
    ) = this.apply { instructions.value.add(Instructions.setKeyValue(triggerId, key, value)) }

    fun setKeyValue(
        domainId: DomainId,
        key: Name,
        value: String,
    ) = this.apply { instructions.value.add(Instructions.setKeyValue(domainId, key, value)) }

    fun removeKeyValue(
        assetId: AssetId,
        key: Name,
    ) = this.apply { instructions.value.add(Instructions.removeKeyValue(assetId, key)) }

    fun removeKeyValue(
        assetId: AssetId,
        key: String,
    ) = removeKeyValue(assetId, key.asName())

    fun executeTrigger(
        triggerId: TriggerId,
    ) = this.apply { instructions.value.add(Instructions.executeTrigger(triggerId)) }

    fun mintAsset(
        assetId: AssetId,
        quantity: Int,
    ) = this.apply { instructions.value.add(Instructions.mintAsset(assetId, quantity)) }

    fun mintAsset(
        assetId: AssetId,
        quantity: BigDecimal,
    ) = this.apply { instructions.value.add(Instructions.mintAsset(assetId, quantity)) }

    @JvmOverloads
    fun registerDomain(
        domainId: DomainId,
        metadata: Map<Name, String> = mapOf(),
        logo: IpfsPath? = null,
    ) = this.apply {
        instructions.value.add(
            Instructions.registerDomain(
                domainId,
                metadata,
                logo,
            ),
        )
    }

    fun registerPeer(peerId: PeerId) = this.apply { instructions.value.add(Instructions.registerPeer(peerId)) }

    fun unregisterPeer(
        peerId: PeerId,
    ) = this.apply { instructions.value.add(Instructions.unregisterPeer(peerId)) }

    fun grantPermissionToken(permission: Permissions, payload: String, target: AccountId) = this.apply {
        instructions.value.add(Instructions.grantPermissionToken(permission, payload, target))
    }

    fun burnAsset(assetId: AssetId, value: Int) = this.apply {
        instructions.value.add(Instructions.burnAsset(assetId, value))
    }

    fun burnAsset(assetId: AssetId, value: BigDecimal) = this.apply {
        instructions.value.add(Instructions.burnAsset(assetId, value))
    }

    fun transferAsset(sourceId: AssetId, value: Int, destinationId: AccountId) = this.apply {
        instructions.value.add(Instructions.transferAsset(sourceId, value, destinationId))
    }

    fun transferDomainOwnership(sourceId: AccountId, value: DomainId, destinationId: AccountId) = this.apply {
        instructions.value.add(Instructions.transferDomainOwnership(sourceId, value, destinationId))
    }

    fun revokeSetKeyValueAsset(assetId: AssetId, target: AccountId) =
        this.apply { instructions.value.add(Instructions.revokeSetKeyValueAsset(assetId, target)) }

    fun revokeSetKeyValueAccount(accountId: AccountId, target: AccountId) =
        this.apply { instructions.value.add(Instructions.revokeSetKeyValueAccount(accountId, target)) }

    fun revokeSetKeyValueDomain(domainId: DomainId, target: AccountId) =
        this.apply { instructions.value.add(Instructions.revokeSetKeyValueDomain(domainId, target)) }

    fun revokeRole(
        roleId: RoleId,
        accountId: AccountId,
    ) = this.apply { instructions.value.add(Instructions.revokeRole(roleId, accountId)) }

    private fun fallbackCreationTime() = System.currentTimeMillis().toBigInteger()

    companion object {
        fun builder() = TransactionBuilder()

        val DURATION_OF_24_HOURS_IN_MILLIS = Duration.ofHours(24).toMillis().toBigInteger()
    }
}
