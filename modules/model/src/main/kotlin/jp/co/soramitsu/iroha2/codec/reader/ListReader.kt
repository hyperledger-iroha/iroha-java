package jp.co.soramitsu.iroha2.codec.reader

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleReader

/**
 * SCALE codec reader for a list of values encoded as <T>type</T>
 */
class ListReader<T>(
    private val scaleReader: ScaleReader<T>,
) : ScaleReader<List<T>> {
    override fun read(reader: ScaleCodecReader): List<T> {
        val size = reader.readCompactInt()
        val result: MutableList<T> = ArrayList(size)
        for (i in 0 until size) {
            reader.read(scaleReader)?.also { result.add(it) }
        }
        return result
    }
}
