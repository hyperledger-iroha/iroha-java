@file:Suppress("ktlint:standard:no-wildcard-imports")

package jp.co.soramitsu.iroha2.transaction

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import jp.co.soramitsu.iroha2.asNumeric
import jp.co.soramitsu.iroha2.generated.*
import java.math.BigDecimal

/**
 * Iroha Special Instructions cover all possible actions within a blockchain
 * @see [Iroha2 Tutorial on Iroha Special Instructions](https://hyperledger.github.io/iroha-2-docs/guide/advanced/isi.html)
 */
object Instructions {
    private val mapper = jacksonObjectMapper()

    /**
     * Register a role that has the specified permissions
     */
    fun register(
        grantTo: AccountId,
        roleId: RoleId,
        vararg tokens: Permission,
    ) = InstructionBox.Register(
        RegisterBox.Role(RegisterOfRole(NewRole(Role(roleId, tokens.toList().map { permission -> permission.asRaw() }), grantTo))),
    )

    /**
     * Register an account
     */
    @JvmOverloads
    fun register(id: AccountId, metadata: Metadata = Metadata(mapOf())) = InstructionBox.Register(
        RegisterBox.Account(RegisterOfAccount(NewAccount(id, metadata))),
    )

    /**
     * Register a WASM trigger
     */
    fun register(
        triggerId: TriggerId,
        wasm: ByteArray,
        repeats: Repeats,
        accountId: AccountId,
        metadata: Metadata,
        filter: EventFilterBox,
    ) = InstructionBox.Register(
        RegisterBox.Trigger(
            RegisterOfTrigger(
                Trigger(
                    triggerId,
                    Action(Executable.Wasm(WasmSmartContract(wasm)), repeats, accountId, filter, metadata),
                ),
            ),
        ),
    )

    /**
     * Register a instructions trigger to run after every transaction
     */
    fun register(
        triggerId: TriggerId,
        isi: List<InstructionBox>,
        repeats: Repeats,
        accountId: AccountId,
        metadata: Metadata,
        filter: TimeEventFilter,
    ) = register(
        triggerId,
        isi,
        repeats,
        accountId,
        metadata,
        EventFilterBox.Time(TimeEventFilter(filter.executionTime)),
    )

    /**
     * Register a instructions trigger to run after every transaction
     */
    fun register(
        triggerId: TriggerId,
        isi: List<InstructionBox>,
        repeats: Repeats,
        accountId: AccountId,
        metadata: Metadata,
        filter: EventFilterBox = EventFilterBox.ExecuteTrigger(
            ExecuteTriggerEventFilter(triggerId, accountId),
        ),
    ) = InstructionBox.Register(
        RegisterBox.Trigger(
            RegisterOfTrigger(
                Trigger(
                    triggerId,
                    Action(Executable.Instructions(isi), repeats, accountId, filter, metadata),
                ),
            ),
        ),
    )

    /**
     * Unregister a trigger
     */
    fun unregister(id: TriggerId) = InstructionBox.Unregister(
        UnregisterBox.Trigger(UnregisterOfTrigger(id)),
    )

    /**
     * Unregister an asset
     */
    fun unregister(id: AssetId) = InstructionBox.Unregister(UnregisterBox.Asset(UnregisterOfAsset(id)))

    /**
     * Unregister an asset definition
     */
    fun unregister(id: AssetDefinitionId) = InstructionBox.Unregister(
        UnregisterBox.AssetDefinition(
            UnregisterOfAssetDefinition(id),
        ),
    )

    /**
     * Unregister an account
     */
    fun unregister(id: AccountId) = InstructionBox.Unregister(UnregisterBox.Account(UnregisterOfAccount(id)))

    /**
     * Unregister a domain
     */
    fun unregister(id: DomainId) = InstructionBox.Unregister(UnregisterBox.Domain(UnregisterOfDomain(id)))

    /**
     * Unregister a role
     */
    fun unregister(id: RoleId) = InstructionBox.Unregister(UnregisterBox.Role(UnregisterOfRole(id)))

    /**
     * Register an asset
     */
    @JvmOverloads
    fun register(
        id: AssetDefinitionId,
        assetType: AssetType,
        metadata: Metadata = Metadata(mapOf()),
        mintable: Mintable = Mintable.Infinitely(),
        logo: IpfsPath? = null,
    ) = InstructionBox.Register(
        RegisterBox.AssetDefinition(
            RegisterOfAssetDefinition(
                NewAssetDefinition(id, assetType, mintable, logo, metadata),
            ),
        ),
    )

    /**
     * Register an asset
     */
    fun register(id: AssetId, assetValue: AssetValue) = InstructionBox.Register(
        RegisterBox.Asset(RegisterOfAsset(Asset(id, assetValue))),
    )

    /**
     * Register a domain
     */
    @JvmOverloads
    fun register(
        domainId: DomainId,
        metadata: Map<Name, Json> = mapOf(),
        logo: IpfsPath? = null,
    ) = InstructionBox.Register(
        RegisterBox.Domain(RegisterOfDomain(NewDomain(domainId, logo, Metadata(metadata)))),
    )

    /**
     * Register a peer
     */
    fun register(peerId: PeerId) = InstructionBox.Register(
        RegisterBox.Peer(RegisterOfPeer(peerId)),
    )

