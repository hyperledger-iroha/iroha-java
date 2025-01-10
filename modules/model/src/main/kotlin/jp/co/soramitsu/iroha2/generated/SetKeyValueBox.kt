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
 * SetKeyValueBox
 *
 * Generated from 'SetKeyValueBox' enum
 */
public sealed class SetKeyValueBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Domain' variant
     */
    public data class Domain(
        public val setKeyValueOfDomain: SetKeyValueOfDomain,
    ) : SetKeyValueBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SetKeyValueBox.Domain>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SetKeyValueBox.Domain> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SetKeyValueBox.Domain = try {
                Domain(
                    SetKeyValueOfDomain.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SetKeyValueBox.Domain,
            ): Unit = try {
                SetKeyValueOfDomain.write(writer, instance.setKeyValueOfDomain)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Account' variant
     */
    public data class Account(
        public val setKeyValueOfAccount: SetKeyValueOfAccount,
    ) : SetKeyValueBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SetKeyValueBox.Account>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SetKeyValueBox.Account> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SetKeyValueBox.Account = try {
                Account(
                    SetKeyValueOfAccount.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SetKeyValueBox.Account,
            ): Unit = try {
                SetKeyValueOfAccount.write(writer, instance.setKeyValueOfAccount)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'AssetDefinition' variant
     */
    public data class AssetDefinition(
        public val setKeyValueOfAssetDefinition: SetKeyValueOfAssetDefinition,
    ) : SetKeyValueBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SetKeyValueBox.AssetDefinition>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SetKeyValueBox.AssetDefinition> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SetKeyValueBox.AssetDefinition = try {
                AssetDefinition(
                    SetKeyValueOfAssetDefinition.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SetKeyValueBox.AssetDefinition,
            ): Unit = try {
                SetKeyValueOfAssetDefinition.write(writer, instance.setKeyValueOfAssetDefinition)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Asset' variant
     */
    public data class Asset(
        public val setKeyValueOfAsset: SetKeyValueOfAsset,
    ) : SetKeyValueBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SetKeyValueBox.Asset>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SetKeyValueBox.Asset> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SetKeyValueBox.Asset = try {
                Asset(
                    SetKeyValueOfAsset.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SetKeyValueBox.Asset,
            ): Unit = try {
                SetKeyValueOfAsset.write(writer, instance.setKeyValueOfAsset)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Trigger' variant
     */
    public data class Trigger(
        public val setKeyValueOfTrigger: SetKeyValueOfTrigger,
    ) : SetKeyValueBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SetKeyValueBox.Trigger>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SetKeyValueBox.Trigger> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SetKeyValueBox.Trigger = try {
                Trigger(
                    SetKeyValueOfTrigger.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SetKeyValueBox.Trigger,
            ): Unit = try {
                SetKeyValueOfTrigger.write(writer, instance.setKeyValueOfTrigger)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<SetKeyValueBox>, ScaleWriter<SetKeyValueBox> {
        override fun read(reader: ScaleCodecReader): SetKeyValueBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Domain.read(reader)
            1 -> Account.read(reader)
            2 -> AssetDefinition.read(reader)
            3 -> Asset.read(reader)
            4 -> Trigger.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: SetKeyValueBox) {
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
