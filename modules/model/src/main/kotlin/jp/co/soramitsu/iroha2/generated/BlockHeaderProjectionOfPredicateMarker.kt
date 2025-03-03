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

/**
 * BlockHeaderProjectionOfPredicateMarker
 *
 * Generated from 'BlockHeaderProjectionOfPredicateMarker' enum
 */
public sealed class BlockHeaderProjectionOfPredicateMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(
        public val blockHeaderPredicateAtom: BlockHeaderPredicateAtom,
    ) : BlockHeaderProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.BlockHeaderProjectionOfPredicateMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.BlockHeaderProjectionOfPredicateMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.BlockHeaderProjectionOfPredicateMarker.Atom =
                try {
                    Atom(
                        BlockHeaderPredicateAtom.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.BlockHeaderProjectionOfPredicateMarker.Atom,
            ): Unit =
                try {
                    BlockHeaderPredicateAtom.write(writer, instance.blockHeaderPredicateAtom)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Hash' variant
     */
    public data class Hash(
        public val blockHeaderHashProjectionOfPredicateMarker: BlockHeaderHashProjectionOfPredicateMarker,
    ) : BlockHeaderProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.BlockHeaderProjectionOfPredicateMarker.Hash>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.BlockHeaderProjectionOfPredicateMarker.Hash> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.BlockHeaderProjectionOfPredicateMarker.Hash =
                try {
                    Hash(
                        BlockHeaderHashProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.BlockHeaderProjectionOfPredicateMarker.Hash,
            ): Unit =
                try {
                    BlockHeaderHashProjectionOfPredicateMarker.write(writer, instance.blockHeaderHashProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<BlockHeaderProjectionOfPredicateMarker>,
        ScaleWriter<BlockHeaderProjectionOfPredicateMarker> {
        override fun read(reader: ScaleCodecReader): BlockHeaderProjectionOfPredicateMarker =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> Hash.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: BlockHeaderProjectionOfPredicateMarker,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Atom.write(writer, instance as Atom)
                1 -> Hash.write(writer, instance as Hash)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
