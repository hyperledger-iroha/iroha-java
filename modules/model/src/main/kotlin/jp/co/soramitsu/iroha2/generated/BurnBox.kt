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
 * BurnBox
 *
 * Generated from 'BurnBox' enum
 */
public sealed class BurnBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Asset' variant
     */
    public data class Asset(
        public val burnOfNumericAndAsset: BurnOfNumericAndAsset,
    ) : BurnBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.BurnBox.Asset>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.BurnBox.Asset> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.BurnBox.Asset =
                try {
                    Asset(
                        BurnOfNumericAndAsset.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.BurnBox.Asset,
            ): Unit = try {
                BurnOfNumericAndAsset.write(writer, instance.burnOfNumericAndAsset)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'TriggerRepetitions' variant
     */
    public data class TriggerRepetitions(
        public val burnOfu32AndTrigger: BurnOfu32AndTrigger,
    ) : BurnBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.BurnBox.TriggerRepetitions>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.BurnBox.TriggerRepetitions> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.BurnBox.TriggerRepetitions = try {
                TriggerRepetitions(
                    BurnOfu32AndTrigger.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.BurnBox.TriggerRepetitions,
            ): Unit = try {
                BurnOfu32AndTrigger.write(writer, instance.burnOfu32AndTrigger)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<BurnBox>, ScaleWriter<BurnBox> {
        override fun read(reader: ScaleCodecReader): BurnBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Asset.read(reader)
            1 -> TriggerRepetitions.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: BurnBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Asset.write(writer, instance as Asset)
                1 -> TriggerRepetitions.write(writer, instance as TriggerRepetitions)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
