package jp.co.soramitsu.iroha2.codec.reader

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.UnionValue

/**
 * SCALE reader for [UnionValue]
 */
class UnionReader<T>(
    private val mapping: List<ScaleReader<out T>>,
) : ScaleReader<UnionValue<T>> {
    constructor(vararg mapping: ScaleReader<out T>) : this(listOf<ScaleReader<out T>>(*mapping))

    override fun read(reader: ScaleCodecReader): UnionValue<T> {
        val index = reader.readUByte()
        check(mapping.size > index) { "Unknown type index: $index" }
        val value = mapping[index.toInt()].read(reader)
        return UnionValue(index.toInt(), value)
    }
}
