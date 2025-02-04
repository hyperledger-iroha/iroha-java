package jp.co.soramitsu.iroha2.client.balancing

import java.net.URL

/**
 * Round-robin load balancing strategy
 */
open class RoundRobinStrategy(
    private val urls: List<URL>,
) : BalancingStrategy {
    private var lastRequestedPeerIdx: Int? = null

    override fun getApiURL(): URL = getUrls()

    private fun getUrls() =
        when (lastRequestedPeerIdx) {
            null -> urls.first().also { lastRequestedPeerIdx = 0 }
            else -> {
                lastRequestedPeerIdx =
                    when (lastRequestedPeerIdx) {
                        urls.size - 1 -> 0
                        else -> lastRequestedPeerIdx!! + 1
                    }
                urls[lastRequestedPeerIdx!!]
            }
        }
}
