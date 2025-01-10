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
 * MintBox
 *
 * Generated from 'MintBox' enum
 */
public sealed class MintBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Asset' variant
     */
    public data class Asset(
        public val mintOfNumericAndAsset: MintOfNumericAndAsset,
    ) : MintBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.MintBox.Asset>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.MintBox.Asset> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.MintBox.Asset =
                try {
                    Asset(
                        MintOfNumericAndAsset.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.MintBox.Asset,
            ): Unit = try {
                MintOfNumericAndAsset.write(writer, instance.mintOfNumericAndAsset)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'TriggerRepetitions' variant
     */
    public data class TriggerRepetitions(
        public val mintOfu32AndTrigger: MintOfu32AndTrigger,
    ) : MintBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.MintBox.TriggerRepetitions>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.MintBox.TriggerRepetitions> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.MintBox.TriggerRepetitions = try {
                TriggerRepetitions(
                    MintOfu32AndTrigger.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.MintBox.TriggerRepetitions,
            ): Unit = try {
                MintOfu32AndTrigger.write(writer, instance.mintOfu32AndTrigger)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<MintBox>, ScaleWriter<MintBox> {
        override fun read(reader: ScaleCodecReader): MintBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Asset.read(reader)
            1 -> TriggerRepetitions.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: MintBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Asset.write(writer, instance as Asset)
                1 -> TriggerRepetitions.write(writer, instance as TriggerRepetitions)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
