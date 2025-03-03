package jp.co.soramitsu.iroha2.codec.writer

import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleWriter

/**
 * SCALE codec writer for Java Short Integers to encode them as unsigned byte SCALE values
 */
class UByteWriter : ScaleWriter<Short> {
    override fun write(
        writer: ScaleCodecWriter,
        instance: Short,
    ) {
        require(!(instance < 0 || instance > 0xff)) { "Only values in range 0..255 are supported: $instance" }
        writer.directWrite(instance)
    }
}
