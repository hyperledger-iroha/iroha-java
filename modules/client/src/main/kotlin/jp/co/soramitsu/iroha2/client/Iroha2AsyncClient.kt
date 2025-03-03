package jp.co.soramitsu.iroha2.client

import io.ktor.client.plugins.logging.LogLevel
import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.SignedTransaction
import jp.co.soramitsu.iroha2.query.QueryAndExtractor
import kotlinx.coroutines.future.asCompletableFuture
import kotlinx.coroutines.future.future
import kotlinx.coroutines.runBlocking
import java.net.URL
import java.security.KeyPair
import java.util.UUID
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Future

/**
 * Extension of [Iroha2Client] for Java
 */
@Suppress("unused")
class Iroha2AsyncClient
    @JvmOverloads
    constructor(
        override val apiURL: List<URL>,
        override val chain: UUID,
        override val authority: AccountId,
        override val keyPair: KeyPair,
        httpLogLevel: LogLevel = LogLevel.NONE,
        credentials: String? = null,
        eventReadTimeoutInMills: Long = 250,
        eventReadMaxAttempts: Int = 10,
    ) : Iroha2Client(apiURL, chain, authority, keyPair, credentials, httpLogLevel, eventReadTimeoutInMills, eventReadMaxAttempts) {
        /**
         * Send a request to Iroha2 and extract payload.
         * {@see Extractors}
         */
        fun <T> sendQueryAsync(queryAndExtractor: QueryAndExtractor<T>): CompletableFuture<T> =
            future {
                submit(queryAndExtractor)
            }

        /**
         * Send a transaction to an Iroha peer and wait until it is committed or rejected.
         */
        fun sendTransactionAsync(transaction: SignedTransaction): Future<ByteArray> =
            runBlocking {
                submit(transaction).asCompletableFuture()
            }
    }
