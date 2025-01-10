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
 * TypeError
 *
 * Generated from 'TypeError' enum
 */
public sealed class TypeError : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'AssetType' variant
     */
    public data class AssetType(
        public val mismatch: Mismatch<jp.co.soramitsu.iroha2.generated.AssetType>,
    ) : TypeError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TypeError.AssetType>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TypeError.AssetType> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TypeError.AssetType = try {
                AssetType(
                    Mismatch.read(reader) as Mismatch<jp.co.soramitsu.iroha2.generated.AssetType>,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TypeError.AssetType,
            ): Unit = try {
                Mismatch.write(writer, instance.mismatch)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'NumericAssetTypeExpected' variant
     */
    public data class NumericAssetTypeExpected(
        public val assetType: jp.co.soramitsu.iroha2.generated.AssetType,
    ) : TypeError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TypeError.NumericAssetTypeExpected>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TypeError.NumericAssetTypeExpected> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TypeError.NumericAssetTypeExpected = try {
                NumericAssetTypeExpected(
                    jp.co.soramitsu.iroha2.generated.AssetType.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TypeError.NumericAssetTypeExpected,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.AssetType.write(writer, instance.assetType)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<TypeError>, ScaleWriter<TypeError> {
        override fun read(reader: ScaleCodecReader): TypeError = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> AssetType.read(reader)
            1 -> NumericAssetTypeExpected.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: TypeError) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> AssetType.write(writer, instance as AssetType)
                1 -> NumericAssetTypeExpected.write(writer, instance as NumericAssetTypeExpected)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
