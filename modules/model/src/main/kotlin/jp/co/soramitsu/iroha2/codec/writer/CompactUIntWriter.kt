package jp.co.soramitsu.iroha2.codec.writer

import jp.co.soramitsu.iroha2.codec.CompactMode
import jp.co.soramitsu.iroha2.codec.CompactMode.Companion.forNumber
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleWriter

/**
 * [Compact mode][CompactMode] SCALE writer for unsigned Integers
 */
class CompactUIntWriter : ScaleWriter<Int> {
    override fun write(
        writer: ScaleCodecWriter,
        instance: Int,
    ) {
        val mode = forNumber(instance)
        var compact: Int
        var bytes: Int
        if (mode === CompactMode.BIGINT) {
            writer.directWrite(mode.value.toInt())
            compact = instance
            bytes = 4
        } else {
            compact = (instance shl 2) + mode.value
            bytes =
                when (mode) {
                    CompactMode.SINGLE -> 1
                    CompactMode.TWO -> 2
                    else -> 4
                }
        }
        while (bytes > 0) {
            writer.directWrite(compact and 0xff)
            compact = compact shr 8
            bytes--
        }
    }
}
