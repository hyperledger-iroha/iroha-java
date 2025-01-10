//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Long
import kotlin.Unit

/**
 * TriggerEventFilter
 *
 * Generated from 'TriggerEventFilter' regular structure
 */
public data class TriggerEventFilter(
    public val idMatcher: TriggerId? = null,
    public val eventSet: Long,
) {
    public companion object : ScaleReader<TriggerEventFilter>, ScaleWriter<TriggerEventFilter> {
        override fun read(reader: ScaleCodecReader): TriggerEventFilter = try {
            TriggerEventFilter(
                reader.readNullable(TriggerId) as TriggerId?,
                reader.readUint32(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: TriggerEventFilter): Unit = try {
            writer.writeNullable(TriggerId, instance.idMatcher)
            writer.writeUint32(instance.eventSet)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
