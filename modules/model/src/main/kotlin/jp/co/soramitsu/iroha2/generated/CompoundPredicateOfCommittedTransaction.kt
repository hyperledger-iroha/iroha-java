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
 * CompoundPredicateOfCommittedTransaction
 *
 * Generated from 'CompoundPredicateOfCommittedTransaction' enum
 */
public sealed class CompoundPredicateOfCommittedTransaction : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(public val committedTransactionProjectionOfPredicateMarker: CommittedTransactionProjectionOfPredicateMarker) :
        CompoundPredicateOfCommittedTransaction() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfCommittedTransaction.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfCommittedTransaction.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfCommittedTransaction.Atom =
                try {
                    Atom(
                        CommittedTransactionProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfCommittedTransaction.Atom,
            ): Unit = try {
                CommittedTransactionProjectionOfPredicateMarker.write(writer, instance.committedTransactionProjectionOfPredicateMarker)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Not' variant
     */
    public data class Not(public val compoundPredicateOfCommittedTransaction: CompoundPredicateOfCommittedTransaction) :
        CompoundPredicateOfCommittedTransaction() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfCommittedTransaction.Not>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfCommittedTransaction.Not> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfCommittedTransaction.Not =
                try {
                    Not(
                        CompoundPredicateOfCommittedTransaction.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfCommittedTransaction.Not,
            ): Unit = try {
                CompoundPredicateOfCommittedTransaction.write(writer, instance.compoundPredicateOfCommittedTransaction)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'And' variant
     */
    public data class And(public val vec: List<CompoundPredicateOfCommittedTransaction>) : CompoundPredicateOfCommittedTransaction() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfCommittedTransaction.And>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfCommittedTransaction.And> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfCommittedTransaction.And =
                try {
                    And(
                        reader.readVec(reader.readCompactInt()) { CompoundPredicateOfCommittedTransaction.read(reader) },
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfCommittedTransaction.And,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    CompoundPredicateOfCommittedTransaction.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Or' variant
     */
    public data class Or(public val vec: List<CompoundPredicateOfCommittedTransaction>) : CompoundPredicateOfCommittedTransaction() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfCommittedTransaction.Or>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfCommittedTransaction.Or> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfCommittedTransaction.Or = try {
                Or(
                    reader.readVec(reader.readCompactInt()) { CompoundPredicateOfCommittedTransaction.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfCommittedTransaction.Or,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    CompoundPredicateOfCommittedTransaction.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<CompoundPredicateOfCommittedTransaction>,
        ScaleWriter<CompoundPredicateOfCommittedTransaction> {
        override fun read(reader: ScaleCodecReader): CompoundPredicateOfCommittedTransaction =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> Not.read(reader)
                2 -> And.read(reader)
                3 -> Or.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(writer: ScaleCodecWriter, instance: CompoundPredicateOfCommittedTransaction) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Atom.write(writer, instance as Atom)
                1 -> Not.write(writer, instance as Not)
                2 -> And.write(writer, instance as And)
                3 -> Or.write(writer, instance as Or)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
