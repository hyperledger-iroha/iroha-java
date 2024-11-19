package jp.co.soramitsu.iroha2

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import jp.co.soramitsu.iroha2.client.Iroha2Client
import jp.co.soramitsu.iroha2.generated.Peer
import jp.co.soramitsu.iroha2.model.IrohaUrls
import kotlinx.coroutines.runBlocking
import java.net.URL

/**
 * Enhancement of [Iroha2Client] for monitoring peers and configuration support
 */
@Suppress("unused")
open class AdminIroha2Client(
    urls: List<IrohaUrls>,
    log: Boolean = false,
    credentials: String? = null,
    private val balancingHealthCheck: Boolean = true,
) : Iroha2Client(urls, log, credentials) {

    constructor(
        url: IrohaUrls,
        log: Boolean = false,
        credentials: String? = null,
        balancingHealthCheck: Boolean = true,
    ) : this(mutableListOf(url), log, credentials, balancingHealthCheck)

    constructor(
        apiUrl: URL,
        peerUrl: URL,
        log: Boolean = false,
        credentials: String? = null,
        balancingHealthCheck: Boolean = true,
    ) : this(IrohaUrls(apiUrl, peerUrl), log, credentials, balancingHealthCheck)

    constructor(
        apiUrl: String,
        peerUrl: String,
        log: Boolean = false,
        credentials: String? = null,
        balancingHealthCheck: Boolean = true,
    ) : this(URL(apiUrl), URL(peerUrl), log, credentials, balancingHealthCheck)

    /**
     * Send metrics request
     */
    suspend fun metrics(): String = client.get("${getApiUrl()}$METRICS_ENDPOINT").body()

    /**
     * Send health check request
     */
    suspend fun health(): Int = client.get("${getApiUrl()}$HEALTH_ENDPOINT").status.value

    /**
     * Send health check request
     */
    private suspend fun health(peerUrl: URL): Int = client.get("$peerUrl$HEALTH_ENDPOINT").status.value

    /**
     * Send status check request
     */
    suspend fun status(): PeerStatus = client.get("${getApiUrl()}$STATUS_ENDPOINT").body()

    /**
     * Send peers request
     */
    suspend fun peers(): List<Peer> = client.get("${getApiUrl()}$PEERS_ENDPOINT").body()

    /**
     * Send schema request
     */
    suspend fun schema(): String = client.get("${getApiUrl()}$SCHEMA_ENDPOINT").body()

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
        val response: HttpResponse = client.get("${getApiUrl()}$CONFIGURATION_ENDPOINT") {
            contentType(ContentType.Application.Json)
            setBody(body)
        }
        return response.body()
    }

    override fun getApiUrl(): URL = when (balancingHealthCheck) {
        true -> {
            var attempt = 0
            var url = super.getApiUrl()

            while (runBlocking { health(url) } != HttpStatusCode.OK.value) {
                url = super.getApiUrl()
                if (++attempt >= urls.size) {
                    throw IrohaClientException("All peers are unhealthy")
                }
            }
            url
        }

        false -> super.getApiUrl()
    }

    enum class ConfigurationFieldType { Value, Docs }
}
