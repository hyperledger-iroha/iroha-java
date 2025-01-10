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
 * IdentifiableBox
 *
 * Generated from 'IdentifiableBox' enum
 */
public sealed class IdentifiableBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'NewDomain' variant
     */
    public data class NewDomain(
        public val newDomain: jp.co.soramitsu.iroha2.generated.NewDomain,
    ) : IdentifiableBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.IdentifiableBox.NewDomain>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.IdentifiableBox.NewDomain> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.IdentifiableBox.NewDomain = try {
                NewDomain(
                    jp.co.soramitsu.iroha2.generated.NewDomain.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.IdentifiableBox.NewDomain,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.NewDomain.write(writer, instance.newDomain)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'NewAccount' variant
     */
    public data class NewAccount(
        public val newAccount: jp.co.soramitsu.iroha2.generated.NewAccount,
    ) : IdentifiableBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.IdentifiableBox.NewAccount>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.IdentifiableBox.NewAccount> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.IdentifiableBox.NewAccount = try {
                NewAccount(
                    jp.co.soramitsu.iroha2.generated.NewAccount.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.IdentifiableBox.NewAccount,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.NewAccount.write(writer, instance.newAccount)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'NewAssetDefinition' variant
     */
    public data class NewAssetDefinition(
        public val newAssetDefinition: jp.co.soramitsu.iroha2.generated.NewAssetDefinition,
    ) : IdentifiableBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.IdentifiableBox.NewAssetDefinition>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.IdentifiableBox.NewAssetDefinition> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.IdentifiableBox.NewAssetDefinition = try {
                NewAssetDefinition(
                    jp.co.soramitsu.iroha2.generated.NewAssetDefinition.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.IdentifiableBox.NewAssetDefinition,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.NewAssetDefinition.write(
                    writer,
                    instance.newAssetDefinition,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'NewRole' variant
     */
    public data class NewRole(
        public val role: jp.co.soramitsu.iroha2.generated.Role,
    ) : IdentifiableBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.IdentifiableBox.NewRole>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.IdentifiableBox.NewRole> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.IdentifiableBox.NewRole = try {
                NewRole(
                    jp.co.soramitsu.iroha2.generated.Role.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.IdentifiableBox.NewRole,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.Role.write(writer, instance.role)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Peer' variant
     */
    public data class Peer(
        public val peer: jp.co.soramitsu.iroha2.generated.Peer,
    ) : IdentifiableBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.IdentifiableBox.Peer>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.IdentifiableBox.Peer> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.IdentifiableBox.Peer = try {
                Peer(
                    jp.co.soramitsu.iroha2.generated.Peer.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.IdentifiableBox.Peer,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.Peer.write(writer, instance.peer)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Domain' variant
     */
    public data class Domain(
        public val domain: jp.co.soramitsu.iroha2.generated.Domain,
    ) : IdentifiableBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.IdentifiableBox.Domain>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.IdentifiableBox.Domain> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.IdentifiableBox.Domain = try {
                Domain(
                    jp.co.soramitsu.iroha2.generated.Domain.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.IdentifiableBox.Domain,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.Domain.write(writer, instance.domain)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Account' variant
     */
    public data class Account(
        public val account: jp.co.soramitsu.iroha2.generated.Account,
    ) : IdentifiableBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.IdentifiableBox.Account>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.IdentifiableBox.Account> {
            public const val DISCRIMINANT: Int = 6

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.IdentifiableBox.Account = try {
                Account(
                    jp.co.soramitsu.iroha2.generated.Account.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.IdentifiableBox.Account,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.Account.write(writer, instance.account)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'AssetDefinition' variant
     */
    public data class AssetDefinition(
        public val assetDefinition: jp.co.soramitsu.iroha2.generated.AssetDefinition,
    ) : IdentifiableBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.IdentifiableBox.AssetDefinition>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.IdentifiableBox.AssetDefinition> {
            public const val DISCRIMINANT: Int = 7

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.IdentifiableBox.AssetDefinition = try {
                AssetDefinition(
                    jp.co.soramitsu.iroha2.generated.AssetDefinition.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.IdentifiableBox.AssetDefinition,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.AssetDefinition.write(writer, instance.assetDefinition)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Asset' variant
     */
    public data class Asset(
        public val asset: jp.co.soramitsu.iroha2.generated.Asset,
    ) : IdentifiableBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.IdentifiableBox.Asset>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.IdentifiableBox.Asset> {
            public const val DISCRIMINANT: Int = 8

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.IdentifiableBox.Asset = try {
                Asset(
                    jp.co.soramitsu.iroha2.generated.Asset.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.IdentifiableBox.Asset,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.Asset.write(writer, instance.asset)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Trigger' variant
     */
    public data class Trigger(
        public val trigger: jp.co.soramitsu.iroha2.generated.Trigger,
    ) : IdentifiableBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.IdentifiableBox.Trigger>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.IdentifiableBox.Trigger> {
            public const val DISCRIMINANT: Int = 9

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.IdentifiableBox.Trigger = try {
                Trigger(
                    jp.co.soramitsu.iroha2.generated.Trigger.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.IdentifiableBox.Trigger,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.Trigger.write(writer, instance.trigger)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Role' variant
     */
    public data class Role(
        public val role: jp.co.soramitsu.iroha2.generated.Role,
    ) : IdentifiableBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.IdentifiableBox.Role>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.IdentifiableBox.Role> {
            public const val DISCRIMINANT: Int = 10

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.IdentifiableBox.Role = try {
                Role(
                    jp.co.soramitsu.iroha2.generated.Role.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.IdentifiableBox.Role,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.Role.write(writer, instance.role)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'CustomParameter' variant
     */
    public data class CustomParameter(
        public val customParameter: jp.co.soramitsu.iroha2.generated.CustomParameter,
    ) : IdentifiableBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.IdentifiableBox.CustomParameter>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.IdentifiableBox.CustomParameter> {
            public const val DISCRIMINANT: Int = 11

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.IdentifiableBox.CustomParameter = try {
                CustomParameter(
                    jp.co.soramitsu.iroha2.generated.CustomParameter.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.IdentifiableBox.CustomParameter,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.CustomParameter.write(writer, instance.customParameter)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<IdentifiableBox>, ScaleWriter<IdentifiableBox> {
        override fun read(reader: ScaleCodecReader): IdentifiableBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> NewDomain.read(reader)
            1 -> NewAccount.read(reader)
            2 -> NewAssetDefinition.read(reader)
            3 -> NewRole.read(reader)
            4 -> Peer.read(reader)
            5 -> Domain.read(reader)
            6 -> Account.read(reader)
            7 -> AssetDefinition.read(reader)
            8 -> Asset.read(reader)
            9 -> Trigger.read(reader)
            10 -> Role.read(reader)
            11 -> CustomParameter.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: IdentifiableBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> NewDomain.write(writer, instance as NewDomain)
                1 -> NewAccount.write(writer, instance as NewAccount)
                2 -> NewAssetDefinition.write(writer, instance as NewAssetDefinition)
                3 -> NewRole.write(writer, instance as NewRole)
                4 -> Peer.write(writer, instance as Peer)
                5 -> Domain.write(writer, instance as Domain)
                6 -> Account.write(writer, instance as Account)
                7 -> AssetDefinition.write(writer, instance as AssetDefinition)
                8 -> Asset.write(writer, instance as Asset)
                9 -> Trigger.write(writer, instance as Trigger)
                10 -> Role.write(writer, instance as Role)
                11 -> CustomParameter.write(writer, instance as CustomParameter)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
