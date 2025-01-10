package jp.co.soramitsu.iroha2.query

import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.AssetId
import jp.co.soramitsu.iroha2.generated.DomainId
import jp.co.soramitsu.iroha2.generated.FindAccountById
import jp.co.soramitsu.iroha2.generated.FindAccountKeyValueByIdAndKey
import jp.co.soramitsu.iroha2.generated.FindAccountsByDomainId
import jp.co.soramitsu.iroha2.generated.FindAccountsWithAsset
import jp.co.soramitsu.iroha2.generated.FindAllAccounts
import jp.co.soramitsu.iroha2.generated.FindAllActiveTriggerIds
import jp.co.soramitsu.iroha2.generated.FindAllAssets
import jp.co.soramitsu.iroha2.generated.FindAllAssetsDefinitions
import jp.co.soramitsu.iroha2.generated.FindAllBlockHeaders
import jp.co.soramitsu.iroha2.generated.FindAllBlocks
import jp.co.soramitsu.iroha2.generated.FindAllDomains
import jp.co.soramitsu.iroha2.generated.FindAllParameters
import jp.co.soramitsu.iroha2.generated.FindAllPeers
import jp.co.soramitsu.iroha2.generated.FindAllRoleIds
import jp.co.soramitsu.iroha2.generated.FindAllRoles
import jp.co.soramitsu.iroha2.generated.FindAllTransactions
import jp.co.soramitsu.iroha2.generated.FindAssetById
import jp.co.soramitsu.iroha2.generated.FindAssetDefinitionById
import jp.co.soramitsu.iroha2.generated.FindAssetDefinitionKeyValueByIdAndKey
import jp.co.soramitsu.iroha2.generated.FindAssetKeyValueByIdAndKey
import jp.co.soramitsu.iroha2.generated.FindAssetQuantityById
import jp.co.soramitsu.iroha2.generated.FindAssetsByAccountId
import jp.co.soramitsu.iroha2.generated.FindAssetsByAssetDefinitionId
import jp.co.soramitsu.iroha2.generated.FindAssetsByDomainId
import jp.co.soramitsu.iroha2.generated.FindAssetsByDomainIdAndAssetDefinitionId
import jp.co.soramitsu.iroha2.generated.FindAssetsByName
import jp.co.soramitsu.iroha2.generated.FindBlockHeaderByHash
import jp.co.soramitsu.iroha2.generated.FindDomainById
import jp.co.soramitsu.iroha2.generated.FindDomainKeyValueByIdAndKey
import jp.co.soramitsu.iroha2.generated.FindExecutorDataModel
import jp.co.soramitsu.iroha2.generated.FindPermissionsByAccountId
import jp.co.soramitsu.iroha2.generated.FindRoleByRoleId
import jp.co.soramitsu.iroha2.generated.FindRolesByAccountId
import jp.co.soramitsu.iroha2.generated.FindTotalAssetQuantityByAssetDefinitionId
import jp.co.soramitsu.iroha2.generated.FindTransactionByHash
import jp.co.soramitsu.iroha2.generated.FindTransactionsByAccountId
import jp.co.soramitsu.iroha2.generated.FindTriggerById
import jp.co.soramitsu.iroha2.generated.FindTriggerKeyValueByIdAndKey
import jp.co.soramitsu.iroha2.generated.FindTriggersByAuthorityDomainId
import jp.co.soramitsu.iroha2.generated.FindTriggersByAuthorityId
import jp.co.soramitsu.iroha2.generated.Hash
import jp.co.soramitsu.iroha2.generated.HashOf
import jp.co.soramitsu.iroha2.generated.Name
import jp.co.soramitsu.iroha2.generated.QueryBox
import jp.co.soramitsu.iroha2.generated.RoleId
import jp.co.soramitsu.iroha2.generated.SignedTransaction
import jp.co.soramitsu.iroha2.generated.TriggerId

/**
 * Queries are sent to an Iroha peer and prompt a response with details from the current world state view.
 */
object Queries {

    /**
     * Find all accounts registered globally in the blockchain
     */
    fun findAllAccounts() = QueryBox.FindAllAccounts(FindAllAccounts())

    /**
     * Return the full account information corresponding to the given [AccountId]
     */
    fun findAccountById(accountId: AccountId) = QueryBox.FindAccountById(FindAccountById(accountId))

