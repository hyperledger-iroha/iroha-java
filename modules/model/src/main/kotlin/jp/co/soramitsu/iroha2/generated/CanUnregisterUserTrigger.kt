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
 * CanUnregisterUserTrigger
 *
 * Generated from 'CanUnregisterUserTrigger' regular structure
 */
public data class CanUnregisterUserTrigger(
    public val account: AccountId,
) {
    public companion object :
        ScaleReader<CanUnregisterUserTrigger>,
        ScaleWriter<CanUnregisterUserTrigger> {
        override fun read(reader: ScaleCodecReader): CanUnregisterUserTrigger = try {
            CanUnregisterUserTrigger(
                AccountId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanUnregisterUserTrigger): Unit = try {
            AccountId.write(writer, instance.account)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
