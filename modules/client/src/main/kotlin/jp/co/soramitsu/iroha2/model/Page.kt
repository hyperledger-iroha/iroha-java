package jp.co.soramitsu.iroha2.model

import java.math.BigInteger

/**
 * Pages contain query results with extracted [data].
 */
data class Page<T>(
    val data: T,
    val total: BigInteger,
)
