package jp.co.soramitsu.iroha2.query

import jp.co.soramitsu.iroha2.generated.*

/**
 * Queries are sent to an Iroha peer and prompt a response with details from the current world state view.
 */
object Queries {
    /**
     * Return the values of all known accounts
     */
    fun findAccounts(predicate: CompoundPredicateOfAccountPredicateBox) = QueryBox.FindAccounts(
        QueryWithFilterOfFindAccountsAndAccountPredicateBox(FindAccounts(), predicate),
    )

    /**
     * Return all the accounts that belong to a specific asset definition [AssetDefinitionId]
     */
    fun findAccountsWithAsset(definitionId: AssetDefinitionId, predicate: CompoundPredicateOfAccountPredicateBox) =
        QueryBox.FindAccountsWithAsset(
            QueryWithFilterOfFindAccountsWithAssetAndAccountPredicateBox(
                FindAccountsWithAsset(definitionId),
                predicate,
            ),
        )

    /**
     * Return the values of all known assets
     */
    fun findAssets(predicate: CompoundPredicateOfAssetPredicateBox) = QueryBox.FindAssets(
        QueryWithFilterOfFindAssetsAndAssetPredicateBox(
            FindAssets(),
            predicate,
        ),
    )

    /**
     * Return the values of all known asset definitions
     */
    fun findAssetsDefinitions(predicate: CompoundPredicateOfAssetDefinitionPredicateBox) = QueryBox.FindAssetsDefinitions(
        QueryWithFilterOfFindAssetsDefinitionsAndAssetDefinitionPredicateBox(
            FindAssetsDefinitions(),
            predicate,
        ),
    )

    /**
     * Return all known registered domains
     */
    fun findDomains(predicate: CompoundPredicateOfDomainPredicateBox) = QueryBox.FindDomains(
        QueryWithFilterOfFindDomainsAndDomainPredicateBox(FindDomains(), predicate),
    )

    /**
     * Return all known peers identified by their key and accompanied by the address of their API endpoint
     */
    fun findPeers(predicate: CompoundPredicateOfPeerPredicateBox) = QueryBox.FindPeers(
        QueryWithFilterOfFindPeersAndPeerPredicateBox(FindPeers(), predicate),
    )

    /**
     * Return the full set of transactions
     */
    fun findTransactions(predicate: CompoundPredicateOfCommittedTransactionPredicateBox) = QueryBox.FindTransactions(
        QueryWithFilterOfFindTransactionsAndCommittedTransactionPredicateBox(
            FindTransactions(),
            predicate,
        ),
    )

    /**
     * Return all the permission tokens granted to the specified [AccountId]
     */
    fun findPermissionsByAccountId(accountId: AccountId, predicate: CompoundPredicateOfPermissionPredicateBox) =
        QueryBox.FindPermissionsByAccountId(
            QueryWithFilterOfFindPermissionsByAccountIdAndPermissionPredicateBox(
                FindPermissionsByAccountId(accountId),
                predicate,
            ),
        )

    /**
     * Return the full set of roles
     */
    fun findRoles(predicate: CompoundPredicateOfRolePredicateBox) = QueryBox.FindRoles(
        QueryWithFilterOfFindRolesAndRolePredicateBox(
            FindRoles(),
            predicate,
        ),
    )

    /**
     * Return the full set of role IDs
     */
    fun findRoleIds(predicate: CompoundPredicateOfRoleIdPredicateBox) = QueryBox.FindRoleIds(
        QueryWithFilterOfFindRoleIdsAndRoleIdPredicateBox(
            FindRoleIds(),
            predicate,
        ),
    )

    /**
     * Return all the role IDs that are attached to the given [AccountId]
     */
    fun findRolesByAccountId(accountId: AccountId, predicate: CompoundPredicateOfRoleIdPredicateBox) = QueryBox.FindRolesByAccountId(
        QueryWithFilterOfFindRolesByAccountIdAndRoleIdPredicateBox(
            FindRolesByAccountId(accountId),
            predicate,
        ),
    )

    /**
     * Return all currently triggers
     */
    fun findTriggers(predicate: CompoundPredicateOfTriggerPredicateBox) = QueryBox.FindTriggers(
        QueryWithFilterOfFindTriggersAndTriggerPredicateBox(FindTriggers(), predicate),
    )

    /**
     * Return all active trigger IDs
     */
    fun findActiveTriggerIds(predicate: CompoundPredicateOfTriggerIdPredicateBox) = QueryBox.FindActiveTriggerIds(
        QueryWithFilterOfFindActiveTriggerIdsAndTriggerIdPredicateBox(
            FindActiveTriggerIds(),
            predicate,
        ),
    )

    /**
     * Return all blocks
     */
    fun findBlocks(predicate: CompoundPredicateOfSignedBlockPredicateBox) = QueryBox.FindBlocks(
        QueryWithFilterOfFindBlocksAndSignedBlockPredicateBox(FindBlocks(), predicate),
    )

    /**
     * Return all block headers
     */
    fun findBlockHeaders(predicate: CompoundPredicateOfBlockHeaderPredicateBox) = QueryBox.FindBlockHeaders(
        QueryWithFilterOfFindBlockHeadersAndBlockHeaderPredicateBox(
            FindBlockHeaders(),
            predicate,
        ),
    )

    fun findExecutorDataModel() = SingularQueryBox.FindExecutorDataModel(
        FindExecutorDataModel(),
    )

    fun findParameters() = SingularQueryBox.FindParameters(
        FindParameters(),
    )

    fun findDomainMetadata(id: DomainId, key: Name) = SingularQueryBox.FindDomainMetadata(
        FindDomainMetadata(id, key),
    )

    fun findAccountMetadata(id: AccountId, key: Name) = SingularQueryBox.FindAccountMetadata(
        FindAccountMetadata(id, key),
    )

    fun findAssetMetadata(id: AssetId, key: Name) = SingularQueryBox.FindAssetMetadata(
        FindAssetMetadata(id, key),
    )

    fun findAssetDefinitionMetadata(id: AssetDefinitionId, key: Name) = SingularQueryBox.FindAssetDefinitionMetadata(
        FindAssetDefinitionMetadata(id, key),
    )

    fun findTriggerMetadata(id: TriggerId, key: Name) = SingularQueryBox.FindTriggerMetadata(
        FindTriggerMetadata(id, key),
    )
}
