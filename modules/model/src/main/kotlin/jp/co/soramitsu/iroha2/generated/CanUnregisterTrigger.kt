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
 * CanUnregisterTrigger
 *
 * Generated from 'CanUnregisterTrigger' regular structure
 */
public data class CanUnregisterTrigger(public val trigger: TriggerId) : ModelPermission {
    public companion object : ScaleReader<CanUnregisterTrigger>, ScaleWriter<CanUnregisterTrigger> {
        override fun read(reader: ScaleCodecReader): CanUnregisterTrigger = try {
            CanUnregisterTrigger(
                TriggerId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanUnregisterTrigger): Unit = try {
            TriggerId.write(writer, instance.trigger)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
