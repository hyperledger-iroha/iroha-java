package jp.co.soramitsu.iroha2.codec.reader

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleReader

/**
 * SCALE codec reader for Java enum values.
 *
 * The reader reads one byte and returns a Enum value with the equal Ordinal value.
 *
 * If you need to read an enumeration with assigned value, i.e. Rust style enum, you should use [UnionReader] instead.
 *
 * @param <T> type of Enum
 * @see UnionReader
</T> */
class EnumReader<T : Enum<*>?>(
    values: Array<T>,
) : ScaleReader<T> {
    private val values: Array<T>

    override fun read(reader: ScaleCodecReader): T {
        val id = reader.readUByte()
        for (t in values) {
            if (t!!.ordinal == id.toInt()) {
                return t
            }
        }
        throw IllegalStateException("Unknown enum value: $id")
    }

    /**
     * Define reader by specifying the list of possible values. In most cases it would be:
     * `new EnumReader(MyEnum.values()`.
     *
     * @param values list of enum values
     */
    init {
        require(values.isNotEmpty()) { "List of enums is empty" }
        this.values = values
    }
}
