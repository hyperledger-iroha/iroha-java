package jp.co.soramitsu.iroha2.transaction

import jp.co.soramitsu.iroha2.ModelPermission
import jp.co.soramitsu.iroha2.asNumeric
import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.Action
import jp.co.soramitsu.iroha2.generated.Asset
import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.AssetId
import jp.co.soramitsu.iroha2.generated.AssetType
import jp.co.soramitsu.iroha2.generated.AssetValue
import jp.co.soramitsu.iroha2.generated.BurnOfNumericAndAsset
import jp.co.soramitsu.iroha2.generated.BurnOfu32AndTrigger
import jp.co.soramitsu.iroha2.generated.DomainId
import jp.co.soramitsu.iroha2.generated.EventFilterBox
import jp.co.soramitsu.iroha2.generated.Executable
import jp.co.soramitsu.iroha2.generated.ExecuteTrigger
import jp.co.soramitsu.iroha2.generated.GrantOfPermissionAndAccount
import jp.co.soramitsu.iroha2.generated.GrantOfPermissionAndRole
import jp.co.soramitsu.iroha2.generated.GrantOfRoleIdAndAccount
import jp.co.soramitsu.iroha2.generated.InstructionBox
import jp.co.soramitsu.iroha2.generated.IpfsPath
import jp.co.soramitsu.iroha2.generated.Json
import jp.co.soramitsu.iroha2.generated.Metadata
import jp.co.soramitsu.iroha2.generated.MintOfNumericAndAsset
import jp.co.soramitsu.iroha2.generated.MintOfu32AndTrigger
import jp.co.soramitsu.iroha2.generated.Mintable
import jp.co.soramitsu.iroha2.generated.Name
import jp.co.soramitsu.iroha2.generated.NewAccount
import jp.co.soramitsu.iroha2.generated.NewAssetDefinition
import jp.co.soramitsu.iroha2.generated.NewDomain
import jp.co.soramitsu.iroha2.generated.NewRole
import jp.co.soramitsu.iroha2.generated.PeerId
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
import jp.co.soramitsu.iroha2.generated.Repeats
import jp.co.soramitsu.iroha2.generated.RevokeOfPermissionAndAccount
import jp.co.soramitsu.iroha2.generated.RevokeOfPermissionAndRole
import jp.co.soramitsu.iroha2.generated.RevokeOfRoleIdAndAccount
import jp.co.soramitsu.iroha2.generated.Role
import jp.co.soramitsu.iroha2.generated.RoleId
import jp.co.soramitsu.iroha2.generated.SetKeyValueOfAccount
import jp.co.soramitsu.iroha2.generated.SetKeyValueOfAsset
import jp.co.soramitsu.iroha2.generated.SetKeyValueOfAssetDefinition
import jp.co.soramitsu.iroha2.generated.SetKeyValueOfDomain
import jp.co.soramitsu.iroha2.generated.SetKeyValueOfTrigger
import jp.co.soramitsu.iroha2.generated.TransferOfAccountAndAssetDefinitionIdAndAccount
import jp.co.soramitsu.iroha2.generated.TransferOfAccountAndDomainIdAndAccount
import jp.co.soramitsu.iroha2.generated.TransferOfAssetAndMetadataAndAccount
import jp.co.soramitsu.iroha2.generated.TransferOfAssetAndNumericAndAccount
import jp.co.soramitsu.iroha2.generated.Trigger
import jp.co.soramitsu.iroha2.generated.TriggerId
import jp.co.soramitsu.iroha2.generated.UnregisterOfAccount
import jp.co.soramitsu.iroha2.generated.UnregisterOfAsset
import jp.co.soramitsu.iroha2.generated.UnregisterOfAssetDefinition
import jp.co.soramitsu.iroha2.generated.UnregisterOfDomain
import jp.co.soramitsu.iroha2.generated.UnregisterOfPeer
import jp.co.soramitsu.iroha2.generated.UnregisterOfRole
import jp.co.soramitsu.iroha2.generated.UnregisterOfTrigger
import jp.co.soramitsu.iroha2.generated.WasmSmartContract
import jp.co.soramitsu.iroha2.writeValue
import java.math.BigDecimal

interface Instruction {
    fun asInstructionBox(): InstructionBox
}

