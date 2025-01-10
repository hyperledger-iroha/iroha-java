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
 * EventMessage
 *
 * Generated from 'EventMessage' regular structure
 */
public data class EventMessage(
    public val eventBox: EventBox,
) {
    public companion object : ScaleReader<EventMessage>, ScaleWriter<EventMessage> {
        override fun read(reader: ScaleCodecReader): EventMessage = try {
            EventMessage(
                EventBox.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: EventMessage): Unit = try {
            EventBox.write(writer, instance.eventBox)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
