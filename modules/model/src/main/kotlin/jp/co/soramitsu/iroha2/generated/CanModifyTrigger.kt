//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.ModelPermission
import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Unit

/**
 * CanModifyTrigger
 *
 * Generated from 'CanModifyTrigger' regular structure
 */
public data class CanModifyTrigger(
    public val trigger: TriggerId,
) : ModelPermission {
    public companion object : ScaleReader<CanModifyTrigger>, ScaleWriter<CanModifyTrigger> {
        override fun read(reader: ScaleCodecReader): CanModifyTrigger = try {
            CanModifyTrigger(
                TriggerId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanModifyTrigger): Unit = try {
            TriggerId.write(writer, instance.trigger)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
