package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.AssetValue
import jp.co.soramitsu.iroha2.generated.GenericPredicateBox
import jp.co.soramitsu.iroha2.generated.QueryOutputPredicate
import jp.co.soramitsu.iroha2.query.QueryBuilder
import java.math.BigInteger
import java.security.KeyPair

open class Query(
    private val client: AdminIroha2Client,
    private val admin: AccountId,
    private val keyPair: KeyPair,
) {

    suspend fun findAllDomains(queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null) = QueryBuilder
        .findAllDomains(queryFilter)
        .account(admin)
        .buildSigned(keyPair)
        .let { client.sendQuery(it) }

    suspend fun findAllAccounts(queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null) = QueryBuilder
        .findAllAccounts(queryFilter)
        .account(admin)
        .buildSigned(keyPair)
        .let { client.sendQuery(it) }

    suspend fun findAllAssets(queryFilter: GenericPredicateBox<QueryOutputPredicate>? = null) = QueryBuilder
        .findAllAssets(queryFilter)
        .account(admin)
        .buildSigned(keyPair)
        .let { client.sendQuery(it) }

    suspend fun getAccountAmount(accountId: AccountId, assetDefinitionId: AssetDefinitionId): BigInteger =
        QueryBuilder.findAssetsByAccountId(accountId)
            .account(admin)
            .buildSigned(keyPair)
            .let { query ->
                client.sendQuery(query).find { it.id.definition == assetDefinitionId }?.value
            }.let { value ->
                value?.cast<AssetValue.Numeric>()?.numeric?.mantissa
            } ?: throw RuntimeException("NOT FOUND")
}
