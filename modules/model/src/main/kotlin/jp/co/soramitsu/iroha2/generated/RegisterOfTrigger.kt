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
 * RegisterOfTrigger
 *
 * Generated from 'RegisterOfTrigger' regular structure
 */
public data class RegisterOfTrigger(
    public val `object`: Trigger,
) {
    public companion object : ScaleReader<RegisterOfTrigger>, ScaleWriter<RegisterOfTrigger> {
        override fun read(reader: ScaleCodecReader): RegisterOfTrigger = try {
            RegisterOfTrigger(
                Trigger.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: RegisterOfTrigger): Unit = try {
            Trigger.write(writer, instance.`object`)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
