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
 * CompoundPredicateOfSignedBlockPredicateBox
 *
 * Generated from 'CompoundPredicateOfSignedBlockPredicateBox' enum
 */
public sealed class CompoundPredicateOfSignedBlockPredicateBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(
        public val signedBlockPredicateBox: SignedBlockPredicateBox,
    ) : CompoundPredicateOfSignedBlockPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlockPredicateBox.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlockPredicateBox.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlockPredicateBox.Atom = try {
                Atom(
                    SignedBlockPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlockPredicateBox.Atom,
            ): Unit = try {
                SignedBlockPredicateBox.write(writer, instance.signedBlockPredicateBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Not' variant
     */
    public data class Not(
        public val compoundPredicateOfSignedBlockPredicateBox:
        CompoundPredicateOfSignedBlockPredicateBox,
    ) : CompoundPredicateOfSignedBlockPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlockPredicateBox.Not>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlockPredicateBox.Not> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlockPredicateBox.Not = try {
                Not(
                    CompoundPredicateOfSignedBlockPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlockPredicateBox.Not,
            ): Unit = try {
                CompoundPredicateOfSignedBlockPredicateBox.write(
                    writer,
                    instance.compoundPredicateOfSignedBlockPredicateBox,
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
        public val vec: List<CompoundPredicateOfSignedBlockPredicateBox>,
    ) : CompoundPredicateOfSignedBlockPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlockPredicateBox.And>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlockPredicateBox.And> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlockPredicateBox.And = try {
                And(
                    reader.readVec(reader.readCompactInt()) { CompoundPredicateOfSignedBlockPredicateBox.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlockPredicateBox.And,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    CompoundPredicateOfSignedBlockPredicateBox.write(writer, value)
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
        public val vec: List<CompoundPredicateOfSignedBlockPredicateBox>,
    ) : CompoundPredicateOfSignedBlockPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlockPredicateBox.Or>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlockPredicateBox.Or> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlockPredicateBox.Or = try {
                Or(
                    reader.readVec(reader.readCompactInt()) { CompoundPredicateOfSignedBlockPredicateBox.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlockPredicateBox.Or,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    CompoundPredicateOfSignedBlockPredicateBox.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<CompoundPredicateOfSignedBlockPredicateBox>,
        ScaleWriter<CompoundPredicateOfSignedBlockPredicateBox> {
        override fun read(reader: ScaleCodecReader): CompoundPredicateOfSignedBlockPredicateBox =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> Not.read(reader)
                2 -> And.read(reader)
                3 -> Or.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(
            writer: ScaleCodecWriter,
            instance: CompoundPredicateOfSignedBlockPredicateBox,
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
