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
 * ValidationFail
 *
 * Generated from 'ValidationFail' enum
 */
public sealed class ValidationFail : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    override fun equals(other: Any?): Boolean =
        when (this) {
            is TooComplex -> TooComplex.equals(this, other)
            is InternalError -> InternalError.equals(this, other)
            else -> super.equals(other)
        }

    override fun hashCode(): Int =
        when (this) {
            is TooComplex -> TooComplex.hashCode()
            is InternalError -> InternalError.hashCode()
            else -> super.hashCode()
        }

    /**
     * 'NotPermitted' variant
     */
    public data class NotPermitted(
        public val string: String,
    ) : ValidationFail() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.ValidationFail.NotPermitted>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.ValidationFail.NotPermitted> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.ValidationFail.NotPermitted =
                try {
                    NotPermitted(
                        reader.readString(),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.ValidationFail.NotPermitted,
            ): Unit =
                try {
                    writer.writeAsList(instance.string.toByteArray(Charsets.UTF_8))
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'InstructionFailed' variant
     */
    public data class InstructionFailed(
        public val instructionExecutionError: InstructionExecutionError,
    ) : ValidationFail() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.ValidationFail.InstructionFailed>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.ValidationFail.InstructionFailed> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.ValidationFail.InstructionFailed =
                try {
                    InstructionFailed(
                        InstructionExecutionError.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.ValidationFail.InstructionFailed,
            ): Unit =
                try {
                    InstructionExecutionError.write(writer, instance.instructionExecutionError)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'QueryFailed' variant
     */
    public data class QueryFailed(
        public val queryExecutionFail: QueryExecutionFail,
    ) : ValidationFail() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.ValidationFail.QueryFailed>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.ValidationFail.QueryFailed> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.ValidationFail.QueryFailed =
                try {
                    QueryFailed(
                        QueryExecutionFail.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.ValidationFail.QueryFailed,
            ): Unit =
                try {
                    QueryExecutionFail.write(writer, instance.queryExecutionFail)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'TooComplex' variant
     */
    public class TooComplex : ValidationFail() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.ValidationFail.TooComplex>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.ValidationFail.TooComplex> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.ValidationFail.TooComplex =
                try {
                    TooComplex()
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.ValidationFail.TooComplex,
            ): Unit =
                try {
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            public fun equals(
                o1: jp.co.soramitsu.iroha2.generated.ValidationFail.TooComplex,
                o2: Any?,
            ): Boolean =
                when (o2) {
                    null -> false
                    else -> o2::class == o1::class
                }

            override fun hashCode(): Int = ".ValidationFail.TooComplex".hashCode()
        }
    }

    /**
     * 'InternalError' variant
     */
    public class InternalError : ValidationFail() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.ValidationFail.InternalError>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.ValidationFail.InternalError> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.ValidationFail.InternalError =
                try {
                    InternalError()
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.ValidationFail.InternalError,
            ): Unit =
                try {
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            public fun equals(
                o1: jp.co.soramitsu.iroha2.generated.ValidationFail.InternalError,
                o2: Any?,
            ): Boolean =
                when (o2) {
                    null -> false
                    else -> o2::class == o1::class
                }

            override fun hashCode(): Int = ".ValidationFail.InternalError".hashCode()
        }
    }

    public companion object : ScaleReader<ValidationFail>, ScaleWriter<ValidationFail> {
        override fun read(reader: ScaleCodecReader): ValidationFail =
            when (val discriminant = reader.readUByte()) {
                0 -> NotPermitted.read(reader)
                1 -> InstructionFailed.read(reader)
                2 -> QueryFailed.read(reader)
                3 -> TooComplex.read(reader)
                4 -> InternalError.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: ValidationFail,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> NotPermitted.write(writer, instance as NotPermitted)
                1 -> InstructionFailed.write(writer, instance as InstructionFailed)
                2 -> QueryFailed.write(writer, instance as QueryFailed)
                3 -> TooComplex.write(writer, instance as TooComplex)
                4 -> InternalError.write(writer, instance as InternalError)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
