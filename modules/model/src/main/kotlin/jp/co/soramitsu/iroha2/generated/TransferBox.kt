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
 * TransferBox
 *
 * Generated from 'TransferBox' enum
 */
public sealed class TransferBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Domain' variant
     */
    public data class Domain(
        public val transferOfAccountAndDomainIdAndAccount: TransferOfAccountAndDomainIdAndAccount,
    ) : TransferBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TransferBox.Domain>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TransferBox.Domain> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TransferBox.Domain = try {
                Domain(
                    TransferOfAccountAndDomainIdAndAccount.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TransferBox.Domain,
            ): Unit = try {
                TransferOfAccountAndDomainIdAndAccount.write(
                    writer,
                    instance.transferOfAccountAndDomainIdAndAccount,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'AssetDefinition' variant
     */
    public data class AssetDefinition(
        public val transferOfAccountAndAssetDefinitionIdAndAccount:
        TransferOfAccountAndAssetDefinitionIdAndAccount,
    ) : TransferBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TransferBox.AssetDefinition>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TransferBox.AssetDefinition> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TransferBox.AssetDefinition = try {
                AssetDefinition(
                    TransferOfAccountAndAssetDefinitionIdAndAccount.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TransferBox.AssetDefinition,
            ): Unit = try {
                TransferOfAccountAndAssetDefinitionIdAndAccount.write(
                    writer,
                    instance.transferOfAccountAndAssetDefinitionIdAndAccount,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Asset' variant
     */
    public data class Asset(
        public val assetTransferBox: AssetTransferBox,
    ) : TransferBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TransferBox.Asset>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TransferBox.Asset> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TransferBox.Asset = try {
                Asset(
                    AssetTransferBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TransferBox.Asset,
            ): Unit = try {
                AssetTransferBox.write(writer, instance.assetTransferBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<TransferBox>, ScaleWriter<TransferBox> {
        override fun read(reader: ScaleCodecReader): TransferBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Domain.read(reader)
            1 -> AssetDefinition.read(reader)
            2 -> Asset.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: TransferBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Domain.write(writer, instance as Domain)
                1 -> AssetDefinition.write(writer, instance as AssetDefinition)
                2 -> Asset.write(writer, instance as Asset)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
