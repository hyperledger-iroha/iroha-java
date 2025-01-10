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
 * CanUnregisterAccount
 *
 * Generated from 'CanUnregisterAccount' regular structure
 */
public data class CanUnregisterAccount(
    public val account: AccountId,
) {
    public companion object : ScaleReader<CanUnregisterAccount>, ScaleWriter<CanUnregisterAccount> {
        override fun read(reader: ScaleCodecReader): CanUnregisterAccount = try {
            CanUnregisterAccount(
                AccountId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanUnregisterAccount): Unit = try {
            AccountId.write(writer, instance.account)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
