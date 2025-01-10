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
import java.math.BigInteger
import kotlin.Int
import kotlin.Unit

/**
 * SumeragiParameter
 *
 * Generated from 'SumeragiParameter' enum
 */
public sealed class SumeragiParameter : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'BlockTimeMs' variant
     */
    public data class BlockTimeMs(
        public val u64: BigInteger,
    ) : SumeragiParameter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SumeragiParameter.BlockTimeMs>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SumeragiParameter.BlockTimeMs> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SumeragiParameter.BlockTimeMs = try {
                BlockTimeMs(
                    reader.readUint64(),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SumeragiParameter.BlockTimeMs,
            ): Unit = try {
                writer.writeUint64(instance.u64)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'CommitTimeMs' variant
     */
    public data class CommitTimeMs(
        public val u64: BigInteger,
    ) : SumeragiParameter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SumeragiParameter.CommitTimeMs>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SumeragiParameter.CommitTimeMs> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SumeragiParameter.CommitTimeMs = try {
                CommitTimeMs(
                    reader.readUint64(),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SumeragiParameter.CommitTimeMs,
            ): Unit = try {
                writer.writeUint64(instance.u64)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'MaxClockDriftMs' variant
     */
    public data class MaxClockDriftMs(
        public val u64: BigInteger,
    ) : SumeragiParameter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SumeragiParameter.MaxClockDriftMs>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SumeragiParameter.MaxClockDriftMs> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SumeragiParameter.MaxClockDriftMs = try {
                MaxClockDriftMs(
                    reader.readUint64(),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SumeragiParameter.MaxClockDriftMs,
            ): Unit = try {
                writer.writeUint64(instance.u64)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<SumeragiParameter>, ScaleWriter<SumeragiParameter> {
        override fun read(reader: ScaleCodecReader): SumeragiParameter = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> BlockTimeMs.read(reader)
            1 -> CommitTimeMs.read(reader)
            2 -> MaxClockDriftMs.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: SumeragiParameter) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> BlockTimeMs.write(writer, instance as BlockTimeMs)
                1 -> CommitTimeMs.write(writer, instance as CommitTimeMs)
                2 -> MaxClockDriftMs.write(writer, instance as MaxClockDriftMs)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
