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
 * CanRegisterUserTrigger
 *
 * Generated from 'CanRegisterUserTrigger' regular structure
 */
public data class CanRegisterUserTrigger(
    public val account: AccountId,
) {
    public companion object : ScaleReader<CanRegisterUserTrigger>, ScaleWriter<CanRegisterUserTrigger> {
        override fun read(reader: ScaleCodecReader): CanRegisterUserTrigger = try {
            CanRegisterUserTrigger(
                AccountId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanRegisterUserTrigger): Unit = try {
            AccountId.write(writer, instance.account)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
