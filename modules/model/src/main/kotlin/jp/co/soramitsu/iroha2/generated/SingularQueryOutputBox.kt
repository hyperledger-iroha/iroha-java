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
 * SingularQueryOutputBox
 *
 * Generated from 'SingularQueryOutputBox' enum
 */
public sealed class SingularQueryOutputBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Numeric' variant
     */
    public data class Numeric(
        public val numeric: jp.co.soramitsu.iroha2.generated.Numeric,
    ) : SingularQueryOutputBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.Numeric>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.Numeric> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.Numeric = try {
                Numeric(
                    jp.co.soramitsu.iroha2.generated.Numeric.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.Numeric,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.Numeric.write(writer, instance.numeric)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'ExecutorDataModel' variant
     */
    public data class ExecutorDataModel(
        public val executorDataModel: jp.co.soramitsu.iroha2.generated.ExecutorDataModel,
    ) : SingularQueryOutputBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.ExecutorDataModel>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.ExecutorDataModel> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.ExecutorDataModel = try {
                ExecutorDataModel(
                    jp.co.soramitsu.iroha2.generated.ExecutorDataModel.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.ExecutorDataModel,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.ExecutorDataModel.write(writer, instance.executorDataModel)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'JsonString' variant
     */
    public data class JsonString(
        public val string: String,
    ) : SingularQueryOutputBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.JsonString>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.JsonString> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.JsonString = try {
                JsonString(
                    reader.readString(),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.JsonString,
            ): Unit = try {
                writer.writeAsList(instance.string.toByteArray(Charsets.UTF_8))
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Trigger' variant
     */
    public data class Trigger(
        public val trigger: jp.co.soramitsu.iroha2.generated.Trigger,
    ) : SingularQueryOutputBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.Trigger>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.Trigger> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.Trigger = try {
                Trigger(
                    jp.co.soramitsu.iroha2.generated.Trigger.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.Trigger,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.Trigger.write(writer, instance.trigger)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Parameters' variant
     */
    public data class Parameters(
        public val parameters: jp.co.soramitsu.iroha2.generated.Parameters,
    ) : SingularQueryOutputBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.Parameters>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.Parameters> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.Parameters = try {
                Parameters(
                    jp.co.soramitsu.iroha2.generated.Parameters.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.Parameters,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.Parameters.write(writer, instance.parameters)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Transaction' variant
     */
    public data class Transaction(
        public val transactionQueryOutput: TransactionQueryOutput,
    ) : SingularQueryOutputBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.Transaction>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.Transaction> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.Transaction = try {
                Transaction(
                    TransactionQueryOutput.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.Transaction,
            ): Unit = try {
                TransactionQueryOutput.write(writer, instance.transactionQueryOutput)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'BlockHeader' variant
     */
    public data class BlockHeader(
        public val blockHeader: jp.co.soramitsu.iroha2.generated.BlockHeader,
    ) : SingularQueryOutputBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.BlockHeader>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.BlockHeader> {
            public const val DISCRIMINANT: Int = 6

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.BlockHeader = try {
                BlockHeader(
                    jp.co.soramitsu.iroha2.generated.BlockHeader.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.BlockHeader,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.BlockHeader.write(writer, instance.blockHeader)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<SingularQueryOutputBox>, ScaleWriter<SingularQueryOutputBox> {
        override fun read(reader: ScaleCodecReader): SingularQueryOutputBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Numeric.read(reader)
            1 -> ExecutorDataModel.read(reader)
            2 -> JsonString.read(reader)
            3 -> Trigger.read(reader)
            4 -> Parameters.read(reader)
            5 -> Transaction.read(reader)
            6 -> BlockHeader.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: SingularQueryOutputBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Numeric.write(writer, instance as Numeric)
                1 -> ExecutorDataModel.write(writer, instance as ExecutorDataModel)
                2 -> JsonString.write(writer, instance as JsonString)
                3 -> Trigger.write(writer, instance as Trigger)
                4 -> Parameters.write(writer, instance as Parameters)
                5 -> Transaction.write(writer, instance as Transaction)
                6 -> BlockHeader.write(writer, instance as BlockHeader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
