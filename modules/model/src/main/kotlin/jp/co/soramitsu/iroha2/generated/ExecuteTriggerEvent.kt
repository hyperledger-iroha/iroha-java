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
 * ExecuteTriggerEvent
 *
 * Generated from 'ExecuteTriggerEvent' regular structure
 */
public data class ExecuteTriggerEvent(
    public val triggerId: TriggerId,
    public val authority: AccountId,
    public val args: Json,
) {
    public companion object : ScaleReader<ExecuteTriggerEvent>, ScaleWriter<ExecuteTriggerEvent> {
        override fun read(reader: ScaleCodecReader): ExecuteTriggerEvent =
            try {
                ExecuteTriggerEvent(
                    TriggerId.read(reader),
                    AccountId.read(reader),
                    Json.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: ExecuteTriggerEvent,
        ): Unit =
            try {
                TriggerId.write(writer, instance.triggerId)
                AccountId.write(writer, instance.authority)
                Json.write(writer, instance.args)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
