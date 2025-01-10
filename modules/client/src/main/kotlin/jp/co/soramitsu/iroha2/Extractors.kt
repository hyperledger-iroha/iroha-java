package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.generated.Account
import jp.co.soramitsu.iroha2.generated.Asset
import jp.co.soramitsu.iroha2.generated.AssetDefinition
import jp.co.soramitsu.iroha2.generated.BatchedResponse
import jp.co.soramitsu.iroha2.generated.BlockHeader
import jp.co.soramitsu.iroha2.generated.Domain
import jp.co.soramitsu.iroha2.generated.ExecutorDataModel
import jp.co.soramitsu.iroha2.generated.IdBox
import jp.co.soramitsu.iroha2.generated.IdentifiableBox
import jp.co.soramitsu.iroha2.generated.Numeric
import jp.co.soramitsu.iroha2.generated.Peer
import jp.co.soramitsu.iroha2.generated.Permission
import jp.co.soramitsu.iroha2.generated.QueryOutputBox
import jp.co.soramitsu.iroha2.generated.Role
import jp.co.soramitsu.iroha2.generated.RoleId
import jp.co.soramitsu.iroha2.generated.SignedBlock
import jp.co.soramitsu.iroha2.generated.TransactionQueryOutput
import jp.co.soramitsu.iroha2.generated.Trigger
import jp.co.soramitsu.iroha2.generated.TriggerId

/**
 * Extractors are used by [QueryBuilder] to extract data from query results
 */
interface ResultExtractor<T> {
    fun extract(result: BatchedResponse<QueryOutputBox>): T
}

/**
 * @return the query result as it is
 */
object AsIs : ResultExtractor<BatchedResponse<QueryOutputBox>> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): BatchedResponse<QueryOutputBox> = result
}

/**
 * Extract an asset from a query [result]
 */
object AssetExtractor : ResultExtractor<Asset> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): Asset {
        return extractIdentifiable(result.cast<BatchedResponse.V1>().batchedResponseV1.batch, IdentifiableBox.Asset::asset)
    }
}

/**
 * Extract an asset definition from a query [result]
 */
object AssetDefinitionExtractor : ResultExtractor<AssetDefinition> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): AssetDefinition {
        return extractIdentifiable(result.cast<BatchedResponse.V1>().batchedResponseV1.batch, IdentifiableBox.AssetDefinition::assetDefinition)
    }
}

/**
 * Extract an account from a query [result]
 */
object AccountExtractor : ResultExtractor<Account> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): Account {
        return extractIdentifiable(result.cast<BatchedResponse.V1>().batchedResponseV1.batch, IdentifiableBox.Account::account)
    }
}

/**
 * Extract a list of accounts from a query [result]
 */
object AccountsExtractor : ResultExtractor<List<Account>> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): List<Account> {
        return extractVec(result.cast<BatchedResponse.V1>().batchedResponseV1.batch) {
            extractIdentifiable(it, IdentifiableBox.Account::account)
        }
    }
}

/**
 * Extract a numeric from a query
 */
object NumericExtractor : ResultExtractor<Numeric> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): Numeric {
        return result.cast<BatchedResponse.V1>().batchedResponseV1.batch.cast<QueryOutputBox.Numeric>().numeric
    }
}

/**
 * Extract a list of assets from a query [result]
 */
object AssetsExtractor : ResultExtractor<List<Asset>> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): List<Asset> {
        return extractVec(result.cast<BatchedResponse.V1>().batchedResponseV1.batch) {
            extractIdentifiable(it, IdentifiableBox.Asset::asset)
        }
    }
}

/**
 * Extract a list of asset definitions from a query [result]
 */
object AssetDefinitionsExtractor : ResultExtractor<List<AssetDefinition>> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): List<AssetDefinition> {
        return extractVec(result.cast<BatchedResponse.V1>().batchedResponseV1.batch) {
            extractIdentifiable(it, IdentifiableBox.AssetDefinition::assetDefinition)
        }
    }
}

/**
 * Extract a domain from a query [result]
 */
object DomainExtractor : ResultExtractor<Domain> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): Domain {
        return extractIdentifiable(result.cast<BatchedResponse.V1>().batchedResponseV1.batch, IdentifiableBox.Domain::domain)
    }
}

/**
 * Extract a list of domains from a query [result]
 */
object DomainsExtractor : ResultExtractor<List<Domain>> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): List<Domain> {
        return extractVec(result.cast<BatchedResponse.V1>().batchedResponseV1.batch) {
            extractIdentifiable(it, IdentifiableBox.Domain::domain)
        }
    }
}

/**
 * Extract a lost of peers from a query [result]
 */
object PeersExtractor : ResultExtractor<List<Peer>> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): List<Peer> {
        return extractVec(result.cast<BatchedResponse.V1>().batchedResponseV1.batch) {
            extractIdentifiable(it, IdentifiableBox.Peer::peer)
        }
    }
}

/**
 * Extract a trigger from a query [result]
 */
object TriggerBoxExtractor : ResultExtractor<Trigger> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): Trigger {
        return extractIdentifiable(
            result.cast<BatchedResponse.V1>().batchedResponseV1.batch,
            IdentifiableBox.Trigger::trigger,
        )
    }
}

/**
 * Extract a list of triggers from a query [result]
 */
object TriggerBoxesExtractor : ResultExtractor<List<Trigger>> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): List<Trigger> {
        return extractVec(result.cast<BatchedResponse.V1>().batchedResponseV1.batch) {
            extractIdentifiable(it, IdentifiableBox.Trigger::trigger)
        }
    }
}

