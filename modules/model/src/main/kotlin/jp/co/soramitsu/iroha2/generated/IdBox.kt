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
 * IdBox
 *
 * Generated from 'IdBox' enum
 */
public sealed class IdBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'DomainId' variant
     */
    public data class DomainId(
        public val domainId: jp.co.soramitsu.iroha2.generated.DomainId,
    ) : IdBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.IdBox.DomainId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.IdBox.DomainId> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.IdBox.DomainId =
                try {
                    DomainId(
                        jp.co.soramitsu.iroha2.generated.DomainId.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.IdBox.DomainId,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.DomainId.write(writer, instance.domainId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'AccountId' variant
     */
    public data class AccountId(
        public val accountId: jp.co.soramitsu.iroha2.generated.AccountId,
    ) : IdBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.IdBox.AccountId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.IdBox.AccountId> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.IdBox.AccountId = try {
                AccountId(
                    jp.co.soramitsu.iroha2.generated.AccountId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.IdBox.AccountId,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.AccountId.write(writer, instance.accountId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'AssetDefinitionId' variant
     */
    public data class AssetDefinitionId(
        public val assetDefinitionId: jp.co.soramitsu.iroha2.generated.AssetDefinitionId,
    ) : IdBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.IdBox.AssetDefinitionId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.IdBox.AssetDefinitionId> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.IdBox.AssetDefinitionId = try {
                AssetDefinitionId(
                    jp.co.soramitsu.iroha2.generated.AssetDefinitionId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.IdBox.AssetDefinitionId,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.AssetDefinitionId.write(writer, instance.assetDefinitionId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'AssetId' variant
     */
    public data class AssetId(
        public val assetId: jp.co.soramitsu.iroha2.generated.AssetId,
    ) : IdBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.IdBox.AssetId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.IdBox.AssetId> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.IdBox.AssetId =
                try {
                    AssetId(
                        jp.co.soramitsu.iroha2.generated.AssetId.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.IdBox.AssetId,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.AssetId.write(writer, instance.assetId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'PeerId' variant
     */
    public data class PeerId(
        public val peerId: jp.co.soramitsu.iroha2.generated.PeerId,
    ) : IdBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.IdBox.PeerId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.IdBox.PeerId> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.IdBox.PeerId =
                try {
                    PeerId(
                        jp.co.soramitsu.iroha2.generated.PeerId.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.IdBox.PeerId,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.PeerId.write(writer, instance.peerId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'TriggerId' variant
     */
    public data class TriggerId(
        public val triggerId: jp.co.soramitsu.iroha2.generated.TriggerId,
    ) : IdBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.IdBox.TriggerId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.IdBox.TriggerId> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.IdBox.TriggerId = try {
                TriggerId(
                    jp.co.soramitsu.iroha2.generated.TriggerId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.IdBox.TriggerId,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.TriggerId.write(writer, instance.triggerId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'RoleId' variant
     */
    public data class RoleId(
        public val roleId: jp.co.soramitsu.iroha2.generated.RoleId,
    ) : IdBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.IdBox.RoleId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.IdBox.RoleId> {
            public const val DISCRIMINANT: Int = 6

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.IdBox.RoleId =
                try {
                    RoleId(
                        jp.co.soramitsu.iroha2.generated.RoleId.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.IdBox.RoleId,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.RoleId.write(writer, instance.roleId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Permission' variant
     */
    public data class Permission(
        public val permission: jp.co.soramitsu.iroha2.generated.Permission,
    ) : IdBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.IdBox.Permission>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.IdBox.Permission> {
            public const val DISCRIMINANT: Int = 7

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.IdBox.Permission = try {
                Permission(
                    jp.co.soramitsu.iroha2.generated.Permission.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.IdBox.Permission,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.Permission.write(writer, instance.permission)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'CustomParameterId' variant
     */
    public data class CustomParameterId(
        public val customParameterId: jp.co.soramitsu.iroha2.generated.CustomParameterId,
    ) : IdBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.IdBox.CustomParameterId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.IdBox.CustomParameterId> {
            public const val DISCRIMINANT: Int = 8

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.IdBox.CustomParameterId = try {
                CustomParameterId(
                    jp.co.soramitsu.iroha2.generated.CustomParameterId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.IdBox.CustomParameterId,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.CustomParameterId.write(writer, instance.customParameterId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<IdBox>, ScaleWriter<IdBox> {
        override fun read(reader: ScaleCodecReader): IdBox = when (val discriminant = reader.readUByte()) {
            0 -> DomainId.read(reader)
            1 -> AccountId.read(reader)
            2 -> AssetDefinitionId.read(reader)
            3 -> AssetId.read(reader)
            4 -> PeerId.read(reader)
            5 -> TriggerId.read(reader)
            6 -> RoleId.read(reader)
            7 -> Permission.read(reader)
            8 -> CustomParameterId.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: IdBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> DomainId.write(writer, instance as DomainId)
                1 -> AccountId.write(writer, instance as AccountId)
                2 -> AssetDefinitionId.write(writer, instance as AssetDefinitionId)
                3 -> AssetId.write(writer, instance as AssetId)
                4 -> PeerId.write(writer, instance as PeerId)
                5 -> TriggerId.write(writer, instance as TriggerId)
                6 -> RoleId.write(writer, instance as RoleId)
                7 -> Permission.write(writer, instance as Permission)
                8 -> CustomParameterId.write(writer, instance as CustomParameterId)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
