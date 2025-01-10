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
 * CanExecuteUserTrigger
 *
 * Generated from 'CanExecuteUserTrigger' regular structure
 */
public data class CanExecuteUserTrigger(
    public val trigger: TriggerId,
) {
    public companion object : ScaleReader<CanExecuteUserTrigger>, ScaleWriter<CanExecuteUserTrigger> {
        override fun read(reader: ScaleCodecReader): CanExecuteUserTrigger = try {
            CanExecuteUserTrigger(
                TriggerId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanExecuteUserTrigger): Unit = try {
            TriggerId.write(writer, instance.trigger)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
