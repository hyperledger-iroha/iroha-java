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
 * TransactionStatus
 *
 * Generated from 'TransactionStatus' enum
 */
public sealed class TransactionStatus : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    override fun equals(other: Any?): Boolean = when (this) {
        is Queued -> Queued.equals(this, other)
        is Expired -> Expired.equals(this, other)
        is Approved -> Approved.equals(this, other)
        else -> super.equals(other) }

    override fun hashCode(): Int = when (this) {
        is Queued -> Queued.hashCode()
        is Expired -> Expired.hashCode()
        is Approved -> Approved.hashCode()
        else -> super.hashCode() }

    /**
     * 'Queued' variant
     */
    public class Queued : TransactionStatus() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TransactionStatus.Queued>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TransactionStatus.Queued> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TransactionStatus.Queued = try {
                Queued()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TransactionStatus.Queued,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.TransactionStatus.Queued, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".TransactionStatus.Queued".hashCode()
        }
    }

    /**
     * 'Expired' variant
     */
    public class Expired : TransactionStatus() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TransactionStatus.Expired>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TransactionStatus.Expired> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TransactionStatus.Expired = try {
                Expired()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TransactionStatus.Expired,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.TransactionStatus.Expired, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".TransactionStatus.Expired".hashCode()
        }
    }

    /**
     * 'Approved' variant
     */
    public class Approved : TransactionStatus() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TransactionStatus.Approved>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TransactionStatus.Approved> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TransactionStatus.Approved = try {
                Approved()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TransactionStatus.Approved,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.TransactionStatus.Approved, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".TransactionStatus.Approved".hashCode()
        }
    }

    /**
     * 'Rejected' variant
     */
    public data class Rejected(
        public val transactionRejectionReason: TransactionRejectionReason,
    ) : TransactionStatus() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TransactionStatus.Rejected>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TransactionStatus.Rejected> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TransactionStatus.Rejected = try {
                Rejected(
                    TransactionRejectionReason.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TransactionStatus.Rejected,
            ): Unit = try {
                TransactionRejectionReason.write(writer, instance.transactionRejectionReason)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<TransactionStatus>, ScaleWriter<TransactionStatus> {
        override fun read(reader: ScaleCodecReader): TransactionStatus = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Queued.read(reader)
            1 -> Expired.read(reader)
            2 -> Approved.read(reader)
            3 -> Rejected.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: TransactionStatus) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Queued.write(writer, instance as Queued)
                1 -> Expired.write(writer, instance as Expired)
                2 -> Approved.write(writer, instance as Approved)
                3 -> Rejected.write(writer, instance as Rejected)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
