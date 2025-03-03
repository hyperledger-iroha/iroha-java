package jp.co.soramitsu.iroha2.codec.writer

import jp.co.soramitsu.iroha2.codec.IntMax
import jp.co.soramitsu.iroha2.codec.IntMin
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import java.math.BigInteger

/**
 * SCALE codec writer for Java Integers to encode them as 32-bit integer SCALE value.
 */
class Int32Writer : ScaleWriter<Int> {
    override fun write(
        writer: ScaleCodecWriter,
        instance: Int,
    ) {
        require(Int.MIN_VALUE <= instance) { "Value is too small for I32: $instance" }
        require(instance <= Int.MAX_VALUE) { "Value is too big for I32: $instance" }

        writer.directWrite(instance and 0xff)
        writer.directWrite(instance shr 8 and 0xff)
        writer.directWrite(instance shr 16 and 0xff)
        writer.directWrite(instance shr 24 and 0xff)
    }
}

/**
 * SCALE codec writer for Java Long Integers to encode them as 64-bit integer SCALE value.
 */
class Int64Writer : ScaleWriter<Long> {
    override fun write(
        writer: ScaleCodecWriter,
        instance: Long,
    ) {
        require(Long.MIN_VALUE <= instance) { "Value is too small for I64: $instance" }
        require(instance <= Long.MAX_VALUE) { "Value is too big for I64: $instance" }

        writer.directWrite(instance and 0xff)
        writer.directWrite(instance shr 8 and 0xff)
        writer.directWrite(instance shr 16 and 0xff)
        writer.directWrite(instance shr 24 and 0xff)
        writer.directWrite(instance shr 32 and 0xff)
        writer.directWrite(instance shr 40 and 0xff)
        writer.directWrite(instance shr 48 and 0xff)
        writer.directWrite(instance shr 56 and 0xff)
    }
}

/**
 * SCALE codec writer for Java Big Integers to encode them as integer SCALE value.
 */
class IntWriter(
    private val bit: Int,
) : ScaleWriter<BigInteger> {
    override fun write(
        writer: ScaleCodecWriter,
        instance: BigInteger,
    ) {
        require(IntMin.intMinValue(bit) <= instance) { "Value is too small for I$bit: $instance" }
        require(instance <= IntMax.intMaxValue(bit)) { "Value is too big for I$bit: $instance" }

        writer.directWrite(instance.and(BigInteger.valueOf(255)))
        for (n in 8..bit - 8 step 8) {
            writer.directWrite(instance.shiftRight(n).and(BigInteger.valueOf(255)))
        }
    }
}
