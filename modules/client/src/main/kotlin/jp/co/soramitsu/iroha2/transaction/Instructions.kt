package jp.co.soramitsu.iroha2.transaction

import jp.co.soramitsu.iroha2.DigestFunction
import jp.co.soramitsu.iroha2.IdKey
import jp.co.soramitsu.iroha2.Permissions
import jp.co.soramitsu.iroha2.asName
import jp.co.soramitsu.iroha2.asValue
import jp.co.soramitsu.iroha2.cast
import jp.co.soramitsu.iroha2.evaluatesTo
import jp.co.soramitsu.iroha2.generated.crypto.PublicKey
import jp.co.soramitsu.iroha2.generated.datamodel.IdBox
import jp.co.soramitsu.iroha2.generated.datamodel.RegistrableBox
import jp.co.soramitsu.iroha2.generated.datamodel.Value
import jp.co.soramitsu.iroha2.generated.datamodel.ValueKind
import jp.co.soramitsu.iroha2.generated.datamodel.account.AccountId
import jp.co.soramitsu.iroha2.generated.datamodel.account.NewAccount
import jp.co.soramitsu.iroha2.generated.datamodel.asset.Asset
import jp.co.soramitsu.iroha2.generated.datamodel.asset.AssetId
import jp.co.soramitsu.iroha2.generated.datamodel.asset.AssetValue
import jp.co.soramitsu.iroha2.generated.datamodel.asset.AssetValueType
import jp.co.soramitsu.iroha2.generated.datamodel.asset.DefinitionId
import jp.co.soramitsu.iroha2.generated.datamodel.asset.Mintable
import jp.co.soramitsu.iroha2.generated.datamodel.asset.NewAssetDefinition
import jp.co.soramitsu.iroha2.generated.datamodel.domain.DomainId
import jp.co.soramitsu.iroha2.generated.datamodel.domain.IpfsPath
import jp.co.soramitsu.iroha2.generated.datamodel.domain.NewDomain
import jp.co.soramitsu.iroha2.generated.datamodel.events.EventsFilterBox
import jp.co.soramitsu.iroha2.generated.datamodel.events.time.TimeEventFilter
import jp.co.soramitsu.iroha2.generated.datamodel.isi.BurnBox
import jp.co.soramitsu.iroha2.generated.datamodel.isi.ExecuteTriggerBox
import jp.co.soramitsu.iroha2.generated.datamodel.isi.FailBox
import jp.co.soramitsu.iroha2.generated.datamodel.isi.GrantBox
import jp.co.soramitsu.iroha2.generated.datamodel.isi.If
import jp.co.soramitsu.iroha2.generated.datamodel.isi.Instruction
import jp.co.soramitsu.iroha2.generated.datamodel.isi.MintBox
import jp.co.soramitsu.iroha2.generated.datamodel.isi.Pair
import jp.co.soramitsu.iroha2.generated.datamodel.isi.RegisterBox
import jp.co.soramitsu.iroha2.generated.datamodel.isi.RemoveKeyValueBox
import jp.co.soramitsu.iroha2.generated.datamodel.isi.SequenceBox
import jp.co.soramitsu.iroha2.generated.datamodel.isi.SetKeyValueBox
import jp.co.soramitsu.iroha2.generated.datamodel.isi.TransferBox
import jp.co.soramitsu.iroha2.generated.datamodel.isi.UnregisterBox
import jp.co.soramitsu.iroha2.generated.datamodel.metadata.Metadata
import jp.co.soramitsu.iroha2.generated.datamodel.name.Name
import jp.co.soramitsu.iroha2.generated.datamodel.peer.Peer
import jp.co.soramitsu.iroha2.generated.datamodel.peer.PeerId
import jp.co.soramitsu.iroha2.generated.datamodel.permission.token.Definition
import jp.co.soramitsu.iroha2.generated.datamodel.permission.token.Token
import jp.co.soramitsu.iroha2.generated.datamodel.permission.token.TokenId
import jp.co.soramitsu.iroha2.generated.datamodel.role.NewRole
import jp.co.soramitsu.iroha2.generated.datamodel.role.Role
import jp.co.soramitsu.iroha2.generated.datamodel.role.RoleId
import jp.co.soramitsu.iroha2.generated.datamodel.transaction.Executable
import jp.co.soramitsu.iroha2.generated.datamodel.transaction.WasmSmartContract
import jp.co.soramitsu.iroha2.generated.datamodel.trigger.Trigger
import jp.co.soramitsu.iroha2.generated.datamodel.trigger.TriggerId
import jp.co.soramitsu.iroha2.generated.datamodel.trigger.action.Action
import jp.co.soramitsu.iroha2.generated.datamodel.trigger.action.Repeats
import jp.co.soramitsu.iroha2.generated.primitives.fixed.Fixed
import jp.co.soramitsu.iroha2.toValueId
import java.math.BigDecimal
import java.math.BigInteger

