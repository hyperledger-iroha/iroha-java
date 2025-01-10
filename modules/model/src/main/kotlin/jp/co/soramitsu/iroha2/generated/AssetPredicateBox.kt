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
 * AssetPredicateBox
 *
 * Generated from 'AssetPredicateBox' enum
 */
public sealed class AssetPredicateBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Id' variant
     */
    public data class Id(
        public val assetIdPredicateBox: AssetIdPredicateBox,
    ) : AssetPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetPredicateBox.Id>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetPredicateBox.Id> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetPredicateBox.Id = try {
                Id(
                    AssetIdPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetPredicateBox.Id,
            ): Unit = try {
                AssetIdPredicateBox.write(writer, instance.assetIdPredicateBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Value' variant
     */
    public data class Value(
        public val assetValuePredicateBox: AssetValuePredicateBox,
    ) : AssetPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetPredicateBox.Value>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetPredicateBox.Value> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetPredicateBox.Value = try {
                Value(
                    AssetValuePredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetPredicateBox.Value,
            ): Unit = try {
                AssetValuePredicateBox.write(writer, instance.assetValuePredicateBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<AssetPredicateBox>, ScaleWriter<AssetPredicateBox> {
        override fun read(reader: ScaleCodecReader): AssetPredicateBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Id.read(reader)
            1 -> Value.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: AssetPredicateBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Id.write(writer, instance as Id)
                1 -> Value.write(writer, instance as Value)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
