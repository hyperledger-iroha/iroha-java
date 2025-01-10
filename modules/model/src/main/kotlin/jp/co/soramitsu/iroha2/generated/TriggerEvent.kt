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
 * TriggerEvent
 *
 * Generated from 'TriggerEvent' enum
 */
public sealed class TriggerEvent : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Created' variant
     */
    public data class Created(
        public val triggerId: TriggerId,
    ) : TriggerEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TriggerEvent.Created>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TriggerEvent.Created> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TriggerEvent.Created = try {
                Created(
                    TriggerId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TriggerEvent.Created,
            ): Unit = try {
                TriggerId.write(writer, instance.triggerId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Deleted' variant
     */
    public data class Deleted(
        public val triggerId: TriggerId,
    ) : TriggerEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TriggerEvent.Deleted>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TriggerEvent.Deleted> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TriggerEvent.Deleted = try {
                Deleted(
                    TriggerId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TriggerEvent.Deleted,
            ): Unit = try {
                TriggerId.write(writer, instance.triggerId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Extended' variant
     */
    public data class Extended(
        public val triggerNumberOfExecutionsChanged: TriggerNumberOfExecutionsChanged,
    ) : TriggerEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TriggerEvent.Extended>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TriggerEvent.Extended> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TriggerEvent.Extended = try {
                Extended(
                    TriggerNumberOfExecutionsChanged.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TriggerEvent.Extended,
            ): Unit = try {
                TriggerNumberOfExecutionsChanged.write(writer, instance.triggerNumberOfExecutionsChanged)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Shortened' variant
     */
    public data class Shortened(
        public val triggerNumberOfExecutionsChanged: TriggerNumberOfExecutionsChanged,
    ) : TriggerEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TriggerEvent.Shortened>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TriggerEvent.Shortened> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TriggerEvent.Shortened = try {
                Shortened(
                    TriggerNumberOfExecutionsChanged.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TriggerEvent.Shortened,
            ): Unit = try {
                TriggerNumberOfExecutionsChanged.write(writer, instance.triggerNumberOfExecutionsChanged)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'MetadataInserted' variant
     */
    public data class MetadataInserted(
        public val metadataChangedOfTriggerId: MetadataChangedOfTriggerId,
    ) : TriggerEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TriggerEvent.MetadataInserted>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TriggerEvent.MetadataInserted> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TriggerEvent.MetadataInserted = try {
                MetadataInserted(
                    MetadataChangedOfTriggerId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TriggerEvent.MetadataInserted,
            ): Unit = try {
                MetadataChangedOfTriggerId.write(writer, instance.metadataChangedOfTriggerId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'MetadataRemoved' variant
     */
    public data class MetadataRemoved(
        public val metadataChangedOfTriggerId: MetadataChangedOfTriggerId,
    ) : TriggerEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TriggerEvent.MetadataRemoved>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TriggerEvent.MetadataRemoved> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TriggerEvent.MetadataRemoved = try {
                MetadataRemoved(
                    MetadataChangedOfTriggerId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TriggerEvent.MetadataRemoved,
            ): Unit = try {
                MetadataChangedOfTriggerId.write(writer, instance.metadataChangedOfTriggerId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<TriggerEvent>, ScaleWriter<TriggerEvent> {
        override fun read(reader: ScaleCodecReader): TriggerEvent = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Created.read(reader)
            1 -> Deleted.read(reader)
            2 -> Extended.read(reader)
            3 -> Shortened.read(reader)
            4 -> MetadataInserted.read(reader)
            5 -> MetadataRemoved.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: TriggerEvent) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Created.write(writer, instance as Created)
                1 -> Deleted.write(writer, instance as Deleted)
                2 -> Extended.write(writer, instance as Extended)
                3 -> Shortened.write(writer, instance as Shortened)
                4 -> MetadataInserted.write(writer, instance as MetadataInserted)
                5 -> MetadataRemoved.write(writer, instance as MetadataRemoved)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
