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
 * RemoveKeyValueBox
 *
 * Generated from 'RemoveKeyValueBox' enum
 */
public sealed class RemoveKeyValueBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Domain' variant
     */
    public data class Domain(
        public val removeKeyValueOfDomain: RemoveKeyValueOfDomain,
    ) : RemoveKeyValueBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.RemoveKeyValueBox.Domain>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.RemoveKeyValueBox.Domain> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.RemoveKeyValueBox.Domain = try {
                Domain(
                    RemoveKeyValueOfDomain.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.RemoveKeyValueBox.Domain,
            ): Unit = try {
                RemoveKeyValueOfDomain.write(writer, instance.removeKeyValueOfDomain)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Account' variant
     */
    public data class Account(
        public val removeKeyValueOfAccount: RemoveKeyValueOfAccount,
    ) : RemoveKeyValueBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.RemoveKeyValueBox.Account>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.RemoveKeyValueBox.Account> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.RemoveKeyValueBox.Account = try {
                Account(
                    RemoveKeyValueOfAccount.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.RemoveKeyValueBox.Account,
            ): Unit = try {
                RemoveKeyValueOfAccount.write(writer, instance.removeKeyValueOfAccount)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'AssetDefinition' variant
     */
    public data class AssetDefinition(
        public val removeKeyValueOfAssetDefinition: RemoveKeyValueOfAssetDefinition,
    ) : RemoveKeyValueBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.RemoveKeyValueBox.AssetDefinition>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.RemoveKeyValueBox.AssetDefinition> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.RemoveKeyValueBox.AssetDefinition = try {
                AssetDefinition(
                    RemoveKeyValueOfAssetDefinition.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.RemoveKeyValueBox.AssetDefinition,
            ): Unit = try {
                RemoveKeyValueOfAssetDefinition.write(writer, instance.removeKeyValueOfAssetDefinition)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Asset' variant
     */
    public data class Asset(
        public val removeKeyValueOfAsset: RemoveKeyValueOfAsset,
    ) : RemoveKeyValueBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.RemoveKeyValueBox.Asset>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.RemoveKeyValueBox.Asset> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.RemoveKeyValueBox.Asset = try {
                Asset(
                    RemoveKeyValueOfAsset.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.RemoveKeyValueBox.Asset,
            ): Unit = try {
                RemoveKeyValueOfAsset.write(writer, instance.removeKeyValueOfAsset)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Trigger' variant
     */
    public data class Trigger(
        public val removeKeyValueOfTrigger: RemoveKeyValueOfTrigger,
    ) : RemoveKeyValueBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.RemoveKeyValueBox.Trigger>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.RemoveKeyValueBox.Trigger> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.RemoveKeyValueBox.Trigger = try {
                Trigger(
                    RemoveKeyValueOfTrigger.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.RemoveKeyValueBox.Trigger,
            ): Unit = try {
                RemoveKeyValueOfTrigger.write(writer, instance.removeKeyValueOfTrigger)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<RemoveKeyValueBox>, ScaleWriter<RemoveKeyValueBox> {
        override fun read(reader: ScaleCodecReader): RemoveKeyValueBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Domain.read(reader)
            1 -> Account.read(reader)
            2 -> AssetDefinition.read(reader)
            3 -> Asset.read(reader)
            4 -> Trigger.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: RemoveKeyValueBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Domain.write(writer, instance as Domain)
                1 -> Account.write(writer, instance as Account)
                2 -> AssetDefinition.write(writer, instance as AssetDefinition)
                3 -> Asset.write(writer, instance as Asset)
                4 -> Trigger.write(writer, instance as Trigger)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
