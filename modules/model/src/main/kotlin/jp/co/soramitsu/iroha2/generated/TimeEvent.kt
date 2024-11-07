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
 * TimeEvent
 *
 * Generated from 'TimeEvent' regular structure
 */
public data class TimeEvent(
    public val interval: TimeInterval,
) {
    public companion object : ScaleReader<TimeEvent>, ScaleWriter<TimeEvent> {
        override fun read(reader: ScaleCodecReader): TimeEvent = try {
            TimeEvent(
                TimeInterval.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: TimeEvent): Unit = try {
            TimeInterval.write(writer, instance.interval)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
