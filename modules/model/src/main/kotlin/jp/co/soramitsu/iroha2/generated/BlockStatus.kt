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
 * BlockStatus
 *
 * Generated from 'BlockStatus' enum
 */
public sealed class BlockStatus : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    override fun equals(other: Any?): Boolean = when (this) {
        is Approved -> Approved.equals(this, other)
        is Committed -> Committed.equals(this, other)
        is Applied -> Applied.equals(this, other)
        else -> super.equals(other) }

    override fun hashCode(): Int = when (this) {
        is Approved -> Approved.hashCode()
        is Committed -> Committed.hashCode()
        is Applied -> Applied.hashCode()
        else -> super.hashCode() }

    /**
     * 'Approved' variant
     */
    public class Approved : BlockStatus() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.BlockStatus.Approved>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.BlockStatus.Approved> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.BlockStatus.Approved = try {
                Approved()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.BlockStatus.Approved,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.BlockStatus.Approved, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".BlockStatus.Approved".hashCode()
        }
    }

    /**
     * 'Rejected' variant
     */
    public data class Rejected(
        public val blockRejectionReason: BlockRejectionReason,
    ) : BlockStatus() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.BlockStatus.Rejected>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.BlockStatus.Rejected> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.BlockStatus.Rejected = try {
                Rejected(
                    BlockRejectionReason.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.BlockStatus.Rejected,
            ): Unit = try {
                BlockRejectionReason.write(writer, instance.blockRejectionReason)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Committed' variant
     */
    public class Committed : BlockStatus() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.BlockStatus.Committed>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.BlockStatus.Committed> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.BlockStatus.Committed = try {
                Committed()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.BlockStatus.Committed,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.BlockStatus.Committed, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".BlockStatus.Committed".hashCode()
        }
    }

    /**
     * 'Applied' variant
     */
    public class Applied : BlockStatus() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.BlockStatus.Applied>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.BlockStatus.Applied> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.BlockStatus.Applied = try {
                Applied()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.BlockStatus.Applied,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.BlockStatus.Applied, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".BlockStatus.Applied".hashCode()
        }
    }

    public companion object : ScaleReader<BlockStatus>, ScaleWriter<BlockStatus> {
        override fun read(reader: ScaleCodecReader): BlockStatus = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Approved.read(reader)
            1 -> Rejected.read(reader)
            2 -> Committed.read(reader)
            3 -> Applied.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: BlockStatus) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Approved.write(writer, instance as Approved)
                1 -> Rejected.write(writer, instance as Rejected)
                2 -> Committed.write(writer, instance as Committed)
                3 -> Applied.write(writer, instance as Applied)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
