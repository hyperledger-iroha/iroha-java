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
 * RoleEvent
 *
 * Generated from 'RoleEvent' enum
 */
public sealed class RoleEvent : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Created' variant
     */
    public data class Created(
        public val role: Role,
    ) : RoleEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.RoleEvent.Created>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.RoleEvent.Created> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.RoleEvent.Created = try {
                Created(
                    Role.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.RoleEvent.Created,
            ): Unit = try {
                Role.write(writer, instance.role)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Deleted' variant
     */
    public data class Deleted(
        public val roleId: RoleId,
    ) : RoleEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.RoleEvent.Deleted>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.RoleEvent.Deleted> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.RoleEvent.Deleted = try {
                Deleted(
                    RoleId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.RoleEvent.Deleted,
            ): Unit = try {
                RoleId.write(writer, instance.roleId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'PermissionAdded' variant
     */
    public data class PermissionAdded(
        public val rolePermissionChanged: RolePermissionChanged,
    ) : RoleEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.RoleEvent.PermissionAdded>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.RoleEvent.PermissionAdded> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.RoleEvent.PermissionAdded = try {
                PermissionAdded(
                    RolePermissionChanged.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.RoleEvent.PermissionAdded,
            ): Unit = try {
                RolePermissionChanged.write(writer, instance.rolePermissionChanged)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'PermissionRemoved' variant
     */
    public data class PermissionRemoved(
        public val rolePermissionChanged: RolePermissionChanged,
    ) : RoleEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.RoleEvent.PermissionRemoved>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.RoleEvent.PermissionRemoved> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.RoleEvent.PermissionRemoved = try {
                PermissionRemoved(
                    RolePermissionChanged.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.RoleEvent.PermissionRemoved,
            ): Unit = try {
                RolePermissionChanged.write(writer, instance.rolePermissionChanged)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<RoleEvent>, ScaleWriter<RoleEvent> {
        override fun read(reader: ScaleCodecReader): RoleEvent = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Created.read(reader)
            1 -> Deleted.read(reader)
            2 -> PermissionAdded.read(reader)
            3 -> PermissionRemoved.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: RoleEvent) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Created.write(writer, instance as Created)
                1 -> Deleted.write(writer, instance as Deleted)
                2 -> PermissionAdded.write(writer, instance as PermissionAdded)
                3 -> PermissionRemoved.write(writer, instance as PermissionRemoved)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
