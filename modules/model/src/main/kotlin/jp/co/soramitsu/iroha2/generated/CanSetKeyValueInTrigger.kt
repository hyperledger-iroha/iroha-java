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
 * CanSetKeyValueInTrigger
 *
 * Generated from 'CanSetKeyValueInTrigger' regular structure
 */
public data class CanSetKeyValueInTrigger(
    public val trigger: TriggerId,
) {
    public companion object :
        ScaleReader<CanSetKeyValueInTrigger>,
        ScaleWriter<CanSetKeyValueInTrigger> {
        override fun read(reader: ScaleCodecReader): CanSetKeyValueInTrigger = try {
            CanSetKeyValueInTrigger(
                TriggerId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanSetKeyValueInTrigger): Unit = try {
            TriggerId.write(writer, instance.trigger)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
