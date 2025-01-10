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
 * Trigger
 *
 * Generated from 'Trigger' regular structure
 */
public data class Trigger(
    public val id: TriggerId,
    public val action: Action,
) {
    public companion object : ScaleReader<Trigger>, ScaleWriter<Trigger> {
        override fun read(reader: ScaleCodecReader): Trigger = try {
            Trigger(
                TriggerId.read(reader),
                Action.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: Trigger): Unit = try {
            TriggerId.write(writer, instance.id)
            Action.write(writer, instance.action)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
