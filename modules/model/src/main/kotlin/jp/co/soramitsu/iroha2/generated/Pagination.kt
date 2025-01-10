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
 * Pagination
 *
 * Generated from 'Pagination' regular structure
 */
public data class Pagination(
    public val limit: NonZeroOfu32? = null,
    public val start: NonZeroOfu64? = null,
) {
    public companion object : ScaleReader<Pagination>, ScaleWriter<Pagination> {
        override fun read(reader: ScaleCodecReader): Pagination = try {
            Pagination(
                reader.readNullable(NonZeroOfu32) as NonZeroOfu32?,
                reader.readNullable(NonZeroOfu64) as NonZeroOfu64?,
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: Pagination): Unit = try {
            writer.writeNullable(NonZeroOfu32, instance.limit)
            writer.writeNullable(NonZeroOfu64, instance.start)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
