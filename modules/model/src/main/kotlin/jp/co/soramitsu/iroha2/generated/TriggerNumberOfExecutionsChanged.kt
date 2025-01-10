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
 * TriggerNumberOfExecutionsChanged
 *
 * Generated from 'TriggerNumberOfExecutionsChanged' regular structure
 */
public data class TriggerNumberOfExecutionsChanged(
    public val trigger: TriggerId,
    public val `by`: Long,
) {
    public companion object :
        ScaleReader<TriggerNumberOfExecutionsChanged>,
        ScaleWriter<TriggerNumberOfExecutionsChanged> {
        override fun read(reader: ScaleCodecReader): TriggerNumberOfExecutionsChanged = try {
            TriggerNumberOfExecutionsChanged(
                TriggerId.read(reader),
                reader.readUint32(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: TriggerNumberOfExecutionsChanged): Unit =
            try {
                TriggerId.write(writer, instance.trigger)
                writer.writeUint32(instance.`by`)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
