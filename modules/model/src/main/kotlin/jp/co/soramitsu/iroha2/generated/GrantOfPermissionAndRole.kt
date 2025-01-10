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
 * GrantOfPermissionAndRole
 *
 * Generated from 'GrantOfPermissionAndRole' regular structure
 */
public data class GrantOfPermissionAndRole(
    public val `object`: Permission,
    public val destination: RoleId,
) {
    public companion object :
        ScaleReader<GrantOfPermissionAndRole>,
        ScaleWriter<GrantOfPermissionAndRole> {
        override fun read(reader: ScaleCodecReader): GrantOfPermissionAndRole = try {
            GrantOfPermissionAndRole(
                Permission.read(reader),
                RoleId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: GrantOfPermissionAndRole): Unit = try {
            Permission.write(writer, instance.`object`)
            RoleId.write(writer, instance.destination)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
