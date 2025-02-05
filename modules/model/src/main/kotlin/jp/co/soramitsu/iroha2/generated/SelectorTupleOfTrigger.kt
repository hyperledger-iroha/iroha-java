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
 * SelectorTupleOfTrigger
 *
 * Generated from 'SelectorTupleOfTrigger' regular structure
 */
public data class SelectorTupleOfTrigger(
    public val vecOfTriggerProjectionOfSelectorMarker: List<TriggerProjectionOfSelectorMarker>,
) {
    public companion object :
        ScaleReader<SelectorTupleOfTrigger>,
        ScaleWriter<SelectorTupleOfTrigger> {
        override fun read(reader: ScaleCodecReader): SelectorTupleOfTrigger =
            try {
                SelectorTupleOfTrigger(
                    reader.readVec(reader.readCompactInt()) { TriggerProjectionOfSelectorMarker.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: SelectorTupleOfTrigger,
        ): Unit =
            try {
                writer.writeCompact(instance.vecOfTriggerProjectionOfSelectorMarker.size)
                instance.vecOfTriggerProjectionOfSelectorMarker.forEach { value ->
                    TriggerProjectionOfSelectorMarker.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
