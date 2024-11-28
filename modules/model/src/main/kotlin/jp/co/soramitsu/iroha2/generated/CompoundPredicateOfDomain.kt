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
 * CompoundPredicateOfDomain
 *
 * Generated from 'CompoundPredicateOfDomain' enum
 */
public sealed class CompoundPredicateOfDomain : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(public val domainProjectionOfPredicateMarker: DomainProjectionOfPredicateMarker) : CompoundPredicateOfDomain() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfDomain.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfDomain.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfDomain.Atom = try {
                Atom(
                    DomainProjectionOfPredicateMarker.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfDomain.Atom): Unit =
                try {
                    DomainProjectionOfPredicateMarker.write(writer, instance.domainProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Not' variant
     */
    public data class Not(public val compoundPredicateOfDomain: CompoundPredicateOfDomain) : CompoundPredicateOfDomain() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfDomain.Not>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfDomain.Not> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfDomain.Not = try {
                Not(
                    CompoundPredicateOfDomain.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfDomain.Not): Unit =
                try {
                    CompoundPredicateOfDomain.write(writer, instance.compoundPredicateOfDomain)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'And' variant
     */
    public data class And(public val vec: List<CompoundPredicateOfDomain>) : CompoundPredicateOfDomain() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfDomain.And>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfDomain.And> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfDomain.And = try {
                And(
                    reader.readVec(reader.readCompactInt()) { CompoundPredicateOfDomain.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfDomain.And): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        CompoundPredicateOfDomain.write(writer, value)
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Or' variant
     */
    public data class Or(public val vec: List<CompoundPredicateOfDomain>) : CompoundPredicateOfDomain() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfDomain.Or>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfDomain.Or> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfDomain.Or = try {
                Or(
                    reader.readVec(reader.readCompactInt()) { CompoundPredicateOfDomain.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfDomain.Or): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        CompoundPredicateOfDomain.write(writer, value)
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<CompoundPredicateOfDomain>,
        ScaleWriter<CompoundPredicateOfDomain> {
        override fun read(reader: ScaleCodecReader): CompoundPredicateOfDomain = when (val discriminant = reader.readUByte()) {
            0 -> Atom.read(reader)
            1 -> Not.read(reader)
            2 -> And.read(reader)
            3 -> Or.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: CompoundPredicateOfDomain) {
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
