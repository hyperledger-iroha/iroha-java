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
 * DomainEvent
 *
 * Generated from 'DomainEvent' enum
 */
public sealed class DomainEvent : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Created' variant
     */
    public data class Created(
        public val domain: Domain,
    ) : DomainEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DomainEvent.Created>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DomainEvent.Created> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DomainEvent.Created = try {
                Created(
                    Domain.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DomainEvent.Created,
            ): Unit = try {
                Domain.write(writer, instance.domain)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Deleted' variant
     */
    public data class Deleted(
        public val domainId: DomainId,
    ) : DomainEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DomainEvent.Deleted>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DomainEvent.Deleted> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DomainEvent.Deleted = try {
                Deleted(
                    DomainId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DomainEvent.Deleted,
            ): Unit = try {
                DomainId.write(writer, instance.domainId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'AssetDefinition' variant
     */
    public data class AssetDefinition(
        public val assetDefinitionEvent: AssetDefinitionEvent,
    ) : DomainEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DomainEvent.AssetDefinition>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DomainEvent.AssetDefinition> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DomainEvent.AssetDefinition = try {
                AssetDefinition(
                    AssetDefinitionEvent.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DomainEvent.AssetDefinition,
            ): Unit = try {
                AssetDefinitionEvent.write(writer, instance.assetDefinitionEvent)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Account' variant
     */
    public data class Account(
        public val accountEvent: AccountEvent,
    ) : DomainEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DomainEvent.Account>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DomainEvent.Account> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DomainEvent.Account = try {
                Account(
                    AccountEvent.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DomainEvent.Account,
            ): Unit = try {
                AccountEvent.write(writer, instance.accountEvent)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'MetadataInserted' variant
     */
    public data class MetadataInserted(
        public val metadataChangedOfDomainId: MetadataChangedOfDomainId,
    ) : DomainEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DomainEvent.MetadataInserted>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DomainEvent.MetadataInserted> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DomainEvent.MetadataInserted = try {
                MetadataInserted(
                    MetadataChangedOfDomainId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DomainEvent.MetadataInserted,
            ): Unit = try {
                MetadataChangedOfDomainId.write(writer, instance.metadataChangedOfDomainId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'MetadataRemoved' variant
     */
    public data class MetadataRemoved(
        public val metadataChangedOfDomainId: MetadataChangedOfDomainId,
    ) : DomainEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DomainEvent.MetadataRemoved>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DomainEvent.MetadataRemoved> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DomainEvent.MetadataRemoved = try {
                MetadataRemoved(
                    MetadataChangedOfDomainId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DomainEvent.MetadataRemoved,
            ): Unit = try {
                MetadataChangedOfDomainId.write(writer, instance.metadataChangedOfDomainId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'OwnerChanged' variant
     */
    public data class OwnerChanged(
        public val domainOwnerChanged: DomainOwnerChanged,
    ) : DomainEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DomainEvent.OwnerChanged>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DomainEvent.OwnerChanged> {
            public const val DISCRIMINANT: Int = 6

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DomainEvent.OwnerChanged = try {
                OwnerChanged(
                    DomainOwnerChanged.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DomainEvent.OwnerChanged,
            ): Unit = try {
                DomainOwnerChanged.write(writer, instance.domainOwnerChanged)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<DomainEvent>, ScaleWriter<DomainEvent> {
        override fun read(reader: ScaleCodecReader): DomainEvent = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Created.read(reader)
            1 -> Deleted.read(reader)
            2 -> AssetDefinition.read(reader)
            3 -> Account.read(reader)
            4 -> MetadataInserted.read(reader)
            5 -> MetadataRemoved.read(reader)
            6 -> OwnerChanged.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: DomainEvent) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Created.write(writer, instance as Created)
                1 -> Deleted.write(writer, instance as Deleted)
                2 -> AssetDefinition.write(writer, instance as AssetDefinition)
                3 -> Account.write(writer, instance as Account)
                4 -> MetadataInserted.write(writer, instance as MetadataInserted)
                5 -> MetadataRemoved.write(writer, instance as MetadataRemoved)
                6 -> OwnerChanged.write(writer, instance as OwnerChanged)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
