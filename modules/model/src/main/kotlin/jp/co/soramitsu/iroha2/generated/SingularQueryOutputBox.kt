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
     * 'ExecutorDataModel' variant
     */
    public data class ExecutorDataModel(public val executorDataModel: jp.co.soramitsu.iroha2.generated.ExecutorDataModel) :
        SingularQueryOutputBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.ExecutorDataModel>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.ExecutorDataModel> {
            public const val DISCRIMINANT: Int = 0

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
     * 'Parameters' variant
     */
    public data class Parameters(public val parameters: jp.co.soramitsu.iroha2.generated.Parameters) : SingularQueryOutputBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.Parameters>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SingularQueryOutputBox.Parameters> {
            public const val DISCRIMINANT: Int = 1

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

    public companion object :
        ScaleReader<SingularQueryOutputBox>,
        ScaleWriter<SingularQueryOutputBox> {
        override fun read(reader: ScaleCodecReader): SingularQueryOutputBox = when (val discriminant = reader.readUByte()) {
            0 -> ExecutorDataModel.read(reader)
            1 -> Parameters.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: SingularQueryOutputBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> ExecutorDataModel.write(writer, instance as ExecutorDataModel)
                1 -> Parameters.write(writer, instance as Parameters)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
