package jp.co.soramitsu.iroha2.query

import jp.co.soramitsu.iroha2.AccountExtractor
import jp.co.soramitsu.iroha2.AccountsExtractor
import jp.co.soramitsu.iroha2.AssetDefinitionExtractor
import jp.co.soramitsu.iroha2.AssetDefinitionsExtractor
import jp.co.soramitsu.iroha2.AssetExtractor
import jp.co.soramitsu.iroha2.AssetsExtractor
import jp.co.soramitsu.iroha2.BlockHeaderExtractor
import jp.co.soramitsu.iroha2.BlockHeadersExtractor
import jp.co.soramitsu.iroha2.BlocksValueExtractor
import jp.co.soramitsu.iroha2.DomainExtractor
import jp.co.soramitsu.iroha2.DomainsExtractor
import jp.co.soramitsu.iroha2.ExecutorDataModelExtractor
import jp.co.soramitsu.iroha2.NumericExtractor
import jp.co.soramitsu.iroha2.PeersExtractor
import jp.co.soramitsu.iroha2.PermissionTokensExtractor
import jp.co.soramitsu.iroha2.ResultExtractor
import jp.co.soramitsu.iroha2.RoleExtractor
import jp.co.soramitsu.iroha2.RoleIdsExtractor
import jp.co.soramitsu.iroha2.RolesExtractor
import jp.co.soramitsu.iroha2.StringExtractor
import jp.co.soramitsu.iroha2.TransactionValueExtractor
import jp.co.soramitsu.iroha2.TransactionValuesExtractor
import jp.co.soramitsu.iroha2.TriggerBoxExtractor
import jp.co.soramitsu.iroha2.TriggerBoxesExtractor
import jp.co.soramitsu.iroha2.TriggerIdsExtractor
import jp.co.soramitsu.iroha2.asName
import jp.co.soramitsu.iroha2.asSignatureOf
import jp.co.soramitsu.iroha2.fromHex
import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.AssetId
import jp.co.soramitsu.iroha2.generated.ClientQueryPayload
import jp.co.soramitsu.iroha2.generated.DomainId
import jp.co.soramitsu.iroha2.generated.FetchSize
import jp.co.soramitsu.iroha2.generated.GenericPredicateBox
import jp.co.soramitsu.iroha2.generated.Hash
import jp.co.soramitsu.iroha2.generated.Name
import jp.co.soramitsu.iroha2.generated.NonZeroOfu32
import jp.co.soramitsu.iroha2.generated.NonZeroOfu64
import jp.co.soramitsu.iroha2.generated.Pagination
import jp.co.soramitsu.iroha2.generated.PublicKey
import jp.co.soramitsu.iroha2.generated.QueryBox
import jp.co.soramitsu.iroha2.generated.QueryOutputPredicate
import jp.co.soramitsu.iroha2.generated.QuerySignature
import jp.co.soramitsu.iroha2.generated.RoleId
import jp.co.soramitsu.iroha2.generated.Signature
import jp.co.soramitsu.iroha2.generated.SignedQuery
import jp.co.soramitsu.iroha2.generated.SignedQueryV1
import jp.co.soramitsu.iroha2.generated.Sorting
import jp.co.soramitsu.iroha2.generated.TriggerId
import jp.co.soramitsu.iroha2.hash
import jp.co.soramitsu.iroha2.sign
import jp.co.soramitsu.iroha2.toIrohaHash
import java.math.BigInteger
import java.security.KeyPair

