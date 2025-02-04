package jp.co.soramitsu.iroha2.codec.writer

import jp.co.soramitsu.iroha2.codec.CompactMode
import jp.co.soramitsu.iroha2.codec.CompactMode.Companion.forNumber
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import java.math.BigInteger

/**
 * [Compact mode][CompactMode] SCALE writer for unsigned Long Integers
 */
class CompactULongWriter : ScaleWriter<Long> {
    override fun write(
        wrt: ScaleCodecWriter,
        value: Long,
    ) {
        val mode = forNumber(value)
        var compact: Long
        var bytes: Int
        if (mode === CompactMode.BIGINT) {
            BIGINT_WRITER.write(wrt, BigInteger.valueOf(value))
            return
        } else {
            compact = (value shl 2) + mode.value
            bytes =
                when (mode) {
                    CompactMode.SINGLE -> 1
                    CompactMode.TWO -> 2
                    else -> 4
                }
        }
        while (bytes > 0) {
            wrt.directWrite(compact.toInt() and 0xff)
            compact = compact shr 8
            bytes--
        }
    }

    companion object {
        private val BIGINT_WRITER = CompactBigIntWriter()
    }
}
