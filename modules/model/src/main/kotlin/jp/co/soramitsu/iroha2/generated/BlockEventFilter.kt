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
 * BlockEventFilter
 *
 * Generated from 'BlockEventFilter' regular structure
 */
public data class BlockEventFilter(
    public val height: NonZeroOfu64? = null,
    public val status: BlockStatus? = null,
) {
    public companion object : ScaleReader<BlockEventFilter>, ScaleWriter<BlockEventFilter> {
        override fun read(reader: ScaleCodecReader): BlockEventFilter = try {
            BlockEventFilter(
                reader.readNullable(NonZeroOfu64) as NonZeroOfu64?,
                reader.readNullable(BlockStatus) as BlockStatus?,
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: BlockEventFilter): Unit = try {
            writer.writeNullable(NonZeroOfu64, instance.height)
            writer.writeNullable(BlockStatus, instance.status)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
