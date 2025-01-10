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
 * GrantOfRoleIdAndAccount
 *
 * Generated from 'GrantOfRoleIdAndAccount' regular structure
 */
public data class GrantOfRoleIdAndAccount(
    public val `object`: RoleId,
    public val destination: AccountId,
) {
    public companion object :
        ScaleReader<GrantOfRoleIdAndAccount>,
        ScaleWriter<GrantOfRoleIdAndAccount> {
        override fun read(reader: ScaleCodecReader): GrantOfRoleIdAndAccount = try {
            GrantOfRoleIdAndAccount(
                RoleId.read(reader),
                AccountId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: GrantOfRoleIdAndAccount): Unit = try {
            RoleId.write(writer, instance.`object`)
            AccountId.write(writer, instance.destination)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
