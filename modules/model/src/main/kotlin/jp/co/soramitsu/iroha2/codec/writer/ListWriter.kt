package jp.co.soramitsu.iroha2.codec.writer

import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleWriter

/**
 * SCALE codec writer for a list of values to be encoded as <T>type</T>
 */
class ListWriter<T>(
    private val scaleWriter: ScaleWriter<T>,
) : ScaleWriter<List<T>> {
    override fun write(
        writer: ScaleCodecWriter,
        instance: List<T>,
    ) {
        writer.writeCompact(instance.size)
        for (item in instance) {
            scaleWriter.write(writer, item)
        }
    }
}
