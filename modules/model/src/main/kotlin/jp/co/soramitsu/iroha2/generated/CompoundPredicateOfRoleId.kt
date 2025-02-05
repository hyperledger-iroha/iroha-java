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
 * CompoundPredicateOfRoleId
 *
 * Generated from 'CompoundPredicateOfRoleId' enum
 */
public sealed class CompoundPredicateOfRoleId : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(
        public val roleIdProjectionOfPredicateMarker: RoleIdProjectionOfPredicateMarker,
    ) : CompoundPredicateOfRoleId() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRoleId.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRoleId.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRoleId.Atom =
                try {
                    Atom(
                        RoleIdProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRoleId.Atom,
            ): Unit =
                try {
                    RoleIdProjectionOfPredicateMarker.write(writer, instance.roleIdProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Not' variant
     */
    public data class Not(
        public val compoundPredicateOfRoleId: CompoundPredicateOfRoleId,
    ) : CompoundPredicateOfRoleId() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRoleId.Not>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRoleId.Not> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRoleId.Not =
                try {
                    Not(
                        CompoundPredicateOfRoleId.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRoleId.Not,
            ): Unit =
                try {
                    CompoundPredicateOfRoleId.write(writer, instance.compoundPredicateOfRoleId)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'And' variant
     */
    public data class And(
        public val vec: List<CompoundPredicateOfRoleId>,
    ) : CompoundPredicateOfRoleId() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRoleId.And>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRoleId.And> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRoleId.And =
                try {
                    And(
                        reader.readVec(reader.readCompactInt()) { CompoundPredicateOfRoleId.read(reader) },
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRoleId.And,
            ): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        CompoundPredicateOfRoleId.write(writer, value)
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
        public val vec: List<CompoundPredicateOfRoleId>,
    ) : CompoundPredicateOfRoleId() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRoleId.Or>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRoleId.Or> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRoleId.Or =
                try {
                    Or(
                        reader.readVec(reader.readCompactInt()) { CompoundPredicateOfRoleId.read(reader) },
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfRoleId.Or,
            ): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        CompoundPredicateOfRoleId.write(writer, value)
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<CompoundPredicateOfRoleId>,
        ScaleWriter<CompoundPredicateOfRoleId> {
        override fun read(reader: ScaleCodecReader): CompoundPredicateOfRoleId =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> Not.read(reader)
                2 -> And.read(reader)
                3 -> Or.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: CompoundPredicateOfRoleId,
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
