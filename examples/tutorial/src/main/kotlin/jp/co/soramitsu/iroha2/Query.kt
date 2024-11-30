package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.AccountIdPredicateAtom
import jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.AssetProjectionOfPredicateMarker
import jp.co.soramitsu.iroha2.generated.AssetValue
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAccount
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAsset
import jp.co.soramitsu.iroha2.generated.CompoundPredicateOfDomain
import jp.co.soramitsu.iroha2.query.QueryBuilder
import java.math.BigInteger
import java.security.KeyPair

open class Query(
    private val client: AdminIroha2Client,
    private val admin: AccountId,
    private val keyPair: KeyPair,
) {

    suspend fun findAllDomains(filter: CompoundPredicateOfDomain? = null) = client.submit(
        QueryBuilder
            .findDomains(filter)
            .signAs(admin, keyPair),
    )

    suspend fun findAllAccounts(filter: CompoundPredicateOfAccount? = null) = client.submit(
        QueryBuilder
            .findAccounts(filter)
            .signAs(admin, keyPair),
    )

    suspend fun findAllAssets(filter: CompoundPredicateOfAsset? = null) = client.submit(
        QueryBuilder
            .findAssets(filter).signAs(admin, keyPair),
    )

    suspend fun getAccountAmount(accountId: AccountId, assetDefinitionId: AssetDefinitionId): BigInteger {
        val byAccountIdFilter = CompoundPredicateOfAsset.Atom(
            AssetProjectionOfPredicateMarker.Id(
                AssetIdProjectionOfPredicateMarker.Account(
                    AccountIdProjectionOfPredicateMarker.Atom(
                        AccountIdPredicateAtom.Equals(accountId),
                    ),
                ),
            ),
        )
        return client.submit(QueryBuilder.findAssets(byAccountIdFilter).signAs(admin, keyPair))
            .let { query ->
                query.find { it.id.definition == assetDefinitionId }?.value
            }.let { value ->
                value?.cast<AssetValue.Numeric>()?.numeric?.mantissa
            } ?: throw RuntimeException("NOT FOUND")
    }
}
