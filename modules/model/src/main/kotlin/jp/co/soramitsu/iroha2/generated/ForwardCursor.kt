//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.String
import kotlin.Unit

/**
 * ForwardCursor
 *
 * Generated from 'ForwardCursor' regular structure
 */
public data class ForwardCursor(
    public val query: String? = null,
    public val cursor: NonZeroOfu64? = null,
) {
    public companion object : ScaleReader<ForwardCursor>, ScaleWriter<ForwardCursor> {
        override fun read(reader: ScaleCodecReader): ForwardCursor = try {
            ForwardCursor(
                reader.readNullable(),
                reader.readNullable(NonZeroOfu64) as NonZeroOfu64?,
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: ForwardCursor): Unit = try {
            writer.writeNullable(instance.query)
            writer.writeNullable(NonZeroOfu64, instance.cursor)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
