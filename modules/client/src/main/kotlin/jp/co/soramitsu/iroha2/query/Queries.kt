package jp.co.soramitsu.iroha2.query

import jp.co.soramitsu.iroha2.generated.*

/**
 * Queries are sent to an Iroha peer and prompt a response with details from the current world state view.
 */
object Queries {
    /**
     * Return the values of all known accounts
     */
    fun findAccounts(predicate: CompoundPredicateOfAccount, selector: SelectorTupleOfAccount) = QueryBox.FindAccounts(
        QueryWithFilterOfFindAccounts(FindAccounts(), predicate, selector),
    )

    /**
     * Return all the accounts that belong to a specific asset definition [AssetDefinitionId]
     */
    fun findAccountsWithAsset(
        definitionId: AssetDefinitionId,
        predicate: CompoundPredicateOfAccount,
        selector: SelectorTupleOfAccount,
    ) = QueryBox.FindAccountsWithAsset(
        QueryWithFilterOfFindAccountsWithAsset(
            FindAccountsWithAsset(definitionId),
            predicate,
            selector,
        ),
    )

    /**
     * Return the values of all known assets
     */
    fun findAssets(predicate: CompoundPredicateOfAsset, selector: SelectorTupleOfAsset) = QueryBox.FindAssets(
        QueryWithFilterOfFindAssets(
            FindAssets(),
            predicate,
            selector,
        ),
    )

    /**
     * Return the values of all known asset definitions
     */
    fun findAssetsDefinitions(predicate: CompoundPredicateOfAssetDefinition, selector: SelectorTupleOfAssetDefinition) =
        QueryBox.FindAssetsDefinitions(
            QueryWithFilterOfFindAssetsDefinitions(
                FindAssetsDefinitions(),
                predicate,
                selector,
            ),
        )

    /**
     * Return all known registered domains
     */
    fun findDomains(predicate: CompoundPredicateOfDomain, selector: SelectorTupleOfDomain) = QueryBox.FindDomains(
        QueryWithFilterOfFindDomains(FindDomains(), predicate, selector),
    )

    /**
     * Return all known peers identified by their key and accompanied by the address of their API endpoint
     */
    fun findPeers(predicate: CompoundPredicateOfPeerId, selector: SelectorTupleOfPeerId) = QueryBox.FindPeers(
        QueryWithFilterOfFindPeers(FindPeers(), predicate, selector),
    )

    /**
     * Return the full set of transactions
     */
    fun findTransactions(predicate: CompoundPredicateOfCommittedTransaction, selector: SelectorTupleOfCommittedTransaction) =
        QueryBox.FindTransactions(
            QueryWithFilterOfFindTransactions(
                FindTransactions(),
                predicate,
                selector,
            ),
        )

    /**
     * Return all the permission tokens granted to the specified [AccountId]
     */
    fun findPermissionsByAccountId(
        accountId: AccountId,
        predicate: CompoundPredicateOfPermission,
        selector: SelectorTupleOfPermission,
    ) = QueryBox.FindPermissionsByAccountId(
        QueryWithFilterOfFindPermissionsByAccountId(
            FindPermissionsByAccountId(accountId),
            predicate,
            selector,
        ),
    )

    /**
     * Return the full set of roles
     */
    fun findRoles(predicate: CompoundPredicateOfRole, selector: SelectorTupleOfRole) = QueryBox.FindRoles(
        QueryWithFilterOfFindRoles(
            FindRoles(),
            predicate,
            selector,
        ),
    )

    /**
     * Return the full set of role IDs
     */
    fun findRoleIds(predicate: CompoundPredicateOfRoleId, selector: SelectorTupleOfRoleId) = QueryBox.FindRoleIds(
        QueryWithFilterOfFindRoleIds(
            FindRoleIds(),
            predicate,
            selector,
        ),
    )

    /**
     * Return all the role IDs that are attached to the given [AccountId]
     */
    fun findRolesByAccountId(
        accountId: AccountId,
        predicate: CompoundPredicateOfRoleId,
        selector: SelectorTupleOfRoleId,
    ) = QueryBox.FindRolesByAccountId(
        QueryWithFilterOfFindRolesByAccountId(
            FindRolesByAccountId(accountId),
            predicate,
            selector,
        ),
    )

    /**
     * Return all currently triggers
     */
    fun findTriggers(predicate: CompoundPredicateOfTrigger, selector: SelectorTupleOfTrigger) = QueryBox.FindTriggers(
        QueryWithFilterOfFindTriggers(FindTriggers(), predicate, selector),
    )

    /**
     * Return all active trigger IDs
     */
    fun findActiveTriggerIds(predicate: CompoundPredicateOfTriggerId, selector: SelectorTupleOfTriggerId) = QueryBox.FindActiveTriggerIds(
        QueryWithFilterOfFindActiveTriggerIds(
            FindActiveTriggerIds(),
            predicate,
            selector,
        ),
    )

    /**
     * Return all blocks
     */
    fun findBlocks(predicate: CompoundPredicateOfSignedBlock, selector: SelectorTupleOfSignedBlock) = QueryBox.FindBlocks(
        QueryWithFilterOfFindBlocks(FindBlocks(), predicate, selector),
    )

    /**
     * Return all block headers
     */
    fun findBlockHeaders(predicate: CompoundPredicateOfBlockHeader, selector: SelectorTupleOfBlockHeader) = QueryBox.FindBlockHeaders(
        QueryWithFilterOfFindBlockHeaders(
            FindBlockHeaders(),
            predicate,
            selector,
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
