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
     * 'FindAssetQuantityById' variant
     */
    public data class FindAssetQuantityById(
        public val findAssetQuantityById: jp.co.soramitsu.iroha2.generated.FindAssetQuantityById,
    ) : SingularQueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindAssetQuantityById>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindAssetQuantityById> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindAssetQuantityById = try {
                FindAssetQuantityById(
                    jp.co.soramitsu.iroha2.generated.FindAssetQuantityById.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindAssetQuantityById,
            ): Unit =
                try {
                    jp.co.soramitsu.iroha2.generated.FindAssetQuantityById.write(
                        writer,
                        instance.findAssetQuantityById,
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

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
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindExecutorDataModel = try {
                FindExecutorDataModel(
                    jp.co.soramitsu.iroha2.generated.FindExecutorDataModel.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindExecutorDataModel,
            ): Unit =
                try {
                    jp.co.soramitsu.iroha2.generated.FindExecutorDataModel.write(
                        writer,
                        instance.findExecutorDataModel,
                    )
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
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindParameters = try {
                FindParameters(
                    jp.co.soramitsu.iroha2.generated.FindParameters.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindParameters,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindParameters.write(writer, instance.findParameters)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindDomainMetadata' variant
     */
    public data class FindDomainMetadata(
        public val findDomainMetadata: jp.co.soramitsu.iroha2.generated.FindDomainMetadata,
    ) : SingularQueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindDomainMetadata>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindDomainMetadata> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindDomainMetadata = try {
                FindDomainMetadata(
                    jp.co.soramitsu.iroha2.generated.FindDomainMetadata.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindDomainMetadata,
            ): Unit =
                try {
                    jp.co.soramitsu.iroha2.generated.FindDomainMetadata.write(
                        writer,
                        instance.findDomainMetadata,
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'FindAccountMetadata' variant
     */
    public data class FindAccountMetadata(
        public val findAccountMetadata: jp.co.soramitsu.iroha2.generated.FindAccountMetadata,
    ) : SingularQueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindAccountMetadata>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindAccountMetadata> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindAccountMetadata = try {
                FindAccountMetadata(
                    jp.co.soramitsu.iroha2.generated.FindAccountMetadata.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindAccountMetadata,
            ): Unit =
                try {
                    jp.co.soramitsu.iroha2.generated.FindAccountMetadata.write(
                        writer,
                        instance.findAccountMetadata,
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'FindAssetMetadata' variant
     */
    public data class FindAssetMetadata(
        public val findAssetMetadata: jp.co.soramitsu.iroha2.generated.FindAssetMetadata,
    ) : SingularQueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindAssetMetadata>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindAssetMetadata> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindAssetMetadata = try {
                FindAssetMetadata(
                    jp.co.soramitsu.iroha2.generated.FindAssetMetadata.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindAssetMetadata,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAssetMetadata.write(writer, instance.findAssetMetadata)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindAssetDefinitionMetadata' variant
     */
    public data class FindAssetDefinitionMetadata(
        public val findAssetDefinitionMetadata:
        jp.co.soramitsu.iroha2.generated.FindAssetDefinitionMetadata,
    ) : SingularQueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindAssetDefinitionMetadata>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindAssetDefinitionMetadata> {
            public const val DISCRIMINANT: Int = 6

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindAssetDefinitionMetadata = try {
                FindAssetDefinitionMetadata(
                    jp.co.soramitsu.iroha2.generated.FindAssetDefinitionMetadata.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindAssetDefinitionMetadata,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.FindAssetDefinitionMetadata.write(
                    writer,
                    instance.findAssetDefinitionMetadata,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'FindTriggerMetadata' variant
     */
    public data class FindTriggerMetadata(
        public val findTriggerMetadata: jp.co.soramitsu.iroha2.generated.FindTriggerMetadata,
    ) : SingularQueryBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindTriggerMetadata>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindTriggerMetadata> {
            public const val DISCRIMINANT: Int = 7

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindTriggerMetadata = try {
                FindTriggerMetadata(
                    jp.co.soramitsu.iroha2.generated.FindTriggerMetadata.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SingularQueryBox.FindTriggerMetadata,
            ): Unit =
                try {
                    jp.co.soramitsu.iroha2.generated.FindTriggerMetadata.write(
                        writer,
                        instance.findTriggerMetadata,
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object : ScaleReader<SingularQueryBox>, ScaleWriter<SingularQueryBox> {
        override fun read(reader: ScaleCodecReader): SingularQueryBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> FindAssetQuantityById.read(reader)
            1 -> FindExecutorDataModel.read(reader)
            2 -> FindParameters.read(reader)
            3 -> FindDomainMetadata.read(reader)
            4 -> FindAccountMetadata.read(reader)
            5 -> FindAssetMetadata.read(reader)
            6 -> FindAssetDefinitionMetadata.read(reader)
            7 -> FindTriggerMetadata.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: SingularQueryBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> FindAssetQuantityById.write(writer, instance as FindAssetQuantityById)
                1 -> FindExecutorDataModel.write(writer, instance as FindExecutorDataModel)
                2 -> FindParameters.write(writer, instance as FindParameters)
                3 -> FindDomainMetadata.write(writer, instance as FindDomainMetadata)
                4 -> FindAccountMetadata.write(writer, instance as FindAccountMetadata)
                5 -> FindAssetMetadata.write(writer, instance as FindAssetMetadata)
                6 -> FindAssetDefinitionMetadata.write(writer, instance as FindAssetDefinitionMetadata)
                7 -> FindTriggerMetadata.write(writer, instance as FindTriggerMetadata)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
