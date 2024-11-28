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
 * BlockHeaderProjectionOfSelectorMarker
 *
 * Generated from 'BlockHeaderProjectionOfSelectorMarker' enum
 */
public sealed class BlockHeaderProjectionOfSelectorMarker : ModelEnum {
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
    public class Atom : BlockHeaderProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.BlockHeaderProjectionOfSelectorMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.BlockHeaderProjectionOfSelectorMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.BlockHeaderProjectionOfSelectorMarker.Atom = try {
                Atom()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.BlockHeaderProjectionOfSelectorMarker.Atom,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.BlockHeaderProjectionOfSelectorMarker.Atom, o2: Any?): Boolean =
                when (o2) {
                    null -> false
                    else -> o2::class == o1::class
                }

            override fun hashCode(): Int = ".BlockHeaderProjectionOfSelectorMarker.Atom".hashCode()
        }
    }

    /**
     * 'Hash' variant
     */
    public data class Hash(public val blockHeaderHashProjectionOfSelectorMarker: BlockHeaderHashProjectionOfSelectorMarker) :
        BlockHeaderProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.BlockHeaderProjectionOfSelectorMarker.Hash>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.BlockHeaderProjectionOfSelectorMarker.Hash> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.BlockHeaderProjectionOfSelectorMarker.Hash = try {
                Hash(
                    BlockHeaderHashProjectionOfSelectorMarker.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.BlockHeaderProjectionOfSelectorMarker.Hash,
            ): Unit = try {
                BlockHeaderHashProjectionOfSelectorMarker.write(writer, instance.blockHeaderHashProjectionOfSelectorMarker)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<BlockHeaderProjectionOfSelectorMarker>,
        ScaleWriter<BlockHeaderProjectionOfSelectorMarker> {
        override fun read(reader: ScaleCodecReader): BlockHeaderProjectionOfSelectorMarker = when (val discriminant = reader.readUByte()) {
            0 -> Atom.read(reader)
            1 -> Hash.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: BlockHeaderProjectionOfSelectorMarker) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Atom.write(writer, instance as Atom)
                1 -> Hash.write(writer, instance as Hash)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