    /**
     * Return the value keyed by the provided [Name] for the given [AccountId]
     */
    fun findAccountKeyValueByIdAndKey(accountId: AccountId, key: Name) = QueryBox.FindAccountKeyValueByIdAndKey(
        FindAccountKeyValueByIdAndKey(accountId, key),
    )

    /**
     * Return all the accounts that belong to a specific domain [DomainId]
     */
    fun findAccountsByDomainId(domainId: DomainId) = QueryBox.FindAccountsByDomainId(
        FindAccountsByDomainId(domainId),
    )

    /**
     * Return all the accounts that belong to a specific asset definition [AssetDefinitionId]
     */
    fun findAccountsWithAsset(definitionId: AssetDefinitionId) = QueryBox.FindAccountsWithAsset(
        FindAccountsWithAsset(definitionId),
    )

    /**
     * Return the values of all known assets
     */
    fun findAllAssets() = QueryBox.FindAllAssets(FindAllAssets())

    /**
     * Return the aggregated data about the [AssetId] usage across the network
     */
    fun findAssetById(assetId: AssetId) = QueryBox.FindAssetById(FindAssetById(assetId))

    /**
     * Return all the assets that are registered in the given domain [DomainId]
     */
    fun findAssetsByDomainId(domainId: DomainId) = QueryBox.FindAssetsByDomainId(
        FindAssetsByDomainId(domainId),
    )

    /**
     * Search the network for all assets that match the given [Name]
     */
    fun findAssetsByName(name: Name) = QueryBox.FindAssetsByName(FindAssetsByName(name))

    /**
     * Return all the assets that belong to a given [AccountId]
     */
    fun findAssetsByAccountId(accountId: AccountId) = QueryBox.FindAssetsByAccountId(
        FindAssetsByAccountId(accountId),
    )

    /**
     * Search for all the assets that have the given [AssetDefinitionId]
     */
    fun findAssetsByAssetDefinitionId(assetDefinition: AssetDefinitionId) = QueryBox.FindAssetsByAssetDefinitionId(
        FindAssetsByAssetDefinitionId(assetDefinition),
    )

    /**
     * Search the domain with the [DomainId] for assets that have the given [AssetDefinitionId]
     */
    fun findAssetsByDomainIdAndAssetDefinitionId(
        domainId: DomainId,
        assetDefinition: AssetDefinitionId,
    ) = QueryBox.FindAssetsByDomainIdAndAssetDefinitionId(
        FindAssetsByDomainIdAndAssetDefinitionId(
            domainId,
            assetDefinition,
        ),
    )

    /**
     * Return the values of all known asset definitions
     */
    fun findAllAssetsDefinitions() = QueryBox.FindAllAssetsDefinitions(FindAllAssetsDefinitions())

    /**
     * Return the asset quantity for the given asset with [AssetId]
     */
    fun findAssetQuantityById(assetId: AssetId) = QueryBox.FindAssetQuantityById(
        FindAssetQuantityById(assetId),
    )

    /**
     * Return the asset quantity for the given asset with [AssetDefinitionId]
     */
    fun findTotalAssetQuantityByAssetDefinitionId(
        definitionId: AssetDefinitionId,
    ) = QueryBox.FindTotalAssetQuantityByAssetDefinitionId(
        FindTotalAssetQuantityByAssetDefinitionId(definitionId),
    )

    /**
     * Return the value keyed by the given [Name] in the metadata of the asset corresponding to the given [AssetId]
     */
    fun findAssetKeyValueByIdAndKey(assetId: AssetId, key: Name) = QueryBox.FindAssetKeyValueByIdAndKey(
        FindAssetKeyValueByIdAndKey(assetId, key),
    )

    /**
     * Return the value keyed by the given [Name]
     * in the metadata of the asset definition corresponding to the given [AssetDefinitionId]
     */
    fun findAssetDefinitionKeyValueByIdAndKey(
        assetDefinition: AssetDefinitionId,
        key: Name,
    ) = QueryBox.FindAssetDefinitionKeyValueByIdAndKey(
        FindAssetDefinitionKeyValueByIdAndKey(
            assetDefinition,
            key,
        ),
    )

    /**
     * Return the asset definition corresponding to the given [AssetDefinitionId]
     */
    fun findAssetDefinitionById(definitionId: AssetDefinitionId) = QueryBox.FindAssetDefinitionById(
        FindAssetDefinitionById(definitionId),
    )