/**
 * Extract a list of trigger IDs from a query [result]
 */
object TriggerIdsExtractor : ResultExtractor<List<TriggerId>> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): List<TriggerId> {
        return extractVec(result.cast<BatchedResponse.V1>().batchedResponseV1.batch) {
            extractValue(it, QueryOutputBox.Id::idBox).cast<IdBox.TriggerId>().triggerId
        }
    }
}

/**
 * Extract a list of permission tokens from a query [result]
 */
object PermissionTokensExtractor : ResultExtractor<List<Permission>> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): List<Permission> {
        return extractVec(result.cast<BatchedResponse.V1>().batchedResponseV1.batch) {
            extractValue(it, QueryOutputBox.Permission::permission)
        }
    }
}

/**
 * Extract a permission token schema from a query [result]
 */
object ExecutorDataModelExtractor : ResultExtractor<ExecutorDataModel> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): ExecutorDataModel {
        return extractValue(result.cast<BatchedResponse.V1>().batchedResponseV1.batch, QueryOutputBox.ExecutorDataModel::executorDataModel)
    }
}

/**
* Extract a list of transaction values from a query [result]
*/
object TransactionValuesExtractor : ResultExtractor<List<TransactionQueryOutput>> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): List<TransactionQueryOutput> {
        return extractVec(result.cast<BatchedResponse.V1>().batchedResponseV1.batch) {
            extractValue(it, QueryOutputBox.Transaction::transactionQueryOutput)
        }
    }
}

/**
* Extract a transaction value from a query [result]
*/
object TransactionValueExtractor : ResultExtractor<TransactionQueryOutput> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): TransactionQueryOutput {
        return extractValue(result.cast<BatchedResponse.V1>().batchedResponseV1.batch, QueryOutputBox.Transaction::transactionQueryOutput)
    }
}

object BlocksValueExtractor : ResultExtractor<List<SignedBlock>> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): List<SignedBlock> {
        return extractVec(result.cast<BatchedResponse.V1>().batchedResponseV1.batch) {
            extractValue(it, QueryOutputBox.Block::signedBlock)
        }
    }
}

object BlockHeadersExtractor : ResultExtractor<List<BlockHeader>> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): List<BlockHeader> {
        return extractVec(result.cast<BatchedResponse.V1>().batchedResponseV1.batch) {
            extractValue(it, QueryOutputBox.BlockHeader::blockHeader)
        }
    }
}

object BlockHeaderExtractor : ResultExtractor<BlockHeader> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): BlockHeader {
        return extractValue(result.cast<BatchedResponse.V1>().batchedResponseV1.batch, QueryOutputBox.BlockHeader::blockHeader)
    }
}

/**
 * Extract `String` from a query [result]
 */
object StringExtractor : ResultExtractor<String> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): String {
        return result.cast<BatchedResponse.V1>().batchedResponseV1.batch
            .cast<QueryOutputBox.Metadata>().string
            .fromJsonString()
    }
}

/**
 * Extract a list of roles from a query [result]
 */
object RolesExtractor : ResultExtractor<List<Role>> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): List<Role> {
        return extractVec(result.cast<BatchedResponse.V1>().batchedResponseV1.batch) {
            extractIdentifiable(it, IdentifiableBox.Role::role)
        }
    }
}

/**
 * Extract a role from a query [result]
 */
object RoleExtractor : ResultExtractor<Role> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): Role {
        return extractIdentifiable(result.cast<BatchedResponse.V1>().batchedResponseV1.batch, IdentifiableBox.Role::role)
    }
}

/**
 * Extract a list of role IDs from a query [result]
 */
object RoleIdsExtractor : ResultExtractor<List<RoleId>> {
    override fun extract(result: BatchedResponse<QueryOutputBox>): List<RoleId> {
        return extractVec(result.cast<BatchedResponse.V1>().batchedResponseV1.batch) {
            extractValue(it, QueryOutputBox.Id::idBox).cast<IdBox.RoleId>().roleId
        }
    }
}

/**
 * Extract one of the [IdentifiableBox] objects from value
 *
 * @param downstream Type to extract
 */
inline fun <reified I, R> extractIdentifiable(value: QueryOutputBox, downstream: (I) -> R): R {
    return when (value) {
        is QueryOutputBox.Identifiable -> when (val box = value.identifiableBox) {
            is I -> downstream(box)
            else -> throw QueryPayloadExtractionException(
                "Expected `${I::class.qualifiedName}`, but got `${box::class.qualifiedName}`",
            )
        }

        else -> throw QueryPayloadExtractionException(
            "Expected `${QueryOutputBox.Identifiable::class.qualifiedName}`, but got `${value::class.qualifiedName}`",
        )
    }
}

/**
 * Extract collection from `Value.Vec`
 *
 * @param downstream Type to extract
 */
inline fun <reified R> extractVec(value: QueryOutputBox, downstream: (QueryOutputBox) -> R): List<R> {
    when (value) {
        is QueryOutputBox.Vec -> {
            return value.vec.map { downstream(it) }
        }

        else -> throw QueryPayloadExtractionException(
            "Expected `${QueryOutputBox.Vec::class.qualifiedName}`, but got `${value::class.qualifiedName}`",
        )
    }
}

/**
 * Extract value
 *
 * @param downstream Type to extract
 */
inline fun <reified V, R> extractValue(value: QueryOutputBox, downstream: (V) -> R): R {
    return when (value) {
        is V -> downstream(value)
        else -> throw QueryPayloadExtractionException(
            "Expected `${V::class.qualifiedName}`, but got `${value::class.qualifiedName}`",
        )
    }
}
