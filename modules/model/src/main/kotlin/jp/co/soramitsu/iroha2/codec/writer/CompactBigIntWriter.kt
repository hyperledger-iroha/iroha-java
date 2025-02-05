package jp.co.soramitsu.iroha2.codec.writer

import jp.co.soramitsu.iroha2.codec.CompactMode
import jp.co.soramitsu.iroha2.codec.CompactMode.Companion.forNumber
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import java.math.BigInteger

/**
 * [Compact mode][CompactMode] SCALE writer for Big Integers
 */
class CompactBigIntWriter : ScaleWriter<BigInteger> {
    override fun write(
        writer: ScaleCodecWriter,
        instance: BigInteger,
    ) {
        val mode = forNumber(instance)
        val data = instance.toByteArray()
        var length = data.size
        var pos = data.size - 1
        var limit = 0
        if (mode !== CompactMode.BIGINT) {
            LONG_WRITER.write(writer, instance.toLong())
            return
        }

        // skip the first byte if it's 0
        if (data[0] == 0.toByte()) {
            length--
            limit++
        }
        writer.directWrite((length - 4 shl 2) + mode.value)
        while (pos >= limit) {
            writer.directWrite(data[pos].toInt())
            pos--
        }
    }

    companion object {
        private val LONG_WRITER = CompactULongWriter()
    }
}
