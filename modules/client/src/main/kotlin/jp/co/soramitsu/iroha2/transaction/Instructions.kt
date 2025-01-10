package jp.co.soramitsu.iroha2.transaction

import jp.co.soramitsu.iroha2.Permissions
import jp.co.soramitsu.iroha2.asJsonString
import jp.co.soramitsu.iroha2.asName
import jp.co.soramitsu.iroha2.asNumeric
import jp.co.soramitsu.iroha2.generated.* // ktlint-disable no-wildcard-imports
import java.math.BigDecimal

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
        vararg tokens: Permission,
    ) = InstructionBox.Register(
        RegisterBox.Role(RegisterOfRole(Role(roleId, tokens.toList()))),
    )

    /**
     * Register an account
     */
    @JvmOverloads
    fun registerAccount(
        id: AccountId,
        metadata: Metadata = Metadata(mapOf()),
    ) = InstructionBox.Register(
        RegisterBox.Account(RegisterOfAccount(NewAccount(id, metadata))),
    )

    /**
     * Register a WASM trigger
     */
    fun registerTrigger(
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
    fun registerTrigger(
        triggerId: TriggerId,
        isi: List<InstructionBox>,
        repeats: Repeats,
        accountId: AccountId,
        metadata: Metadata,
        filter: TimeEventFilter,
    ) = registerTrigger(
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
    fun registerTrigger(
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
    fun unregisterTrigger(id: TriggerId) = InstructionBox.Unregister(
        UnregisterBox.Trigger(UnregisterOfTrigger(id)),
    )

    /**
     * Unregister a trigger
     */
    fun unregisterTrigger(
        triggerName: String,
        domainId: DomainId? = null,
    ) = unregisterTrigger(TriggerId(triggerName.asName()))

    /**
     * Unregister an asset
     */
    fun unregisterAsset(id: AssetId) = InstructionBox.Unregister(UnregisterBox.Asset(UnregisterOfAsset(id)))

    /**
     * Unregister an asset definition
     */
    fun unregisterAssetDefinition(id: AssetDefinitionId) = InstructionBox.Unregister(
        UnregisterBox.AssetDefinition(
            UnregisterOfAssetDefinition(id),
        ),
    )

    /**
     * Unregister an account
     */
    fun unregisterAccount(id: AccountId) = InstructionBox.Unregister(UnregisterBox.Account(UnregisterOfAccount(id)))

    /**
     * Unregister a domain
     */
    fun unregisterDomain(id: DomainId) = InstructionBox.Unregister(UnregisterBox.Domain(UnregisterOfDomain(id)))

    /**
     * Unregister a role
     */
    fun unregisterRole(id: RoleId) = InstructionBox.Unregister(UnregisterBox.Role(UnregisterOfRole(id)))

    /**
     * Register an asset
     */
    @JvmOverloads
    fun registerAssetDefinition(
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
    fun registerAsset(id: AssetId, assetValue: AssetValue) = InstructionBox.Register(
        RegisterBox.Asset(RegisterOfAsset(Asset(id, assetValue))),
    )

    /**
     * Register a domain
     */
    @JvmOverloads
    fun registerDomain(
        domainId: DomainId,
        metadata: Map<Name, String> = mapOf(),
        logo: IpfsPath? = null,
    ) = InstructionBox.Register(
        RegisterBox.Domain(RegisterOfDomain(NewDomain(domainId, logo, Metadata(metadata)))),
    )

    /**
     * Register a peer
     */
    fun registerPeer(
        peerId: PeerId,
    ) = InstructionBox.Register(
        RegisterBox.Peer(RegisterOfPeer(Peer(peerId))),
    )

    /**
     * Unregister a peer
     */
    fun unregisterPeer(peerId: PeerId) = InstructionBox.Unregister(
        UnregisterBox.Peer(UnregisterOfPeer(peerId)),
    )

    /**
     * Set key/value for a given asset
     */
    fun setKeyValue(
        assetId: AssetId,
        key: Name,
        value: String,
    ) = InstructionBox.SetKeyValue(
        SetKeyValueBox.Asset(
            SetKeyValueOfAsset(assetId, key, value),
        ),
    )

    /**
     * Set key/value for a given trigger
     */
    fun setKeyValue(
        triggerId: TriggerId,
        key: Name,
        value: String,
    ) = InstructionBox.SetKeyValue(
        SetKeyValueBox.Trigger(
            SetKeyValueOfTrigger(triggerId, key, value),
        ),
    )

    /**
     * Set key/value for a given asset definition
     */
    fun setKeyValue(
        definitionId: AssetDefinitionId,
        key: Name,
        value: String,
    ) = InstructionBox.SetKeyValue(
        SetKeyValueBox.AssetDefinition(
            SetKeyValueOfAssetDefinition(definitionId, key, value),
        ),
    )

    /**
     * Set key/value in the metadata of a given domain
     */
    fun setKeyValue(
        domainId: DomainId,
        key: Name,
        value: String,
    ) = InstructionBox.SetKeyValue(
        SetKeyValueBox.Domain(SetKeyValueOfDomain(domainId, key, value)),
    )

    /**
     * Set key/value in the metadata of a given account
     */
    fun setKeyValue(
        accountId: AccountId,
        key: Name,
        value: String,
    ) = InstructionBox.SetKeyValue(
        SetKeyValueBox.Account(SetKeyValueOfAccount(accountId, key, value)),
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
    fun executeTrigger(triggerId: TriggerId) = InstructionBox.ExecuteTrigger(ExecuteTrigger(triggerId))

    /**
     * Mint an asset of the [AssetType.Quantity] asset value type
     */
    fun mintAsset(assetId: AssetId, quantity: Int) = InstructionBox.Mint(
        MintBox.Asset(MintOfNumericAndAsset(quantity.asNumeric(), assetId)),
    )

    /**
     * Mint an asset of the [AssetType.Fixed] asset value type
     */
    fun mintAsset(assetId: AssetId, quantity: BigDecimal) = InstructionBox.Mint(
        MintBox.Asset(MintOfNumericAndAsset(quantity.asNumeric(), assetId)),
    )

    /**
     * Burn an asset of the [AssetType.Quantity] asset value type
     */
    fun burnAsset(assetId: AssetId, value: Int) = InstructionBox.Burn(
        BurnBox.Asset(BurnOfNumericAndAsset(value.asNumeric(), assetId)),
    )

    /**
     * Burn an asset of the [AssetType.Fixed] asset value type
     */
    fun burnAsset(assetId: AssetId, value: BigDecimal) = InstructionBox.Burn(
        BurnBox.Asset(BurnOfNumericAndAsset(value.asNumeric(), assetId)),
    )

    /**
     * Grant an account the custom permission
     */
    fun grantPermissionToken(
        permission: Permissions,
        payload: String = "null",
        destinationId: AccountId,
    ) = InstructionBox.Grant(
        GrantBox.Permission(
            GrantOfPermissionAndAccount(
                Permission(permission.type, payload),
                destinationId,
            ),
        ),
    )

    /**
     * Grant an account a given role.
     */
    fun grantRole(roleId: RoleId, destinationId: AccountId) = InstructionBox.Grant(
        GrantBox.Role(GrantOfRoleIdAndAccount(roleId, destinationId)),
    )

    /**
     * Transfer an asset from the identifiable source.
     */
    fun transferAsset(sourceId: AssetId, value: Int, destinationId: AccountId) = InstructionBox.Transfer(
        TransferBox.Asset(
            AssetTransferBox.Numeric(
                TransferOfAssetAndNumericAndAccount(sourceId, value.asNumeric(), destinationId),
            ),
        ),
    )

    /**
     * Transfer domain ownership.
     */
    fun transferDomainOwnership(sourceId: AccountId, domainId: DomainId, destinationId: AccountId) =
        InstructionBox.Transfer(
            TransferBox.Domain(
                TransferOfAccountAndDomainIdAndAccount(sourceId, domainId, destinationId),
            ),
        )

    /**
     * Revoke an account the [Permissions.CanSetKeyValueInUserAsset] permission
     */
    fun revokeSetKeyValueAsset(assetId: AssetId, target: AccountId): InstructionBox {
        return revokeSome(target) {
            Permission(
                name = Permissions.CanSetKeyValueInUserAsset.type,
                payload = assetId.asJsonString(),
            )
        }
    }

    /**
     * Revoke an account the [Permissions.CanSetKeyValueInAccount] permission
     */
    fun revokeSetKeyValueAccount(accountId: AccountId, target: AccountId): InstructionBox {
        return revokeSome(target) {
            Permission(
                name = Permissions.CanSetKeyValueInAccount.type,
                payload = accountId.asJsonString(),
            )
        }
    }

    /**
     * Revoke an account the [Permissions.CanSetKeyValueInDomain] permission
     */
    fun grantSetKeyValueDomain(domainId: DomainId, target: AccountId): InstructionBox {
        return InstructionBox.Grant(
            GrantBox.Permission(
                GrantOfPermissionAndAccount(
                    Permission(
                        name = Permissions.CanSetKeyValueInDomain.type,
                        payload = domainId.asJsonString(),
                    ),
                    target,
                ),
            ),
        )
    }

    /**
     * Revoke an account the [Permissions.CanSetKeyValueInDomain] permission
     */
    fun revokeSetKeyValueDomain(domainId: DomainId, target: AccountId): InstructionBox {
        return revokeSome(target) {
            Permission(
                name = Permissions.CanSetKeyValueInDomain.type,
                payload = domainId.asJsonString(),
            )
        }
    }

    /**
     * Revoke an account a given role.
     */
    fun revokeRole(roleId: RoleId, accountId: AccountId): InstructionBox {
        return InstructionBox.Revoke(
            RevokeBox.Role(RevokeOfRoleIdAndAccount(roleId, accountId)),
        )
    }

    private inline fun revokeSome(
        accountId: AccountId,
        permission: () -> Permission,
    ) = InstructionBox.Revoke(
        RevokeBox.Permission(
            RevokeOfPermissionAndAccount(permission(), accountId),
        ),
    )
}
