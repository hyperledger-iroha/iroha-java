package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.client.Iroha2Client
import jp.co.soramitsu.iroha2.query.QueryBuilder
import jp.co.soramitsu.iroha2.testengine.ALICE_ACCOUNT_ID
import jp.co.soramitsu.iroha2.testengine.ALICE_KEYPAIR
import jp.co.soramitsu.iroha2.testengine.DefaultGenesis
import jp.co.soramitsu.iroha2.testengine.IrohaConfig
import jp.co.soramitsu.iroha2.testengine.IrohaContainer
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.withTimeout
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.time.Duration
import kotlin.reflect.full.createInstance
import kotlin.test.assertEquals

@Disabled
class ExampleTest {

    /**
     * Test with manual Iroha2Client initialization
     */
    @Test
    fun `register domain instruction committed`(): Unit = runBlocking {
        val ports = findFreePorts(3)
        val p2pPort = ports[IrohaConfig.P2P_PORT_IDX]

        val container = IrohaContainer {
            this.ports = ports
            this.alias = "iroha$p2pPort"
            this.genesis = DefaultGenesis::class.createInstance()
        }.also { it.start() }

        val client = Iroha2Client(container.getApiUrl(), true)

        val domainId = "new_domain_name".asDomainId()
        client.sendTransaction {
            account(ALICE_ACCOUNT_ID)
            registerDomain(domainId)
            buildSigned(ALICE_KEYPAIR)
        }.also { d ->
            withTimeout(Duration.ofSeconds(10)) { d.await() }
        }

        QueryBuilder.findDomainById(domainId)
            .account(ALICE_ACCOUNT_ID)
            .buildSigned(ALICE_KEYPAIR)
            .let { query -> client.sendQuery(query) }
            .also { result -> assertEquals(result.id, domainId) }
    }
}
