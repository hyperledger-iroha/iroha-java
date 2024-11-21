package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.AssetId
import jp.co.soramitsu.iroha2.generated.AssetType
import jp.co.soramitsu.iroha2.generated.AssetValue
import jp.co.soramitsu.iroha2.generated.Json
import jp.co.soramitsu.iroha2.generated.Metadata
import jp.co.soramitsu.iroha2.generated.Mintable
import jp.co.soramitsu.iroha2.generated.Name
import kotlinx.coroutines.withTimeout
import java.security.KeyPair
import java.util.UUID

class SendTransaction(
    private val client: AdminIroha2Client,
    private val admin: AccountId,
    private val keyPair: KeyPair,
    private val chainUuid: UUID,
    private val timeout: Long = 10000,
) {

    suspend fun registerDomain(
        id: String,
        metadata: Map<Name, Json> = mapOf(),
        admin: AccountId = this.admin,
        keyPair: KeyPair = this.keyPair,
    ) {
        client.sendTransaction {
            account(admin)
            chainId(chainUuid)
            register(id.asDomainId(), metadata)
            buildSigned(keyPair)
        }.also {
            withTimeout(timeout) { it.await() }
        }
    }

    suspend fun registerAccount(
        id: String,
        metadata: Map<Name, Json> = mapOf(),
        admin: AccountId = this.admin,
        keyPair: KeyPair = this.keyPair,
    ) {
        client.sendTransaction {
            account(admin)
            chainId(chainUuid)
            register(id.asAccountId(), Metadata(metadata))
            buildSigned(keyPair)
        }.also {
            withTimeout(timeout) { it.await() }
        }
    }

    suspend fun registerAssetDefinition(
        id: String,
        type: AssetType = AssetType.Store(),
        metadata: Map<Name, Json> = mapOf(),
        mintable: Mintable = Mintable.Infinitely(),
        admin: AccountId = this.admin,
        keyPair: KeyPair = this.keyPair,
    ) {
        client.sendTransaction {
            account(admin)
            chainId(chainUuid)
            register(id.asAssetDefinitionId(), type, Metadata(metadata), mintable)
            buildSigned(keyPair)
        }.also {
            withTimeout(timeout) { it.await() }
        }
    }

    suspend fun registerAsset(
        id: AssetId,
        value: AssetValue,
        admin: AccountId = this.admin,
        keyPair: KeyPair = this.keyPair,
    ) {
        client.sendTransaction {
            account(admin)
            chainId(chainUuid)
            register(id, value)
            buildSigned(keyPair)
        }.also {
            withTimeout(timeout) { it.await() }
        }
    }

    suspend fun transferAsset(
        from: AssetId,
        value: Int,
        to: String,
        admin: AccountId = this.admin,
        keyPair: KeyPair = this.keyPair,
    ) {
        client.sendTransaction {
            account(admin)
            chainId(chainUuid)
            transfer(from, value, to.asAccountId())
            buildSigned(keyPair)
        }.also {
            withTimeout(timeout) { it.await() }
        }
    }

    suspend fun burnAssets(
        assetId: AssetId,
        value: Int,
        admin: AccountId = this.admin,
        keyPair: KeyPair = this.keyPair,
    ) {
        client.sendTransaction {
            account(admin)
            chainId(chainUuid)
            burn(assetId, value)
            buildSigned(keyPair)
        }.also {
            withTimeout(timeout) { it.await() }
        }
    }
}
