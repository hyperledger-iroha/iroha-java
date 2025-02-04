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
 * BlockRejectionReason
 *
 * Generated from 'BlockRejectionReason' enum
 */
public sealed class BlockRejectionReason : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    override fun equals(other: Any?): Boolean =
        when (this) {
            is ConsensusBlockRejection -> ConsensusBlockRejection.equals(this, other)
            else -> super.equals(other)
        }

    override fun hashCode(): Int =
        when (this) {
            is ConsensusBlockRejection -> ConsensusBlockRejection.hashCode()
            else -> super.hashCode()
        }

    /**
     * 'ConsensusBlockRejection' variant
     */
    public class ConsensusBlockRejection : BlockRejectionReason() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.BlockRejectionReason.ConsensusBlockRejection>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.BlockRejectionReason.ConsensusBlockRejection> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.BlockRejectionReason.ConsensusBlockRejection =
                try {
                    ConsensusBlockRejection()
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.BlockRejectionReason.ConsensusBlockRejection,
            ): Unit =
                try {
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            public fun equals(
                o1: jp.co.soramitsu.iroha2.generated.BlockRejectionReason.ConsensusBlockRejection,
                o2: Any?,
            ): Boolean =
                when (o2) {
                    null -> false
                    else -> o2::class == o1::class
                }

            override fun hashCode(): Int = ".BlockRejectionReason.ConsensusBlockRejection".hashCode()
        }
    }

    public companion object : ScaleReader<BlockRejectionReason>, ScaleWriter<BlockRejectionReason> {
        override fun read(reader: ScaleCodecReader): BlockRejectionReason =
            when (val discriminant = reader.readUByte()) {
                0 -> ConsensusBlockRejection.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: BlockRejectionReason,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> ConsensusBlockRejection.write(writer, instance as ConsensusBlockRejection)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
