package jp.co.soramitsu.iroha2

import io.ktor.http.HttpStatusCode
import jp.co.soramitsu.iroha2.testengine.IrohaTest
import jp.co.soramitsu.iroha2.testengine.WithIroha
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import kotlin.test.assertEquals

@Timeout(120)
class ClientTest : IrohaTest<AdminIroha2Client>() {

    @Test
    @WithIroha
    fun schema(): Unit = runBlocking {
        val schema = client.schema()
        assert(schema.isNotEmpty())
    }

    @Test
    @WithIroha
    fun health(): Unit = runBlocking {
        val health = client.health()
        assert(health == HttpStatusCode.OK.value)
    }

    @Test
    @WithIroha
    fun status(): Unit = runBlocking {
        val status = client.status()
        assertEquals(1, status.blocks)
    }

    @Test
    @WithIroha
    fun metrics(): Unit = runBlocking {
        val metrics = client.metrics()
        assert(metrics.isNotEmpty())
    }

    @Test
    @WithIroha
    fun getConfigValues(): Unit = runBlocking {
        val configs = client.getConfigs()
        assert(configs.isNotEmpty())
    }

    companion object {
        private const val PEER_AMOUNT = 4
    }
}
