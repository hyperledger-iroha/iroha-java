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
 * CompoundPredicateOfAccount
 *
 * Generated from 'CompoundPredicateOfAccount' enum
 */
public sealed class CompoundPredicateOfAccount : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(public val accountProjectionOfPredicateMarker: AccountProjectionOfPredicateMarker) :
        CompoundPredicateOfAccount() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAccount.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAccount.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAccount.Atom = try {
                Atom(
                    AccountProjectionOfPredicateMarker.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAccount.Atom): Unit =
                try {
                    AccountProjectionOfPredicateMarker.write(writer, instance.accountProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Not' variant
     */
    public data class Not(public val compoundPredicateOfAccount: CompoundPredicateOfAccount) : CompoundPredicateOfAccount() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAccount.Not>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAccount.Not> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAccount.Not = try {
                Not(
                    CompoundPredicateOfAccount.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAccount.Not): Unit =
                try {
                    CompoundPredicateOfAccount.write(writer, instance.compoundPredicateOfAccount)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'And' variant
     */
    public data class And(public val vec: List<CompoundPredicateOfAccount>) : CompoundPredicateOfAccount() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAccount.And>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAccount.And> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAccount.And = try {
                And(
                    reader.readVec(reader.readCompactInt()) { CompoundPredicateOfAccount.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAccount.And): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        CompoundPredicateOfAccount.write(writer, value)
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Or' variant
     */
    public data class Or(public val vec: List<CompoundPredicateOfAccount>) : CompoundPredicateOfAccount() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAccount.Or>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAccount.Or> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAccount.Or = try {
                Or(
                    reader.readVec(reader.readCompactInt()) { CompoundPredicateOfAccount.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAccount.Or): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        CompoundPredicateOfAccount.write(writer, value)
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<CompoundPredicateOfAccount>,
        ScaleWriter<CompoundPredicateOfAccount> {
        override fun read(reader: ScaleCodecReader): CompoundPredicateOfAccount = when (val discriminant = reader.readUByte()) {
            0 -> Atom.read(reader)
            1 -> Not.read(reader)
            2 -> And.read(reader)
            3 -> Or.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: CompoundPredicateOfAccount) {
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
