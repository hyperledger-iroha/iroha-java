package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.generated.Account
import jp.co.soramitsu.iroha2.generated.Asset
import jp.co.soramitsu.iroha2.generated.AssetDefinition
import jp.co.soramitsu.iroha2.generated.BlockHeader
import jp.co.soramitsu.iroha2.generated.CommittedTransaction
import jp.co.soramitsu.iroha2.generated.Domain
import jp.co.soramitsu.iroha2.generated.PeerId
import jp.co.soramitsu.iroha2.generated.Permission
import jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox
import jp.co.soramitsu.iroha2.generated.QueryResponse
import jp.co.soramitsu.iroha2.generated.Role
import jp.co.soramitsu.iroha2.generated.RoleId
import jp.co.soramitsu.iroha2.generated.SignedBlock
import jp.co.soramitsu.iroha2.generated.Trigger
import jp.co.soramitsu.iroha2.generated.TriggerId

/**
 * Extractors are used by [QueryBuilder] to extract data from query results
 */
interface ResultExtractor<T> {
    fun extract(result: QueryResponse): T
}

/**
 * Extract a list of accounts from a [QueryResponse]
 */
object AccountsExtractor : ResultExtractor<List<Account>> {
    override fun extract(result: QueryResponse): List<Account> = extract<Account>(
        result.cast<QueryResponse.Iterable>().queryOutput.batch.tuple.takeIf { it.size == 1 }!!.first(),
    )
}

/**
 * Extract an account from a [QueryResponse]
 */
object AccountExtractor : ResultExtractor<Account> {
    override fun extract(result: QueryResponse): Account = AccountsExtractor.extract(result).first()
}

/**
 * Extract an account from a [QueryResponse]
 */
object AccountOrNullExtractor : ResultExtractor<Account?> {
    override fun extract(result: QueryResponse): Account? = AccountsExtractor.extract(result).firstOrNull()
}

/**
 * Extract a list of assets from a [QueryResponse]
 */
object AssetsExtractor : ResultExtractor<List<Asset>> {
    override fun extract(result: QueryResponse): List<Asset> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch.tuple.takeIf { it.size == 1 }!!.first(),
    )
}

/**
 * Extract an asset from a [QueryResponse]
 */
object AssetExtractor : ResultExtractor<Asset> {
    override fun extract(result: QueryResponse): Asset = AssetsExtractor.extract(result).first()
}

/**
 * Extract an asset from a [QueryResponse]
 */
object AssetOrNullExtractor : ResultExtractor<Asset?> {
    override fun extract(result: QueryResponse): Asset? = AssetsExtractor.extract(result).firstOrNull()
}

/**
 * Extract a list of asset definitions from a [QueryResponse]
 */
object AssetDefinitionsExtractor : ResultExtractor<List<AssetDefinition>> {
    override fun extract(result: QueryResponse): List<AssetDefinition> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch.tuple.takeIf { it.size == 1 }!!.first(),
    )
}

/**
 * Extract an asset definition from a [QueryResponse]
 */
object AssetDefinitionExtractor : ResultExtractor<AssetDefinition> {
    override fun extract(result: QueryResponse): AssetDefinition = AssetDefinitionsExtractor.extract(result).first()
}

/**
 * Extract an asset definition from a [QueryResponse]
 */
object AssetDefinitionOrNullExtractor : ResultExtractor<AssetDefinition?> {
    override fun extract(result: QueryResponse): AssetDefinition? = AssetDefinitionsExtractor.extract(result).firstOrNull()
}

/**
 * Extract a list of domains from a [QueryResponse]
 */
object DomainsExtractor : ResultExtractor<List<Domain>> {
    override fun extract(result: QueryResponse): List<Domain> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch.tuple.takeIf { it.size == 1 }!!.first(),
    )
}

/**
 * Extract a domain from a [QueryResponse]
 */
