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
 * UnregisterBox
 *
 * Generated from 'UnregisterBox' enum
 */
public sealed class UnregisterBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Peer' variant
     */
    public data class Peer(
        public val unregisterOfPeer: UnregisterOfPeer,
    ) : UnregisterBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.UnregisterBox.Peer>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.UnregisterBox.Peer> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.UnregisterBox.Peer = try {
                Peer(
                    UnregisterOfPeer.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.UnregisterBox.Peer,
            ): Unit = try {
                UnregisterOfPeer.write(writer, instance.unregisterOfPeer)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Domain' variant
     */
    public data class Domain(
        public val unregisterOfDomain: UnregisterOfDomain,
    ) : UnregisterBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.UnregisterBox.Domain>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.UnregisterBox.Domain> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.UnregisterBox.Domain = try {
                Domain(
                    UnregisterOfDomain.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.UnregisterBox.Domain,
            ): Unit = try {
                UnregisterOfDomain.write(writer, instance.unregisterOfDomain)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Account' variant
     */
    public data class Account(
        public val unregisterOfAccount: UnregisterOfAccount,
    ) : UnregisterBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.UnregisterBox.Account>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.UnregisterBox.Account> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.UnregisterBox.Account = try {
                Account(
                    UnregisterOfAccount.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.UnregisterBox.Account,
            ): Unit = try {
                UnregisterOfAccount.write(writer, instance.unregisterOfAccount)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'AssetDefinition' variant
     */
    public data class AssetDefinition(
        public val unregisterOfAssetDefinition: UnregisterOfAssetDefinition,
    ) : UnregisterBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.UnregisterBox.AssetDefinition>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.UnregisterBox.AssetDefinition> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.UnregisterBox.AssetDefinition = try {
                AssetDefinition(
                    UnregisterOfAssetDefinition.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.UnregisterBox.AssetDefinition,
            ): Unit = try {
                UnregisterOfAssetDefinition.write(writer, instance.unregisterOfAssetDefinition)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Asset' variant
     */
    public data class Asset(
        public val unregisterOfAsset: UnregisterOfAsset,
    ) : UnregisterBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.UnregisterBox.Asset>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.UnregisterBox.Asset> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.UnregisterBox.Asset = try {
                Asset(
                    UnregisterOfAsset.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.UnregisterBox.Asset,
            ): Unit = try {
                UnregisterOfAsset.write(writer, instance.unregisterOfAsset)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Role' variant
     */
    public data class Role(
        public val unregisterOfRole: UnregisterOfRole,
    ) : UnregisterBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.UnregisterBox.Role>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.UnregisterBox.Role> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.UnregisterBox.Role = try {
                Role(
                    UnregisterOfRole.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.UnregisterBox.Role,
            ): Unit = try {
                UnregisterOfRole.write(writer, instance.unregisterOfRole)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Trigger' variant
     */
    public data class Trigger(
        public val unregisterOfTrigger: UnregisterOfTrigger,
    ) : UnregisterBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.UnregisterBox.Trigger>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.UnregisterBox.Trigger> {
            public const val DISCRIMINANT: Int = 6

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.UnregisterBox.Trigger = try {
                Trigger(
                    UnregisterOfTrigger.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.UnregisterBox.Trigger,
            ): Unit = try {
                UnregisterOfTrigger.write(writer, instance.unregisterOfTrigger)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<UnregisterBox>, ScaleWriter<UnregisterBox> {
        override fun read(reader: ScaleCodecReader): UnregisterBox = when (
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

        override fun write(writer: ScaleCodecWriter, instance: UnregisterBox) {
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
