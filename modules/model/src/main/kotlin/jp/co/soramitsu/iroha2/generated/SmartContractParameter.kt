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
 * SmartContractParameter
 *
 * Generated from 'SmartContractParameter' enum
 */
public sealed class SmartContractParameter : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Fuel' variant
     */
    public data class Fuel(
        public val nonZeroOfu64: NonZeroOfu64,
    ) : SmartContractParameter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SmartContractParameter.Fuel>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SmartContractParameter.Fuel> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SmartContractParameter.Fuel = try {
                Fuel(
                    NonZeroOfu64.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SmartContractParameter.Fuel,
            ): Unit = try {
                NonZeroOfu64.write(writer, instance.nonZeroOfu64)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Memory' variant
     */
    public data class Memory(
        public val nonZeroOfu64: NonZeroOfu64,
    ) : SmartContractParameter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SmartContractParameter.Memory>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SmartContractParameter.Memory> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SmartContractParameter.Memory = try {
                Memory(
                    NonZeroOfu64.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SmartContractParameter.Memory,
            ): Unit = try {
                NonZeroOfu64.write(writer, instance.nonZeroOfu64)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<SmartContractParameter>, ScaleWriter<SmartContractParameter> {
        override fun read(reader: ScaleCodecReader): SmartContractParameter = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Fuel.read(reader)
            1 -> Memory.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: SmartContractParameter) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Fuel.write(writer, instance as Fuel)
                1 -> Memory.write(writer, instance as Memory)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
