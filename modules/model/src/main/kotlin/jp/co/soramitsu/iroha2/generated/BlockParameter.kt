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
 * BlockParameter
 *
 * Generated from 'BlockParameter' enum
 */
public sealed class BlockParameter : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'MaxTransactions' variant
     */
    public data class MaxTransactions(
        public val nonZeroOfu64: NonZeroOfu64,
    ) : BlockParameter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.BlockParameter.MaxTransactions>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.BlockParameter.MaxTransactions> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.BlockParameter.MaxTransactions = try {
                MaxTransactions(
                    NonZeroOfu64.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.BlockParameter.MaxTransactions,
            ): Unit = try {
                NonZeroOfu64.write(writer, instance.nonZeroOfu64)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<BlockParameter>, ScaleWriter<BlockParameter> {
        override fun read(reader: ScaleCodecReader): BlockParameter = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> MaxTransactions.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: BlockParameter) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> MaxTransactions.write(writer, instance as MaxTransactions)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
