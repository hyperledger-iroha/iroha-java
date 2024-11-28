package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.generated.AssetId
import jp.co.soramitsu.iroha2.generated.AssetType
import jp.co.soramitsu.iroha2.generated.AssetValue
import jp.co.soramitsu.iroha2.generated.Json
import jp.co.soramitsu.iroha2.generated.Metadata
import jp.co.soramitsu.iroha2.generated.Mintable
import jp.co.soramitsu.iroha2.generated.Name
import jp.co.soramitsu.iroha2.transaction.Burn
import jp.co.soramitsu.iroha2.transaction.Register
import jp.co.soramitsu.iroha2.transaction.Transfer
import kotlinx.coroutines.withTimeout
import java.math.BigDecimal

class SendTransaction(private val client: AdminIroha2Client, private val timeout: Long = 10000) {

    suspend fun registerDomain(id: String, metadata: Map<Name, Json> = mapOf()) {
        Register.domain(id.asDomainId(), metadata).execute(client).also {
            withTimeout(timeout) { it.await() }
        }
    }

    suspend fun registerAccount(id: String, metadata: Map<Name, Json> = mapOf()) {
        Register.account(id.asAccountId(), Metadata(metadata)).execute(client).also {
            withTimeout(timeout) { it.await() }
        }
    }

    suspend fun registerAssetDefinition(
        id: String,
        type: AssetType = AssetType.Store(),
        metadata: Map<Name, Json> = mapOf(),
        mintable: Mintable = Mintable.Infinitely(),
    ) {
        Register.assetDefinition(id.asAssetDefinitionId(), type, mintable, metadata = Metadata(metadata)).execute(client).also {
            withTimeout(timeout) { it.await() }
        }
    }

    suspend fun registerAsset(id: AssetId, value: AssetValue) {
        Register.asset(id, value).execute(client).also {
            withTimeout(timeout) { it.await() }
        }
    }

    suspend fun transferAsset(
        from: AssetId,
        value: BigDecimal,
        to: String,
    ) {
        Transfer.asset(from, value, to.asAccountId()).execute(client).also {
            withTimeout(timeout) { it.await() }
        }
    }

    suspend fun burnAssets(assetId: AssetId, value: BigDecimal) {
        Burn.asset(assetId, value).execute(client).also {
            withTimeout(timeout) { it.await() }
        }
    }
}
