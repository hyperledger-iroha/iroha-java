package jp.co.soramitsu.iroha2.codec.writer

import java.io.IOException
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleWriter

class UInt16Writer : ScaleWriter<Int?> {
    @Throws(IOException::class)
    override fun write(wrt: ScaleCodecWriter, value: Int) {
        wrt.directWrite(value and 0xff)
        wrt.directWrite(value shr 8 and 0xff)
    }
}