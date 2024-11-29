package jp.co.soramitsu.iroha2.query

import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.AccountProjectionOfSelectorMarker
import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.AssetDefinitionProjectionOfSelectorMarker
import jp.co.soramitsu.iroha2.generated.AssetProjectionOfSelectorMarker
import jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfSelectorMarker
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAccount
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAsset
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAssetDefinition
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfCommittedTransaction
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfDomain
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPeerId
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPermission
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRole
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRoleId
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlock
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTrigger
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerId
import jp.co.soramitsu.iroha2.generated.DomainProjectionOfSelectorMarker
import jp.co.soramitsu.iroha2.generated.FindAccounts
import jp.co.soramitsu.iroha2.generated.FindAccountsWithAsset
import jp.co.soramitsu.iroha2.generated.FindActiveTriggerIds
import jp.co.soramitsu.iroha2.generated.FindAssets
import jp.co.soramitsu.iroha2.generated.FindAssetsDefinitions
import jp.co.soramitsu.iroha2.generated.FindBlocks
import jp.co.soramitsu.iroha2.generated.FindDomains
import jp.co.soramitsu.iroha2.generated.FindExecutorDataModel
import jp.co.soramitsu.iroha2.generated.FindParameters
import jp.co.soramitsu.iroha2.generated.FindPeers
import jp.co.soramitsu.iroha2.generated.FindPermissionsByAccountId
import jp.co.soramitsu.iroha2.generated.FindRoles
import jp.co.soramitsu.iroha2.generated.FindRolesByAccountId
import jp.co.soramitsu.iroha2.generated.FindTransactions
import jp.co.soramitsu.iroha2.generated.FindTriggers
import jp.co.soramitsu.iroha2.generated.PeerIdProjectionOfSelectorMarker
import jp.co.soramitsu.iroha2.generated.PermissionProjectionOfSelectorMarker
import jp.co.soramitsu.iroha2.generated.QueryBox
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindAccounts
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindAccountsWithAsset
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindActiveTriggerIds
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindAssets
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindAssetsDefinitions
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindBlocks
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindDomains
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindPeers
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindPermissionsByAccountId
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindRoles
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindRolesByAccountId
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindTransactions
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindTriggers
import jp.co.soramitsu.iroha2.generated.RoleIdProjectionOfSelectorMarker
import jp.co.soramitsu.iroha2.generated.RoleProjectionOfSelectorMarker
import jp.co.soramitsu.iroha2.generated.SelectorTupleOfAccount
import jp.co.soramitsu.iroha2.generated.SelectorTupleOfAsset
import jp.co.soramitsu.iroha2.generated.SelectorTupleOfAssetDefinition
import jp.co.soramitsu.iroha2.generated.SelectorTupleOfCommittedTransaction
import jp.co.soramitsu.iroha2.generated.SelectorTupleOfDomain
import jp.co.soramitsu.iroha2.generated.SelectorTupleOfPeerId
import jp.co.soramitsu.iroha2.generated.SelectorTupleOfPermission
import jp.co.soramitsu.iroha2.generated.SelectorTupleOfRole
import jp.co.soramitsu.iroha2.generated.SelectorTupleOfRoleId
import jp.co.soramitsu.iroha2.generated.SelectorTupleOfSignedBlock
import jp.co.soramitsu.iroha2.generated.SelectorTupleOfTrigger
import jp.co.soramitsu.iroha2.generated.SelectorTupleOfTriggerId
import jp.co.soramitsu.iroha2.generated.SignedBlockProjectionOfSelectorMarker
import jp.co.soramitsu.iroha2.generated.SingularQueryBox
import jp.co.soramitsu.iroha2.generated.TriggerIdProjectionOfSelectorMarker
import jp.co.soramitsu.iroha2.generated.TriggerProjectionOfSelectorMarker

/**
 * Queries are sent to an Iroha peer and prompt a response with details from the current world state view.
 */
object Queries {
    /**
     * Return all peers (peers are identified by their public key)
     */
    fun findPeers(predicate: CompoundPredicateOfPeerId? = null) = QueryBox.FindPeers(
        QueryWithFilterOfFindPeers(
            FindPeers(),
            predicate ?: CompoundPredicateOfPeerId.And(emptyList()),
            SelectorTupleOfPeerId(
                listOf(
                    PeerIdProjectionOfSelectorMarker.Atom(),
                ),
            ),
        ),
    )

    /**
     * Return all domains
     */
    fun findDomains(predicate: CompoundPredicateOfDomain? = null) = QueryBox.FindDomains(
        QueryWithFilterOfFindDomains(
            FindDomains(),
            predicate ?: CompoundPredicateOfDomain.And(emptyList()),
            SelectorTupleOfDomain(listOf(DomainProjectionOfSelectorMarker.Atom())),
        ),
    )

    /**
     * Return the values of all known asset definitions
     */
    fun findAssetsDefinitions(predicate: CompoundPredicateOfAssetDefinition? = null) = QueryBox.FindAssetsDefinitions(
        QueryWithFilterOfFindAssetsDefinitions(
            FindAssetsDefinitions(),
            predicate ?: CompoundPredicateOfAssetDefinition.And(emptyList()),
            SelectorTupleOfAssetDefinition(listOf(AssetDefinitionProjectionOfSelectorMarker.Atom())),
        ),
    )