val COUNT_PARAM_NAME by lazy { "count".asName() }
val PERIOD_PARAM_NAME by lazy { "period".asName() }

/**
 * Iroha Special Instructions cover all possible actions within a blockchain
 * @see [Iroha2 Tutorial on Iroha Special Instructions](https://hyperledger.github.io/iroha-2-docs/guide/advanced/isi.html)
 */
object Instructions {

    /**
     * Register a role that has the specified permissions
     */
    fun registerRole(
        roleId: RoleId,
        vararg tokens: Token
    ): Instruction.Register {
        return registerSome {
            RegistrableBox.Role(
                NewRole(
                    Role(roleId, tokens.toList())
                )
            )
        }
    }

    /**
     * Register an account
     */
    @JvmOverloads
    fun registerAccount(
        id: AccountId,
        signatories: List<PublicKey>,
        metadata: Metadata = Metadata(mapOf())
    ): Instruction.Register {
        return registerSome {
            RegistrableBox.Account(
                NewAccount(id, signatories, metadata)
            )
        }
    }

    /**
     * Register a permission token
     */
    fun registerPermissionToken(
        permissionsId: TokenId,
        params: Map<Name, ValueKind> = mapOf()
    ): Instruction.Register {
        return registerSome {
            RegistrableBox.PermissionTokenDefinition(
                Definition(permissionsId, params)
            )
        }
    }

    fun registerPermissionToken(permission: Permissions, idKey: IdKey): Instruction.Register {
        return registerPermissionToken(permission.type, idKey.type)
    }

    fun registerPermissionToken(name: Name, idKey: IdKey): Instruction.Register {
        return registerPermissionToken(name, idKey.type)
    }

    fun registerPermissionToken(name: Name, idKey: String): Instruction.Register {
        return registerPermissionToken(
            TokenId(name),
            mapOf(idKey.asName() to ValueKind.Id())
        )
    }

    /**
     * Register a time trigger
     */
    fun registerTimeTrigger(
        triggerId: TriggerId,
        isi: List<Instruction>,
        repeats: Repeats,
        accountId: AccountId,
        filter: TimeEventFilter,
        metadata: Metadata
    ): Instruction {
        return registerSome {
            RegistrableBox.Trigger(
                Trigger(
                    triggerId,
                    Action(
                        Executable.Instructions(isi),
                        repeats,
                        accountId,
                        EventsFilterBox.Time(filter),
                        metadata
                    )
                )
            )
        }
    }

    /**
     * Register an executable trigger
     */
    fun registerExecutableTrigger(
        triggerId: TriggerId,
        isi: List<Instruction>,
        repeats: Repeats,
        accountId: AccountId,
        metadata: Metadata
    ): Instruction.Register {
        return registerSome {
            RegistrableBox.Trigger(
                Trigger(
                    triggerId,
                    Action(
                        Executable.Instructions(isi),
                        repeats,
                        accountId,
                        Filters.executeTrigger(triggerId, accountId),
                        metadata
                    )
                )
            )
        }
    }

    /**
     * Register an event trigger
     */
    fun registerEventTrigger(
        triggerId: TriggerId,
        isi: List<Instruction>,
        repeats: Repeats,
        accountId: AccountId,
        metadata: Metadata,
        filter: EventsFilterBox
    ): Instruction.Register {
        return registerSome {
            RegistrableBox.Trigger(
                Trigger(
                    triggerId,
                    Action(
                        Executable.Instructions(isi),
                        repeats,
                        accountId,
                        filter,
                        metadata
                    )
                )
            )
        }
    }

