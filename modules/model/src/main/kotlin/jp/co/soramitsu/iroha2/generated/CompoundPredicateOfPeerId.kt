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
 * CompoundPredicateOfPeerId
 *
 * Generated from 'CompoundPredicateOfPeerId' enum
 */
public sealed class CompoundPredicateOfPeerId : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(public val peerIdProjectionOfPredicateMarker: PeerIdProjectionOfPredicateMarker) : CompoundPredicateOfPeerId() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPeerId.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPeerId.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPeerId.Atom = try {
                Atom(
                    PeerIdProjectionOfPredicateMarker.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPeerId.Atom): Unit =
                try {
                    PeerIdProjectionOfPredicateMarker.write(writer, instance.peerIdProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Not' variant
     */
    public data class Not(public val compoundPredicateOfPeerId: CompoundPredicateOfPeerId) : CompoundPredicateOfPeerId() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPeerId.Not>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPeerId.Not> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPeerId.Not = try {
                Not(
                    CompoundPredicateOfPeerId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPeerId.Not): Unit =
                try {
                    CompoundPredicateOfPeerId.write(writer, instance.compoundPredicateOfPeerId)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'And' variant
     */
    public data class And(public val vec: List<CompoundPredicateOfPeerId>) : CompoundPredicateOfPeerId() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPeerId.And>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPeerId.And> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPeerId.And = try {
                And(
                    reader.readVec(reader.readCompactInt()) { CompoundPredicateOfPeerId.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPeerId.And): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        CompoundPredicateOfPeerId.write(writer, value)
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Or' variant
     */
    public data class Or(public val vec: List<CompoundPredicateOfPeerId>) : CompoundPredicateOfPeerId() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPeerId.Or>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPeerId.Or> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPeerId.Or = try {
                Or(
                    reader.readVec(reader.readCompactInt()) { CompoundPredicateOfPeerId.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfPeerId.Or): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        CompoundPredicateOfPeerId.write(writer, value)
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<CompoundPredicateOfPeerId>,
        ScaleWriter<CompoundPredicateOfPeerId> {
        override fun read(reader: ScaleCodecReader): CompoundPredicateOfPeerId = when (val discriminant = reader.readUByte()) {
            0 -> Atom.read(reader)
            1 -> Not.read(reader)
            2 -> And.read(reader)
            3 -> Or.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: CompoundPredicateOfPeerId) {
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
