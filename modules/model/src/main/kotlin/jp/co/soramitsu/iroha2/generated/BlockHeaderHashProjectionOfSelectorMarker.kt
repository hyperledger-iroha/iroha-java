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
 * BlockHeaderHashProjectionOfSelectorMarker
 *
 * Generated from 'BlockHeaderHashProjectionOfSelectorMarker' enum
 */
public sealed class BlockHeaderHashProjectionOfSelectorMarker : ModelEnum {
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
    public class Atom : BlockHeaderHashProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.BlockHeaderHashProjectionOfSelectorMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.BlockHeaderHashProjectionOfSelectorMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.BlockHeaderHashProjectionOfSelectorMarker.Atom =
                try {
                    Atom()
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.BlockHeaderHashProjectionOfSelectorMarker.Atom,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.BlockHeaderHashProjectionOfSelectorMarker.Atom, o2: Any?): Boolean =
                when (o2) {
                    null -> false
                    else -> o2::class == o1::class
                }

            override fun hashCode(): Int = ".BlockHeaderHashProjectionOfSelectorMarker.Atom".hashCode()
        }
    }

    public companion object :
        ScaleReader<BlockHeaderHashProjectionOfSelectorMarker>,
        ScaleWriter<BlockHeaderHashProjectionOfSelectorMarker> {
        override fun read(reader: ScaleCodecReader): BlockHeaderHashProjectionOfSelectorMarker =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(writer: ScaleCodecWriter, instance: BlockHeaderHashProjectionOfSelectorMarker) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Atom.write(writer, instance as Atom)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
