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
 * CanBurnUserTrigger
 *
 * Generated from 'CanBurnUserTrigger' regular structure
 */
public data class CanBurnUserTrigger(
    public val trigger: TriggerId,
) {
    public companion object : ScaleReader<CanBurnUserTrigger>, ScaleWriter<CanBurnUserTrigger> {
        override fun read(reader: ScaleCodecReader): CanBurnUserTrigger = try {
            CanBurnUserTrigger(
                TriggerId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanBurnUserTrigger): Unit = try {
            TriggerId.write(writer, instance.trigger)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
