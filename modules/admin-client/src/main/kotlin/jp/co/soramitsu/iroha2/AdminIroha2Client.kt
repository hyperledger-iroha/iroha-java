package jp.co.soramitsu.iroha2

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import jp.co.soramitsu.iroha2.client.Iroha2Client
import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.Peer
import java.net.URL
import java.security.KeyPair
import java.util.*

/**
 * Enhancement of [Iroha2Client] for monitoring peers and configuration support
 */
@Suppress("unused")
open class AdminIroha2Client(
    override val apiUrl: URL,
    override val chain: UUID,
    override val authority: AccountId,
    override val keyPair: KeyPair,
    credentials: String? = null,
    log: Boolean = false,
    private val balancingHealthCheck: Boolean = true,
) : Iroha2Client(apiUrl, chain, authority, keyPair, credentials, log) {

    /**
     * Send metrics request
     */
    suspend fun metrics(): String = client.get("${apiUrl}$METRICS_ENDPOINT").body()

    /**
     * Send health check request
     */
    suspend fun health(): Int = client.get("${apiUrl}$HEALTH_ENDPOINT").status.value

    /**
     * Send health check request
     */
    private suspend fun health(peerUrl: URL): Int = client.get("$peerUrl$HEALTH_ENDPOINT").status.value

    /**
     * Send status check request
     */
    suspend fun status(): PeerStatus = client.get("${apiUrl}$STATUS_ENDPOINT").body()

    /**
     * Send peers request
     */
    suspend fun peers(): List<Peer> = client.get("${apiUrl}$PEERS_ENDPOINT").body()

    /**
     * Send schema request
     */
    suspend fun schema(): String = client.get("${apiUrl}$SCHEMA_ENDPOINT").body()

    /**
     * Request current configuration of the peer
     */
    suspend fun getConfigs(): Map<String, *> = config(ConfigurationFieldType.Value)

    /**
     * Request description of a configuration property
     */
    suspend fun describeConfig(fieldValue: Collection<String>): String {
        if (fieldValue.isEmpty()) {
            throw IrohaClientException("At least one config property name must be provided")
        }
        return config(mapOf(ConfigurationFieldType.Docs to fieldValue))
    }

    private suspend inline fun <reified T, reified B> config(body: B): T {
        val response: HttpResponse = client.get("${apiUrl}$CONFIGURATION_ENDPOINT") {
            contentType(ContentType.Application.Json)
            setBody(body)
        }
        return response.body()
    }

    enum class ConfigurationFieldType { Value, Docs }
}
