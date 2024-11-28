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
 * SelectorTupleOfSignedBlock
 *
 * Generated from 'SelectorTupleOfSignedBlock' regular structure
 */
public data class SelectorTupleOfSignedBlock(
    public val vecOfSignedBlockProjectionOfSelectorMarker: List<SignedBlockProjectionOfSelectorMarker>,
) {
    public companion object :
        ScaleReader<SelectorTupleOfSignedBlock>,
        ScaleWriter<SelectorTupleOfSignedBlock> {
        override fun read(reader: ScaleCodecReader): SelectorTupleOfSignedBlock = try {
            SelectorTupleOfSignedBlock(
                reader.readVec(reader.readCompactInt()) { SignedBlockProjectionOfSelectorMarker.read(reader) },
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: SelectorTupleOfSignedBlock): Unit = try {
            writer.writeCompact(instance.vecOfSignedBlockProjectionOfSelectorMarker.size)
            instance.vecOfSignedBlockProjectionOfSelectorMarker.forEach { value ->
                SignedBlockProjectionOfSelectorMarker.write(writer, value)
            }
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
