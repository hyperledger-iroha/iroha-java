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
 * CompoundPredicateOfTrigger
 *
 * Generated from 'CompoundPredicateOfTrigger' enum
 */
public sealed class CompoundPredicateOfTrigger : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(public val triggerProjectionOfPredicateMarker: TriggerProjectionOfPredicateMarker) :
        CompoundPredicateOfTrigger() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTrigger.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTrigger.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTrigger.Atom = try {
                Atom(
                    TriggerProjectionOfPredicateMarker.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTrigger.Atom): Unit =
                try {
                    TriggerProjectionOfPredicateMarker.write(writer, instance.triggerProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Not' variant
     */
    public data class Not(public val compoundPredicateOfTrigger: CompoundPredicateOfTrigger) : CompoundPredicateOfTrigger() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTrigger.Not>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTrigger.Not> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTrigger.Not = try {
                Not(
                    CompoundPredicateOfTrigger.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTrigger.Not): Unit =
                try {
                    CompoundPredicateOfTrigger.write(writer, instance.compoundPredicateOfTrigger)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'And' variant
     */
    public data class And(public val vec: List<CompoundPredicateOfTrigger>) : CompoundPredicateOfTrigger() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTrigger.And>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTrigger.And> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTrigger.And = try {
                And(
                    reader.readVec(reader.readCompactInt()) { CompoundPredicateOfTrigger.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTrigger.And): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        CompoundPredicateOfTrigger.write(writer, value)
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Or' variant
     */
    public data class Or(public val vec: List<CompoundPredicateOfTrigger>) : CompoundPredicateOfTrigger() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTrigger.Or>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTrigger.Or> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTrigger.Or = try {
                Or(
                    reader.readVec(reader.readCompactInt()) { CompoundPredicateOfTrigger.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTrigger.Or): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        CompoundPredicateOfTrigger.write(writer, value)
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<CompoundPredicateOfTrigger>,
        ScaleWriter<CompoundPredicateOfTrigger> {
        override fun read(reader: ScaleCodecReader): CompoundPredicateOfTrigger = when (val discriminant = reader.readUByte()) {
            0 -> Atom.read(reader)
            1 -> Not.read(reader)
            2 -> And.read(reader)
            3 -> Or.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: CompoundPredicateOfTrigger) {
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