    /**
     * Register a WASM trigger
     */
    fun registerWasmTrigger(
        triggerId: TriggerId,
        wasm: ByteArray,
        repeats: Repeats,
        accountId: AccountId,
        metadata: Metadata,
        filter: EventsFilterBox
    ): Instruction.Register {
        return registerSome {
            RegistrableBox.Trigger(
                Trigger(
                    triggerId,
                    Action(
                        Executable.Wasm(
                            WasmSmartContract(wasm)
                        ),
                        repeats,
                        accountId,
                        filter,
                        metadata
                    )
                )
            )
        }
    }

    /**
     * Register a pre-commit trigger to run after every transaction
     */
    fun registerPreCommitTrigger(
        triggerId: TriggerId,
        isi: List<Instruction>,
        repeats: Repeats,
        accountId: AccountId,
        metadata: Metadata
    ): Instruction.Register {
        return registerSome {
            RegistrableBox.Trigger(
                Trigger(
                    triggerId,
                    Action(
                        Executable.Instructions(isi),
                        repeats,
                        accountId,
                        Filters.time(EventFilters.timeEventFilter()),
                        metadata
                    )
                )
            )
        }
    }

    /**
     * Unregister a trigger
     */
    fun unregisterTrigger(
        id: TriggerId
    ): Instruction.Unregister {
        return unregisterSome {
            IdBox.TriggerId(id)
        }
    }

    /**
     * Unregister a trigger
     */
    fun unregisterTrigger(
        triggerName: String,
        domainId: DomainId? = null
    ): Instruction.Unregister {
        return unregisterSome {
            IdBox.TriggerId(
                TriggerId(triggerName.asName(), domainId)
            )
        }
    }

    /**
     * Unregister an asset
     */
    fun unregisterAsset(id: AssetId): Instruction.Unregister {
        return unregisterSome { IdBox.AssetId(id) }
    }

    /**
     * Unregister an account
     */
    fun unregisterAccount(id: AccountId): Instruction.Unregister {
        return unregisterSome { IdBox.AccountId(id) }
    }

    /**
     * Unregister a domain
     */
    fun unregisterDomain(id: DomainId): Instruction.Unregister {
        return unregisterSome { IdBox.DomainId(id) }
    }

    /**
     * Register an asset
     */
    @JvmOverloads
    fun registerAssetDefinition(
        id: DefinitionId,
        assetValueType: AssetValueType,
        metadata: Metadata = Metadata(mapOf()),
        mintable: Mintable = Mintable.Infinitely()
    ): Instruction.Register {
        return registerSome {
            RegistrableBox.AssetDefinition(
                NewAssetDefinition(id, assetValueType, mintable, metadata)
            )
        }
    }

    /**
     * Register an asset
     */
    fun registerAsset(id: AssetId, assetValue: AssetValue): Instruction.Register {
        return registerSome {
            RegistrableBox.Asset(Asset(id, assetValue))
        }
    }

    /**
     * Register a domain
     */
    @JvmOverloads
    fun registerDomain(
        domainId: DomainId,
        metadata: Map<Name, Value> = mapOf(),
        logo: IpfsPath? = null
    ): Instruction.Register {
        return registerSome {
            RegistrableBox.Domain(
                NewDomain(domainId, logo, Metadata(metadata))
            )
        }
    }

    /**
     * Register a peer
     */
    @JvmOverloads
    fun registerPeer(
        address: String,
        payload: ByteArray,
        digestFunction: String = DigestFunction.Ed25519.hashFunName
    ): Instruction.Register {
        return registerSome {
            RegistrableBox.Peer(
                Peer(
                    PeerId(
                        address,
                        PublicKey(digestFunction, payload)
                    )
                )
            )
        }
    }

    /**
     * Unregister a peer
     */
    @JvmOverloads
    fun unregisterPeer(
        address: String,
        payload: ByteArray,
        digestFunction: String = DigestFunction.Ed25519.hashFunName
    ): Instruction.Unregister {
        return unregisterSome {
            IdBox.PeerId(
                PeerId(address, PublicKey(digestFunction, payload))
            )
        }
    }

    /**
     * Set key/value for a given asset
     */
    fun setKeyValue(
        assetId: AssetId,
        key: Name,
        value: Value
    ): Instruction.SetKeyValue {
        return Instruction.SetKeyValue(
            SetKeyValueBox(
                objectId = IdBox.AssetId(assetId).evaluatesTo(),
                key = key.evaluatesTo(),
                value = value.evaluatesTo()
            )
        )
    }

