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
 * InstructionEvaluationError
 *
 * Generated from 'InstructionEvaluationError' enum
 */
public sealed class InstructionEvaluationError : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Unsupported' variant
     */
    public data class Unsupported(
        public val instructionType: InstructionType,
    ) : InstructionEvaluationError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.InstructionEvaluationError.Unsupported>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.InstructionEvaluationError.Unsupported> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.InstructionEvaluationError.Unsupported = try {
                Unsupported(
                    InstructionType.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.InstructionEvaluationError.Unsupported,
            ): Unit =
                try {
                    InstructionType.write(writer, instance.instructionType)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'PermissionParameter' variant
     */
    public data class PermissionParameter(
        public val string: String,
    ) : InstructionEvaluationError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.InstructionEvaluationError.PermissionParameter>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.InstructionEvaluationError.PermissionParameter> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.InstructionEvaluationError.PermissionParameter = try {
                PermissionParameter(
                    reader.readString(),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.InstructionEvaluationError.PermissionParameter,
            ): Unit = try {
                writer.writeAsList(instance.string.toByteArray(Charsets.UTF_8))
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Type' variant
     */
    public data class Type(
        public val typeError: TypeError,
    ) : InstructionEvaluationError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.InstructionEvaluationError.Type>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.InstructionEvaluationError.Type> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.InstructionEvaluationError.Type = try {
                Type(
                    TypeError.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.InstructionEvaluationError.Type,
            ): Unit = try {
                TypeError.write(writer, instance.typeError)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<InstructionEvaluationError>,
        ScaleWriter<InstructionEvaluationError> {
        override fun read(reader: ScaleCodecReader): InstructionEvaluationError = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Unsupported.read(reader)
            1 -> PermissionParameter.read(reader)
            2 -> Type.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: InstructionEvaluationError) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Unsupported.write(writer, instance as Unsupported)
                1 -> PermissionParameter.write(writer, instance as PermissionParameter)
                2 -> Type.write(writer, instance as Type)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
