package jp.co.soramitsu.iroha2.client

import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.query.QueryAndExtractor
import kotlinx.coroutines.future.future
import java.net.URL
import java.security.KeyPair
import java.util.UUID
import java.util.concurrent.CompletableFuture

/**
 * Extension of [Iroha2Client] for Java
 */
@Suppress("unused")
class Iroha2AsyncClient @JvmOverloads constructor(
    override val apiURL: List<URL>,
    override val chain: UUID,
    override val authority: AccountId,
    override val keyPair: KeyPair,
    credentials: String? = null,
    log: Boolean = false,
    eventReadTimeoutInMills: Long = 250,
    eventReadMaxAttempts: Int = 10,
) : Iroha2Client(apiURL, chain, authority, keyPair, credentials, log, eventReadTimeoutInMills, eventReadMaxAttempts) {

    /**
     * Send a request to Iroha2 and extract payload.
     * {@see Extractors}
     */
    fun <T> sendQueryAsync(queryAndExtractor: QueryAndExtractor<T>): CompletableFuture<T> = future {
        sendQuery(queryAndExtractor)
    }
}
