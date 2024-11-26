package jp.co.soramitsu.iroha2.client.balancing

import jp.co.soramitsu.iroha2.model.IrohaUrls
import java.net.URL

open class WithoutBalancingStrategy(private val urls: List<IrohaUrls>) : BalancingStrategy {
    override fun getApiURL(): URL = urls.first().apiUrl
}
