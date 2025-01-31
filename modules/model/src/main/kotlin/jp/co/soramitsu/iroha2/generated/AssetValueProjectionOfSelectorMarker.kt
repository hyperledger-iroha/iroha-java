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
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Unit

/**
 * AssetValueProjectionOfSelectorMarker
 *
 * Generated from 'AssetValueProjectionOfSelectorMarker' enum
 */
public sealed class AssetValueProjectionOfSelectorMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    override fun equals(other: Any?): Boolean = when (this) {
        is Atom -> Atom.equals(this, other)
        else -> super.equals(other)
    }

    override fun hashCode(): Int = when (this) {
        is Atom -> Atom.hashCode()
        else -> super.hashCode()
    }

    /**
     * 'Atom' variant
     */
    public class Atom : AssetValueProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfSelectorMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfSelectorMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfSelectorMarker.Atom = try {
                Atom()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfSelectorMarker.Atom,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfSelectorMarker.Atom, o2: Any?): Boolean =
                when (o2) {
                    null -> false
                    else -> o2::class == o1::class
                }

            override fun hashCode(): Int = ".AssetValueProjectionOfSelectorMarker.Atom".hashCode()
        }
    }

    /**
     * 'Numeric' variant
     */
    public data class Numeric(public val numericProjectionOfSelectorMarker: NumericProjectionOfSelectorMarker) :
        AssetValueProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfSelectorMarker.Numeric>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfSelectorMarker.Numeric> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfSelectorMarker.Numeric =
                try {
                    Numeric(
                        NumericProjectionOfSelectorMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfSelectorMarker.Numeric,
            ): Unit = try {
                NumericProjectionOfSelectorMarker.write(writer, instance.numericProjectionOfSelectorMarker)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Store' variant
     */
    public data class Store(public val metadataProjectionOfSelectorMarker: MetadataProjectionOfSelectorMarker) :
        AssetValueProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfSelectorMarker.Store>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfSelectorMarker.Store> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfSelectorMarker.Store = try {
                Store(
                    MetadataProjectionOfSelectorMarker.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfSelectorMarker.Store,
            ): Unit = try {
                MetadataProjectionOfSelectorMarker.write(writer, instance.metadataProjectionOfSelectorMarker)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<AssetValueProjectionOfSelectorMarker>,
        ScaleWriter<AssetValueProjectionOfSelectorMarker> {
        override fun read(reader: ScaleCodecReader): AssetValueProjectionOfSelectorMarker = when (val discriminant = reader.readUByte()) {
            0 -> Atom.read(reader)
            1 -> Numeric.read(reader)
            2 -> Store.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: AssetValueProjectionOfSelectorMarker) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Atom.write(writer, instance as Atom)
                1 -> Numeric.write(writer, instance as Numeric)
                2 -> Store.write(writer, instance as Store)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
