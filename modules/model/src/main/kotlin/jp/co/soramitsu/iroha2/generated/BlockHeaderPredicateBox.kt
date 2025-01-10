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
 * BlockHeaderPredicateBox
 *
 * Generated from 'BlockHeaderPredicateBox' enum
 */
public sealed class BlockHeaderPredicateBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Hash' variant
     */
    public data class Hash(
        public val blockHashPredicateBox: BlockHashPredicateBox,
    ) : BlockHeaderPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.BlockHeaderPredicateBox.Hash>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.BlockHeaderPredicateBox.Hash> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.BlockHeaderPredicateBox.Hash = try {
                Hash(
                    BlockHashPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.BlockHeaderPredicateBox.Hash,
            ): Unit = try {
                BlockHashPredicateBox.write(writer, instance.blockHashPredicateBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<BlockHeaderPredicateBox>,
        ScaleWriter<BlockHeaderPredicateBox> {
        override fun read(reader: ScaleCodecReader): BlockHeaderPredicateBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Hash.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: BlockHeaderPredicateBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Hash.write(writer, instance as Hash)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
