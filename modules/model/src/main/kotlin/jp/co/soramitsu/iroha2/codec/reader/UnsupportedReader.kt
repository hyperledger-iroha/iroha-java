package jp.co.soramitsu.iroha2.codec.reader

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleReader

/**
 * Reader for unsupported values
 *
 * @throws IllegalStateException
 */
class UnsupportedReader<T>
    @JvmOverloads
    constructor(
        private val message: String = "Reading an unsupported value",
    ) : ScaleReader<T> {
        override fun read(reader: ScaleCodecReader): T = throw IllegalStateException(message)
    }