class Register {
    companion object {
        /**
         * Register a peer
         */
        fun peer(peerId: PeerId) = RegisterOfPeer(peerId)

        /**
         * Register a domain
         */
        fun domain(
            domainId: DomainId,
            metadata: Map<Name, Json> = mapOf(),
            logo: IpfsPath? = null,
        ) = RegisterOfDomain(NewDomain(domainId, logo, Metadata(metadata)))

        /**
         * Register an asset
         */
        fun assetDefinition(
            id: AssetDefinitionId,
            assetType: AssetType,
            mintable: Mintable = Mintable.Infinitely(),
            logo: IpfsPath? = null,
            metadata: Metadata = Metadata(mapOf()),
        ) = RegisterOfAssetDefinition(NewAssetDefinition(id, assetType, mintable, logo, metadata))

        /**
         * Register an account
         */
        fun account(id: AccountId, metadata: Metadata = Metadata(mapOf())) = RegisterOfAccount(NewAccount(id, metadata))

        /**
         * Register an asset
         */
        fun asset(id: AssetId, assetValue: AssetValue) = RegisterOfAsset(Asset(id, assetValue))

        /**
         * Register a role that has the specified permissions
         */
        fun role(
            grantTo: AccountId,
            roleId: RoleId,
            vararg tokens: ModelPermission,
        ) = RegisterOfRole(NewRole(Role(roleId, tokens.map { it.asRaw() }), grantTo))

        /**
         * Register a trigger
         */
        fun trigger(
            triggerId: TriggerId,
            isi: List<Instruction>,
            repeats: Repeats,
            accountId: AccountId,
            filter: EventFilterBox,
            metadata: Metadata = Metadata(mapOf()),
        ) = RegisterOfTrigger(
            Trigger(
                triggerId,
                Action(Executable.Instructions(isi.map { it.asInstructionBox() }), repeats, accountId, filter, metadata),
            ),
        )

        /**
         * Register a WASM trigger
         */
        fun trigger(
            triggerId: TriggerId,
            wasm: ByteArray,
            repeats: Repeats,
            accountId: AccountId,
            filter: EventFilterBox,
            metadata: Metadata = Metadata(mapOf()),
        ) = RegisterOfTrigger(
            Trigger(
                triggerId,
                Action(Executable.Wasm(WasmSmartContract(wasm)), repeats, accountId, filter, metadata),
            ),
        )
    }
}

class Unregister {
    companion object {
        /**
         * Unregister a peer
         */
        fun peer(peerId: PeerId) = UnregisterOfPeer(peerId)

        /**
         * Unregister a domain
         */
        fun domain(id: DomainId) = UnregisterOfDomain(id)

        /**
         * Unregister an asset definition
         */
        fun assetDefinition(id: AssetDefinitionId) = UnregisterOfAssetDefinition(id)

        /**
         * Unregister an account
         */
        fun account(id: AccountId) = UnregisterOfAccount(id)

        /**
         * Unregister an asset
         */
        fun asset(id: AssetId) = UnregisterOfAsset(id)

        /**
         * Unregister a role
         */
        fun role(id: RoleId) = UnregisterOfRole(id)

        /**
         * Unregister a trigger
         */
        fun trigger(id: TriggerId) = UnregisterOfTrigger(id)
    }
}

class SetKeyValue {
    companion object {
        /**
         * Set key/value in the metadata of a given domain
         */
        fun <V> domain(
            domainId: DomainId,
            key: Name,
            value: V,
        ) = SetKeyValueOfDomain(domainId, key, Json.writeValue(value))

        /**
         * Set key/value for a given asset definition
         */
        fun <V> assetDefinition(
            definitionId: AssetDefinitionId,
            key: Name,
            value: V,
        ) = SetKeyValueOfAssetDefinition(definitionId, key, Json.writeValue(value))

        /**
         * Set key/value in the metadata of a given account
         */
        fun <V> account(
            accountId: AccountId,
            key: Name,
            value: V,
        ) = SetKeyValueOfAccount(accountId, key, Json.writeValue(value))

        /**
         * Set key/value for a given asset
         */
        fun <V> asset(
            assetId: AssetId,
            key: Name,
            value: V,
        ) = SetKeyValueOfAsset(assetId, key, Json.writeValue(value))

        /**
         * Set key/value for a given trigger
         */
        fun <V> trigger(
            triggerId: TriggerId,
            key: Name,
            value: V,
        ) = SetKeyValueOfTrigger(triggerId, key, Json.writeValue(value))
    }
}

