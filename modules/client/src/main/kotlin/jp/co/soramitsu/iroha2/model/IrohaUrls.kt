package jp.co.soramitsu.iroha2.model

import java.net.URL

data class IrohaUrls(val apiUrl: URL, val peerUrl: URL) {
    constructor(
        apiUrl: String,
        peerUrl: String,
    ) : this(URL(apiUrl), URL(peerUrl))
}
