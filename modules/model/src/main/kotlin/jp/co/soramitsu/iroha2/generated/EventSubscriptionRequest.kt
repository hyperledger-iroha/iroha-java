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
 * EventSubscriptionRequest
 *
 * Generated from 'EventSubscriptionRequest' regular structure
 */
public data class EventSubscriptionRequest(
    public val vecOfEventFilterBox: List<EventFilterBox>,
) {
    public companion object :
        ScaleReader<EventSubscriptionRequest>,
        ScaleWriter<EventSubscriptionRequest> {
        override fun read(reader: ScaleCodecReader): EventSubscriptionRequest = try {
            EventSubscriptionRequest(
                reader.readVec(reader.readCompactInt()) { EventFilterBox.read(reader) },
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: EventSubscriptionRequest): Unit = try {
            writer.writeCompact(instance.vecOfEventFilterBox.size)
            instance.vecOfEventFilterBox.forEach { value ->
                EventFilterBox.write(writer, value)
            }
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
