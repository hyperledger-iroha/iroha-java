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
 * CanRemoveKeyValueInAccount
 *
 * Generated from 'CanRemoveKeyValueInAccount' regular structure
 */
public data class CanRemoveKeyValueInAccount(
    public val account: AccountId,
) {
    public companion object :
        ScaleReader<CanRemoveKeyValueInAccount>,
        ScaleWriter<CanRemoveKeyValueInAccount> {
        override fun read(reader: ScaleCodecReader): CanRemoveKeyValueInAccount = try {
            CanRemoveKeyValueInAccount(
                AccountId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanRemoveKeyValueInAccount): Unit = try {
            AccountId.write(writer, instance.account)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
