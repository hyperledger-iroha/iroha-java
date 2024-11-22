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
 * ExecutionTime
 *
 * Generated from 'ExecutionTime' enum
 */
public sealed class ExecutionTime : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    override fun equals(other: Any?): Boolean = when (this) {
        is PreCommit -> PreCommit.equals(this, other)
        else -> super.equals(other)
    }

    override fun hashCode(): Int = when (this) {
        is PreCommit -> PreCommit.hashCode()
        else -> super.hashCode()
    }

    /**
     * 'PreCommit' variant
     */
    public class PreCommit : ExecutionTime() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.ExecutionTime.PreCommit>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.ExecutionTime.PreCommit> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.ExecutionTime.PreCommit = try {
                PreCommit()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.ExecutionTime.PreCommit): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.ExecutionTime.PreCommit, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".ExecutionTime.PreCommit".hashCode()
        }
    }

    /**
     * 'Schedule' variant
     */
    public data class Schedule(public val schedule: jp.co.soramitsu.iroha2.generated.Schedule) : ExecutionTime() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.ExecutionTime.Schedule>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.ExecutionTime.Schedule> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.ExecutionTime.Schedule = try {
                Schedule(
                    jp.co.soramitsu.iroha2.generated.Schedule.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.ExecutionTime.Schedule): Unit = try {
                jp.co.soramitsu.iroha2.generated.Schedule.write(writer, instance.schedule)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<ExecutionTime>, ScaleWriter<ExecutionTime> {
        override fun read(reader: ScaleCodecReader): ExecutionTime = when (val discriminant = reader.readUByte()) {
            0 -> PreCommit.read(reader)
            1 -> Schedule.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: ExecutionTime) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> PreCommit.write(writer, instance as PreCommit)
                1 -> Schedule.write(writer, instance as Schedule)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
