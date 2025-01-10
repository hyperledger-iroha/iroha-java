//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.ModelEnum
import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Int
import kotlin.Unit

/**
 * RevokeBox
 *
 * Generated from 'RevokeBox' enum
 */
public sealed class RevokeBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Permission' variant
     */
    public data class Permission(
        public val revokeOfPermissionAndAccount: RevokeOfPermissionAndAccount,
    ) : RevokeBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.RevokeBox.Permission>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.RevokeBox.Permission> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.RevokeBox.Permission = try {
                Permission(
                    RevokeOfPermissionAndAccount.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.RevokeBox.Permission,
            ): Unit = try {
                RevokeOfPermissionAndAccount.write(writer, instance.revokeOfPermissionAndAccount)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Role' variant
     */
    public data class Role(
        public val revokeOfRoleIdAndAccount: RevokeOfRoleIdAndAccount,
    ) : RevokeBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.RevokeBox.Role>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.RevokeBox.Role> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.RevokeBox.Role =
                try {
                    Role(
                        RevokeOfRoleIdAndAccount.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.RevokeBox.Role,
            ): Unit = try {
                RevokeOfRoleIdAndAccount.write(writer, instance.revokeOfRoleIdAndAccount)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'RolePermission' variant
     */
    public data class RolePermission(
        public val revokeOfPermissionAndRole: RevokeOfPermissionAndRole,
    ) : RevokeBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.RevokeBox.RolePermission>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.RevokeBox.RolePermission> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.RevokeBox.RolePermission = try {
                RolePermission(
                    RevokeOfPermissionAndRole.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.RevokeBox.RolePermission,
            ): Unit = try {
                RevokeOfPermissionAndRole.write(writer, instance.revokeOfPermissionAndRole)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<RevokeBox>, ScaleWriter<RevokeBox> {
        override fun read(reader: ScaleCodecReader): RevokeBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Permission.read(reader)
            1 -> Role.read(reader)
            2 -> RolePermission.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: RevokeBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Permission.write(writer, instance as Permission)
                1 -> Role.write(writer, instance as Role)
                2 -> RolePermission.write(writer, instance as RolePermission)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
