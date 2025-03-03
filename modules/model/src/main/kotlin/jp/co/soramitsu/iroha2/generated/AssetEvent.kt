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
 * AssetEvent
 *
 * Generated from 'AssetEvent' enum
 */
public sealed class AssetEvent : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Created' variant
     */
    public data class Created(
        public val asset: Asset,
    ) : AssetEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetEvent.Created>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetEvent.Created> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetEvent.Created =
                try {
                    Created(
                        Asset.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetEvent.Created,
            ): Unit =
                try {
                    Asset.write(writer, instance.asset)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Deleted' variant
     */
    public data class Deleted(
        public val assetId: AssetId,
    ) : AssetEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetEvent.Deleted>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetEvent.Deleted> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetEvent.Deleted =
                try {
                    Deleted(
                        AssetId.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetEvent.Deleted,
            ): Unit =
                try {
                    AssetId.write(writer, instance.assetId)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Added' variant
     */
    public data class Added(
        public val assetChanged: AssetChanged,
    ) : AssetEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetEvent.Added>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetEvent.Added> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetEvent.Added =
                try {
                    Added(
                        AssetChanged.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetEvent.Added,
            ): Unit =
                try {
                    AssetChanged.write(writer, instance.assetChanged)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Removed' variant
     */
    public data class Removed(
        public val assetChanged: AssetChanged,
    ) : AssetEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetEvent.Removed>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetEvent.Removed> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetEvent.Removed =
                try {
                    Removed(
                        AssetChanged.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetEvent.Removed,
            ): Unit =
                try {
                    AssetChanged.write(writer, instance.assetChanged)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'MetadataInserted' variant
     */
    public data class MetadataInserted(
        public val metadataChangedOfAssetId: MetadataChangedOfAssetId,
    ) : AssetEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetEvent.MetadataInserted>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetEvent.MetadataInserted> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetEvent.MetadataInserted =
                try {
                    MetadataInserted(
                        MetadataChangedOfAssetId.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetEvent.MetadataInserted,
            ): Unit =
                try {
                    MetadataChangedOfAssetId.write(writer, instance.metadataChangedOfAssetId)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'MetadataRemoved' variant
     */
    public data class MetadataRemoved(
        public val metadataChangedOfAssetId: MetadataChangedOfAssetId,
    ) : AssetEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetEvent.MetadataRemoved>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetEvent.MetadataRemoved> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetEvent.MetadataRemoved =
                try {
                    MetadataRemoved(
                        MetadataChangedOfAssetId.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetEvent.MetadataRemoved,
            ): Unit =
                try {
                    MetadataChangedOfAssetId.write(writer, instance.metadataChangedOfAssetId)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object : ScaleReader<AssetEvent>, ScaleWriter<AssetEvent> {
        override fun read(reader: ScaleCodecReader): AssetEvent =
            when (val discriminant = reader.readUByte()) {
                0 -> Created.read(reader)
                1 -> Deleted.read(reader)
                2 -> Added.read(reader)
                3 -> Removed.read(reader)
                4 -> MetadataInserted.read(reader)
                5 -> MetadataRemoved.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: AssetEvent,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Created.write(writer, instance as Created)
                1 -> Deleted.write(writer, instance as Deleted)
                2 -> Added.write(writer, instance as Added)
                3 -> Removed.write(writer, instance as Removed)
                4 -> MetadataInserted.write(writer, instance as MetadataInserted)
                5 -> MetadataRemoved.write(writer, instance as MetadataRemoved)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
