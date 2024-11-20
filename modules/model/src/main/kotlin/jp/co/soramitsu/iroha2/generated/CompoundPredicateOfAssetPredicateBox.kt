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
 * CompoundPredicateOfAssetPredicateBox
 *
 * Generated from 'CompoundPredicateOfAssetPredicateBox' enum
 */
public sealed class CompoundPredicateOfAssetPredicateBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(public val assetPredicateBox: AssetPredicateBox) : CompoundPredicateOfAssetPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAssetPredicateBox.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAssetPredicateBox.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAssetPredicateBox.Atom = try {
                Atom(
                    AssetPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAssetPredicateBox.Atom,
            ): Unit = try {
                AssetPredicateBox.write(writer, instance.assetPredicateBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Not' variant
     */
    public data class Not(public val compoundPredicateOfAssetPredicateBox: CompoundPredicateOfAssetPredicateBox) :
        CompoundPredicateOfAssetPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAssetPredicateBox.Not>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAssetPredicateBox.Not> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAssetPredicateBox.Not = try {
                Not(
                    CompoundPredicateOfAssetPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAssetPredicateBox.Not,
            ): Unit = try {
                CompoundPredicateOfAssetPredicateBox.write(
                    writer,
                    instance.compoundPredicateOfAssetPredicateBox,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'And' variant
     */
    public data class And(public val vec: List<CompoundPredicateOfAssetPredicateBox>) : CompoundPredicateOfAssetPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAssetPredicateBox.And>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAssetPredicateBox.And> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAssetPredicateBox.And = try {
                And(
                    reader.readVec(reader.readCompactInt()) { CompoundPredicateOfAssetPredicateBox.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAssetPredicateBox.And,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    CompoundPredicateOfAssetPredicateBox.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Or' variant
     */
    public data class Or(public val vec: List<CompoundPredicateOfAssetPredicateBox>) : CompoundPredicateOfAssetPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAssetPredicateBox.Or>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAssetPredicateBox.Or> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAssetPredicateBox.Or = try {
                Or(
                    reader.readVec(reader.readCompactInt()) { CompoundPredicateOfAssetPredicateBox.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CompoundPredicateOfAssetPredicateBox.Or,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    CompoundPredicateOfAssetPredicateBox.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<CompoundPredicateOfAssetPredicateBox>,
        ScaleWriter<CompoundPredicateOfAssetPredicateBox> {
        override fun read(reader: ScaleCodecReader): CompoundPredicateOfAssetPredicateBox = when (
            val
            discriminant = reader.readUByte()
        ) {
            0 -> Atom.read(reader)
            1 -> Not.read(reader)
            2 -> And.read(reader)
            3 -> Or.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: CompoundPredicateOfAssetPredicateBox) {
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