object DomainExtractor : ResultExtractor<Domain> {
    override fun extract(result: QueryResponse): Domain = DomainsExtractor.extract(result).first()
}

/**
 * Extract a domain from a [QueryResponse]
 */
object DomainOrNullExtractor : ResultExtractor<Domain?> {
    override fun extract(result: QueryResponse): Domain? = DomainsExtractor.extract(result).firstOrNull()
}

/**
 * Extract a lost of peers from a [QueryResponse]
 */
object PeersExtractor : ResultExtractor<List<PeerId>> {
    override fun extract(result: QueryResponse): List<PeerId> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch.tuple.takeIf { it.size == 1 }!!.first(),
    )
}

/**
 * Extract a trigger from a [QueryResponse]
 */
object TriggerExtractor : ResultExtractor<Trigger> {
    override fun extract(result: QueryResponse): Trigger = TriggersExtractor.extract(result).first()
}

/**
 * Extract a trigger from a [QueryResponse]
 */
object TriggerOrNullExtractor : ResultExtractor<Trigger?> {
    override fun extract(result: QueryResponse): Trigger? = TriggersExtractor.extract(result).firstOrNull()
}

/**
 * Extract a list of triggers from a [QueryResponse]
 */
object TriggersExtractor : ResultExtractor<List<Trigger>> {
    override fun extract(result: QueryResponse): List<Trigger> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch.tuple.takeIf { it.size == 1 }!!.first(),
    )
}

/**
 * Extract a list of trigger IDs from a [QueryResponse]
 */
object TriggerIdsExtractor : ResultExtractor<List<TriggerId>> {
    override fun extract(result: QueryResponse): List<TriggerId> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch.tuple.takeIf { it.size == 1 }!!.first(),
    )
}

/**
 * Extract a list of permission tokens from a [QueryResponse]
 */
object PermissionTokensExtractor : ResultExtractor<List<Permission>> {
    override fun extract(result: QueryResponse): List<Permission> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch.tuple.takeIf { it.size == 1 }!!.first(),
    )
}

/**
 * Extract a list of commited transactions from a [QueryResponse]
 */
object TransactionsExtractor : ResultExtractor<List<CommittedTransaction>> {
    override fun extract(result: QueryResponse): List<CommittedTransaction> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch.tuple.takeIf { it.size == 1 }!!.first(),
    )
}

object BlocksValueExtractor : ResultExtractor<List<SignedBlock>> {
    override fun extract(result: QueryResponse): List<SignedBlock> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch.tuple.takeIf { it.size == 1 }!!.first(),
    )
}

object BlockHeadersExtractor : ResultExtractor<List<BlockHeader>> {
    override fun extract(result: QueryResponse): List<BlockHeader> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch.tuple.takeIf { it.size == 1 }!!.first(),
    )
}

/**
 * Extract a list of roles from a [QueryResponse]
 */
object RolesExtractor : ResultExtractor<List<Role>> {
    override fun extract(result: QueryResponse): List<Role> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch.tuple.takeIf { it.size == 1 }!!.first(),
    )
}

/**
 * Extract a list of role IDs from a [QueryResponse]
 */
object RoleIdsExtractor : ResultExtractor<List<RoleId>> {
    override fun extract(result: QueryResponse): List<RoleId> = extract(
        result.cast<QueryResponse.Iterable>().queryOutput.batch.tuple.takeIf { it.size == 1 }!!.first(),
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
    is QueryOutputBatchBox.Trigger -> value.vec.cast<List<R>>()
    is QueryOutputBatchBox.Role -> value.vec.cast<List<R>>()
    is QueryOutputBatchBox.RoleId -> value.vec.cast<List<R>>()
    is QueryOutputBatchBox.TriggerId -> value.vec.cast<List<R>>()
    is QueryOutputBatchBox.CommittedTransaction -> value.vec.cast<List<R>>()

    else -> throw QueryPayloadExtractionException(
        "Unexpected type `${value::class.qualifiedName}`",
    )
}
