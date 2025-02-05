package jp.co.soramitsu.iroha2.codec.reader

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleReader

/**
 * SCALE codec reader for Boolean values encoded as SCALE values
 */
class BoolReader : ScaleReader<Boolean> {
    override fun read(reader: ScaleCodecReader): Boolean =
        when (val b = reader.readByte().toInt()) {
            0 -> false
            1 -> true
            else -> throw IllegalStateException("Not a boolean option: $b")
        }
}

/**
 * SCALE codec reader for Nullable Boolean values encoded as SCALE values
 */
class BoolNullableReader : ScaleReader<Boolean?> {
    override fun read(reader: ScaleCodecReader): Boolean? =
        when (val b = reader.readByte().toInt()) {
            0 -> null
            1 -> false
            2 -> true
            else -> throw IllegalStateException("Not a boolean option: $b")
        }
}