class RemoveKeyValue {
    companion object {
        /**
         * Remove key/value from a given domain
         */
        fun domain(domainId: DomainId, key: Name) = RemoveKeyValueOfDomain(domainId, key)

        /**
         * Remove key/value from a given asset definition
         */
        fun assetDefinition(assetDefinitionId: AssetDefinitionId, key: Name) = RemoveKeyValueOfAssetDefinition(assetDefinitionId, key)

        /**
         * Remove key/value from a given account
         */
        fun account(accountId: AccountId, key: Name) = RemoveKeyValueOfAccount(accountId, key)

        /**
         * Remove key/value from a given asset
         */
        fun asset(assetId: AssetId, key: Name) = RemoveKeyValueOfAsset(assetId, key)

        /**
         * Remove key/value from a given trigger
         */
        fun trigger(triggerId: TriggerId, key: Name) = RemoveKeyValueOfTrigger(triggerId, key)
    }
}

class Mint {
    companion object {
        /**
         * Increase a numeric asset by the given amount
         */
        fun asset(assetId: AssetId, quantity: BigDecimal) = MintOfNumericAndAsset(quantity.asNumeric(), assetId)

        /**
         * Increase number of trigger repetitions
         */
        fun trigger(triggerId: TriggerId, quantity: Long) = MintOfu32AndTrigger(quantity, triggerId)
    }
}

class Burn {
    companion object {
        /**
         * Decrease a numeric asset by the given amount
         */
        fun asset(assetId: AssetId, value: BigDecimal) = BurnOfNumericAndAsset(value.asNumeric(), assetId)

        /**
         * Decrease number of trigger repetitions
         */
        fun trigger(triggerId: TriggerId, quantity: Long) = BurnOfu32AndTrigger(quantity, triggerId)
    }
}

class Transfer {
    companion object {
        /**
         * Transfer domain ownership.
         */
        fun domain(
            sourceId: AccountId,
            domainId: DomainId,
            destinationId: AccountId,
        ) = TransferOfAccountAndDomainIdAndAccount(sourceId, domainId, destinationId)

        /**
         * Transfer asset definition ownership
         */
        fun assetDefinition(
            sourceId: AccountId,
            value: AssetDefinitionId,
            destinationId: AccountId,
        ) = TransferOfAccountAndAssetDefinitionIdAndAccount(sourceId, value, destinationId)

        /**
         * Transfer a numeric asset
         */
        fun asset(
            sourceId: AssetId,
            value: Metadata,
            destinationId: AccountId,
        ) = TransferOfAssetAndMetadataAndAccount(sourceId, value, destinationId)

        /**
         * Transfer a store asset
         */
        fun asset(
            sourceId: AssetId,
            value: BigDecimal,
            destinationId: AccountId,
        ) = TransferOfAssetAndNumericAndAccount(sourceId, value.asNumeric(), destinationId)
    }
}

class Grant {
    companion object {
        /**
         * Grant permission to the given account
         */
        fun <P : ModelPermission> accountPermission(permission: P, destinationId: AccountId) = GrantOfPermissionAndAccount(
            permission.asRaw(),
            destinationId,
        )

        /**
         * Grant role to the given account
         */
        fun accountRole(roleId: RoleId, destinationId: AccountId) = GrantOfRoleIdAndAccount(roleId, destinationId)

        /**
         * Grant permission to the given role
         */
        fun <P : ModelPermission> rolePermission(permission: P, destinationId: RoleId) =
            GrantOfPermissionAndRole(permission.asRaw(), destinationId)
    }
}

class Revoke {
    companion object {
        /**
         * Revoke permission from the given account
         */
        fun <P : ModelPermission> accountPermission(permission: P, accountId: AccountId) =
            RevokeOfPermissionAndAccount(permission.asRaw(), accountId)

        /**
         * Revoke role from the given account
         */
        fun accountRole(roleId: RoleId, accountId: AccountId) = RevokeOfRoleIdAndAccount(roleId, accountId)

        /**
         * Revoke permission from the given role
         */
        fun <P : ModelPermission> rolePermission(permission: P, roleId: RoleId) = RevokeOfPermissionAndRole(permission.asRaw(), roleId)
    }
}

class Execute {
    companion object {
        /**
         * Execute a pre-registered trigger
         */
        fun trigger(triggerId: TriggerId, args: Json = Json.writeValue(null)) = ExecuteTrigger(triggerId, args)
    }
}