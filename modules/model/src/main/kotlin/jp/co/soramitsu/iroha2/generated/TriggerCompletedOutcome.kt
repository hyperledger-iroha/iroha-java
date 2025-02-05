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
import kotlin.String
import kotlin.Unit

/**
 * TriggerCompletedOutcome
 *
 * Generated from 'TriggerCompletedOutcome' enum
 */
public sealed class TriggerCompletedOutcome : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    override fun equals(other: Any?): Boolean =
        when (this) {
            is Success -> Success.equals(this, other)
            else -> super.equals(other)
        }

    override fun hashCode(): Int =
        when (this) {
            is Success -> Success.hashCode()
            else -> super.hashCode()
        }

    /**
     * 'Success' variant
     */
    public class Success : TriggerCompletedOutcome() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TriggerCompletedOutcome.Success>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TriggerCompletedOutcome.Success> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TriggerCompletedOutcome.Success =
                try {
                    Success()
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TriggerCompletedOutcome.Success,
            ): Unit =
                try {
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            public fun equals(
                o1: jp.co.soramitsu.iroha2.generated.TriggerCompletedOutcome.Success,
                o2: Any?,
            ): Boolean =
                when (o2) {
                    null -> false
                    else -> o2::class == o1::class
                }

            override fun hashCode(): Int = ".TriggerCompletedOutcome.Success".hashCode()
        }
    }

    /**
     * 'Failure' variant
     */
    public data class Failure(
        public val string: String,
    ) : TriggerCompletedOutcome() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TriggerCompletedOutcome.Failure>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TriggerCompletedOutcome.Failure> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TriggerCompletedOutcome.Failure =
                try {
                    Failure(
                        reader.readString(),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TriggerCompletedOutcome.Failure,
            ): Unit =
                try {
                    writer.writeAsList(instance.string.toByteArray(Charsets.UTF_8))
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<TriggerCompletedOutcome>,
        ScaleWriter<TriggerCompletedOutcome> {
        override fun read(reader: ScaleCodecReader): TriggerCompletedOutcome =
            when (val discriminant = reader.readUByte()) {
                0 -> Success.read(reader)
                1 -> Failure.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: TriggerCompletedOutcome,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Success.write(writer, instance as Success)
                1 -> Failure.write(writer, instance as Failure)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
