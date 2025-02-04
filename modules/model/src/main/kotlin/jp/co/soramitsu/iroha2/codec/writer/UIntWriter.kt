package jp.co.soramitsu.iroha2.codec.writer

import jp.co.soramitsu.iroha2.codec.IntMax
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import java.math.BigInteger

/**
 * SCALE codec writer for Java Big Integers to encode them as unsigned integer SCALE values
 */
open class UIntWriter(
    private val bit: Int,
) : ScaleWriter<BigInteger> {
    override fun write(
        writer: ScaleCodecWriter,
        instance: BigInteger,
    ) {
        require(instance >= BigInteger.ZERO) { "Negative values are not supported: $instance" }
        require(instance <= IntMax.uintMaxValue(bit)) { "Value is too big for U$bit: $instance" }

        writer.directWrite(instance.and(BigInteger.valueOf(255)))
        for (n in 8..bit - 8 step 8) {
            writer.directWrite(instance.shiftRight(n).and(BigInteger.valueOf(255)))
        }
    }
}

/**
 * SCALE codec writer for Java Integers to encode them as unsigned 16-bit integer SCALE values
 */
class UInt16Writer : ScaleWriter<Int> {
    override fun write(
        wrt: ScaleCodecWriter,
        value: Int,
    ) {
        require(value >= 0) { "Negative values are not supported: $value" }
        wrt.directWrite(value and 0xff)
        wrt.directWrite(value shr 8 and 0xff)
    }
}

/**
 * SCALE codec writer for Kotlin Int to encode them as unsigned 32-bit integer SCALE values
 */
class UInt32Writer : ScaleWriter<Int> {
    override fun write(
        wrt: ScaleCodecWriter,
        value: Int,
    ) {
        require(value >= 0) { "Negative values are not supported: $value" }
        wrt.directWrite(value and 0xff)
        wrt.directWrite(value shr 8 and 0xff)
        wrt.directWrite(value shr 16 and 0xff)
        wrt.directWrite(value shr 24 and 0xff)
    }
}

/**
 * SCALE codec writer for Kotlin Long to encode them as unsigned 32-bit integer SCALE values
 */
class ULong32Writer : ScaleWriter<Long> {
    override fun write(
        wrt: ScaleCodecWriter,
        value: Long,
    ) {
        require(value >= 0) { "Negative values are not supported: $value" }
        require(value <= 0xffffffffL) { "Value is too big for U32: $value" }
        wrt.directWrite(value and 0xff)
        wrt.directWrite(value shr 8 and 0xff)
        wrt.directWrite(value shr 16 and 0xff)
        wrt.directWrite(value shr 24 and 0xff)
    }
}