    /**
     * Return all known registered domains
     */
    fun findAllDomains() = QueryBox.FindAllDomains(FindAllDomains())

    /**
     * Return the domain corresponding to the given [DomainId]
     */
    fun findDomainById(domainId: DomainId) = QueryBox.FindDomainById(FindDomainById(domainId))

    /**
     * Return all known peers identified by their key and accompanied by the address of their API endpoint
     */
    fun findAllPeers() = QueryBox.FindAllPeers(FindAllPeers())

    /**
     * Return the full set of transactions that an account with [AccountId] has submitted throughout the existence of the blockchain
     */
    fun findTransactionsByAccountId(accountId: AccountId) = QueryBox.FindTransactionsByAccountId(
        FindTransactionsByAccountId(accountId),
    )

    /**
     * Return all the permission tokens granted to the specified [AccountId]
     */
    fun findPermissionsByAccountId(accountId: AccountId) = QueryBox.FindPermissionsByAccountId(
        FindPermissionsByAccountId(accountId),
    )

    /**
     * Return executor data model
     */
    fun findExecutorDataModel() = QueryBox.FindExecutorDataModel(
        FindExecutorDataModel(),
    )

    /**
     * Return the transaction by [Hash]
     */
    fun findTransactionByHash(hash: Hash) = QueryBox.FindTransactionByHash(
        FindTransactionByHash(HashOf<SignedTransaction>(hash)),
    )

    /**
     * Return all the role IDs that are attached to the given [AccountId]
     */
    fun findRolesByAccountId(accountId: AccountId) = QueryBox.FindRolesByAccountId(
        FindRolesByAccountId(accountId),
    )

    /**
     * Return all roles
     */
    fun findAllRoles() = QueryBox.FindAllRoles(FindAllRoles())

    /**
     * Return the role by [RoleId]
     */
    fun findRoleByRoleId(roleId: RoleId) = QueryBox.FindRoleByRoleId(FindRoleByRoleId(roleId))

    /**
     * Return all role IDs
     */
    fun findAllRoleIds() = QueryBox.FindAllRoleIds(FindAllRoleIds())

    /**
     * Return the value keyed by the given [Name] in the domain corresponding to the given [DomainId]
     */
    fun findDomainKeyValueByIdAndKey(id: DomainId, key: Name) = QueryBox.FindDomainKeyValueByIdAndKey(
        FindDomainKeyValueByIdAndKey(id, key),
    )

    /**
     * Return the value corresponding to the given key [Name] in the metadata of the trigger with the given [TriggerId]
     */
    fun findTriggerKeyValueByIdAndKey(id: TriggerId, key: Name) = QueryBox.FindTriggerKeyValueByIdAndKey(
        FindTriggerKeyValueByIdAndKey(id, key),
    )

    /**
     * Return the trigger with the given [TriggerId]
     */
    fun findTriggerById(id: TriggerId) = QueryBox.FindTriggerById(FindTriggerById(id))

    /**
     * Return all currently active triggers, that have not expired at the time of the query
     */
    fun findAllActiveTriggerIds() = QueryBox.FindAllActiveTriggerIds(FindAllActiveTriggerIds())

    /**
     * Return a trigger with the given [AccountId]
     */
    fun findTriggersByAuthorityId(id: AccountId) = QueryBox.FindTriggersByAuthorityId(
        FindTriggersByAuthorityId(id),
    )

    /**
     * Return all currently triggers with the given [DomainId]
     */
    fun findTriggersByAuthorityDomainId(domainId: DomainId) = QueryBox.FindTriggersByAuthorityDomainId(
        FindTriggersByAuthorityDomainId(domainId),
    )

    /**
     * Return all blocks
     */
    fun findAllBlocks() = QueryBox.FindAllBlocks(FindAllBlocks())

    /**
     * Return all block headers
     */
    fun findAllBlockHeaders() = QueryBox.FindAllBlockHeaders(FindAllBlockHeaders())

    /**
     * Return the block header corresponding to the given [Hash]
     */
    fun findBlockHeaderByHash(hash: Hash) = QueryBox.FindBlockHeaderByHash(
        FindBlockHeaderByHash(HashOf(hash)),
    )

    /**
     * Return all transactions
     */
    fun findAllTransactions() = QueryBox.FindAllTransactions(FindAllTransactions())

    /**
     * Return all parameters
     */
    fun findAllParameters() = QueryBox.FindAllParameters(FindAllParameters())
}
