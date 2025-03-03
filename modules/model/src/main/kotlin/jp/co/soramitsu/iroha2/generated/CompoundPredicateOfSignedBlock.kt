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
 * CompoundPredicateOfSignedBlock
 *
 * Generated from 'CompoundPredicateOfSignedBlock' enum
 */
public sealed class CompoundPredicateOfSignedBlock : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(
        public val signedBlockProjectionOfPredicateMarker: SignedBlockProjectionOfPredicateMarker,
    ) : CompoundPredicateOfSignedBlock() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlock.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlock.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlock.Atom =
                try {
                    Atom(
                        SignedBlockProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlock.Atom,
            ): Unit =
                try {
                    SignedBlockProjectionOfPredicateMarker.write(writer, instance.signedBlockProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Not' variant
     */
    public data class Not(
        public val compoundPredicateOfSignedBlock: CompoundPredicateOfSignedBlock,
    ) : CompoundPredicateOfSignedBlock() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlock.Not>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlock.Not> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlock.Not =
                try {
                    Not(
                        CompoundPredicateOfSignedBlock.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlock.Not,
            ): Unit =
                try {
                    CompoundPredicateOfSignedBlock.write(writer, instance.compoundPredicateOfSignedBlock)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'And' variant
     */
    public data class And(
        public val vec: List<CompoundPredicateOfSignedBlock>,
    ) : CompoundPredicateOfSignedBlock() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlock.And>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlock.And> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlock.And =
                try {
                    And(
                        reader.readVec(reader.readCompactInt()) { CompoundPredicateOfSignedBlock.read(reader) },
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlock.And,
            ): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        CompoundPredicateOfSignedBlock.write(writer, value)
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
        public val vec: List<CompoundPredicateOfSignedBlock>,
    ) : CompoundPredicateOfSignedBlock() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlock.Or>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlock.Or> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlock.Or =
                try {
                    Or(
                        reader.readVec(reader.readCompactInt()) { CompoundPredicateOfSignedBlock.read(reader) },
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfSignedBlock.Or,
            ): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        CompoundPredicateOfSignedBlock.write(writer, value)
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<CompoundPredicateOfSignedBlock>,
        ScaleWriter<CompoundPredicateOfSignedBlock> {
        override fun read(reader: ScaleCodecReader): CompoundPredicateOfSignedBlock =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> Not.read(reader)
                2 -> And.read(reader)
                3 -> Or.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: CompoundPredicateOfSignedBlock,
        ) {
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
