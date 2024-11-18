package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.client.Iroha2Client
import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.AssetValueType
import jp.co.soramitsu.iroha2.query.QueryBuilder
import jp.co.soramitsu.iroha2.testengine.ALICE_ACCOUNT_ID
import jp.co.soramitsu.iroha2.testengine.BOB_ACCOUNT_ID
import jp.co.soramitsu.iroha2.testengine.DEFAULT_DOMAIN_ID
import jp.co.soramitsu.iroha2.testengine.DefaultGenesis
import jp.co.soramitsu.iroha2.testengine.IrohaContainer
import jp.co.soramitsu.iroha2.testengine.IrohaTest
import jp.co.soramitsu.iroha2.testengine.WithIroha
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GenesisTest : IrohaTest<Iroha2Client>() {
    companion object {
        private val ALICE_KEYPAIR = keyPairFromHex(
            "cc25624d62896d3a0bfd8940f928dc2abf27cc57cefeb442aa96d9081aae58a1",
            "3bac34cda9e3763fa069c1198312d1ec73b53023b8180c822ac355435edc4a24",
        )
    }

    @Test
    @WithIroha(source = "src/test/resources/genesis.json")
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

        val client = Iroha2Client(container.getApiUrl(), container.getTelemetryUrl(), container.getP2pUrl())
        client.checkAliceAndBobExists()
    }

    @Test
    @WithIroha([DefaultGenesis::class], executorSource = "src/test/resources/executor.wasm")
    fun `custom executor path`(): Unit = runBlocking {
        val definitionId = AssetDefinitionId("XSTUSD".asName(), DEFAULT_DOMAIN_ID)
        client.tx { registerAssetDefinition(definitionId, AssetValueType.Quantity()) }

        QueryBuilder.findAssetDefinitionById(definitionId)
            .account(super.account)
            .buildSigned(super.keyPair)
            .let { query -> client.sendQuery(query) }
            .also { assetDefinition -> assertEquals(assetDefinition.id, definitionId) }
    }

    private suspend fun Iroha2Client.checkAliceAndBobExists() {
        QueryBuilder.findAllAccounts()
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> this.sendQuery(query) }
            .also { accounts -> assert(accounts.any { it.id == ALICE_ACCOUNT_ID }) }
            .also { accounts -> assert(accounts.any { it.id == BOB_ACCOUNT_ID }) }
    }
}
