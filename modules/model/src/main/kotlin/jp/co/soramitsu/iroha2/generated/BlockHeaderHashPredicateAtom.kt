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
 * BlockHeaderHashPredicateAtom
 *
 * Generated from 'BlockHeaderHashPredicateAtom' enum
 */
public sealed class BlockHeaderHashPredicateAtom : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Equals' variant
     */
    public data class Equals(public val hashOf: HashOf<BlockHeader>) : BlockHeaderHashPredicateAtom() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.BlockHeaderHashPredicateAtom.Equals>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.BlockHeaderHashPredicateAtom.Equals> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.BlockHeaderHashPredicateAtom.Equals = try {
                Equals(
                    HashOf.read(reader) as HashOf<BlockHeader>,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.BlockHeaderHashPredicateAtom.Equals,
            ): Unit = try {
                HashOf.write(writer, instance.hashOf)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<BlockHeaderHashPredicateAtom>,
        ScaleWriter<BlockHeaderHashPredicateAtom> {
        override fun read(reader: ScaleCodecReader): BlockHeaderHashPredicateAtom = when (val discriminant = reader.readUByte()) {
            0 -> Equals.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: BlockHeaderHashPredicateAtom) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Equals.write(writer, instance as Equals)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
