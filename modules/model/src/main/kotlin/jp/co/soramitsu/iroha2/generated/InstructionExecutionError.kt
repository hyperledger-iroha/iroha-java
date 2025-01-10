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
import kotlin.String
import kotlin.Unit

/**
 * InstructionExecutionError
 *
 * Generated from 'InstructionExecutionError' enum
 */
public sealed class InstructionExecutionError : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Evaluate' variant
     */
    public data class Evaluate(
        public val instructionEvaluationError: InstructionEvaluationError,
    ) : InstructionExecutionError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Evaluate>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Evaluate> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Evaluate = try {
                Evaluate(
                    InstructionEvaluationError.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Evaluate,
            ): Unit = try {
                InstructionEvaluationError.write(writer, instance.instructionEvaluationError)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Query' variant
     */
    public data class Query(
        public val queryExecutionFail: QueryExecutionFail,
    ) : InstructionExecutionError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Query>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Query> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Query = try {
                Query(
                    QueryExecutionFail.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Query,
            ): Unit = try {
                QueryExecutionFail.write(writer, instance.queryExecutionFail)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Conversion' variant
     */
    public data class Conversion(
        public val string: String,
    ) : InstructionExecutionError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Conversion>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Conversion> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Conversion = try {
                Conversion(
                    reader.readString(),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Conversion,
            ): Unit =
                try {
                    writer.writeAsList(instance.string.toByteArray(Charsets.UTF_8))
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Find' variant
     */
    public data class Find(
        public val findError: FindError,
    ) : InstructionExecutionError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Find>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Find> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Find = try {
                Find(
                    FindError.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Find,
            ): Unit = try {
                FindError.write(writer, instance.findError)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Repetition' variant
     */
    public data class Repetition(
        public val repetitionError: RepetitionError,
    ) : InstructionExecutionError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Repetition>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Repetition> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Repetition = try {
                Repetition(
                    RepetitionError.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Repetition,
            ): Unit =
                try {
                    RepetitionError.write(writer, instance.repetitionError)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Mintability' variant
     */
    public data class Mintability(
        public val mintabilityError: MintabilityError,
    ) : InstructionExecutionError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Mintability>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Mintability> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Mintability = try {
                Mintability(
                    MintabilityError.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Mintability,
            ): Unit =
                try {
                    MintabilityError.write(writer, instance.mintabilityError)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Math' variant
     */
    public data class Math(
        public val mathError: MathError,
    ) : InstructionExecutionError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Math>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Math> {
            public const val DISCRIMINANT: Int = 6

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Math = try {
                Math(
                    MathError.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.InstructionExecutionError.Math,
            ): Unit = try {
                MathError.write(writer, instance.mathError)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'InvalidParameter' variant
     */
    public data class InvalidParameter(
        public val invalidParameterError: InvalidParameterError,
    ) : InstructionExecutionError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.InstructionExecutionError.InvalidParameter>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.InstructionExecutionError.InvalidParameter> {
            public const val DISCRIMINANT: Int = 7

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.InstructionExecutionError.InvalidParameter = try {
                InvalidParameter(
                    InvalidParameterError.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.InstructionExecutionError.InvalidParameter,
            ): Unit = try {
                InvalidParameterError.write(writer, instance.invalidParameterError)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'InvariantViolation' variant
     */
    public data class InvariantViolation(
        public val string: String,
    ) : InstructionExecutionError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.InstructionExecutionError.InvariantViolation>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.InstructionExecutionError.InvariantViolation> {
            public const val DISCRIMINANT: Int = 8

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.InstructionExecutionError.InvariantViolation = try {
                InvariantViolation(
                    reader.readString(),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.InstructionExecutionError.InvariantViolation,
            ): Unit = try {
                writer.writeAsList(instance.string.toByteArray(Charsets.UTF_8))
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<InstructionExecutionError>,
        ScaleWriter<InstructionExecutionError> {
        override fun read(reader: ScaleCodecReader): InstructionExecutionError = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Evaluate.read(reader)
            1 -> Query.read(reader)
            2 -> Conversion.read(reader)
            3 -> Find.read(reader)
            4 -> Repetition.read(reader)
            5 -> Mintability.read(reader)
            6 -> Math.read(reader)
            7 -> InvalidParameter.read(reader)
            8 -> InvariantViolation.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: InstructionExecutionError) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Evaluate.write(writer, instance as Evaluate)
                1 -> Query.write(writer, instance as Query)
                2 -> Conversion.write(writer, instance as Conversion)
                3 -> Find.write(writer, instance as Find)
                4 -> Repetition.write(writer, instance as Repetition)
                5 -> Mintability.write(writer, instance as Mintability)
                6 -> Math.write(writer, instance as Math)
                7 -> InvalidParameter.write(writer, instance as InvalidParameter)
                8 -> InvariantViolation.write(writer, instance as InvariantViolation)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
