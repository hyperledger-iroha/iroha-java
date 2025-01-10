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
 * RevokeOfPermissionAndAccount
 *
 * Generated from 'RevokeOfPermissionAndAccount' regular structure
 */
public data class RevokeOfPermissionAndAccount(
    public val `object`: Permission,
    public val destination: AccountId,
) {
    public companion object :
        ScaleReader<RevokeOfPermissionAndAccount>,
        ScaleWriter<RevokeOfPermissionAndAccount> {
        override fun read(reader: ScaleCodecReader): RevokeOfPermissionAndAccount = try {
            RevokeOfPermissionAndAccount(
                Permission.read(reader),
                AccountId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: RevokeOfPermissionAndAccount): Unit = try {
            Permission.write(writer, instance.`object`)
            AccountId.write(writer, instance.destination)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
