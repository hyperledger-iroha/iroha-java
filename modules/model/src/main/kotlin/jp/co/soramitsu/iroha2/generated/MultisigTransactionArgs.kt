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
import kotlin.collections.List

/**
 * MultisigTransactionArgs
 *
 * Generated from 'MultisigTransactionArgs' enum
 */
public sealed class MultisigTransactionArgs : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Propose' variant
     */
    public data class Propose(public val vec: List<InstructionBox>) : MultisigTransactionArgs() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.MultisigTransactionArgs.Propose>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.MultisigTransactionArgs.Propose> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.MultisigTransactionArgs.Propose = try {
                Propose(
                    reader.readVec(reader.readCompactInt()) { InstructionBox.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.MultisigTransactionArgs.Propose,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    InstructionBox.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Approve' variant
     */
    public data class Approve(public val hashOf: HashOf<List<InstructionBox>>) : MultisigTransactionArgs() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.MultisigTransactionArgs.Approve>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.MultisigTransactionArgs.Approve> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.MultisigTransactionArgs.Approve = try {
                Approve(
                    HashOf.read(reader) as HashOf<List<InstructionBox>>,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.MultisigTransactionArgs.Approve,
            ): Unit = try {
                HashOf.write(writer, instance.hashOf)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<MultisigTransactionArgs>,
        ScaleWriter<MultisigTransactionArgs> {
        override fun read(reader: ScaleCodecReader): MultisigTransactionArgs = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Propose.read(reader)
            1 -> Approve.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: MultisigTransactionArgs) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Propose.write(writer, instance as Propose)
                1 -> Approve.write(writer, instance as Approve)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
