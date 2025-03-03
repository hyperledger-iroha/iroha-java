package jp.co.soramitsu.iroha2.query

import jp.co.soramitsu.iroha2.AccountOrNullExtractor
import jp.co.soramitsu.iroha2.AccountsExtractor
import jp.co.soramitsu.iroha2.AssetDefinitionOrNullExtractor
import jp.co.soramitsu.iroha2.AssetDefinitionsExtractor
import jp.co.soramitsu.iroha2.AssetOrNullExtractor
import jp.co.soramitsu.iroha2.AssetsExtractor
import jp.co.soramitsu.iroha2.BlocksValueExtractor
import jp.co.soramitsu.iroha2.DomainOrNullExtractor
import jp.co.soramitsu.iroha2.DomainsExtractor
import jp.co.soramitsu.iroha2.PeersExtractor
import jp.co.soramitsu.iroha2.PermissionTokensExtractor
import jp.co.soramitsu.iroha2.ResultExtractor
import jp.co.soramitsu.iroha2.RoleIdsExtractor
import jp.co.soramitsu.iroha2.RolesExtractor
import jp.co.soramitsu.iroha2.TransactionsExtractor
import jp.co.soramitsu.iroha2.TriggerIdsExtractor
import jp.co.soramitsu.iroha2.TriggerOrNullExtractor
import jp.co.soramitsu.iroha2.TriggersExtractor
import jp.co.soramitsu.iroha2.asName
import jp.co.soramitsu.iroha2.asSignatureOf
import jp.co.soramitsu.iroha2.generated.Account
import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.AccountIdPredicateAtom
import jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.AccountProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.Asset
import jp.co.soramitsu.iroha2.generated.AssetDefinition
import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.AssetDefinitionIdPredicateAtom
import jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.AssetDefinitionProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.AssetId
import jp.co.soramitsu.iroha2.generated.AssetIdPredicateAtom
import jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.AssetProjectionOfPredicateMarker
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
import jp.co.soramitsu.iroha2.generated.Domain
import jp.co.soramitsu.iroha2.generated.DomainId
import jp.co.soramitsu.iroha2.generated.DomainIdPredicateAtom
import jp.co.soramitsu.iroha2.generated.DomainIdProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.DomainProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.FetchSize
import jp.co.soramitsu.iroha2.generated.Name
import jp.co.soramitsu.iroha2.generated.NonZeroOfu64
import jp.co.soramitsu.iroha2.generated.Pagination
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
import jp.co.soramitsu.iroha2.generated.Trigger
import jp.co.soramitsu.iroha2.generated.TriggerId
import jp.co.soramitsu.iroha2.generated.TriggerIdPredicateAtom
import jp.co.soramitsu.iroha2.generated.TriggerIdProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.TriggerProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.signAs
import java.math.BigInteger
import java.security.KeyPair

