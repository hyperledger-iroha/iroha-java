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
import kotlin.Unit

/**
 * TransactionRejectionReason
 *
 * Generated from 'TransactionRejectionReason' enum
 */
public sealed class TransactionRejectionReason : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'AccountDoesNotExist' variant
     */
    public data class AccountDoesNotExist(
        public val findError: FindError,
    ) : TransactionRejectionReason() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TransactionRejectionReason.AccountDoesNotExist>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TransactionRejectionReason.AccountDoesNotExist> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TransactionRejectionReason.AccountDoesNotExist = try {
                AccountDoesNotExist(
                    FindError.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TransactionRejectionReason.AccountDoesNotExist,
            ): Unit = try {
                FindError.write(writer, instance.findError)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'LimitCheck' variant
     */
    public data class LimitCheck(
        public val transactionLimitError: TransactionLimitError,
    ) : TransactionRejectionReason() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TransactionRejectionReason.LimitCheck>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TransactionRejectionReason.LimitCheck> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TransactionRejectionReason.LimitCheck = try {
                LimitCheck(
                    TransactionLimitError.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TransactionRejectionReason.LimitCheck,
            ): Unit =
                try {
                    TransactionLimitError.write(writer, instance.transactionLimitError)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Validation' variant
     */
    public data class Validation(
        public val validationFail: ValidationFail,
    ) : TransactionRejectionReason() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TransactionRejectionReason.Validation>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TransactionRejectionReason.Validation> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TransactionRejectionReason.Validation = try {
                Validation(
                    ValidationFail.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TransactionRejectionReason.Validation,
            ): Unit =
                try {
                    ValidationFail.write(writer, instance.validationFail)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'InstructionExecution' variant
     */
    public data class InstructionExecution(
        public val instructionExecutionFail: InstructionExecutionFail,
    ) : TransactionRejectionReason() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TransactionRejectionReason.InstructionExecution>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TransactionRejectionReason.InstructionExecution> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TransactionRejectionReason.InstructionExecution = try {
                InstructionExecution(
                    InstructionExecutionFail.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TransactionRejectionReason.InstructionExecution,
            ): Unit = try {
                InstructionExecutionFail.write(writer, instance.instructionExecutionFail)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'WasmExecution' variant
     */
    public data class WasmExecution(
        public val wasmExecutionFail: WasmExecutionFail,
    ) : TransactionRejectionReason() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TransactionRejectionReason.WasmExecution>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TransactionRejectionReason.WasmExecution> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TransactionRejectionReason.WasmExecution = try {
                WasmExecution(
                    WasmExecutionFail.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TransactionRejectionReason.WasmExecution,
            ): Unit = try {
                WasmExecutionFail.write(writer, instance.wasmExecutionFail)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<TransactionRejectionReason>,
        ScaleWriter<TransactionRejectionReason> {
        override fun read(reader: ScaleCodecReader): TransactionRejectionReason = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> AccountDoesNotExist.read(reader)
            1 -> LimitCheck.read(reader)
            2 -> Validation.read(reader)
            3 -> InstructionExecution.read(reader)
            4 -> WasmExecution.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: TransactionRejectionReason) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> AccountDoesNotExist.write(writer, instance as AccountDoesNotExist)
                1 -> LimitCheck.write(writer, instance as LimitCheck)
                2 -> Validation.write(writer, instance as Validation)
                3 -> InstructionExecution.write(writer, instance as InstructionExecution)
                4 -> WasmExecution.write(writer, instance as WasmExecution)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
