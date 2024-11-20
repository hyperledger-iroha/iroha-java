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
 * TriggerCompletedEvent
 *
 * Generated from 'TriggerCompletedEvent' regular structure
 */
public data class TriggerCompletedEvent(public val triggerId: TriggerId, public val outcome: TriggerCompletedOutcome) {
    public companion object : ScaleReader<TriggerCompletedEvent>, ScaleWriter<TriggerCompletedEvent> {
        override fun read(reader: ScaleCodecReader): TriggerCompletedEvent = try {
            TriggerCompletedEvent(
                TriggerId.read(reader),
                TriggerCompletedOutcome.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: TriggerCompletedEvent): Unit = try {
            TriggerId.write(writer, instance.triggerId)
            TriggerCompletedOutcome.write(writer, instance.outcome)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
