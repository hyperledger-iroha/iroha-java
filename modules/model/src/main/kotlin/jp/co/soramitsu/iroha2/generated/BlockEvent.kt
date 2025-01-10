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
 * BlockEvent
 *
 * Generated from 'BlockEvent' regular structure
 */
public data class BlockEvent(
    public val `header`: BlockHeader,
    public val status: BlockStatus,
) {
    public companion object : ScaleReader<BlockEvent>, ScaleWriter<BlockEvent> {
        override fun read(reader: ScaleCodecReader): BlockEvent = try {
            BlockEvent(
                BlockHeader.read(reader),
                BlockStatus.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: BlockEvent): Unit = try {
            BlockHeader.write(writer, instance.`header`)
            BlockStatus.write(writer, instance.status)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
