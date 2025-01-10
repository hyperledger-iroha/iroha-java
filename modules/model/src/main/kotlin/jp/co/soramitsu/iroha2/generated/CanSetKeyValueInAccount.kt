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
 * CanSetKeyValueInAccount
 *
 * Generated from 'CanSetKeyValueInAccount' regular structure
 */
public data class CanSetKeyValueInAccount(
    public val account: AccountId,
) {
    public companion object :
        ScaleReader<CanSetKeyValueInAccount>,
        ScaleWriter<CanSetKeyValueInAccount> {
        override fun read(reader: ScaleCodecReader): CanSetKeyValueInAccount = try {
            CanSetKeyValueInAccount(
                AccountId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanSetKeyValueInAccount): Unit = try {
            AccountId.write(writer, instance.account)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
