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
 * RegisterBox
 *
 * Generated from 'RegisterBox' enum
 */
public sealed class RegisterBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Peer' variant
     */
    public data class Peer(
        public val registerOfPeer: RegisterOfPeer,
    ) : RegisterBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.RegisterBox.Peer>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.RegisterBox.Peer> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.RegisterBox.Peer = try {
                Peer(
                    RegisterOfPeer.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.RegisterBox.Peer,
            ): Unit = try {
                RegisterOfPeer.write(writer, instance.registerOfPeer)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Domain' variant
     */
    public data class Domain(
        public val registerOfDomain: RegisterOfDomain,
    ) : RegisterBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.RegisterBox.Domain>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.RegisterBox.Domain> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.RegisterBox.Domain = try {
                Domain(
                    RegisterOfDomain.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.RegisterBox.Domain,
            ): Unit = try {
                RegisterOfDomain.write(writer, instance.registerOfDomain)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Account' variant
     */
    public data class Account(
        public val registerOfAccount: RegisterOfAccount,
    ) : RegisterBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.RegisterBox.Account>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.RegisterBox.Account> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.RegisterBox.Account = try {
                Account(
                    RegisterOfAccount.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.RegisterBox.Account,
            ): Unit = try {
                RegisterOfAccount.write(writer, instance.registerOfAccount)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'AssetDefinition' variant
     */
    public data class AssetDefinition(
        public val registerOfAssetDefinition: RegisterOfAssetDefinition,
    ) : RegisterBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.RegisterBox.AssetDefinition>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.RegisterBox.AssetDefinition> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.RegisterBox.AssetDefinition = try {
                AssetDefinition(
                    RegisterOfAssetDefinition.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.RegisterBox.AssetDefinition,
            ): Unit = try {
                RegisterOfAssetDefinition.write(writer, instance.registerOfAssetDefinition)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Asset' variant
     */
    public data class Asset(
        public val registerOfAsset: RegisterOfAsset,
    ) : RegisterBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.RegisterBox.Asset>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.RegisterBox.Asset> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.RegisterBox.Asset = try {
                Asset(
                    RegisterOfAsset.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.RegisterBox.Asset,
            ): Unit = try {
                RegisterOfAsset.write(writer, instance.registerOfAsset)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Role' variant
     */
    public data class Role(
        public val registerOfRole: RegisterOfRole,
    ) : RegisterBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.RegisterBox.Role>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.RegisterBox.Role> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.RegisterBox.Role = try {
                Role(
                    RegisterOfRole.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.RegisterBox.Role,
            ): Unit = try {
                RegisterOfRole.write(writer, instance.registerOfRole)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Trigger' variant
     */
    public data class Trigger(
        public val registerOfTrigger: RegisterOfTrigger,
    ) : RegisterBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.RegisterBox.Trigger>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.RegisterBox.Trigger> {
            public const val DISCRIMINANT: Int = 6

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.RegisterBox.Trigger = try {
                Trigger(
                    RegisterOfTrigger.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.RegisterBox.Trigger,
            ): Unit = try {
                RegisterOfTrigger.write(writer, instance.registerOfTrigger)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<RegisterBox>, ScaleWriter<RegisterBox> {
        override fun read(reader: ScaleCodecReader): RegisterBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Peer.read(reader)
            1 -> Domain.read(reader)
            2 -> Account.read(reader)
            3 -> AssetDefinition.read(reader)
            4 -> Asset.read(reader)
            5 -> Role.read(reader)
            6 -> Trigger.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: RegisterBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Peer.write(writer, instance as Peer)
                1 -> Domain.write(writer, instance as Domain)
                2 -> Account.write(writer, instance as Account)
                3 -> AssetDefinition.write(writer, instance as AssetDefinition)
                4 -> Asset.write(writer, instance as Asset)
                5 -> Role.write(writer, instance as Role)
                6 -> Trigger.write(writer, instance as Trigger)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
