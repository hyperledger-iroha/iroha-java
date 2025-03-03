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
import kotlin.collections.List

/**
 * BlockPayload
 *
 * Generated from 'BlockPayload' regular structure
 */
public data class BlockPayload(
    public val `header`: BlockHeader,
    public val transactions: List<SignedTransaction>,
) {
    public companion object : ScaleReader<BlockPayload>, ScaleWriter<BlockPayload> {
        override fun read(reader: ScaleCodecReader): BlockPayload =
            try {
                BlockPayload(
                    BlockHeader.read(reader),
                    reader.readVec(reader.readCompactInt()) { SignedTransaction.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: BlockPayload,
        ): Unit =
            try {
                BlockHeader.write(writer, instance.`header`)
                writer.writeCompact(instance.transactions.size)
                instance.transactions.forEach { value ->
                    SignedTransaction.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
