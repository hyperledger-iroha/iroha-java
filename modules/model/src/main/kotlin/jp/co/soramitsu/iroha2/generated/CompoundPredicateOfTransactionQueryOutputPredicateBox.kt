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
 * CompoundPredicateOfTransactionQueryOutputPredicateBox
 *
 * Generated from 'CompoundPredicateOfTransactionQueryOutputPredicateBox' enum
 */
public sealed class CompoundPredicateOfTransactionQueryOutputPredicateBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(
        public val transactionQueryOutputPredicateBox: TransactionQueryOutputPredicateBox,
    ) : CompoundPredicateOfTransactionQueryOutputPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTransactionQueryOutputPredicateBox.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTransactionQueryOutputPredicateBox.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTransactionQueryOutputPredicateBox.Atom = try {
                Atom(
                    TransactionQueryOutputPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTransactionQueryOutputPredicateBox.Atom,
            ): Unit = try {
                TransactionQueryOutputPredicateBox.write(
                    writer,
                    instance.transactionQueryOutputPredicateBox,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Not' variant
     */
    public data class Not(
        public val compoundPredicateOfTransactionQueryOutputPredicateBox:
        CompoundPredicateOfTransactionQueryOutputPredicateBox,
    ) : CompoundPredicateOfTransactionQueryOutputPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTransactionQueryOutputPredicateBox.Not>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTransactionQueryOutputPredicateBox.Not> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTransactionQueryOutputPredicateBox.Not = try {
                Not(
                    CompoundPredicateOfTransactionQueryOutputPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTransactionQueryOutputPredicateBox.Not,
            ): Unit = try {
                CompoundPredicateOfTransactionQueryOutputPredicateBox.write(
                    writer,
                    instance.compoundPredicateOfTransactionQueryOutputPredicateBox,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'And' variant
     */
    public data class And(
        public val vec: List<CompoundPredicateOfTransactionQueryOutputPredicateBox>,
    ) : CompoundPredicateOfTransactionQueryOutputPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTransactionQueryOutputPredicateBox.And>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTransactionQueryOutputPredicateBox.And> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTransactionQueryOutputPredicateBox.And = try {
                And(
                    reader.readVec(reader.readCompactInt()) { CompoundPredicateOfTransactionQueryOutputPredicateBox.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTransactionQueryOutputPredicateBox.And,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    CompoundPredicateOfTransactionQueryOutputPredicateBox.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Or' variant
     */
    public data class Or(
        public val vec: List<CompoundPredicateOfTransactionQueryOutputPredicateBox>,
    ) : CompoundPredicateOfTransactionQueryOutputPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTransactionQueryOutputPredicateBox.Or>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTransactionQueryOutputPredicateBox.Or> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTransactionQueryOutputPredicateBox.Or = try {
                Or(
                    reader.readVec(reader.readCompactInt()) { CompoundPredicateOfTransactionQueryOutputPredicateBox.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTransactionQueryOutputPredicateBox.Or,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    CompoundPredicateOfTransactionQueryOutputPredicateBox.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<CompoundPredicateOfTransactionQueryOutputPredicateBox>,
        ScaleWriter<CompoundPredicateOfTransactionQueryOutputPredicateBox> {
        override fun read(reader: ScaleCodecReader): CompoundPredicateOfTransactionQueryOutputPredicateBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Atom.read(reader)
            1 -> Not.read(reader)
            2 -> And.read(reader)
            3 -> Or.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(
            writer: ScaleCodecWriter,
            instance: CompoundPredicateOfTransactionQueryOutputPredicateBox,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Atom.write(writer, instance as Atom)
                1 -> Not.write(writer, instance as Not)
                2 -> And.write(writer, instance as And)
                3 -> Or.write(writer, instance as Or)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
