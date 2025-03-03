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
 * CompoundPredicateOfRole
 *
 * Generated from 'CompoundPredicateOfRole' enum
 */
public sealed class CompoundPredicateOfRole : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(
        public val roleProjectionOfPredicateMarker: RoleProjectionOfPredicateMarker,
    ) : CompoundPredicateOfRole() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRole.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRole.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRole.Atom =
                try {
                    Atom(
                        RoleProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRole.Atom,
            ): Unit =
                try {
                    RoleProjectionOfPredicateMarker.write(writer, instance.roleProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Not' variant
     */
    public data class Not(
        public val compoundPredicateOfRole: CompoundPredicateOfRole,
    ) : CompoundPredicateOfRole() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRole.Not>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRole.Not> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRole.Not =
                try {
                    Not(
                        CompoundPredicateOfRole.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRole.Not,
            ): Unit =
                try {
                    CompoundPredicateOfRole.write(writer, instance.compoundPredicateOfRole)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'And' variant
     */
    public data class And(
        public val vec: List<CompoundPredicateOfRole>,
    ) : CompoundPredicateOfRole() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRole.And>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRole.And> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRole.And =
                try {
                    And(
                        reader.readVec(reader.readCompactInt()) { CompoundPredicateOfRole.read(reader) },
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRole.And,
            ): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        CompoundPredicateOfRole.write(writer, value)
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
        public val vec: List<CompoundPredicateOfRole>,
    ) : CompoundPredicateOfRole() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRole.Or>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRole.Or> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRole.Or =
                try {
                    Or(
                        reader.readVec(reader.readCompactInt()) { CompoundPredicateOfRole.read(reader) },
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRole.Or,
            ): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        CompoundPredicateOfRole.write(writer, value)
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<CompoundPredicateOfRole>,
        ScaleWriter<CompoundPredicateOfRole> {
        override fun read(reader: ScaleCodecReader): CompoundPredicateOfRole =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> Not.read(reader)
                2 -> And.read(reader)
                3 -> Or.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: CompoundPredicateOfRole,
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
