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
 * CanRegisterTrigger
 *
 * Generated from 'CanRegisterTrigger' regular structure
 */
public data class CanRegisterTrigger(
    public val authority: AccountId,
) {
    public companion object : ScaleReader<CanRegisterTrigger>, ScaleWriter<CanRegisterTrigger> {
        override fun read(reader: ScaleCodecReader): CanRegisterTrigger = try {
            CanRegisterTrigger(
                AccountId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanRegisterTrigger): Unit = try {
            AccountId.write(writer, instance.authority)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
