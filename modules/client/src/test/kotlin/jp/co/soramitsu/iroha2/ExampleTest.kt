package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.client.Iroha2Client
import jp.co.soramitsu.iroha2.query.QueryBuilder
import jp.co.soramitsu.iroha2.testengine.ALICE_ACCOUNT_ID
import jp.co.soramitsu.iroha2.testengine.ALICE_KEYPAIR
import jp.co.soramitsu.iroha2.testengine.DefaultGenesis
import jp.co.soramitsu.iroha2.testengine.IrohaContainer
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.withTimeout
import org.junit.jupiter.api.Test
import java.time.Duration
import kotlin.test.assertEquals

class ExampleTest {

    /**
     * Test with manual Iroha2Client initialization
     */
    @Test
    fun `register domain instruction committed`(): Unit = runBlocking {
        val container = IrohaContainer {
            this.alias = "iroha$DEFAULT_P2P_PORT"
            this.genesis = DefaultGenesis()
        }.also { it.start() }

        val client = Iroha2Client(container.getApiUrl(), container.getP2pUrl(), true)

        val domainId = "new_domain_name".asDomainId()
        client.sendTransaction {
            account(ALICE_ACCOUNT_ID)
            register(domainId)
            buildSigned(ALICE_KEYPAIR)
        }.also { d ->
            withTimeout(Duration.ofSeconds(10)) { d.await() }
        }

        QueryBuilder.findDomainById(domainId)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query)!! }
            .also { result -> assertEquals(result.id, domainId) }
    }
}
