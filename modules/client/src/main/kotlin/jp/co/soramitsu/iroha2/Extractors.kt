package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.generated.Account
import jp.co.soramitsu.iroha2.generated.Asset
import jp.co.soramitsu.iroha2.generated.AssetDefinition
import jp.co.soramitsu.iroha2.generated.BlockHeader
import jp.co.soramitsu.iroha2.generated.CommittedTransaction
import jp.co.soramitsu.iroha2.generated.Domain
import jp.co.soramitsu.iroha2.generated.Peer
import jp.co.soramitsu.iroha2.generated.Permission
import jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox
import jp.co.soramitsu.iroha2.generated.QueryResponse
import jp.co.soramitsu.iroha2.generated.Role
import jp.co.soramitsu.iroha2.generated.RoleId
import jp.co.soramitsu.iroha2.generated.SignedBlock
import jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox
import jp.co.soramitsu.iroha2.generated.Trigger
import jp.co.soramitsu.iroha2.generated.TriggerId

/**
 * Extractors are used by [QueryBuilder] to extract data from query results
 */
interface ResultExtractor<T> {
    fun extract(result: QueryResponse): T
}

/**
 * Extract a list of accounts from a query [result]
 */
object AccountsExtractor : ResultExtractor<List<Account>> {
    override fun extract(result: QueryResponse): List<Account> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch,
    )
}

/**
 * Extract an account from a query [result]
 */
object AccountExtractor : ResultExtractor<Account?> {
    override fun extract(result: QueryResponse): Account? = extract<Account?>(
        result.cast<QueryResponse.Iterable>().queryOutput.batch,
    ).firstOrNull()
}

/**
 * Extract a list of assets from a query [result]
 */
object AssetsExtractor : ResultExtractor<List<Asset>> {
    override fun extract(result: QueryResponse): List<Asset> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch,
    )
}

/**
 * Extract an asset from a query [result]
 */
object AssetExtractor : ResultExtractor<Asset?> {
    override fun extract(result: QueryResponse): Asset? = extract<Asset?>(
        result.cast<QueryResponse.Iterable>().queryOutput.batch,
    ).firstOrNull()
}

/**
 * Extract a list of asset definitions from a query [result]
 */
object AssetDefinitionsExtractor : ResultExtractor<List<AssetDefinition>> {
    override fun extract(result: QueryResponse): List<AssetDefinition> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch,
    )
}

/**
 * Extract an asset definition from a query [result]
 */
object AssetDefinitionExtractor : ResultExtractor<AssetDefinition?> {
    override fun extract(result: QueryResponse): AssetDefinition? = extract<AssetDefinition?>(
        result.cast<QueryResponse.Iterable>().queryOutput.batch,
    ).firstOrNull()
}

/**
 * Extract a list of domains from a query [result]
 */
object DomainsExtractor : ResultExtractor<List<Domain>> {
    override fun extract(result: QueryResponse): List<Domain> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch,
    )
}

/**
 * Extract a domain from a query [result]
 */
object DomainExtractor : ResultExtractor<Domain?> {
    override fun extract(result: QueryResponse): Domain? = extract<Domain?>(
        result.cast<QueryResponse.Iterable>().queryOutput.batch,
    ).firstOrNull()
}

/**
 * Extract a lost of peers from a query [result]
 */
object PeersExtractor : ResultExtractor<List<Peer>> {
    override fun extract(result: QueryResponse): List<Peer> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch,
    )
}

/**
 * Extract a trigger from a query [result]
 */
object TriggerBoxExtractor : ResultExtractor<Trigger> {
    override fun extract(result: QueryResponse): Trigger = result.cast<QueryResponse.Singular>()
        .singularQueryOutputBox.cast<SingularQueryOutputBox.Trigger>()
        .trigger
}

/**
 * Extract a list of triggers from a query [result]
 */
object TriggerBoxesExtractor : ResultExtractor<List<Trigger>> {
    override fun extract(result: QueryResponse): List<Trigger> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch,
    )
}

/**
 * Extract a list of trigger IDs from a query [result]
 */
object TriggerIdsExtractor : ResultExtractor<List<TriggerId>> {
    override fun extract(result: QueryResponse): List<TriggerId> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch,
    )
}

/**
 * Extract a list of permission tokens from a query [result]
 */
object PermissionTokensExtractor : ResultExtractor<List<Permission>> {
    override fun extract(result: QueryResponse): List<Permission> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch,
    )
}

/**
 * Extract a list of commited transactions from a query [result]
 */
object TransactionsExtractor : ResultExtractor<List<CommittedTransaction>> {
    override fun extract(result: QueryResponse): List<CommittedTransaction> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch,
    )
}

object BlocksValueExtractor : ResultExtractor<List<SignedBlock>> {
    override fun extract(result: QueryResponse): List<SignedBlock> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch,
    )
}

object BlockHeadersExtractor : ResultExtractor<List<BlockHeader>> {
    override fun extract(result: QueryResponse): List<BlockHeader> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch,
    )
}

/**
 * Extract a list of roles from a query [result]
 */
object RolesExtractor : ResultExtractor<List<Role>> {
    override fun extract(result: QueryResponse): List<Role> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch,
    )
}

/**
 * Extract a list of role IDs from a query [result]
 */
object RoleIdsExtractor : ResultExtractor<List<RoleId>> {
    override fun extract(result: QueryResponse): List<RoleId> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch,
    )
}

/**
 * Extract collection from `Value.Vec`
 */
inline fun <reified R> extract(value: QueryOutputBatchBox): List<R> = when (value) {
    is QueryOutputBatchBox.Asset -> value.vec.cast<List<R>>()
    is QueryOutputBatchBox.AssetDefinition -> value.vec.cast<List<R>>()
    is QueryOutputBatchBox.Account -> value.vec.cast<List<R>>()
    is QueryOutputBatchBox.Domain -> value.vec.cast<List<R>>()
    is QueryOutputBatchBox.Peer -> value.vec.cast<List<R>>()
    is QueryOutputBatchBox.Permission -> value.vec.cast<List<R>>()
    is QueryOutputBatchBox.Block -> value.vec.cast<List<R>>()
    is QueryOutputBatchBox.BlockHeader -> value.vec.cast<List<R>>()
    is QueryOutputBatchBox.Transaction -> value.vec.cast<List<R>>()
    is QueryOutputBatchBox.Trigger -> value.vec.cast<List<R>>()

    else -> throw QueryPayloadExtractionException(
        "Unexpected type `${value::class.qualifiedName}`",
    )
}
