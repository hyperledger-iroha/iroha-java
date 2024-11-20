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
 * TriggerCompletedOutcomeType
 *
 * Generated from 'TriggerCompletedOutcomeType' enum
 */
public sealed class TriggerCompletedOutcomeType : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    override fun equals(other: Any?): Boolean = when (this) {
        is Success -> Success.equals(this, other)
        is Failure -> Failure.equals(this, other)
        else -> super.equals(other)
    }

    override fun hashCode(): Int = when (this) {
        is Success -> Success.hashCode()
        is Failure -> Failure.hashCode()
        else -> super.hashCode()
    }

    /**
     * 'Success' variant
     */
    public class Success : TriggerCompletedOutcomeType() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TriggerCompletedOutcomeType.Success>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TriggerCompletedOutcomeType.Success> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TriggerCompletedOutcomeType.Success = try {
                Success()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TriggerCompletedOutcomeType.Success,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.TriggerCompletedOutcomeType.Success, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".TriggerCompletedOutcomeType.Success".hashCode()
        }
    }

    /**
     * 'Failure' variant
     */
    public class Failure : TriggerCompletedOutcomeType() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TriggerCompletedOutcomeType.Failure>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TriggerCompletedOutcomeType.Failure> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TriggerCompletedOutcomeType.Failure = try {
                Failure()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TriggerCompletedOutcomeType.Failure,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.TriggerCompletedOutcomeType.Failure, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".TriggerCompletedOutcomeType.Failure".hashCode()
        }
    }

    public companion object :
        ScaleReader<TriggerCompletedOutcomeType>,
        ScaleWriter<TriggerCompletedOutcomeType> {
        override fun read(reader: ScaleCodecReader): TriggerCompletedOutcomeType = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Success.read(reader)
            1 -> Failure.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: TriggerCompletedOutcomeType) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Success.write(writer, instance as Success)
                1 -> Failure.write(writer, instance as Failure)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
