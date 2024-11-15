package jp.co.soramitsu.iroha2

import io.ktor.client.call.body
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.request.get
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import jp.co.soramitsu.iroha2.client.Iroha2Client
import jp.co.soramitsu.iroha2.model.IrohaUrls
import kotlinx.coroutines.runBlocking
import java.net.URL

/**
 * Enhancement of [Iroha2Client] for monitoring peers and configuration support
 */
@Suppress("unused")
open class AdminIroha2Client(
    urls: List<IrohaUrls>,
    httpLogLevel: LogLevel = LogLevel.NONE,
    credentials: String? = null,
    private val balancingHealthCheck: Boolean = true,
) : Iroha2Client(urls, httpLogLevel, credentials) {

    constructor(
        url: IrohaUrls,
        httpLogLevel: LogLevel = LogLevel.NONE,
        credentials: String? = null,
        balancingHealthCheck: Boolean = true,
    ) : this(mutableListOf(url), httpLogLevel, credentials, balancingHealthCheck)

    constructor(
        apiUrl: URL,
        telemetryUrl: URL,
        peerUrl: URL,
        httpLogLevel: LogLevel = LogLevel.NONE,
        credentials: String? = null,
        balancingHealthCheck: Boolean = true,
    ) : this(IrohaUrls(apiUrl, telemetryUrl, peerUrl), httpLogLevel, credentials, balancingHealthCheck)

    constructor(
        apiUrl: String,
        telemetryUrl: String,
        peerUrl: String,
        httpLogLevel: LogLevel = LogLevel.NONE,
        credentials: String? = null,
        balancingHealthCheck: Boolean = true,
    ) : this(URL(apiUrl), URL(telemetryUrl), URL(peerUrl), httpLogLevel, credentials, balancingHealthCheck)

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
    suspend fun health(peerUrl: URL): Int = client.get("$peerUrl$HEALTH_ENDPOINT").status.value

    /**
     * Send status check request
     */
    suspend fun status(): PeerStatus = client.get("${getApiUrl()}$STATUS_ENDPOINT").body()

    /**
     * Send schema request
     */
    suspend fun schema(): String = client.get("${getTelemetryUrl()}$SCHEMA_ENDPOINT").body()

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

    suspend fun describeConfig(vararg fieldValue: String): String = describeConfig(fieldValue.asList())

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
