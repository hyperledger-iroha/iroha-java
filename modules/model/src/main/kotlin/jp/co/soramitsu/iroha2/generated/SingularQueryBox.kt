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
 * SingularQueryBox
 *
 * Generated from 'SingularQueryBox' enum
 */
public sealed class SingularQueryBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'FindExecutorDataModel' variant
     */
    public data class FindExecutorDataModel(
        public val findExecutorDataModel: jp.co.soramitsu.iroha2.generated.FindExecutorDataModel,
    ) : SingularQueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindExecutorDataModel>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindExecutorDataModel> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindExecutorDataModel =
                try {
                    FindExecutorDataModel(
                        jp.co.soramitsu.iroha2.generated.FindExecutorDataModel
                            .read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindExecutorDataModel,
            ): Unit =
                try {
                    jp.co.soramitsu.iroha2.generated.FindExecutorDataModel
                        .write(writer, instance.findExecutorDataModel)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'FindParameters' variant
     */
    public data class FindParameters(
        public val findParameters: jp.co.soramitsu.iroha2.generated.FindParameters,
    ) : SingularQueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindParameters>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindParameters> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindParameters =
                try {
                    FindParameters(
                        jp.co.soramitsu.iroha2.generated.FindParameters
                            .read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindParameters,
            ): Unit =
                try {
                    jp.co.soramitsu.iroha2.generated.FindParameters
                        .write(writer, instance.findParameters)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object : ScaleReader<SingularQueryBox>, ScaleWriter<SingularQueryBox> {
        override fun read(reader: ScaleCodecReader): SingularQueryBox =
            when (val discriminant = reader.readUByte()) {
                0 -> FindExecutorDataModel.read(reader)
                1 -> FindParameters.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: SingularQueryBox,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> FindExecutorDataModel.write(writer, instance as FindExecutorDataModel)
                1 -> FindParameters.write(writer, instance as FindParameters)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
