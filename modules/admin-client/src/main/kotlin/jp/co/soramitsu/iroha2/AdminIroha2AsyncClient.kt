package jp.co.soramitsu.iroha2

import io.ktor.client.plugins.logging.LogLevel
import jp.co.soramitsu.iroha2.model.IrohaUrls
import kotlinx.coroutines.future.future

/**
 * Extension of [AdminIroha2Client] for Java. Functionality for monitoring peers and configuration support
 */
@Suppress("unused")
class AdminIroha2AsyncClient @JvmOverloads constructor(
    urls: List<IrohaUrls>,
    httpLogLevel: LogLevel = LogLevel.NONE,
    credentials: String? = null,
) : AdminIroha2Client(urls, httpLogLevel, credentials) {

    /**
     * Send health check request
     */
    fun healthAsync() = future { health() }

    /**
     * Send status check request
     */
    fun statusAsync() = future { status() }

    /**
     * Send metrics request
     */
    fun metricsAsync() = future { metrics() }

    /**
     * Request current configuration of the peer
     */
    fun getConfigsAsync() = future { getConfigs() }

    /**
     * Request description of a configuration property
     */
    fun describeConfigAsync(fieldValue: Collection<String>) = future { describeConfig(fieldValue) }
}