class QueryBuilder<R>(
    private val query: QueryBox,
    private val resultExtractor: ResultExtractor<R>,
    private val queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null,
) {
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

    fun pagination(limit: Long? = null, start: BigInteger? = null) = this.apply {
        this.pagination = Pagination(limit?.let { NonZeroOfu32(limit) }, start?.let { NonZeroOfu64(start) })
    }

    fun fetchSize(value: Long) = this.apply {
        this.fetchSize = FetchSize(NonZeroOfu32(value))
    }

    fun buildSigned(keyPair: KeyPair): QueryAndExtractor<R> {
        val filter = queryFilter ?: GenericPredicateBox.Raw(QueryOutputPredicate.Pass())
        val payload = ClientQueryPayload(
            checkNotNull(accountId) { "Account ID of the sender is mandatory" },
            query,
            filter,
            sorting ?: Sorting(null),
            this.pagination ?: Pagination(null, null),
            this.fetchSize ?: FetchSize(null),
        )
        val encodedPayload = ClientQueryPayload.encode(payload)
        val signature = QuerySignature(Signature(keyPair.private.sign(encodedPayload)).asSignatureOf())

        val query = SignedQuery.V1(SignedQueryV1(signature, payload))
        return QueryAndExtractor(query, resultExtractor)
    }

    companion object {
        @JvmStatic
        @JvmOverloads
        fun findAllAccounts(queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null) = QueryBuilder(
            Queries.findAllAccounts(),
            AccountsExtractor,
            queryFilter,
        )

        @JvmStatic
        fun findAccountKeyValueByIdAndKey(accountId: AccountId, key: Name) = QueryBuilder(
            Queries.findAccountKeyValueByIdAndKey(accountId, key),
            StringExtractor,
        )

        @JvmStatic
        fun findAccountKeyValueByIdAndKey(
            accountId: AccountId,
            key: String,
        ) = findAccountKeyValueByIdAndKey(accountId, key.asName())

        @JvmStatic
        @JvmOverloads
        fun findAccountsByDomainId(
            domainId: DomainId,
            queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null,
        ) = QueryBuilder(Queries.findAccountsByDomainId(domainId), AccountsExtractor, queryFilter)

        @JvmStatic
        @JvmOverloads
        fun findAccountsWithAsset(
            definitionId: AssetDefinitionId,
            queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null,
        ) = QueryBuilder(Queries.findAccountsWithAsset(definitionId), AccountsExtractor, queryFilter)

        @JvmStatic
        @JvmOverloads
        fun findAllAssets(queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null) = QueryBuilder(
            Queries.findAllAssets(),
            AssetsExtractor,
            queryFilter,
        )

        @JvmStatic
        @JvmOverloads
        fun findAllAssetsDefinitions(
            queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null,
        ) = QueryBuilder(
            Queries.findAllAssetsDefinitions(),
            AssetDefinitionsExtractor,
            queryFilter,
        )

        @JvmStatic
        @JvmOverloads
        fun findAssetsByName(
            name: Name,
            queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null,
        ) = QueryBuilder(
            Queries.findAssetsByName(name),
            AssetsExtractor,
            queryFilter,
        )

        @JvmStatic
        @JvmOverloads
        fun findAssetsByAccountId(
            accountId: AccountId,
            queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null,
        ) = QueryBuilder(
            Queries.findAssetsByAccountId(accountId),
            AssetsExtractor,
            queryFilter,
        )

        @JvmStatic
        fun findAccountById(accountId: AccountId) = QueryBuilder(Queries.findAccountById(accountId), AccountExtractor)

        @JvmStatic
        fun findAssetById(assetId: AssetId) = QueryBuilder(Queries.findAssetById(assetId), AssetExtractor)

        @JvmStatic
        @JvmOverloads
        fun findAssetsByDomainId(
            domainId: DomainId,
            queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null,
        ) = QueryBuilder(
            Queries.findAssetsByDomainId(domainId),
            AssetsExtractor,
            queryFilter,
        )

        @JvmStatic
        fun findAssetsByAssetDefinitionId(assetDefinition: AssetDefinitionId) = QueryBuilder(
            Queries.findAssetsByAssetDefinitionId(assetDefinition),
            AssetsExtractor,
        )

        @JvmStatic
        @JvmOverloads
        fun findAllAssetsDefinitions(
            assetDefinition: AssetDefinitionId,
            queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null,
        ) = QueryBuilder(
            Queries.findAssetsByAssetDefinitionId(assetDefinition),
            AssetDefinitionsExtractor,
            queryFilter,
        )

        @JvmStatic
        @JvmOverloads
        fun findAssetsByDomainIdAndAssetDefinitionId(
            domainId: DomainId,
            assetDefinition: AssetDefinitionId,
            queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null,
        ) = QueryBuilder(
            Queries.findAssetsByDomainIdAndAssetDefinitionId(domainId, assetDefinition),
            AssetsExtractor,
            queryFilter,
        )

        @JvmStatic
        fun findAssetQuantityById(assetId: AssetId) = QueryBuilder(
            Queries.findAssetQuantityById(assetId),
            NumericExtractor,
        )

        @JvmStatic
        fun findTotalAssetQuantityByAssetDefinitionId(definitionId: AssetDefinitionId) = QueryBuilder(
            Queries.findTotalAssetQuantityByAssetDefinitionId(definitionId),
            NumericExtractor,
        )

        @JvmStatic
        fun findAssetKeyValueByIdAndKey(assetId: AssetId, key: Name) = QueryBuilder(
            Queries.findAssetKeyValueByIdAndKey(assetId, key),
            StringExtractor,
        )

        @JvmStatic
        fun findAssetKeyValueByIdAndKey(
            assetId: AssetId,
            key: String,
        ) = findAssetKeyValueByIdAndKey(assetId, key.asName())

        @JvmStatic
        fun findAssetDefinitionKeyValueByIdAndKey(id: AssetDefinitionId, key: Name) = QueryBuilder(
            Queries.findAssetDefinitionKeyValueByIdAndKey(id, key),
            StringExtractor,
        )

        @JvmStatic
        fun findAssetDefinitionKeyValueByIdAndKey(
            id: AssetDefinitionId,
            key: String,
        ) = findAssetDefinitionKeyValueByIdAndKey(id, key.asName())

        @JvmStatic
        fun findDomainKeyValueByIdAndKey(id: DomainId, key: String) = findDomainKeyValueByIdAndKey(id, key.asName())

        @JvmStatic
        fun findDomainKeyValueByIdAndKey(id: DomainId, key: Name) = QueryBuilder(
            Queries.findDomainKeyValueByIdAndKey(id, key),
            StringExtractor,
        )

        @JvmStatic
        @JvmOverloads
        fun findAllDomains(
            queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null,
        ) = QueryBuilder(Queries.findAllDomains(), DomainsExtractor, queryFilter)

        @JvmStatic
        fun findDomainById(domainId: DomainId) = QueryBuilder(Queries.findDomainById(domainId), DomainExtractor)

        @JvmStatic
        @JvmOverloads
        fun findAllPeers(queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null) =
            QueryBuilder(Queries.findAllPeers(), PeersExtractor, queryFilter)

        @JvmStatic
        fun findTransactionsByAccountId(
            accountId: AccountId,
            queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null,
        ) = QueryBuilder(
            Queries.findTransactionsByAccountId(accountId),
            TransactionValuesExtractor,
            queryFilter,
        )

        @JvmStatic
        @JvmOverloads
        fun findPermissionsByAccountId(
            accountId: AccountId,
            queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null,
        ) = QueryBuilder(
            Queries.findPermissionsByAccountId(accountId),
            PermissionTokensExtractor,
            queryFilter,
        )

        @JvmStatic
        fun findExecutorDataModel(
            queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null,
        ) = QueryBuilder(
            Queries.findExecutorDataModel(),
            ExecutorDataModelExtractor,
            queryFilter,
        )

        @JvmStatic
        @JvmOverloads
        fun findRolesByAccountId(accountId: AccountId, queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null) =
            QueryBuilder(
                Queries.findRolesByAccountId(accountId),
                RoleIdsExtractor,
                queryFilter,
            )

        @JvmStatic
        @JvmOverloads
        fun findAllRoleIds(queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null) = QueryBuilder(
            Queries.findAllRoleIds(),
            RoleIdsExtractor,
            queryFilter,
        )

        @JvmStatic
        @JvmOverloads
        fun findAllRoles(queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null) = QueryBuilder(
            Queries.findAllRoles(),
            RolesExtractor,
            queryFilter,
        )

        @JvmStatic
        @JvmOverloads
        fun findRoleByRoleId(roleId: RoleId, queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null) =
            QueryBuilder(
                Queries.findRoleByRoleId(roleId),
                RoleExtractor,
                queryFilter,
            )

        @JvmStatic
        fun findTransactionByHash(hash: Hash) = QueryBuilder(
            Queries.findTransactionByHash(hash),
            TransactionValueExtractor,
        )

        @JvmStatic
        fun findTransactionByHash(bytes: ByteArray) = findTransactionByHash(bytes.toIrohaHash())

        @JvmStatic
        fun findTransactionByHash(hex: String) = findTransactionByHash(hex.fromHex().hash().toIrohaHash())

        @JvmStatic
        fun findAllTransactions(queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null) = QueryBuilder(
            Queries.findAllTransactions(),
            TransactionValuesExtractor,
            queryFilter,
        )

        @JvmStatic
        @JvmOverloads
        fun findAllBlocks(queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null) = QueryBuilder(
            Queries.findAllBlocks(),
            BlocksValueExtractor,
            queryFilter,
        )

        @JvmStatic
        @JvmOverloads
        fun findAllBlockHeaders(queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null) = QueryBuilder(
            Queries.findAllBlockHeaders(),
            BlockHeadersExtractor,
            queryFilter,
        )

        @JvmStatic
        fun findBlockHeaderByHash(hash: Hash) = QueryBuilder(
            Queries.findBlockHeaderByHash(hash),
            BlockHeaderExtractor,
        )

        @JvmStatic
        fun findAssetDefinitionById(definitionId: AssetDefinitionId) = QueryBuilder(
            Queries.findAssetDefinitionById(definitionId),
            AssetDefinitionExtractor,
        )

        @JvmStatic
        fun findTriggerById(id: TriggerId) = QueryBuilder(
            Queries.findTriggerById(id),
            TriggerBoxExtractor,
        )

        @JvmStatic
        fun findTriggerKeyValueByIdAndKey(id: TriggerId, key: Name) = QueryBuilder(
            Queries.findTriggerKeyValueByIdAndKey(id, key),
            StringExtractor,
        )

        @JvmStatic
        @JvmOverloads
        fun findAllActiveTriggerIds(queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null) = QueryBuilder(
            Queries.findAllActiveTriggerIds(),
            TriggerIdsExtractor,
            queryFilter,
        )

        @JvmStatic
        @JvmOverloads
        fun findTriggersByAuthorityId(
            id: AccountId,
            queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null,
        ) = QueryBuilder(
            Queries.findTriggersByAuthorityId(id),
            TriggerBoxExtractor,
            queryFilter,
        )

        @JvmStatic
        @JvmOverloads
        fun findTriggersByAuthorityDomainId(
            domainId: DomainId,
            queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null,
        ) = QueryBuilder(
            Queries.findTriggersByAuthorityDomainId(domainId),
            TriggerBoxesExtractor,
            queryFilter,
        )

        @JvmStatic
        @JvmOverloads
        fun findAllParameters(queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null) = QueryBuilder(
            Queries.findAllParameters(),
            StringExtractor,
            queryFilter,
        )
    }
}

/**
 * Encapsulate signed [query] and extractor of result of the query
 *
 * [R] is a type of extracted value as a result of query execution
 */
class QueryAndExtractor<R>(val query: SignedQuery, val resultExtractor: ResultExtractor<R>)
