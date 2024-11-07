package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.client.Iroha2Client
import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.AssetType
import jp.co.soramitsu.iroha2.query.QueryBuilder
import jp.co.soramitsu.iroha2.testengine.ALICE_ACCOUNT_ID
import jp.co.soramitsu.iroha2.testengine.ALICE_KEYPAIR
import jp.co.soramitsu.iroha2.testengine.BOB_ACCOUNT_ID
import jp.co.soramitsu.iroha2.testengine.DEFAULT_DOMAIN_ID
import jp.co.soramitsu.iroha2.testengine.DefaultGenesis
import jp.co.soramitsu.iroha2.testengine.IROHA_CONFIG_DELIMITER
import jp.co.soramitsu.iroha2.testengine.IrohaContainer
import jp.co.soramitsu.iroha2.testengine.IrohaTest
import jp.co.soramitsu.iroha2.testengine.WithIroha
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GenesisTest : IrohaTest<Iroha2Client>() {
    companion object {
    }

    @Test
    @WithIroha(source = "src/test/resources/genesis.json", configs = ["LOG_LEVEL${IROHA_CONFIG_DELIMITER}TRACE"])
    fun `register asset instruction committed`(): Unit = runBlocking {
        client.checkAliceAndBobExists()
    }

    @Test
    fun `manual IrohaContainer initialization`(): Unit = runBlocking {
        val path = javaClass.getResource("../../genesis.json")!!.path
        val container = IrohaContainer {
            this.alias = "iroha$DEFAULT_P2P_PORT"
            this.genesisPath = path
        }.also { it.start() }

        val client = Iroha2Client(container.getApiUrl(), container.getP2pUrl(), true)
        client.checkAliceAndBobExists()
    }

    @Test
    @WithIroha([DefaultGenesis::class], executorSource = "src/test/resources/executor.wasm")
    fun `custom executor path`(): Unit = runBlocking {
        val definitionId = AssetDefinitionId(DEFAULT_DOMAIN_ID, "XSTUSD".asName())
        client.tx { registerAssetDefinition(definitionId, AssetType.numeric()) }

        QueryBuilder.findAssetsDefinitions()
            .account(super.account)
            .buildSigned(super.keyPair)
            .let { query -> client.sendQuery(query) }
            .first { it.id == definitionId }
            .also { assetDefinition -> assertEquals(assetDefinition.id, definitionId) }
    }

    private suspend fun Iroha2Client.checkAliceAndBobExists() {
        QueryBuilder.findAccounts()
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> this.sendQuery(query) }
            .also { accounts -> assert(accounts.any { it.id == ALICE_ACCOUNT_ID }) }
            .also { accounts -> assert(accounts.any { it.id == BOB_ACCOUNT_ID }) }
    }
}
