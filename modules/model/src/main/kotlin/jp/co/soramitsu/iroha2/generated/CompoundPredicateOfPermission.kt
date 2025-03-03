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
 * CompoundPredicateOfPermission
 *
 * Generated from 'CompoundPredicateOfPermission' enum
 */
public sealed class CompoundPredicateOfPermission : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(
        public val permissionProjectionOfPredicateMarker: PermissionProjectionOfPredicateMarker,
    ) : CompoundPredicateOfPermission() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPermission.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPermission.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPermission.Atom =
                try {
                    Atom(
                        PermissionProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPermission.Atom,
            ): Unit =
                try {
                    PermissionProjectionOfPredicateMarker.write(writer, instance.permissionProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Not' variant
     */
    public data class Not(
        public val compoundPredicateOfPermission: CompoundPredicateOfPermission,
    ) : CompoundPredicateOfPermission() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPermission.Not>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPermission.Not> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPermission.Not =
                try {
                    Not(
                        CompoundPredicateOfPermission.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPermission.Not,
            ): Unit =
                try {
                    CompoundPredicateOfPermission.write(writer, instance.compoundPredicateOfPermission)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'And' variant
     */
    public data class And(
        public val vec: List<CompoundPredicateOfPermission>,
    ) : CompoundPredicateOfPermission() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPermission.And>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPermission.And> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPermission.And =
                try {
                    And(
                        reader.readVec(reader.readCompactInt()) { CompoundPredicateOfPermission.read(reader) },
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPermission.And,
            ): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        CompoundPredicateOfPermission.write(writer, value)
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
        public val vec: List<CompoundPredicateOfPermission>,
    ) : CompoundPredicateOfPermission() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPermission.Or>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPermission.Or> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPermission.Or =
                try {
                    Or(
                        reader.readVec(reader.readCompactInt()) { CompoundPredicateOfPermission.read(reader) },
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPermission.Or,
            ): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        CompoundPredicateOfPermission.write(writer, value)
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<CompoundPredicateOfPermission>,
        ScaleWriter<CompoundPredicateOfPermission> {
        override fun read(reader: ScaleCodecReader): CompoundPredicateOfPermission =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> Not.read(reader)
                2 -> And.read(reader)
                3 -> Or.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: CompoundPredicateOfPermission,
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