    /**
     * Return all accounts
     */
    fun findAccounts(predicate: CompoundPredicateOfAccount? = null) = QueryBox.FindAccounts(
        QueryWithFilterOfFindAccounts(
            FindAccounts(),
            predicate ?: CompoundPredicateOfAccount.And(emptyList()),
            SelectorTupleOfAccount(listOf(AccountProjectionOfSelectorMarker.Atom())),
        ),
    )

    /**
     * Return all accounts that contain an asset of the given definition
     */
    fun findAccountsWithAsset(definitionId: AssetDefinitionId, predicate: CompoundPredicateOfAccount? = null) =
        QueryBox.FindAccountsWithAsset(
            QueryWithFilterOfFindAccountsWithAsset(
                FindAccountsWithAsset(definitionId),
                predicate ?: CompoundPredicateOfAccount.And(emptyList()),
                SelectorTupleOfAccount(listOf(AccountProjectionOfSelectorMarker.Atom())),
            ),
        )

    /**
     * Return the all assets
     */
    fun findAssets(predicate: CompoundPredicateOfAsset? = null) = QueryBox.FindAssets(
        QueryWithFilterOfFindAssets(
            FindAssets(),
            predicate ?: CompoundPredicateOfAsset.And(emptyList()),
            SelectorTupleOfAsset(listOf(AssetProjectionOfSelectorMarker.Atom())),
        ),
    )

    /**
     * Return all the permission tokens granted to the specified [AccountId]
     */
    fun findPermissionsByAccountId(accountId: AccountId, predicate: CompoundPredicateOfPermission? = null) =
        QueryBox.FindPermissionsByAccountId(
            QueryWithFilterOfFindPermissionsByAccountId(
                FindPermissionsByAccountId(accountId),
                predicate ?: CompoundPredicateOfPermission.And(emptyList()),
                SelectorTupleOfPermission(
                    listOf(
                        PermissionProjectionOfSelectorMarker.Atom(),
                    ),
                ),
            ),
        )

    /**
     * Return the full set of roles
     */
    fun findRoles(predicate: CompoundPredicateOfRole? = null) = QueryBox.FindRoles(
        QueryWithFilterOfFindRoles(
            FindRoles(),
            predicate ?: CompoundPredicateOfRole.And(emptyList()),
            SelectorTupleOfRole(listOf(RoleProjectionOfSelectorMarker.Atom())),
        ),
    )

    /**
     * Return all the role IDs that are attached to the given [AccountId]
     */
    fun findRolesByAccountId(accountId: AccountId, predicate: CompoundPredicateOfRoleId? = null) = QueryBox.FindRolesByAccountId(
        QueryWithFilterOfFindRolesByAccountId(
            FindRolesByAccountId(accountId),
            predicate ?: CompoundPredicateOfRoleId.And(emptyList()),
            SelectorTupleOfRoleId(listOf(RoleIdProjectionOfSelectorMarker.Atom())),
        ),
    )

    /**
     * Return all currently triggers
     */
    fun findTriggers(predicate: CompoundPredicateOfTrigger? = null) = QueryBox.FindTriggers(
        QueryWithFilterOfFindTriggers(
            FindTriggers(),
            predicate ?: CompoundPredicateOfTrigger.And(emptyList()),
            SelectorTupleOfTrigger(listOf(TriggerProjectionOfSelectorMarker.Atom())),
        ),
    )

    /**
     * Return all active trigger IDs
     */
    fun findActiveTriggerIds(predicate: CompoundPredicateOfTriggerId? = null) = QueryBox.FindActiveTriggerIds(
        QueryWithFilterOfFindActiveTriggerIds(
            FindActiveTriggerIds(),
            predicate ?: CompoundPredicateOfTriggerId.And(emptyList()),
            SelectorTupleOfTriggerId(listOf(TriggerIdProjectionOfSelectorMarker.Atom())),
        ),
    )

    /**
     * Return the full set of transactions
     */
    fun findTransactions(predicate: CompoundPredicateOfCommittedTransaction? = null) = QueryBox.FindTransactions(
        QueryWithFilterOfFindTransactions(
            FindTransactions(),
            predicate ?: CompoundPredicateOfCommittedTransaction.And(emptyList()),
            SelectorTupleOfCommittedTransaction(
                listOf(
                    CommittedTransactionProjectionOfSelectorMarker.Atom(),
                ),
            ),
        ),
    )

    /**
     * Return all blocks
     */
    fun findBlocks(predicate: CompoundPredicateOfSignedBlock? = null) = QueryBox.FindBlocks(
        QueryWithFilterOfFindBlocks(
            FindBlocks(),
            predicate ?: CompoundPredicateOfSignedBlock.And(emptyList()),
            SelectorTupleOfSignedBlock(listOf(SignedBlockProjectionOfSelectorMarker.Atom())),
        ),
    )

    /**
     * Return current executor data model
     */
    fun findExecutorDataModel() = SingularQueryBox.FindExecutorDataModel(
        FindExecutorDataModel(),
    )

    /**
     * Return current parameter values (including custom)
     */
    fun findParameters() = SingularQueryBox.FindParameters(
        FindParameters(),
    )
}
