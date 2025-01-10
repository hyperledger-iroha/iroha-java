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
 * CanRemoveKeyValueInTrigger
 *
 * Generated from 'CanRemoveKeyValueInTrigger' regular structure
 */
public data class CanRemoveKeyValueInTrigger(
    public val trigger: TriggerId,
) {
    public companion object :
        ScaleReader<CanRemoveKeyValueInTrigger>,
        ScaleWriter<CanRemoveKeyValueInTrigger> {
        override fun read(reader: ScaleCodecReader): CanRemoveKeyValueInTrigger = try {
            CanRemoveKeyValueInTrigger(
                TriggerId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanRemoveKeyValueInTrigger): Unit = try {
            TriggerId.write(writer, instance.trigger)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
