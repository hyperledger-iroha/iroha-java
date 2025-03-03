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
 * TriggerCompletedEventFilter
 *
 * Generated from 'TriggerCompletedEventFilter' regular structure
 */
public data class TriggerCompletedEventFilter(
    public val triggerId: TriggerId? = null,
    public val outcomeType: TriggerCompletedOutcomeType? = null,
) {
    public companion object :
        ScaleReader<TriggerCompletedEventFilter>,
        ScaleWriter<TriggerCompletedEventFilter> {
        override fun read(reader: ScaleCodecReader): TriggerCompletedEventFilter =
            try {
                TriggerCompletedEventFilter(
                    reader.readNullable(TriggerId) as TriggerId?,
                    reader.readNullable(TriggerCompletedOutcomeType) as TriggerCompletedOutcomeType?,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: TriggerCompletedEventFilter,
        ): Unit =
            try {
                writer.writeNullable(TriggerId, instance.triggerId)
                writer.writeNullable(TriggerCompletedOutcomeType, instance.outcomeType)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