    /**
     * Set key/value for a given asset definition
     */
    fun setKeyValue(
        definitionId: DefinitionId,
        key: Name,
        value: Value
    ): Instruction.SetKeyValue {
        return Instruction.SetKeyValue(
            SetKeyValueBox(
                objectId = IdBox.AssetDefinitionId(definitionId).evaluatesTo(),
                key = key.evaluatesTo(),
                value = value.evaluatesTo()
            )
        )
    }

    /**
     * Set key/value in the metadata of a given account
     */
    fun setKeyValue(
        accountId: AccountId,
        key: Name,
        value: Value
    ): Instruction.SetKeyValue {
        return Instruction.SetKeyValue(
            SetKeyValueBox(
                objectId = IdBox.AccountId(accountId).evaluatesTo(),
                key = key.evaluatesTo(),
                value = value.evaluatesTo()
            )
        )
    }

    /**
     * Remove key/value from a given asset
     */
    fun removeKeyValue(assetId: AssetId, key: Name): Instruction.RemoveKeyValue {
        return Instruction.RemoveKeyValue(
            RemoveKeyValueBox(
                objectId = IdBox.AssetId(assetId).evaluatesTo(),
                key = key.evaluatesTo()
            )
        )
    }

    /**
     * Set key/value in the metadata of a given domain
     */
    fun setKeyValue(
        domainId: DomainId,
        key: Name,
        value: Value
    ): Instruction.SetKeyValue {
        return Instruction.SetKeyValue(
            SetKeyValueBox(
                objectId = IdBox.DomainId(domainId).evaluatesTo(),
                key = key.evaluatesTo(),
                value = value.evaluatesTo()
            )
        )
    }

    /**
     * Execute a trigger
     */
    fun executeTrigger(triggerId: TriggerId): Instruction.ExecuteTrigger {
        return Instruction.ExecuteTrigger(ExecuteTriggerBox(triggerId))
    }

    /**
     * Mint an asset of the [AssetValueType.Quantity] asset value type
     */
    fun mintAsset(
        assetId: AssetId,
        quantity: Long
    ): Instruction.Mint {
        return mintSome(Value.U32(quantity), assetId)
    }

    /**
     * Mint an asset of the [AssetValueType.Fixed] asset value type
     */
    fun mintAsset(
        assetId: AssetId,
        quantity: BigDecimal
    ): Instruction.Mint {
        return mintSome(Value.Fixed(Fixed(quantity)), assetId)
    }

    /**
     * Mint a public key
     */
    fun mintPublicKey(accountId: AccountId, pubKey: PublicKey): Instruction {
        return mintSome(
            Value.PublicKey(pubKey),
            IdBox.AccountId(accountId)
        )
    }

    /**
     * Burn an asset of the [AssetValueType.Quantity] asset value type
     */
    fun burnAsset(assetId: AssetId, value: Long): Instruction {
        return burnSome(
            Value.U32(value),
            IdBox.AssetId(assetId)
        )
    }

    /**
     * Burn an asset of the [AssetValueType.Fixed] asset value type
     */
    fun burnAsset(assetId: AssetId, value: BigDecimal): Instruction {
        return burnSome(
            Value.Fixed(Fixed(value)),
            IdBox.AssetId(assetId)
        )
    }

    /**
     * Burn a public key
     */
    fun burnPublicKey(accountId: AccountId, pubKey: PublicKey): Instruction {
        return burnSome(
            Value.PublicKey(pubKey),
            IdBox.AccountId(accountId)
        )
    }

    fun removePublicKey(accountId: AccountId, pubKey: PublicKey) = burnPublicKey(accountId, pubKey)

    /**
     * Grant an account the [Permissions.CanSetKeyValueUserAssetsToken] permission
     */
    fun grantSetKeyValueAsset(assetId: AssetId, target: AccountId): Instruction {
        return grantSome(IdBox.AccountId(target)) {
            Token(
                definitionId = TokenId(Permissions.CanSetKeyValueUserAssetsToken.type),
                params = mapOf(IdKey.AssetId.type.asName() to assetId.toValueId())
            )
        }
    }

    /**
     * Grant an account the [Permissions.CanRemoveKeyValueInUserAssets] permission
     */
    fun grantRemoveKeyValueAsset(assetId: AssetId, target: AccountId): Instruction {
        return grantSome(IdBox.AccountId(target)) {
            Token(
                definitionId = TokenId(Permissions.CanRemoveKeyValueInUserAssets.type),
                params = mapOf(IdKey.AssetId.type.asName() to assetId.toValueId())
            )
        }
    }

