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
 * AccountRoleChanged
 *
 * Generated from 'AccountRoleChanged' regular structure
 */
public data class AccountRoleChanged(
    public val account: AccountId,
    public val role: RoleId,
) {
    public companion object : ScaleReader<AccountRoleChanged>, ScaleWriter<AccountRoleChanged> {
        override fun read(reader: ScaleCodecReader): AccountRoleChanged = try {
            AccountRoleChanged(
                AccountId.read(reader),
                RoleId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: AccountRoleChanged): Unit = try {
            AccountId.write(writer, instance.account)
            RoleId.write(writer, instance.role)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
