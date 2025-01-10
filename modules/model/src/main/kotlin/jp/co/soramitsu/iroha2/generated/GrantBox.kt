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
 * GrantBox
 *
 * Generated from 'GrantBox' enum
 */
public sealed class GrantBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Permission' variant
     */
    public data class Permission(
        public val grantOfPermissionAndAccount: GrantOfPermissionAndAccount,
    ) : GrantBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.GrantBox.Permission>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.GrantBox.Permission> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.GrantBox.Permission = try {
                Permission(
                    GrantOfPermissionAndAccount.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.GrantBox.Permission,
            ): Unit = try {
                GrantOfPermissionAndAccount.write(writer, instance.grantOfPermissionAndAccount)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Role' variant
     */
    public data class Role(
        public val grantOfRoleIdAndAccount: GrantOfRoleIdAndAccount,
    ) : GrantBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.GrantBox.Role>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.GrantBox.Role> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.GrantBox.Role =
                try {
                    Role(
                        GrantOfRoleIdAndAccount.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.GrantBox.Role,
            ): Unit = try {
                GrantOfRoleIdAndAccount.write(writer, instance.grantOfRoleIdAndAccount)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'RolePermission' variant
     */
    public data class RolePermission(
        public val grantOfPermissionAndRole: GrantOfPermissionAndRole,
    ) : GrantBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.GrantBox.RolePermission>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.GrantBox.RolePermission> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.GrantBox.RolePermission = try {
                RolePermission(
                    GrantOfPermissionAndRole.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.GrantBox.RolePermission,
            ): Unit = try {
                GrantOfPermissionAndRole.write(writer, instance.grantOfPermissionAndRole)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<GrantBox>, ScaleWriter<GrantBox> {
        override fun read(reader: ScaleCodecReader): GrantBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Permission.read(reader)
            1 -> Role.read(reader)
            2 -> RolePermission.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: GrantBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Permission.write(writer, instance as Permission)
                1 -> Role.write(writer, instance as Role)
                2 -> RolePermission.write(writer, instance as RolePermission)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
