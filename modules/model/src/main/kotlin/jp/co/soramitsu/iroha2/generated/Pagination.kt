//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import java.math.BigInteger
import kotlin.Unit

/**
 * Pagination
 *
 * Generated from 'Pagination' regular structure
 */
public data class Pagination(
    public val limit: NonZeroOfu64? = null,
    public val offset: BigInteger,
) {
    public companion object : ScaleReader<Pagination>, ScaleWriter<Pagination> {
        override fun read(reader: ScaleCodecReader): Pagination =
            try {
                Pagination(
                    reader.readNullable(NonZeroOfu64) as NonZeroOfu64?,
                    reader.readUint64(),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: Pagination,
        ): Unit =
            try {
                writer.writeNullable(NonZeroOfu64, instance.limit)
                writer.writeUint64(instance.offset)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
