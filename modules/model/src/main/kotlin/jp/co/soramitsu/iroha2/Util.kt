package jp.co.soramitsu.iroha2

/**
 * The largest power of two that can be represented as an `int`.
 */
const val MAX_POWER_OF_TWO = 1 shl Integer.SIZE - 2

/**
 * The maximum unsigned zero-based value that can be represented by a 32-bit integer
 */
const val U32_MAX_VALUE = (1L shl 32) - 1

/**
 * Wrap an [exception][ex] in `ScaleCodecException`
 */
fun wrapException(ex: Exception): Exception = when (ex) {
    is ScaleCodecException -> ex
    else -> ScaleCodecException(cause = ex)
}
