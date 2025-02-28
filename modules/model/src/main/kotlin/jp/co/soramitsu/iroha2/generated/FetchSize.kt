//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Unit

/**
 * FetchSize
 *
 * Generated from 'FetchSize' regular structure
 */
public data class FetchSize(
    public val fetchSize: NonZeroOfu64? = null,
) {
    public companion object : ScaleReader<FetchSize>, ScaleWriter<FetchSize> {
        override fun read(reader: ScaleCodecReader): FetchSize =
            try {
                FetchSize(
                    reader.readNullable(NonZeroOfu64) as NonZeroOfu64?,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: FetchSize,
        ): Unit =
            try {
                writer.writeNullable(NonZeroOfu64, instance.fetchSize)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