    /**
     * Grant an account the [Permissions.CanSetKeyValueInUserMetadata] permission
     */
    fun grantSetKeyValueMetadata(accountId: AccountId, target: AccountId): Instruction {
        return grantSome(IdBox.AccountId(target)) {
            Token(
                definitionId = TokenId(Permissions.CanSetKeyValueInUserMetadata.type),
                params = mapOf(IdKey.AccountId.type.asName() to accountId.toValueId())
            )
        }
    }

    /**
     * Grant an account the [Permissions.CanRemoveKeyValueInUserMetadata] permission
     */
    fun grantRemoveKeyValueMetadata(accountId: AccountId, target: AccountId): Instruction {
        return grantSome(IdBox.AccountId(target)) {
            Token(
                definitionId = TokenId(Permissions.CanRemoveKeyValueInUserMetadata.type),
                params = mapOf(IdKey.AccountId.type.asName() to accountId.toValueId())
            )
        }
    }

    /**
     * Grant an account the [Permissions.CanSetKeyValueInAssetDefinition] permission
     */
    fun grantSetKeyValueAssetDefinition(assetDefinitionId: DefinitionId, target: AccountId): Instruction {
        return grantSome(IdBox.AccountId(target)) {
            Token(
                definitionId = TokenId(Permissions.CanSetKeyValueInAssetDefinition.type),
                params = mapOf(
                    IdKey.AssetDefinitionId.type.asName() to assetDefinitionId.toValueId()
                )
            )
        }
    }

    /**
     * Grant an account the [Permissions.CanRemoveKeyValueInAssetDefinition] permission
     */
    fun grantRemoveKeyValueAssetDefinition(assetDefinitionId: DefinitionId, target: AccountId): Instruction {
        return grantSome(IdBox.AccountId(target)) {
            Token(
                definitionId = TokenId(Permissions.CanRemoveKeyValueInAssetDefinition.type),
                params = mapOf(
                    IdKey.AssetDefinitionId.type.asName() to assetDefinitionId.toValueId()
                )
            )
        }
    }

    /**
     * Grant an account the [Permissions.CanMintUserAssetDefinitionsToken] permission
     */
    fun grantMintUserAssetDefinitions(assetDefinitionId: DefinitionId, target: AccountId): Instruction {
        return grantSome(IdBox.AccountId(target)) {
            Token(
                definitionId = TokenId(Permissions.CanMintUserAssetDefinitionsToken.type),
                params = mapOf(
                    IdKey.AssetDefinitionId.type.asName() to assetDefinitionId.toValueId()
                )
            )
        }
    }

    /**
     * Grant an account the [Permissions.CanTransferOnlyFixedNumberOfTimesPerPeriod] permission
     */
    fun grantTransferOnlyFixedNumberOfTimesPerPeriod(period: BigInteger, count: Long, target: AccountId): Instruction {
        return grantSome(IdBox.AccountId(target)) {
            Token(
                definitionId = TokenId(Permissions.CanTransferOnlyFixedNumberOfTimesPerPeriod.type),
                params = mapOf(
                    PERIOD_PARAM_NAME to period.asValue(),
                    COUNT_PARAM_NAME to count.asValue()
                )
            )
        }
    }

    /**
     * Grant an account the [Permissions.CanBurnAssetWithDefinition] permission
     */
    fun grantBurnAssetWithDefinitionId(assetDefinitionId: DefinitionId, target: AccountId): Instruction {
        return grantSome(IdBox.AccountId(target)) {
            Token(
                definitionId = TokenId(Permissions.CanBurnAssetWithDefinition.type),
                params = mapOf(
                    IdKey.AssetDefinitionId.type.asName() to assetDefinitionId.toValueId()
                )
            )
        }
    }

    /**
     * Grant an account the [Permissions.CanBurnUserAssetsToken] permission
     */
    fun grantBurnAssets(assetId: AssetId, target: AccountId): Instruction {
        return grantSome(IdBox.AccountId(target)) {
            Token(
                definitionId = TokenId(Permissions.CanBurnUserAssetsToken.type),
                params = mapOf(
                    IdKey.AssetId.type.asName() to assetId.toValueId()
                )
            )
        }
    }

