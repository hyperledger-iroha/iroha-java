package jp.co.soramitsu.iroha2.query

import jp.co.soramitsu.iroha2.*
import jp.co.soramitsu.iroha2.generated.Account
import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.AccountIdPredicateBox
import jp.co.soramitsu.iroha2.generated.AccountPredicateBox
import jp.co.soramitsu.iroha2.generated.Asset
import jp.co.soramitsu.iroha2.generated.AssetDefinition
import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.AssetDefinitionIdPredicateBox
import jp.co.soramitsu.iroha2.generated.AssetDefinitionPredicateBox
import jp.co.soramitsu.iroha2.generated.AssetId
import jp.co.soramitsu.iroha2.generated.AssetIdPredicateBox
import jp.co.soramitsu.iroha2.generated.AssetPredicateBox
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
import jp.co.soramitsu.iroha2.generated.Domain
import jp.co.soramitsu.iroha2.generated.DomainId
import jp.co.soramitsu.iroha2.generated.DomainIdPredicateBox
import jp.co.soramitsu.iroha2.generated.DomainPredicateBox
import jp.co.soramitsu.iroha2.generated.FetchSize
import jp.co.soramitsu.iroha2.generated.Name
import jp.co.soramitsu.iroha2.generated.NonZeroOfu64
import jp.co.soramitsu.iroha2.generated.Pagination
import jp.co.soramitsu.iroha2.generated.PublicKey
import jp.co.soramitsu.iroha2.generated.QueryBox
import jp.co.soramitsu.iroha2.generated.QueryParams
import jp.co.soramitsu.iroha2.generated.QueryRequest
import jp.co.soramitsu.iroha2.generated.QueryRequestWithAuthority
import jp.co.soramitsu.iroha2.generated.QuerySignature
import jp.co.soramitsu.iroha2.generated.QueryWithParams
import jp.co.soramitsu.iroha2.generated.Signature
import jp.co.soramitsu.iroha2.generated.SignedQuery
import jp.co.soramitsu.iroha2.generated.SignedQueryV1
import jp.co.soramitsu.iroha2.generated.Sorting
import jp.co.soramitsu.iroha2.generated.StringPredicateBox
import jp.co.soramitsu.iroha2.generated.Trigger
import jp.co.soramitsu.iroha2.generated.TriggerId
import jp.co.soramitsu.iroha2.generated.TriggerIdPredicateBox
import jp.co.soramitsu.iroha2.generated.TriggerPredicateBox
import java.math.BigInteger
import java.security.KeyPair

class QueryBuilder<R>(private val query: QueryBox, private val extractor: ResultExtractor<R>) {
    private var accountId: AccountId? = null
    private var sorting: Sorting? = null
    private var pagination: Pagination? = null
    private var fetchSize: FetchSize? = null

    fun account(accountId: AccountId) = this.apply { this.accountId = accountId }

    fun account(signatory: PublicKey, domainId: DomainId) = this.account(AccountId(domainId, signatory))

    fun sorting(key: String) = this.apply {
        this.sorting = Sorting(key.asName())
    }

    fun sorting(key: Name) = this.apply {
        this.sorting = Sorting(key)
    }

    fun pagination(limit: BigInteger? = null, offset: BigInteger) = this.apply {
        this.pagination = Pagination(limit?.let { NonZeroOfu64(limit) }, offset)
    }

    fun fetchSize(value: BigInteger) = this.apply {
        this.fetchSize = FetchSize(NonZeroOfu64(value))
    }

    fun buildSigned(keyPair: KeyPair): QueryAndExtractor<R> {
        val request = QueryRequest.Start(
            QueryWithParams(
                query,
                QueryParams(
                    this.pagination ?: Pagination(null, BigInteger.ZERO),
                    this.sorting ?: Sorting(null),
                    this.fetchSize ?: FetchSize(null),
                ),
            ),
        )
        val payload = QueryRequestWithAuthority(
            checkNotNull(accountId) { "Account ID of the sender is mandatory" },
            request,
        )
        val encodedPayload = QueryRequestWithAuthority.encode(payload)
        val signature = QuerySignature(Signature(keyPair.private.sign(encodedPayload)).asSignatureOf())

        val query = SignedQuery.V1(SignedQueryV1(signature, payload))
        return QueryAndExtractor(query, extractor)
    }

