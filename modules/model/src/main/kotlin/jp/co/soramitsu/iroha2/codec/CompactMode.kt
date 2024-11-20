package jp.co.soramitsu.iroha2.codec

import java.math.BigInteger

/**
 * Compact mode for SCALE codec writers and readers
 */
enum class CompactMode(val value: Byte) {
    SINGLE(0.toByte()),
    TWO(1.toByte()),
    FOUR(2.toByte()),
    BIGINT(3.toByte()),
    ;

    companion object {
        private val MAX = BigInteger.valueOf(2).pow(536).subtract(BigInteger.ONE)

        @JvmStatic
        fun byValue(value: Byte): CompactMode = when (value) {
            SINGLE.value -> SINGLE
            TWO.value -> TWO
            FOUR.value -> FOUR
            else -> BIGINT
        }

        fun forNumber(number: Int): CompactMode = forNumber(number.toLong())

        fun forNumber(number: Long): CompactMode {
            require(number >= 0) { "Negative numbers are not supported" }
            return when {
                number <= 0x3f -> SINGLE
                number <= 0x3fff -> TWO
                number <= 0x3fffffff -> FOUR
                else -> BIGINT
            }
        }

        @JvmStatic
        fun forNumber(number: BigInteger): CompactMode {
            require(number.signum() >= 0) { "Negative numbers are not supported" }
            require(number <= MAX) { "Numbers larger than 2**536-1 are not supported" }
            return when {
                number > BigInteger.valueOf(0x3fffffff) -> BIGINT
                number > BigInteger.valueOf(0x3fff) -> FOUR
                number > BigInteger.valueOf(0x3f) -> TWO
                number == BigInteger.ZERO -> SINGLE
                else -> SINGLE
            }
        }
    }
}
