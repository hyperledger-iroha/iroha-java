package jp.co.soramitsu.iroha2.codec.writer

import jp.co.soramitsu.iroha2.codec.CompactMode
import jp.co.soramitsu.iroha2.codec.CompactMode.Companion.forNumber
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleWriter

class CompactUIntWriter : ScaleWriter<Int> {
    override fun write(wrt: ScaleCodecWriter, value: Int) {
        val mode = forNumber(value)
        var compact: Int
        var bytes: Int
        if (mode === CompactMode.BIGINT) {
            wrt.directWrite(mode.value.toInt())
            compact = value
            bytes = 4
        } else {
            compact = (value shl 2) + mode.value
            bytes = when (mode) {
                CompactMode.SINGLE -> 1
                CompactMode.TWO -> 2
                else -> 4
            }
        }
        while (bytes > 0) {
            wrt.directWrite(compact and 0xff)
            compact = compact shr 8
            bytes--
        }
    }
}
