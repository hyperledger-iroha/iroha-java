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
 * CanMintUserTrigger
 *
 * Generated from 'CanMintUserTrigger' regular structure
 */
public data class CanMintUserTrigger(
    public val trigger: TriggerId,
) {
    public companion object : ScaleReader<CanMintUserTrigger>, ScaleWriter<CanMintUserTrigger> {
        override fun read(reader: ScaleCodecReader): CanMintUserTrigger = try {
            CanMintUserTrigger(
                TriggerId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanMintUserTrigger): Unit = try {
            TriggerId.write(writer, instance.trigger)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
