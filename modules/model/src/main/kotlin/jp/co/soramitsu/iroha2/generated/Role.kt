//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.comparator
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Unit
import kotlin.collections.List

/**
 * Role
 *
 * Generated from 'Role' regular structure
 */
public data class Role(
    public val id: RoleId,
    public val permissions: List<Permission>,
) {
    public companion object : ScaleReader<Role>, ScaleWriter<Role> {
        override fun read(reader: ScaleCodecReader): Role = try {
            Role(
                RoleId.read(reader),
                reader.readVec(reader.readCompactInt()) { Permission.read(reader) },
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: Role): Unit = try {
            RoleId.write(writer, instance.id)
            writer.writeCompact(instance.permissions.size)
            instance.permissions.sortedWith(
                Permission.comparator(),
            ).forEach { value ->
                Permission.write(writer, value)
            }
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