    /**
     * Unregister a peer
     */
    fun unregister(peerId: PeerId) = InstructionBox.Unregister(
        UnregisterBox.Peer(UnregisterOfPeer(peerId)),
    )

    /**
     * Set key/value for a given asset
     */
    fun<V> setKeyValue(
        assetId: AssetId,
        key: Name,
        value: V,
    ) = InstructionBox.SetKeyValue(
        SetKeyValueBox.Asset(
            SetKeyValueOfAsset(assetId, key, Json(mapper.writeValueAsString(value))),
        ),
    )

    /**
     * Set key/value for a given trigger
     */
    fun<V> setKeyValue(
        triggerId: TriggerId,
        key: Name,
        value: V,
    ) = InstructionBox.SetKeyValue(
        SetKeyValueBox.Trigger(
            SetKeyValueOfTrigger(triggerId, key, Json(mapper.writeValueAsString(value))),
        ),
    )

    /**
     * Set key/value for a given asset definition
     */
    fun<V> setKeyValue(
        definitionId: AssetDefinitionId,
        key: Name,
        value: V,
    ) = InstructionBox.SetKeyValue(
        SetKeyValueBox.AssetDefinition(
            SetKeyValueOfAssetDefinition(definitionId, key, Json(mapper.writeValueAsString(value))),
        ),
    )

    /**
     * Set key/value in the metadata of a given domain
     */
    fun<V> setKeyValue(
        domainId: DomainId,
        key: Name,
        value: V,
    ) = InstructionBox.SetKeyValue(
        SetKeyValueBox.Domain(
            SetKeyValueOfDomain(domainId, key, Json(mapper.writeValueAsString(value))),
        ),
    )

    /**
     * Set key/value in the metadata of a given account
     */
    fun<V> setKeyValue(
        accountId: AccountId,
        key: Name,
        value: V,
    ) = InstructionBox.SetKeyValue(
        SetKeyValueBox.Account(
            SetKeyValueOfAccount(accountId, key, Json(mapper.writeValueAsString(value))),
        ),
    )

    /**
     * Remove key/value from a given asset
     */
    fun removeKeyValue(assetId: AssetId, key: Name) = InstructionBox.RemoveKeyValue(
        RemoveKeyValueBox.Asset(RemoveKeyValueOfAsset(assetId, key)),
    )

    /**
     * Execute a trigger
     */
    fun<V> executeTrigger(triggerId: TriggerId, args: V?) = InstructionBox.ExecuteTrigger(
        ExecuteTrigger(
            triggerId,
            Json(mapper.writeValueAsString(args)),
        ),
    )

    /**
     * Mint an asset of the [AssetType.Quantity] asset value type
     */
    fun mint(assetId: AssetId, quantity: Int) = InstructionBox.Mint(
        MintBox.Asset(MintOfNumericAndAsset(quantity.asNumeric(), assetId)),
    )

    /**
     * Mint an asset of the [AssetType.Fixed] asset value type
     */
    fun mint(assetId: AssetId, quantity: BigDecimal) = InstructionBox.Mint(
        MintBox.Asset(MintOfNumericAndAsset(quantity.asNumeric(), assetId)),
    )

    /**
     * Burn an asset of the [AssetType.Quantity] asset value type
     */
    fun burn(assetId: AssetId, value: Int) = InstructionBox.Burn(
        BurnBox.Asset(BurnOfNumericAndAsset(value.asNumeric(), assetId)),
    )

    /**
     * Burn an asset of the [AssetType.Fixed] asset value type
     */
    fun burn(assetId: AssetId, value: BigDecimal) = InstructionBox.Burn(
        BurnBox.Asset(BurnOfNumericAndAsset(value.asNumeric(), assetId)),
    )

    /**
     * Grant an account the custom permission
     */
    fun<P : Permission> grant(
        permission: P,
        destinationId: AccountId,
    ) = InstructionBox.Grant(
        GrantBox.Permission(
            GrantOfPermissionAndAccount(
                permission.asRaw(),
                destinationId,
            ),
        ),
    )

    /**
     * Grant an account a given role.
     */
    fun grant(roleId: RoleId, destinationId: AccountId) = InstructionBox.Grant(
        GrantBox.Role(GrantOfRoleIdAndAccount(roleId, destinationId)),
    )

    /**
     * Transfer an asset from the identifiable source.
     */
    fun transfer(
        sourceId: AssetId,
        value: Int,
        destinationId: AccountId,
    ) = InstructionBox.Transfer(
        TransferBox.Asset(
            AssetTransferBox.Numeric(
                TransferOfAssetAndNumericAndAccount(sourceId, value.asNumeric(), destinationId),
            ),
        ),
    )

    /**
     * Transfer domain ownership.
     */
    fun transfer(
        sourceId: AccountId,
        domainId: DomainId,
        destinationId: AccountId,
    ) = InstructionBox.Transfer(
        TransferBox.Domain(
            TransferOfAccountAndDomainIdAndAccount(sourceId, domainId, destinationId),
        ),
    )

    /**
     * Revoke an account a given role.
     */
    fun revoke(roleId: RoleId, accountId: AccountId): InstructionBox = InstructionBox.Revoke(
        RevokeBox.Role(RevokeOfRoleIdAndAccount(roleId, accountId)),
    )
}
