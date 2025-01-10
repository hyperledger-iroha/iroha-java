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
import kotlin.Boolean
import kotlin.Int
import kotlin.Unit

/**
 * DataEventFilter
 *
 * Generated from 'DataEventFilter' enum
 */
public sealed class DataEventFilter : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    override fun equals(other: kotlin.Any?): Boolean = when (this) {
        is Any -> Any.equals(this, other)
        else -> super.equals(other) }

    override fun hashCode(): Int = when (this) {
        is Any -> Any.hashCode()
        else -> super.hashCode() }

    /**
     * 'Any' variant
     */
    public class Any : DataEventFilter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DataEventFilter.Any>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DataEventFilter.Any> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DataEventFilter.Any = try {
                Any()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DataEventFilter.Any,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.DataEventFilter.Any, o2: kotlin.Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".DataEventFilter.Any".hashCode()
        }
    }

    /**
     * 'Peer' variant
     */
    public data class Peer(
        public val peerEventFilter: PeerEventFilter,
    ) : DataEventFilter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DataEventFilter.Peer>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DataEventFilter.Peer> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DataEventFilter.Peer = try {
                Peer(
                    PeerEventFilter.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DataEventFilter.Peer,
            ): Unit = try {
                PeerEventFilter.write(writer, instance.peerEventFilter)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Domain' variant
     */
    public data class Domain(
        public val domainEventFilter: DomainEventFilter,
    ) : DataEventFilter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DataEventFilter.Domain>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DataEventFilter.Domain> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DataEventFilter.Domain = try {
                Domain(
                    DomainEventFilter.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DataEventFilter.Domain,
            ): Unit = try {
                DomainEventFilter.write(writer, instance.domainEventFilter)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Account' variant
     */
    public data class Account(
        public val accountEventFilter: AccountEventFilter,
    ) : DataEventFilter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DataEventFilter.Account>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DataEventFilter.Account> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DataEventFilter.Account = try {
                Account(
                    AccountEventFilter.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DataEventFilter.Account,
            ): Unit = try {
                AccountEventFilter.write(writer, instance.accountEventFilter)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Asset' variant
     */
    public data class Asset(
        public val assetEventFilter: AssetEventFilter,
    ) : DataEventFilter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DataEventFilter.Asset>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DataEventFilter.Asset> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DataEventFilter.Asset = try {
                Asset(
                    AssetEventFilter.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DataEventFilter.Asset,
            ): Unit = try {
                AssetEventFilter.write(writer, instance.assetEventFilter)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'AssetDefinition' variant
     */
    public data class AssetDefinition(
        public val assetDefinitionEventFilter: AssetDefinitionEventFilter,
    ) : DataEventFilter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DataEventFilter.AssetDefinition>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DataEventFilter.AssetDefinition> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DataEventFilter.AssetDefinition = try {
                AssetDefinition(
                    AssetDefinitionEventFilter.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DataEventFilter.AssetDefinition,
            ): Unit = try {
                AssetDefinitionEventFilter.write(writer, instance.assetDefinitionEventFilter)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Trigger' variant
     */
    public data class Trigger(
        public val triggerEventFilter: TriggerEventFilter,
    ) : DataEventFilter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DataEventFilter.Trigger>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DataEventFilter.Trigger> {
            public const val DISCRIMINANT: Int = 6

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DataEventFilter.Trigger = try {
                Trigger(
                    TriggerEventFilter.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DataEventFilter.Trigger,
            ): Unit = try {
                TriggerEventFilter.write(writer, instance.triggerEventFilter)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Role' variant
     */
    public data class Role(
        public val roleEventFilter: RoleEventFilter,
    ) : DataEventFilter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DataEventFilter.Role>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DataEventFilter.Role> {
            public const val DISCRIMINANT: Int = 7

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DataEventFilter.Role = try {
                Role(
                    RoleEventFilter.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DataEventFilter.Role,
            ): Unit = try {
                RoleEventFilter.write(writer, instance.roleEventFilter)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Configuration' variant
     */
    public data class Configuration(
        public val configurationEventFilter: ConfigurationEventFilter,
    ) : DataEventFilter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DataEventFilter.Configuration>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DataEventFilter.Configuration> {
            public const val DISCRIMINANT: Int = 8

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DataEventFilter.Configuration = try {
                Configuration(
                    ConfigurationEventFilter.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DataEventFilter.Configuration,
            ): Unit = try {
                ConfigurationEventFilter.write(writer, instance.configurationEventFilter)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Executor' variant
     */
    public data class Executor(
        public val executorEventFilter: ExecutorEventFilter,
    ) : DataEventFilter() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DataEventFilter.Executor>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DataEventFilter.Executor> {
            public const val DISCRIMINANT: Int = 9

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DataEventFilter.Executor = try {
                Executor(
                    ExecutorEventFilter.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DataEventFilter.Executor,
            ): Unit = try {
                ExecutorEventFilter.write(writer, instance.executorEventFilter)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<DataEventFilter>, ScaleWriter<DataEventFilter> {
        override fun read(reader: ScaleCodecReader): DataEventFilter = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Any.read(reader)
            1 -> Peer.read(reader)
            2 -> Domain.read(reader)
            3 -> Account.read(reader)
            4 -> Asset.read(reader)
            5 -> AssetDefinition.read(reader)
            6 -> Trigger.read(reader)
            7 -> Role.read(reader)
            8 -> Configuration.read(reader)
            9 -> Executor.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: DataEventFilter) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Any.write(writer, instance as Any)
                1 -> Peer.write(writer, instance as Peer)
                2 -> Domain.write(writer, instance as Domain)
                3 -> Account.write(writer, instance as Account)
                4 -> Asset.write(writer, instance as Asset)
                5 -> AssetDefinition.write(writer, instance as AssetDefinition)
                6 -> Trigger.write(writer, instance as Trigger)
                7 -> Role.write(writer, instance as Role)
                8 -> Configuration.write(writer, instance as Configuration)
                9 -> Executor.write(writer, instance as Executor)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