class QueryBuilder<R>(
    val query: QueryBox,
    val extractor: ResultExtractor<R>,
) {
    private var sorting: Sorting? = null
    private var pagination: Pagination? = null
    private var fetchSize: FetchSize? = null

    fun sorting(key: String) =
        this.apply {
            this.sorting = Sorting(key.asName())
        }

    fun sorting(key: Name) =
        this.apply {
            this.sorting = Sorting(key)
        }

    fun pagination(
        limit: BigInteger? = null,
        offset: BigInteger? = null,
    ) = this.apply {
        this.pagination = Pagination(limit?.let { NonZeroOfu64(limit) }, offset ?: BigInteger.ZERO)
    }

    fun fetchSize(value: BigInteger) =
        this.apply {
            this.fetchSize = FetchSize(NonZeroOfu64(value))
        }

    fun signAs(
        accountId: AccountId,
        keyPair: KeyPair,
    ): QueryAndExtractor<R> {
        val request =
            QueryRequest.Start(
                QueryWithParams(
                    query,
                    QueryParams(
                        this.pagination ?: Pagination(null, BigInteger.ZERO),
                        this.sorting ?: Sorting(null),
                        this.fetchSize ?: FetchSize(null),
                    ),
                ),
            )
        val payload =
            QueryRequestWithAuthority(
                accountId,
                request,
            )
        val encodedPayload = QueryRequestWithAuthority.encode(payload)
        val signature = QuerySignature(Signature(keyPair.private.signAs(encodedPayload)).asSignatureOf())

        val query = SignedQuery.V1(SignedQueryV1(signature, payload))
        return QueryAndExtractor(query, extractor)
    }

    companion object {
        @JvmStatic
        fun findPeers(predicate: CompoundPredicateOfPeerId? = null) =
            QueryBuilder(
                Queries.findPeers(predicate),
                PeersExtractor,
            )

        /**
         * Return all domains
         */
        @JvmStatic
        fun findDomains(predicate: CompoundPredicateOfDomain? = null) =
            QueryBuilder(
                Queries.findDomains(
                    predicate,
                ),
                DomainsExtractor,
            )

        /**
         * Return domain with the given id
         */
        @JvmStatic
        fun findDomainById(domainId: DomainId): QueryBuilder<Domain?> {
            val byDomainIdFilter =
                CompoundPredicateOfDomain.Atom(
                    DomainProjectionOfPredicateMarker.Id(
                        DomainIdProjectionOfPredicateMarker.Atom(
                            DomainIdPredicateAtom.Equals(domainId),
                        ),
                    ),
                )
            return QueryBuilder(
                Queries.findDomains(byDomainIdFilter),
                DomainOrNullExtractor,
            )
        }

        @JvmStatic
        fun findAssetsDefinitions(predicate: CompoundPredicateOfAssetDefinition? = null) =
            QueryBuilder(
                Queries.findAssetsDefinitions(predicate),
                AssetDefinitionsExtractor,
            )

        @JvmStatic
        fun findAssetDefinitionById(assetDefinitionId: AssetDefinitionId): QueryBuilder<AssetDefinition?> {
            val byAssetDefinitionIdFilter =
                CompoundPredicateOfAssetDefinition.Atom(
                    AssetDefinitionProjectionOfPredicateMarker.Id(
                        AssetDefinitionIdProjectionOfPredicateMarker.Atom(
                            AssetDefinitionIdPredicateAtom.Equals(assetDefinitionId),
                        ),
                    ),
                )
            return QueryBuilder(
                Queries.findAssetsDefinitions(byAssetDefinitionIdFilter),
                AssetDefinitionOrNullExtractor,
            )
        }

        /**
         * Return the values of all known accounts
         */
        @JvmStatic
        fun findAccounts(predicate: CompoundPredicateOfAccount? = null) =
            QueryBuilder(
                Queries.findAccounts(predicate),
                AccountsExtractor,
            )

        @JvmStatic
        fun findAccountsWithAsset(
            definitionId: AssetDefinitionId,
            predicate: CompoundPredicateOfAccount? = null,
        ) = QueryBuilder(
            Queries.findAccountsWithAsset(
                definitionId,
                predicate,
            ),
            AccountsExtractor,
        )

        @JvmStatic
        fun findAccountById(accountId: AccountId): QueryBuilder<Account?> {
            val byAccountIdFilter =
                CompoundPredicateOfAccount.Atom(
                    AccountProjectionOfPredicateMarker.Id(
                        AccountIdProjectionOfPredicateMarker.Atom(
                            AccountIdPredicateAtom.Equals(accountId),
                        ),
                    ),
                )

            return QueryBuilder(Queries.findAccounts(byAccountIdFilter), AccountOrNullExtractor)
        }

        @JvmStatic
        fun findAssets(predicate: CompoundPredicateOfAsset? = null) =
            QueryBuilder(
                Queries.findAssets(predicate),
                AssetsExtractor,
            )

        @JvmStatic
        fun findAssetById(assetId: AssetId): QueryBuilder<Asset?> {
            val byAssetIdFilter =
                CompoundPredicateOfAsset.Atom(
                    AssetProjectionOfPredicateMarker.Id(
                        AssetIdProjectionOfPredicateMarker.Atom(
                            AssetIdPredicateAtom.Equals(assetId),
                        ),
                    ),
                )

            return QueryBuilder(Queries.findAssets(byAssetIdFilter), AssetOrNullExtractor)
        }

        @JvmStatic
        fun findPermissionsByAccountId(
            accountId: AccountId,
            predicate: CompoundPredicateOfPermission? = null,
        ) = QueryBuilder(
            Queries.findPermissionsByAccountId(
                accountId,
                predicate,
            ),
            PermissionTokensExtractor,
        )

        @JvmStatic
        fun findRoles(predicate: CompoundPredicateOfRole? = null) =
            QueryBuilder(
                Queries.findRoles(predicate ?: CompoundPredicateOfRole.And(emptyList())),
                RolesExtractor,
            )

        @JvmStatic
        fun findRoleById(predicate: CompoundPredicateOfRole? = null) =
            QueryBuilder(
                Queries.findRoles(predicate ?: CompoundPredicateOfRole.And(emptyList())),
                RoleIdsExtractor,
            )

        @JvmStatic
        fun findRolesByAccountId(
            accountId: AccountId,
            predicate: CompoundPredicateOfRoleId? = null,
        ) = QueryBuilder(
            Queries.findRolesByAccountId(
                accountId,
                predicate,
            ),
            RoleIdsExtractor,
        )

        @JvmStatic
        fun findTriggers(predicate: CompoundPredicateOfTrigger? = null) =
            QueryBuilder(
                Queries.findTriggers(
                    predicate,
                ),
                TriggersExtractor,
            )

        @JvmStatic
        fun findTriggerById(triggerId: TriggerId): QueryBuilder<Trigger?> {
            val byTriggerIdFilter =
                CompoundPredicateOfTrigger.Atom(
                    TriggerProjectionOfPredicateMarker.Id(
                        TriggerIdProjectionOfPredicateMarker.Atom(
                            TriggerIdPredicateAtom.Equals(triggerId),
                        ),
                    ),
                )
            return QueryBuilder(
                Queries.findTriggers(byTriggerIdFilter),
                TriggerOrNullExtractor,
            )
        }

        @JvmStatic
        fun findActiveTriggerIds(predicate: CompoundPredicateOfTriggerId? = null) =
            QueryBuilder(
                Queries.findActiveTriggerIds(
                    predicate,
                ),
                TriggerIdsExtractor,
            )

        @JvmStatic
        fun findTransactions(predicate: CompoundPredicateOfCommittedTransaction? = null) =
            QueryBuilder(
                Queries.findTransactions(
                    predicate,
                ),
                TransactionsExtractor,
            )

        @JvmStatic
        fun findBlocks(predicate: CompoundPredicateOfSignedBlock? = null) =
            QueryBuilder(
                Queries.findBlocks(
                    predicate,
                ),
                BlocksValueExtractor,
            )
    }
}

/**
 * Encapsulate signed [query] and extractor of result of the query
 *
 * [R] is a type of extracted value as a result of query execution
 */
class QueryAndExtractor<R>(
    val query: SignedQuery,
    val extractor: ResultExtractor<R>,
)
