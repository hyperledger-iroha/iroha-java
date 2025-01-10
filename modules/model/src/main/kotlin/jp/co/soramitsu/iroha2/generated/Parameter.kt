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
 * Parameter
 *
 * Generated from 'Parameter' enum
 */
public sealed class Parameter : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Sumeragi' variant
     */
    public data class Sumeragi(
        public val sumeragiParameter: SumeragiParameter,
    ) : Parameter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.Parameter.Sumeragi>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.Parameter.Sumeragi> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.Parameter.Sumeragi = try {
                Sumeragi(
                    SumeragiParameter.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.Parameter.Sumeragi,
            ): Unit = try {
                SumeragiParameter.write(writer, instance.sumeragiParameter)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Block' variant
     */
    public data class Block(
        public val blockParameter: BlockParameter,
    ) : Parameter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.Parameter.Block>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.Parameter.Block> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.Parameter.Block = try {
                Block(
                    BlockParameter.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.Parameter.Block,
            ): Unit = try {
                BlockParameter.write(writer, instance.blockParameter)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Transaction' variant
     */
    public data class Transaction(
        public val transactionParameter: TransactionParameter,
    ) : Parameter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.Parameter.Transaction>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.Parameter.Transaction> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.Parameter.Transaction = try {
                Transaction(
                    TransactionParameter.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.Parameter.Transaction,
            ): Unit = try {
                TransactionParameter.write(writer, instance.transactionParameter)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'SmartContract' variant
     */
    public data class SmartContract(
        public val smartContractParameter: SmartContractParameter,
    ) : Parameter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.Parameter.SmartContract>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.Parameter.SmartContract> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.Parameter.SmartContract = try {
                SmartContract(
                    SmartContractParameter.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.Parameter.SmartContract,
            ): Unit = try {
                SmartContractParameter.write(writer, instance.smartContractParameter)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Executor' variant
     */
    public data class Executor(
        public val smartContractParameter: SmartContractParameter,
    ) : Parameter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.Parameter.Executor>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.Parameter.Executor> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.Parameter.Executor = try {
                Executor(
                    SmartContractParameter.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.Parameter.Executor,
            ): Unit = try {
                SmartContractParameter.write(writer, instance.smartContractParameter)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Custom' variant
     */
    public data class Custom(
        public val customParameter: CustomParameter,
    ) : Parameter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.Parameter.Custom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.Parameter.Custom> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.Parameter.Custom = try {
                Custom(
                    CustomParameter.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.Parameter.Custom,
            ): Unit = try {
                CustomParameter.write(writer, instance.customParameter)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<Parameter>, ScaleWriter<Parameter> {
        override fun read(reader: ScaleCodecReader): Parameter = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Sumeragi.read(reader)
            1 -> Block.read(reader)
            2 -> Transaction.read(reader)
            3 -> SmartContract.read(reader)
            4 -> Executor.read(reader)
            5 -> Custom.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: Parameter) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Sumeragi.write(writer, instance as Sumeragi)
                1 -> Block.write(writer, instance as Block)
                2 -> Transaction.write(writer, instance as Transaction)
                3 -> SmartContract.write(writer, instance as SmartContract)
                4 -> Executor.write(writer, instance as Executor)
                5 -> Custom.write(writer, instance as Custom)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
