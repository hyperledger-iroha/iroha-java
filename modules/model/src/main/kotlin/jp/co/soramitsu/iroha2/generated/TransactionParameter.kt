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
 * TransactionParameter
 *
 * Generated from 'TransactionParameter' enum
 */
public sealed class TransactionParameter : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'MaxInstructions' variant
     */
    public data class MaxInstructions(
        public val nonZeroOfu64: NonZeroOfu64,
    ) : TransactionParameter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TransactionParameter.MaxInstructions>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TransactionParameter.MaxInstructions> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TransactionParameter.MaxInstructions = try {
                MaxInstructions(
                    NonZeroOfu64.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TransactionParameter.MaxInstructions,
            ): Unit =
                try {
                    NonZeroOfu64.write(writer, instance.nonZeroOfu64)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'SmartContractSize' variant
     */
    public data class SmartContractSize(
        public val nonZeroOfu64: NonZeroOfu64,
    ) : TransactionParameter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TransactionParameter.SmartContractSize>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TransactionParameter.SmartContractSize> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TransactionParameter.SmartContractSize = try {
                SmartContractSize(
                    NonZeroOfu64.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TransactionParameter.SmartContractSize,
            ): Unit =
                try {
                    NonZeroOfu64.write(writer, instance.nonZeroOfu64)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object : ScaleReader<TransactionParameter>, ScaleWriter<TransactionParameter> {
        override fun read(reader: ScaleCodecReader): TransactionParameter = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> MaxInstructions.read(reader)
            1 -> SmartContractSize.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: TransactionParameter) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> MaxInstructions.write(writer, instance as MaxInstructions)
                1 -> SmartContractSize.write(writer, instance as SmartContractSize)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
