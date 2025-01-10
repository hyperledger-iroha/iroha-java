package jp.co.soramitsu.iroha2.client.balancing

import jp.co.soramitsu.iroha2.model.IrohaUrls
import java.net.URL

open class WithoutBalancingStrategy(private val urls: List<IrohaUrls>) : BalancingStrategy {
    override fun getApiUrl(): URL = urls.first().apiUrl

    override fun getPeerUrl(): URL = urls.first().peerUrl
}
