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
 * SelectorTupleOfBlockHeader
 *
 * Generated from 'SelectorTupleOfBlockHeader' regular structure
 */
public data class SelectorTupleOfBlockHeader(
    public val vecOfBlockHeaderProjectionOfSelectorMarker: List<BlockHeaderProjectionOfSelectorMarker>,
) {
    public companion object :
        ScaleReader<SelectorTupleOfBlockHeader>,
        ScaleWriter<SelectorTupleOfBlockHeader> {
        override fun read(reader: ScaleCodecReader): SelectorTupleOfBlockHeader = try {
            SelectorTupleOfBlockHeader(
                reader.readVec(reader.readCompactInt()) { BlockHeaderProjectionOfSelectorMarker.read(reader) },
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: SelectorTupleOfBlockHeader): Unit = try {
            writer.writeCompact(instance.vecOfBlockHeaderProjectionOfSelectorMarker.size)
            instance.vecOfBlockHeaderProjectionOfSelectorMarker.forEach { value ->
                BlockHeaderProjectionOfSelectorMarker.write(writer, value)
            }
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
