package jp.co.soramitsu.iroha2.codec

import java.math.BigInteger

/**
 * The largest values for Integer types
 */
enum class IntMax(
    val max: BigInteger,
) {
    U64(BigInteger.valueOf(2).pow(64) - BigInteger.ONE),
    U128(BigInteger.valueOf(2).pow(128) - BigInteger.ONE),
    U256(BigInteger.valueOf(2).pow(256) - BigInteger.ONE),
    I128(BigInteger.valueOf(2).pow(127) - BigInteger.ONE),
    I256(BigInteger.valueOf(2).pow(255) - BigInteger.ONE),
    ;

    companion object {
        fun uintMaxValue(bit: Int): BigInteger =
            when (bit) {
                64 -> U64
                128 -> U128
                256 -> U256
                else -> throw IllegalArgumentException("Unsupported type $bit")
            }.max

        fun intMaxValue(bit: Int): BigInteger =
            when (bit) {
                128 -> I128
                256 -> I256
                else -> throw IllegalArgumentException("Unsupported type $bit")
            }.max
    }
}

/**
 * The smallest values for signed Integer types
 */
enum class IntMin(
    val min: BigInteger,
) {
    I128(-BigInteger.valueOf(2).pow(127)),
    I256(-BigInteger.valueOf(2).pow(255)),
    ;

    companion object {
        fun intMinValue(bit: Int): BigInteger =
            when (bit) {
                128 -> I128
                256 -> I256
                else -> throw IllegalArgumentException("Unsupported type $bit")
            }.min
    }
}
