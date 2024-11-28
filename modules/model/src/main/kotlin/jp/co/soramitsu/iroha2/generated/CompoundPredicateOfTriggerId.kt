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
 * CompoundPredicateOfTriggerId
 *
 * Generated from 'CompoundPredicateOfTriggerId' enum
 */
public sealed class CompoundPredicateOfTriggerId : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(public val triggerIdProjectionOfPredicateMarker: TriggerIdProjectionOfPredicateMarker) :
        CompoundPredicateOfTriggerId() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerId.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerId.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerId.Atom = try {
                Atom(
                    TriggerIdProjectionOfPredicateMarker.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerId.Atom,
            ): Unit = try {
                TriggerIdProjectionOfPredicateMarker.write(writer, instance.triggerIdProjectionOfPredicateMarker)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Not' variant
     */
    public data class Not(public val compoundPredicateOfTriggerId: CompoundPredicateOfTriggerId) : CompoundPredicateOfTriggerId() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerId.Not>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerId.Not> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerId.Not = try {
                Not(
                    CompoundPredicateOfTriggerId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerId.Not,
            ): Unit = try {
                CompoundPredicateOfTriggerId.write(writer, instance.compoundPredicateOfTriggerId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'And' variant
     */
    public data class And(public val vec: List<CompoundPredicateOfTriggerId>) : CompoundPredicateOfTriggerId() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerId.And>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerId.And> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerId.And = try {
                And(
                    reader.readVec(reader.readCompactInt()) { CompoundPredicateOfTriggerId.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerId.And,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    CompoundPredicateOfTriggerId.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Or' variant
     */
    public data class Or(public val vec: List<CompoundPredicateOfTriggerId>) : CompoundPredicateOfTriggerId() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerId.Or>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerId.Or> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerId.Or = try {
                Or(
                    reader.readVec(reader.readCompactInt()) { CompoundPredicateOfTriggerId.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerId.Or): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        CompoundPredicateOfTriggerId.write(writer, value)
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<CompoundPredicateOfTriggerId>,
        ScaleWriter<CompoundPredicateOfTriggerId> {
        override fun read(reader: ScaleCodecReader): CompoundPredicateOfTriggerId = when (val discriminant = reader.readUByte()) {
            0 -> Atom.read(reader)
            1 -> Not.read(reader)
            2 -> And.read(reader)
            3 -> Or.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: CompoundPredicateOfTriggerId) {
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
