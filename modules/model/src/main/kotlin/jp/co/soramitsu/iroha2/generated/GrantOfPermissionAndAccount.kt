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
 * GrantOfPermissionAndAccount
 *
 * Generated from 'GrantOfPermissionAndAccount' regular structure
 */
public data class GrantOfPermissionAndAccount(
    public val `object`: Permission,
    public val destination: AccountId,
) {
    public companion object :
        ScaleReader<GrantOfPermissionAndAccount>,
        ScaleWriter<GrantOfPermissionAndAccount> {
        override fun read(reader: ScaleCodecReader): GrantOfPermissionAndAccount = try {
            GrantOfPermissionAndAccount(
                Permission.read(reader),
                AccountId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: GrantOfPermissionAndAccount): Unit = try {
            Permission.write(writer, instance.`object`)
            AccountId.write(writer, instance.destination)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
