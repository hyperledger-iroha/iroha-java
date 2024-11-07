package jp.co.soramitsu.iroha2.query

import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAccountPredicateBox
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAssetDefinitionPredicateBox
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAssetPredicateBox
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfBlockHeaderPredicateBox
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfCommittedTransactionPredicateBox
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfDomainPredicateBox
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPeerPredicateBox
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPermissionPredicateBox
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRoleIdPredicateBox
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRolePredicateBox
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlockPredicateBox
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerIdPredicateBox
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerPredicateBox
import jp.co.soramitsu.iroha2.generated.FindAccounts
import jp.co.soramitsu.iroha2.generated.FindAccountsWithAsset
import jp.co.soramitsu.iroha2.generated.FindActiveTriggerIds
import jp.co.soramitsu.iroha2.generated.FindAssets
import jp.co.soramitsu.iroha2.generated.FindAssetsDefinitions
import jp.co.soramitsu.iroha2.generated.FindBlockHeaders
import jp.co.soramitsu.iroha2.generated.FindBlocks
import jp.co.soramitsu.iroha2.generated.FindDomains
import jp.co.soramitsu.iroha2.generated.FindPeers
import jp.co.soramitsu.iroha2.generated.FindPermissionsByAccountId
import jp.co.soramitsu.iroha2.generated.FindRoleIds
import jp.co.soramitsu.iroha2.generated.FindRoles
import jp.co.soramitsu.iroha2.generated.FindRolesByAccountId
import jp.co.soramitsu.iroha2.generated.FindTransactions
import jp.co.soramitsu.iroha2.generated.FindTriggers
import jp.co.soramitsu.iroha2.generated.QueryBox
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindAccountsAndAccountPredicateBox
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindAccountsWithAssetAndAccountPredicateBox
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindActiveTriggerIdsAndTriggerIdPredicateBox
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindAssetsAndAssetPredicateBox
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindAssetsDefinitionsAndAssetDefinitionPredicateBox
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindBlockHeadersAndBlockHeaderPredicateBox
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindBlocksAndSignedBlockPredicateBox
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindDomainsAndDomainPredicateBox
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindPeersAndPeerPredicateBox
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindPermissionsByAccountIdAndPermissionPredicateBox
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindRoleIdsAndRoleIdPredicateBox
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindRolesAndRolePredicateBox
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindRolesByAccountIdAndRoleIdPredicateBox
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindTransactionsAndCommittedTransactionPredicateBox
import jp.co.soramitsu.iroha2.generated.QueryWithFilterOfFindTriggersAndTriggerPredicateBox

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
}
