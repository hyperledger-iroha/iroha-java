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
 * CompoundPredicateOfTriggerIdPredicateBox
 *
 * Generated from 'CompoundPredicateOfTriggerIdPredicateBox' enum
 */
public sealed class CompoundPredicateOfTriggerIdPredicateBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(
        public val triggerIdPredicateBox: TriggerIdPredicateBox,
    ) : CompoundPredicateOfTriggerIdPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerIdPredicateBox.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerIdPredicateBox.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerIdPredicateBox.Atom = try {
                Atom(
                    TriggerIdPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerIdPredicateBox.Atom,
            ): Unit = try {
                TriggerIdPredicateBox.write(writer, instance.triggerIdPredicateBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Not' variant
     */
    public data class Not(
        public val compoundPredicateOfTriggerIdPredicateBox: CompoundPredicateOfTriggerIdPredicateBox,
    ) : CompoundPredicateOfTriggerIdPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerIdPredicateBox.Not>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerIdPredicateBox.Not> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerIdPredicateBox.Not = try {
                Not(
                    CompoundPredicateOfTriggerIdPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerIdPredicateBox.Not,
            ): Unit = try {
                CompoundPredicateOfTriggerIdPredicateBox.write(
                    writer,
                    instance.compoundPredicateOfTriggerIdPredicateBox,
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
        public val vec: List<CompoundPredicateOfTriggerIdPredicateBox>,
    ) : CompoundPredicateOfTriggerIdPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerIdPredicateBox.And>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerIdPredicateBox.And> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerIdPredicateBox.And = try {
                And(
                    reader.readVec(reader.readCompactInt()) { CompoundPredicateOfTriggerIdPredicateBox.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerIdPredicateBox.And,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    CompoundPredicateOfTriggerIdPredicateBox.write(writer, value)
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
        public val vec: List<CompoundPredicateOfTriggerIdPredicateBox>,
    ) : CompoundPredicateOfTriggerIdPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerIdPredicateBox.Or>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerIdPredicateBox.Or> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerIdPredicateBox.Or = try {
                Or(
                    reader.readVec(reader.readCompactInt()) { CompoundPredicateOfTriggerIdPredicateBox.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfTriggerIdPredicateBox.Or,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    CompoundPredicateOfTriggerIdPredicateBox.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<CompoundPredicateOfTriggerIdPredicateBox>,
        ScaleWriter<CompoundPredicateOfTriggerIdPredicateBox> {
        override fun read(reader: ScaleCodecReader): CompoundPredicateOfTriggerIdPredicateBox = when (
            val
            discriminant = reader.readUByte()
        ) {
            0 -> Atom.read(reader)
            1 -> Not.read(reader)
            2 -> And.read(reader)
            3 -> Or.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(
            writer: ScaleCodecWriter,
            instance: CompoundPredicateOfTriggerIdPredicateBox,
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
