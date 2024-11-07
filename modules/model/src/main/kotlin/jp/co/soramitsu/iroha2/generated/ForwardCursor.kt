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
    public val query: String,
    public val cursor: NonZeroOfu64,
) {
    public companion object : ScaleReader<ForwardCursor>, ScaleWriter<ForwardCursor> {
        override fun read(reader: ScaleCodecReader): ForwardCursor = try {
            ForwardCursor(
                reader.readString(),
                NonZeroOfu64.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: ForwardCursor): Unit = try {
            writer.writeAsList(instance.query.toByteArray(Charsets.UTF_8))
            NonZeroOfu64.write(writer, instance.cursor)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
