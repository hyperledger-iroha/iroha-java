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
 * AssetDefinitionEvent
 *
 * Generated from 'AssetDefinitionEvent' enum
 */
public sealed class AssetDefinitionEvent : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Created' variant
     */
    public data class Created(
        public val assetDefinition: AssetDefinition,
    ) : AssetDefinitionEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.Created>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.Created> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.Created = try {
                Created(
                    AssetDefinition.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.Created,
            ): Unit = try {
                AssetDefinition.write(writer, instance.assetDefinition)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Deleted' variant
     */
    public data class Deleted(
        public val assetDefinitionId: AssetDefinitionId,
    ) : AssetDefinitionEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.Deleted>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.Deleted> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.Deleted = try {
                Deleted(
                    AssetDefinitionId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.Deleted,
            ): Unit = try {
                AssetDefinitionId.write(writer, instance.assetDefinitionId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'MetadataInserted' variant
     */
    public data class MetadataInserted(
        public val metadataChangedOfAssetDefinitionId: MetadataChangedOfAssetDefinitionId,
    ) : AssetDefinitionEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.MetadataInserted>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.MetadataInserted> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.MetadataInserted = try {
                MetadataInserted(
                    MetadataChangedOfAssetDefinitionId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.MetadataInserted,
            ): Unit =
                try {
                    MetadataChangedOfAssetDefinitionId.write(
                        writer,
                        instance.metadataChangedOfAssetDefinitionId,
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'MetadataRemoved' variant
     */
    public data class MetadataRemoved(
        public val metadataChangedOfAssetDefinitionId: MetadataChangedOfAssetDefinitionId,
    ) : AssetDefinitionEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.MetadataRemoved>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.MetadataRemoved> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.MetadataRemoved = try {
                MetadataRemoved(
                    MetadataChangedOfAssetDefinitionId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.MetadataRemoved,
            ): Unit =
                try {
                    MetadataChangedOfAssetDefinitionId.write(
                        writer,
                        instance.metadataChangedOfAssetDefinitionId,
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'MintabilityChanged' variant
     */
    public data class MintabilityChanged(
        public val assetDefinitionId: AssetDefinitionId,
    ) : AssetDefinitionEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.MintabilityChanged>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.MintabilityChanged> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.MintabilityChanged = try {
                MintabilityChanged(
                    AssetDefinitionId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.MintabilityChanged,
            ): Unit = try {
                AssetDefinitionId.write(writer, instance.assetDefinitionId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'TotalQuantityChanged' variant
     */
    public data class TotalQuantityChanged(
        public val assetDefinitionTotalQuantityChanged: AssetDefinitionTotalQuantityChanged,
    ) : AssetDefinitionEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.TotalQuantityChanged>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.TotalQuantityChanged> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.TotalQuantityChanged = try {
                TotalQuantityChanged(
                    AssetDefinitionTotalQuantityChanged.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.TotalQuantityChanged,
            ): Unit = try {
                AssetDefinitionTotalQuantityChanged.write(
                    writer,
                    instance.assetDefinitionTotalQuantityChanged,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'OwnerChanged' variant
     */
    public data class OwnerChanged(
        public val assetDefinitionOwnerChanged: AssetDefinitionOwnerChanged,
    ) : AssetDefinitionEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.OwnerChanged>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.OwnerChanged> {
            public const val DISCRIMINANT: Int = 6

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.OwnerChanged = try {
                OwnerChanged(
                    AssetDefinitionOwnerChanged.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionEvent.OwnerChanged,
            ): Unit = try {
                AssetDefinitionOwnerChanged.write(writer, instance.assetDefinitionOwnerChanged)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<AssetDefinitionEvent>, ScaleWriter<AssetDefinitionEvent> {
        override fun read(reader: ScaleCodecReader): AssetDefinitionEvent = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Created.read(reader)
            1 -> Deleted.read(reader)
            2 -> MetadataInserted.read(reader)
            3 -> MetadataRemoved.read(reader)
            4 -> MintabilityChanged.read(reader)
            5 -> TotalQuantityChanged.read(reader)
            6 -> OwnerChanged.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: AssetDefinitionEvent) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Created.write(writer, instance as Created)
                1 -> Deleted.write(writer, instance as Deleted)
                2 -> MetadataInserted.write(writer, instance as MetadataInserted)
                3 -> MetadataRemoved.write(writer, instance as MetadataRemoved)
                4 -> MintabilityChanged.write(writer, instance as MintabilityChanged)
                5 -> TotalQuantityChanged.write(writer, instance as TotalQuantityChanged)
                6 -> OwnerChanged.write(writer, instance as OwnerChanged)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
