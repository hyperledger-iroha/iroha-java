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
import jp.co.soramitsu.iroha2.transaction.Register
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.withTimeout
import org.junit.jupiter.api.Test
import java.time.Duration
import kotlin.test.assertEquals

class GenesisTest : IrohaTest<Iroha2Client>() {
    companion object {
    }

    @Test
    @WithIroha(source = "src/test/resources/genesis.json", configs = ["LOG_LEVEL${IROHA_CONFIG_DELIMITER}TRACE"])
    fun `register asset instruction committed`(): Unit =
        runBlocking {
            client.checkAliceAndBobExists()
        }

    @Test
    fun `manual IrohaContainer initialization`(): Unit =
        runBlocking {
            val path = javaClass.getResource("../../genesis.json")!!.path
            val container =
                IrohaContainer {
                    this.alias = "iroha$DEFAULT_P2P_PORT"
                    this.genesisPath = path
                }.also { it.start() }

            val client = Iroha2Client(listOf(container.getApiUrl()), container.config.chain, ALICE_ACCOUNT_ID, ALICE_KEYPAIR)
            client.checkAliceAndBobExists()
        }

    @Test
    @WithIroha([DefaultGenesis::class], executorSource = "src/test/resources/executor.wasm")
    fun `custom executor path`(): Unit =
        runBlocking {
            val definitionId = AssetDefinitionId(DEFAULT_DOMAIN_ID, "XSTUSD".asName())
            client.submit(Register.assetDefinition(definitionId, AssetType.numeric())).also { d ->
                withTimeout(Duration.ofSeconds(10)) { d.await() }
            }

            client
                .submit(QueryBuilder.findAssetsDefinitions())
                .first { it.id == definitionId }
                .also { assetDefinition -> assertEquals(assetDefinition.id, definitionId) }
        }

    private suspend fun Iroha2Client.checkAliceAndBobExists() {
        submit(QueryBuilder.findAccounts())
            .also { accounts -> assert(accounts.any { it.id == ALICE_ACCOUNT_ID }) }
            .also { accounts -> assert(accounts.any { it.id == BOB_ACCOUNT_ID }) }
    }
}
