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
 * AssetTransferBox
 *
 * Generated from 'AssetTransferBox' enum
 */
public sealed class AssetTransferBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Numeric' variant
     */
    public data class Numeric(
        public val transferOfAssetAndNumericAndAccount: TransferOfAssetAndNumericAndAccount,
    ) : AssetTransferBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetTransferBox.Numeric>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetTransferBox.Numeric> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetTransferBox.Numeric = try {
                Numeric(
                    TransferOfAssetAndNumericAndAccount.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetTransferBox.Numeric,
            ): Unit = try {
                TransferOfAssetAndNumericAndAccount.write(
                    writer,
                    instance.transferOfAssetAndNumericAndAccount,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Store' variant
     */
    public data class Store(
        public val transferOfAssetAndMetadataAndAccount: TransferOfAssetAndMetadataAndAccount,
    ) : AssetTransferBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetTransferBox.Store>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetTransferBox.Store> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetTransferBox.Store = try {
                Store(
                    TransferOfAssetAndMetadataAndAccount.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetTransferBox.Store,
            ): Unit = try {
                TransferOfAssetAndMetadataAndAccount.write(
                    writer,
                    instance.transferOfAssetAndMetadataAndAccount,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<AssetTransferBox>, ScaleWriter<AssetTransferBox> {
        override fun read(reader: ScaleCodecReader): AssetTransferBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Numeric.read(reader)
            1 -> Store.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: AssetTransferBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Numeric.write(writer, instance as Numeric)
                1 -> Store.write(writer, instance as Store)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
