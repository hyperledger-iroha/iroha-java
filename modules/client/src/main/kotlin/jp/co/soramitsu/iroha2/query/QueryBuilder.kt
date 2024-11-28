package jp.co.soramitsu.iroha2.query

import jp.co.soramitsu.iroha2.*
import jp.co.soramitsu.iroha2.generated.*
import java.math.BigInteger
import java.security.KeyPair

class QueryBuilder<R>(val query: QueryBox, val extractor: ResultExtractor<R>) {
    private var sorting: Sorting? = null
    private var pagination: Pagination? = null
    private var fetchSize: FetchSize? = null

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

    fun signAs(accountId: AccountId, keyPair: KeyPair): QueryAndExtractor<R> {
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
        @JvmOverloads
        fun findAccounts(predicate: CompoundPredicateOfAccount? = null, selector: SelectorTupleOfAccount? = null) = QueryBuilder(
            Queries.findAccounts(
                predicate ?: CompoundPredicateOfAccount.And(emptyList()),
                selector ?: SelectorTupleOfAccount(listOf(AccountProjectionOfSelectorMarker.Atom())),
            ),
            AccountsExtractor,
        )

        @JvmStatic
        fun findAccountById(accountId: AccountId, selector: SelectorTupleOfAccount? = null): QueryBuilder<Account?> {
            val predicate = CompoundPredicateOfAccount.Atom(
                AccountProjectionOfPredicateMarker.Id(
                    AccountIdProjectionOfPredicateMarker.Atom(
                        AccountIdPredicateAtom.Equals(accountId),
                    ),
                ),
            )

            return QueryBuilder(
                Queries.findAccounts(predicate, selector ?: SelectorTupleOfAccount(listOf(AccountProjectionOfSelectorMarker.Atom()))),
                AccountOrNullExtractor,
            )
        }

        @JvmStatic
        @JvmOverloads
        fun findAssets(predicate: CompoundPredicateOfAsset? = null, selector: SelectorTupleOfAsset? = null) = QueryBuilder(
            Queries.findAssets(
                predicate ?: CompoundPredicateOfAsset.And(emptyList()),
                selector ?: SelectorTupleOfAsset(listOf(AssetProjectionOfSelectorMarker.Atom())),
            ),
            AssetsExtractor,
        )

        @JvmStatic
        fun findAssetsByAccountId(accountId: AccountId, selector: SelectorTupleOfAsset? = null): QueryBuilder<List<Asset>> {
            val predicate = CompoundPredicateOfAsset.Atom(
                AssetProjectionOfPredicateMarker.Id(
                    AssetIdProjectionOfPredicateMarker.Account(
                        AccountIdProjectionOfPredicateMarker.Atom(
                            AccountIdPredicateAtom.Equals(accountId),
                        ),
                    ),
                ),
            )

            return QueryBuilder(
                Queries.findAssets(predicate, selector ?: SelectorTupleOfAsset(listOf(AssetProjectionOfSelectorMarker.Atom()))),
                AssetsExtractor,
            )
        }

        @JvmStatic
        fun findAssetById(assetId: AssetId, selector: SelectorTupleOfAsset? = null): QueryBuilder<Asset?> {
            val predicate = CompoundPredicateOfAsset.Atom(
                AssetProjectionOfPredicateMarker.Id(
                    AssetIdProjectionOfPredicateMarker.Atom(
                        AssetIdPredicateAtom.Equals(assetId),
                    ),
                ),
            )

            return QueryBuilder(
                Queries.findAssets(predicate, selector ?: SelectorTupleOfAsset(listOf(AssetProjectionOfSelectorMarker.Atom()))),
                AssetOrNullExtractor,
            )
        }

        @JvmStatic
        @JvmOverloads
        fun findAssetsDefinitions(predicate: CompoundPredicateOfAssetDefinition? = null, selector: SelectorTupleOfAssetDefinition? = null) =
            QueryBuilder(
                Queries.findAssetsDefinitions(
                    predicate ?: CompoundPredicateOfAssetDefinition.And(emptyList()),
                    selector ?: SelectorTupleOfAssetDefinition(listOf(AssetDefinitionProjectionOfSelectorMarker.Atom())),
                ),
                AssetDefinitionsExtractor,
            )

        @JvmStatic
        fun findAssetDefinitionById(
            assetDefinitionId: AssetDefinitionId,
            selector: SelectorTupleOfAssetDefinition? = null,
        ): QueryBuilder<AssetDefinition?> {
            val predicate = CompoundPredicateOfAssetDefinition.Atom(
                AssetDefinitionProjectionOfPredicateMarker.Id(
                    AssetDefinitionIdProjectionOfPredicateMarker.Atom(
                        AssetDefinitionIdPredicateAtom.Equals(assetDefinitionId),
                    ),
                ),
            )
            return QueryBuilder(
                Queries.findAssetsDefinitions(
                    predicate,
                    selector ?: SelectorTupleOfAssetDefinition(listOf(AssetDefinitionProjectionOfSelectorMarker.Atom())),
                ),
                AssetDefinitionOrNullExtractor,
            )
        }

        @JvmStatic
        @JvmOverloads
        fun findDomains(predicate: CompoundPredicateOfDomain? = null, selector: SelectorTupleOfDomain? = null) = QueryBuilder(
            Queries.findDomains(
                predicate ?: CompoundPredicateOfDomain.And(emptyList()),
                selector ?: SelectorTupleOfDomain(listOf(DomainProjectionOfSelectorMarker.Atom())),
            ),
            DomainsExtractor,
        )

        @JvmStatic
        fun findDomainById(domainId: DomainId, selector: SelectorTupleOfDomain? = null): QueryBuilder<Domain?> {
            val predicate = CompoundPredicateOfDomain.Atom(
                DomainProjectionOfPredicateMarker.Id(
                    DomainIdProjectionOfPredicateMarker.Atom(
                        DomainIdPredicateAtom.Equals(domainId),
                    ),
                ),
            )
            return QueryBuilder(
                Queries.findDomains(predicate, selector ?: SelectorTupleOfDomain(listOf(DomainProjectionOfSelectorMarker.Atom()))),
                DomainOrNullExtractor,
            )
        }

        @JvmStatic
        fun findTriggerById(triggerId: TriggerId, selector: SelectorTupleOfTrigger? = null): QueryBuilder<Trigger?> {
            val predicate = CompoundPredicateOfTrigger.Atom(
                TriggerProjectionOfPredicateMarker.Id(
                    TriggerIdProjectionOfPredicateMarker.Name(
                        NameProjectionOfPredicateMarker.Atom(StringPredicateAtom.Equals(triggerId.asString())),
                    ),
                ),
            )
            return QueryBuilder(
                Queries.findTriggers(predicate, selector ?: SelectorTupleOfTrigger(listOf(TriggerProjectionOfSelectorMarker.Atom()))),
                TriggerOrNullExtractor,
            )
        }

        @JvmStatic
        @JvmOverloads
        fun findPeers(predicate: CompoundPredicateOfPeerId? = null, selector: SelectorTupleOfPeerId? = null) = QueryBuilder(
            Queries.findPeers(
                predicate ?: CompoundPredicateOfPeerId.And(emptyList()),
                selector ?: SelectorTupleOfPeerId(
                    listOf(
                        PeerIdProjectionOfSelectorMarker.Atom(),
                    ),
                ),
            ),
            PeersExtractor,
        )

        @JvmStatic
        @JvmOverloads
        fun findTransactions(
            predicate: CompoundPredicateOfCommittedTransaction? = null,
            selector: SelectorTupleOfCommittedTransaction? = null,
        ) = QueryBuilder(
            Queries.findTransactions(
                predicate ?: CompoundPredicateOfCommittedTransaction.And(emptyList()),
                selector
                    ?: SelectorTupleOfCommittedTransaction(
                        listOf(
                            CommittedTransactionProjectionOfSelectorMarker.Atom(),
                        ),
                    ),
            ),
            TransactionsExtractor,
        )

        @JvmStatic
        @JvmOverloads
        fun findPermissionsByAccountId(
            accountId: AccountId,
            predicate: CompoundPredicateOfPermission? = null,
            selector: SelectorTupleOfPermission? = null,
        ) = QueryBuilder(
            Queries.findPermissionsByAccountId(
                accountId,
                predicate ?: CompoundPredicateOfPermission.And(emptyList()),
                selector ?: SelectorTupleOfPermission(
                    listOf(
                        PermissionProjectionOfSelectorMarker.Atom(),
                    ),
                ),
            ),
            PermissionTokensExtractor,
        )

        @JvmStatic
        @JvmOverloads
        fun findRolesByAccountId(
            accountId: AccountId,
            predicate: CompoundPredicateOfRoleId? = null,
            selector: SelectorTupleOfRoleId? = null,
        ) = QueryBuilder(
            Queries.findRolesByAccountId(
                accountId,
                predicate ?: CompoundPredicateOfRoleId.And(emptyList()),
                selector ?: SelectorTupleOfRoleId(listOf(RoleIdProjectionOfSelectorMarker.Atom())),
            ),
            RoleIdsExtractor,
        )

        @JvmStatic
        @JvmOverloads
        fun findRoleIds(predicate: CompoundPredicateOfRoleId? = null, selector: SelectorTupleOfRoleId? = null) = QueryBuilder(
            Queries.findRoleIds(
                predicate ?: CompoundPredicateOfRoleId.And(emptyList()),
                selector ?: SelectorTupleOfRoleId(listOf(RoleIdProjectionOfSelectorMarker.Atom())),
            ),
            RoleIdsExtractor,
        )

        @JvmStatic
        @JvmOverloads
        fun findRoles(predicate: CompoundPredicateOfRole? = null, selector: SelectorTupleOfRole? = null) = QueryBuilder(
            Queries.findRoles(
                predicate ?: CompoundPredicateOfRole.And(emptyList()),
                selector ?: SelectorTupleOfRole(listOf(RoleProjectionOfSelectorMarker.Atom())),
            ),
            RolesExtractor,
        )

        @JvmStatic
        @JvmOverloads
        fun findTriggers(predicate: CompoundPredicateOfTrigger? = null, selector: SelectorTupleOfTrigger? = null) = QueryBuilder(
            Queries.findTriggers(
                predicate ?: CompoundPredicateOfTrigger.And(emptyList()),
                selector ?: SelectorTupleOfTrigger(listOf(TriggerProjectionOfSelectorMarker.Atom())),
            ),
            TriggersExtractor,
        )

        @JvmStatic
        @JvmOverloads
        fun findActiveTriggerIds(predicate: CompoundPredicateOfTriggerId? = null, selector: SelectorTupleOfTriggerId? = null) =
            QueryBuilder(
                Queries.findActiveTriggerIds(
                    predicate ?: CompoundPredicateOfTriggerId.And(emptyList()),
                    selector ?: SelectorTupleOfTriggerId(listOf(TriggerIdProjectionOfSelectorMarker.Atom())),
                ),
                TriggerIdsExtractor,
            )

        @JvmStatic
        @JvmOverloads
        fun findBlocks(predicate: CompoundPredicateOfSignedBlock? = null, selector: SelectorTupleOfSignedBlock? = null) = QueryBuilder(
            Queries.findBlocks(
                predicate ?: CompoundPredicateOfSignedBlock.And(emptyList()),
                selector ?: SelectorTupleOfSignedBlock(listOf(SignedBlockProjectionOfSelectorMarker.Atom())),
            ),
            BlocksValueExtractor,
        )

        @JvmStatic
        @JvmOverloads
        fun findBlockHeaders(predicate: CompoundPredicateOfBlockHeader? = null, selector: SelectorTupleOfBlockHeader? = null) =
            QueryBuilder(
                Queries.findBlockHeaders(
                    predicate ?: CompoundPredicateOfBlockHeader.And(emptyList()),
                    selector ?: SelectorTupleOfBlockHeader(listOf(BlockHeaderProjectionOfSelectorMarker.Atom())),
                ),
                BlockHeadersExtractor,
            )

        @JvmStatic
        @JvmOverloads
        fun findAccountsWithAsset(
            definitionId: AssetDefinitionId,
            predicate: CompoundPredicateOfAccount? = null,
            selector: SelectorTupleOfAccount? = null,
        ) = QueryBuilder(
            Queries.findAccountsWithAsset(
                definitionId,
                predicate ?: CompoundPredicateOfAccount.And(emptyList()),
                selector ?: SelectorTupleOfAccount(
                    listOf(
                        AccountProjectionOfSelectorMarker.Atom(),
                    ),
                ),
            ),
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
