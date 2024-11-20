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
 * CanModifyTriggerMetadata
 *
 * Generated from 'CanModifyTriggerMetadata' regular structure
 */
public data class CanModifyTriggerMetadata(
    public val trigger: TriggerId,
) : ModelPermission {
    public companion object :
        ScaleReader<CanModifyTriggerMetadata>,
        ScaleWriter<CanModifyTriggerMetadata> {
        override fun read(reader: ScaleCodecReader): CanModifyTriggerMetadata = try {
            CanModifyTriggerMetadata(
                TriggerId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanModifyTriggerMetadata): Unit = try {
            TriggerId.write(writer, instance.trigger)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