    /**
     * Grant an account the [Permissions.CanRegisterDomainsToken] permission
     */
    fun grantRegisterDomains(target: AccountId): Instruction {
        return grantSome(IdBox.AccountId(target)) {
            Token(
                definitionId = TokenId(Permissions.CanRegisterDomainsToken.type),
                params = emptyMap()
            )
        }
    }

    /**
     * Grant an account the [Permissions.CanTransferUserAssetsToken] permission
     */
    fun grantTransferUserAsset(assetId: AssetId, target: AccountId): Instruction {
        return grantSome(IdBox.AccountId(target)) {
            Token(
                definitionId = TokenId(Permissions.CanTransferUserAssetsToken.type),
                params = mapOf(
                    IdKey.AssetId.type.asName() to assetId.toValueId()
                )
            )
        }
    }

    /**
     * Grant an account the [Permissions.CanUnregisterAssetWithDefinition] permission
     */
    fun grantUnregisterAssetDefinition(assetDefinitionId: DefinitionId, target: AccountId): Instruction {
        return grantSome(IdBox.AccountId(target)) {
            Token(
                definitionId = TokenId(Permissions.CanUnregisterAssetWithDefinition.type),
                params = mapOf(
                    IdKey.AssetDefinitionId.type.asName() to assetDefinitionId.toValueId()
                )
            )
        }
    }

    /**
     * Grant an account a given role.
     */
    fun grantRole(roleId: RoleId, accountId: AccountId): Instruction {
        return Instruction.Grant(
            GrantBox(
                destinationId = accountId.evaluatesTo().cast(),
                `object` = IdBox.RoleId(roleId).evaluatesTo().cast()
            )
        )
    }

    /**
     * Transfer an asset from the identifiable source.
     */
    fun transferAsset(sourceId: AssetId, value: Long, destinationId: AssetId): Instruction {
        return Instruction.Transfer(
            TransferBox(
                sourceId = IdBox.AssetId(sourceId).evaluatesTo(),
                `object` = Value.U32(value).evaluatesTo(),
                destinationId = IdBox.AssetId(destinationId).evaluatesTo()
            )
        )
    }

    /**
     * Evaluate one instruction if a [condition] is met and another one otherwise.
     */
    fun `if`(condition: Boolean, then: Instruction, otherwise: Instruction): Instruction {
        return Instruction.If(
            If(condition.evaluatesTo(), then, otherwise)
        )
    }

    /**
     * Pair two instructions together.
     */
    fun pair(left: Instruction, right: Instruction): Instruction {
        return Instruction.Pair(Pair(left, right))
    }

    /**
     * Combine multiple [instructions] into a sequence.
     */
    fun sequence(instructions: List<Instruction>): Instruction {
        return Instruction.Sequence(SequenceBox(instructions))
    }

    /**
     * Fail a transaction with a given [message].
     */
    fun fail(message: String): Instruction {
        return Instruction.Fail(FailBox(message))
    }

    private inline fun unregisterSome(idBox: () -> IdBox): Instruction.Unregister {
        return Instruction.Unregister(
            UnregisterBox(idBox().evaluatesTo())
        )
    }

    private inline fun registerSome(
        regBox: () -> RegistrableBox
    ): Instruction.Register {
        return Instruction.Register(
            RegisterBox(regBox().evaluatesTo())
        )
    }

    private inline fun grantSome(idBox: IdBox, permissionToken: () -> Token): Instruction.Grant {
        return Instruction.Grant(
            GrantBox(
                destinationId = idBox.evaluatesTo(),
                `object` = Value.PermissionToken(permissionToken()).evaluatesTo()
            )
        )
    }

    private fun burnSome(value: Value, idBox: IdBox): Instruction.Burn {
        return Instruction.Burn(
            BurnBox(
                `object` = value.evaluatesTo(),
                destinationId = idBox.evaluatesTo()
            )
        )
    }

    private fun mintSome(value: Value, idBox: IdBox): Instruction.Mint {
        return Instruction.Mint(
            MintBox(
                `object` = value.evaluatesTo(),
                destinationId = idBox.evaluatesTo()
            )
        )
    }

    private fun mintSome(value: Value, assetId: AssetId): Instruction.Mint {
        return Instruction.Mint(
            MintBox(
                `object` = value.evaluatesTo(),
                destinationId = IdBox.AssetId(assetId).evaluatesTo()
            )
        )
    }
}
