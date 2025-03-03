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
 * CompoundPredicateOfAsset
 *
 * Generated from 'CompoundPredicateOfAsset' enum
 */
public sealed class CompoundPredicateOfAsset : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(
        public val assetProjectionOfPredicateMarker: AssetProjectionOfPredicateMarker,
    ) : CompoundPredicateOfAsset() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAsset.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAsset.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAsset.Atom =
                try {
                    Atom(
                        AssetProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAsset.Atom,
            ): Unit =
                try {
                    AssetProjectionOfPredicateMarker.write(writer, instance.assetProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Not' variant
     */
    public data class Not(
        public val compoundPredicateOfAsset: CompoundPredicateOfAsset,
    ) : CompoundPredicateOfAsset() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAsset.Not>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAsset.Not> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAsset.Not =
                try {
                    Not(
                        CompoundPredicateOfAsset.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAsset.Not,
            ): Unit =
                try {
                    CompoundPredicateOfAsset.write(writer, instance.compoundPredicateOfAsset)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'And' variant
     */
    public data class And(
        public val vec: List<CompoundPredicateOfAsset>,
    ) : CompoundPredicateOfAsset() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAsset.And>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAsset.And> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAsset.And =
                try {
                    And(
                        reader.readVec(reader.readCompactInt()) { CompoundPredicateOfAsset.read(reader) },
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAsset.And,
            ): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        CompoundPredicateOfAsset.write(writer, value)
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
        public val vec: List<CompoundPredicateOfAsset>,
    ) : CompoundPredicateOfAsset() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAsset.Or>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAsset.Or> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAsset.Or =
                try {
                    Or(
                        reader.readVec(reader.readCompactInt()) { CompoundPredicateOfAsset.read(reader) },
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAsset.Or,
            ): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        CompoundPredicateOfAsset.write(writer, value)
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<CompoundPredicateOfAsset>,
        ScaleWriter<CompoundPredicateOfAsset> {
        override fun read(reader: ScaleCodecReader): CompoundPredicateOfAsset =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> Not.read(reader)
                2 -> And.read(reader)
                3 -> Or.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: CompoundPredicateOfAsset,
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
