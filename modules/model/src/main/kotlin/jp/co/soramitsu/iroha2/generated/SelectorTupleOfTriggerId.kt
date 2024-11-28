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
 * SelectorTupleOfTriggerId
 *
 * Generated from 'SelectorTupleOfTriggerId' regular structure
 */
public data class SelectorTupleOfTriggerId(
    public val vecOfTriggerIdProjectionOfSelectorMarker: List<TriggerIdProjectionOfSelectorMarker>,
) {
    public companion object :
        ScaleReader<SelectorTupleOfTriggerId>,
        ScaleWriter<SelectorTupleOfTriggerId> {
        override fun read(reader: ScaleCodecReader): SelectorTupleOfTriggerId = try {
            SelectorTupleOfTriggerId(
                reader.readVec(reader.readCompactInt()) { TriggerIdProjectionOfSelectorMarker.read(reader) },
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: SelectorTupleOfTriggerId): Unit = try {
            writer.writeCompact(instance.vecOfTriggerIdProjectionOfSelectorMarker.size)
            instance.vecOfTriggerIdProjectionOfSelectorMarker.forEach { value ->
                TriggerIdProjectionOfSelectorMarker.write(writer, value)
            }
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
