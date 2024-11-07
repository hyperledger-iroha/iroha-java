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
 * CanExecuteTrigger
 *
 * Generated from 'CanExecuteTrigger' regular structure
 */
public data class CanExecuteTrigger(
    public val trigger: TriggerId,
) {
    public companion object : ScaleReader<CanExecuteTrigger>, ScaleWriter<CanExecuteTrigger> {
        override fun read(reader: ScaleCodecReader): CanExecuteTrigger = try {
            CanExecuteTrigger(
                TriggerId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanExecuteTrigger): Unit = try {
            TriggerId.write(writer, instance.trigger)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