    companion object {
        @JvmStatic
        @JvmOverloads
        fun findAccounts(predicate: CompoundPredicateOfAccountPredicateBox? = null) = QueryBuilder(
            Queries.findAccounts(predicate ?: CompoundPredicateOfAccountPredicateBox.And(emptyList())),
            AccountsExtractor,
        )

        @JvmStatic
        fun findAccountById(accountId: AccountId): QueryBuilder<Account?> {
            val predicate = CompoundPredicateOfAccountPredicateBox.Atom(
                AccountPredicateBox.Id(AccountIdPredicateBox.Equals(accountId)),
            )
            return QueryBuilder(Queries.findAccounts(predicate), AccountExtractor)
        }

        @JvmStatic
        @JvmOverloads
        fun findAssets(predicate: CompoundPredicateOfAssetPredicateBox? = null) = QueryBuilder(
            Queries.findAssets(predicate ?: CompoundPredicateOfAssetPredicateBox.And(emptyList())),
            AssetsExtractor,
        )

        @JvmStatic
        fun findAssetsByDomainId(domainId: DomainId): QueryBuilder<List<Asset>> {
            val predicate = CompoundPredicateOfAssetPredicateBox.Atom(
                AssetPredicateBox.Id(
                    AssetIdPredicateBox.AccountId(
                        AccountIdPredicateBox.DomainId(
                            DomainIdPredicateBox.Equals(domainId),
                        ),
                    ),
                ),
            )
            return QueryBuilder(Queries.findAssets(predicate), AssetsExtractor)
        }

        @JvmStatic
        fun findAssetsByAccountId(accountId: AccountId): QueryBuilder<List<Asset>> {
            val predicate = CompoundPredicateOfAssetPredicateBox.Atom(
                AssetPredicateBox.Id(
                    AssetIdPredicateBox.AccountId(
                        AccountIdPredicateBox.Equals(accountId),
                    ),
                ),
            )
            return QueryBuilder(Queries.findAssets(predicate), AssetsExtractor)
        }

        @JvmStatic
        fun findAssetById(assetId: AssetId): QueryBuilder<Asset?> {
            val predicate = CompoundPredicateOfAssetPredicateBox.Atom(
                AssetPredicateBox.Id(AssetIdPredicateBox.Equals(assetId)),
            )
            return QueryBuilder(Queries.findAssets(predicate), AssetExtractor)
        }

        @JvmStatic
        @JvmOverloads
        fun findAssetsDefinitions(predicate: CompoundPredicateOfAssetDefinitionPredicateBox? = null) = QueryBuilder(
            Queries.findAssetsDefinitions(predicate ?: CompoundPredicateOfAssetDefinitionPredicateBox.And(emptyList())),
            AssetDefinitionsExtractor,
        )

        @JvmStatic
        fun findAssetDefinitionById(definitionId: AssetDefinitionId): QueryBuilder<AssetDefinition?> {
            val predicate = CompoundPredicateOfAssetDefinitionPredicateBox.Atom(
                AssetDefinitionPredicateBox.Id(AssetDefinitionIdPredicateBox.Equals(definitionId)),
            )
            return QueryBuilder(Queries.findAssetsDefinitions(predicate), AssetDefinitionExtractor)
        }

        @JvmStatic
        @JvmOverloads
        fun findDomains(predicate: CompoundPredicateOfDomainPredicateBox? = null) = QueryBuilder(
            Queries.findDomains(predicate ?: CompoundPredicateOfDomainPredicateBox.And(emptyList())),
            DomainsExtractor,
        )

        @JvmStatic
        fun findDomainById(domainId: DomainId): QueryBuilder<Domain?> {
            val predicate = CompoundPredicateOfDomainPredicateBox.Atom(
                DomainPredicateBox.Id(DomainIdPredicateBox.Name(StringPredicateBox.Equals(domainId.asString()))),
            )
            return QueryBuilder(Queries.findDomains(predicate), DomainExtractor)
        }

        @JvmStatic
        fun findTriggerById(triggerId: TriggerId): QueryBuilder<Trigger?> {
            val predicate = CompoundPredicateOfTriggerPredicateBox.Atom(
                TriggerPredicateBox.Id(TriggerIdPredicateBox.Name(StringPredicateBox.Equals(triggerId.asString()))),
            )
            return QueryBuilder(Queries.findTriggers(predicate), TriggerExtractor)
        }

        @JvmStatic
        @JvmOverloads
        fun findPeers(predicate: CompoundPredicateOfPeerPredicateBox? = null) = QueryBuilder(
            Queries.findPeers(predicate ?: CompoundPredicateOfPeerPredicateBox.And(emptyList())),
            PeersExtractor,
        )

        @JvmStatic
        @JvmOverloads
        fun findTransactions(predicate: CompoundPredicateOfCommittedTransactionPredicateBox? = null) = QueryBuilder(
            Queries.findTransactions(predicate ?: CompoundPredicateOfCommittedTransactionPredicateBox.And(emptyList())),
            TransactionsExtractor,
        )

        @JvmStatic
        @JvmOverloads
        fun findPermissionsByAccountId(accountId: AccountId, predicate: CompoundPredicateOfPermissionPredicateBox? = null) = QueryBuilder(
            Queries.findPermissionsByAccountId(accountId, predicate ?: CompoundPredicateOfPermissionPredicateBox.And(emptyList())),
            PermissionTokensExtractor,
        )

        @JvmStatic
        @JvmOverloads
        fun findRolesByAccountId(accountId: AccountId, predicate: CompoundPredicateOfRoleIdPredicateBox? = null) = QueryBuilder(
            Queries.findRolesByAccountId(accountId, predicate ?: CompoundPredicateOfRoleIdPredicateBox.And(emptyList())),
            RoleIdsExtractor,
        )

        @JvmStatic
        @JvmOverloads
        fun findRoleIds(predicate: CompoundPredicateOfRoleIdPredicateBox? = null) = QueryBuilder(
            Queries.findRoleIds(predicate ?: CompoundPredicateOfRoleIdPredicateBox.And(emptyList())),
            RoleIdsExtractor,
        )

        @JvmStatic
        @JvmOverloads
        fun findRoles(predicate: CompoundPredicateOfRolePredicateBox? = null) = QueryBuilder(
            Queries.findRoles(predicate ?: CompoundPredicateOfRolePredicateBox.And(emptyList())),
            RolesExtractor,
        )

        @JvmStatic
        @JvmOverloads
        fun findTriggers(predicate: CompoundPredicateOfTriggerPredicateBox? = null) = QueryBuilder(
            Queries.findTriggers(predicate ?: CompoundPredicateOfTriggerPredicateBox.And(emptyList())),
            TriggersExtractor,
        )

        @JvmStatic
        @JvmOverloads
        fun findActiveTriggerIds(predicate: CompoundPredicateOfTriggerIdPredicateBox? = null) = QueryBuilder(
            Queries.findActiveTriggerIds(predicate ?: CompoundPredicateOfTriggerIdPredicateBox.And(emptyList())),
            TriggerIdsExtractor,
        )

        @JvmStatic
        @JvmOverloads
        fun findBlocks(predicate: CompoundPredicateOfSignedBlockPredicateBox? = null) = QueryBuilder(
            Queries.findBlocks(predicate ?: CompoundPredicateOfSignedBlockPredicateBox.And(emptyList())),
            BlocksValueExtractor,
        )

        @JvmStatic
        @JvmOverloads
        fun findBlockHeaders(predicate: CompoundPredicateOfBlockHeaderPredicateBox? = null) = QueryBuilder(
            Queries.findBlockHeaders(predicate ?: CompoundPredicateOfBlockHeaderPredicateBox.And(emptyList())),
            BlockHeadersExtractor,
        )

        @JvmStatic
        @JvmOverloads
        fun findAccountsWithAsset(definitionId: AssetDefinitionId, predicate: CompoundPredicateOfAccountPredicateBox? = null) =
            QueryBuilder(
                Queries.findAccountsWithAsset(definitionId, predicate ?: CompoundPredicateOfAccountPredicateBox.And(emptyList())),
                AccountsExtractor,
            )
    }
}

/**
 * Encapsulate signed [query] and extractor of result of the query
 *
 * [R] is a type of extracted value as a result of query execution
 */
class QueryAndExtractor<R>(val query: SignedQuery, val extractor: ResultExtractor<R>)
