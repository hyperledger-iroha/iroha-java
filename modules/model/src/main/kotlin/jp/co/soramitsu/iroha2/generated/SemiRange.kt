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
 * SemiRange
 *
 * Generated from 'SemiRange' enum
 */
public sealed class SemiRange : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Numeric' variant
     */
    public data class Numeric(
        public val semiIntervalOfNumeric: SemiIntervalOfNumeric,
    ) : SemiRange() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SemiRange.Numeric>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SemiRange.Numeric> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SemiRange.Numeric = try {
                Numeric(
                    SemiIntervalOfNumeric.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SemiRange.Numeric,
            ): Unit = try {
                SemiIntervalOfNumeric.write(writer, instance.semiIntervalOfNumeric)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<SemiRange>, ScaleWriter<SemiRange> {
        override fun read(reader: ScaleCodecReader): SemiRange = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Numeric.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: SemiRange) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Numeric.write(writer, instance as Numeric)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
