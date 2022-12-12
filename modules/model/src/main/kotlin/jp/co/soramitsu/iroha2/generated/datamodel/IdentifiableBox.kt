//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated.datamodel

import jp.co.soramitsu.iroha2.ModelEnum
import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.generated.datamodel.events.EventsFilterBox
import jp.co.soramitsu.iroha2.generated.datamodel.permission.token.Definition
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Int

/**
 * IdentifiableBox
 *
 * Generated from 'iroha_data_model::IdentifiableBox' enum
 */
public sealed class IdentifiableBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'NewDomain' variant
     */
    public data class NewDomain(
        public val newDomain: jp.co.soramitsu.iroha2.generated.datamodel.domain.NewDomain
    ) : IdentifiableBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<NewDomain>, ScaleWriter<NewDomain> {
            public const val DISCRIMINANT: Int = 0

            public override fun read(reader: ScaleCodecReader): NewDomain = try {
                NewDomain(
                    jp.co.soramitsu.iroha2.generated.datamodel.domain.NewDomain.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: NewDomain) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.domain.NewDomain.write(
                    writer,
                    instance.newDomain
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'NewAccount' variant
     */
    public data class NewAccount(
        public val newAccount: jp.co.soramitsu.iroha2.generated.datamodel.account.NewAccount
    ) : IdentifiableBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<NewAccount>, ScaleWriter<NewAccount> {
            public const val DISCRIMINANT: Int = 1

            public override fun read(reader: ScaleCodecReader): NewAccount = try {
                NewAccount(
                    jp.co.soramitsu.iroha2.generated.datamodel.account.NewAccount.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: NewAccount) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.account.NewAccount.write(
                    writer,
                    instance.newAccount
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'NewAssetDefinition' variant
     */
    public data class NewAssetDefinition(
        public val newAssetDefinition:  
            jp.co.soramitsu.iroha2.generated.datamodel.asset.NewAssetDefinition
    ) : IdentifiableBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<NewAssetDefinition>, ScaleWriter<NewAssetDefinition> {
            public const val DISCRIMINANT: Int = 2

            public override fun read(reader: ScaleCodecReader): NewAssetDefinition = try {
                NewAssetDefinition(
                    jp.co.soramitsu.iroha2.generated.datamodel.asset.NewAssetDefinition.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: NewAssetDefinition) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.asset.NewAssetDefinition.write(
                    writer,
                    instance.newAssetDefinition
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'NewRole' variant
     */
    public data class NewRole(
        public val newRole: jp.co.soramitsu.iroha2.generated.datamodel.role.NewRole
    ) : IdentifiableBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<NewRole>, ScaleWriter<NewRole> {
            public const val DISCRIMINANT: Int = 3

            public override fun read(reader: ScaleCodecReader): NewRole = try {
                NewRole(
                    jp.co.soramitsu.iroha2.generated.datamodel.role.NewRole.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: NewRole) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.role.NewRole.write(writer, instance.newRole)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Peer' variant
     */
    public data class Peer(
        public val peer: jp.co.soramitsu.iroha2.generated.datamodel.peer.Peer
    ) : IdentifiableBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<Peer>, ScaleWriter<Peer> {
            public const val DISCRIMINANT: Int = 4

            public override fun read(reader: ScaleCodecReader): Peer = try {
                Peer(
                    jp.co.soramitsu.iroha2.generated.datamodel.peer.Peer.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: Peer) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.peer.Peer.write(writer, instance.peer)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Domain' variant
     */
    public data class Domain(
        public val domain: jp.co.soramitsu.iroha2.generated.datamodel.domain.Domain
    ) : IdentifiableBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<Domain>, ScaleWriter<Domain> {
            public const val DISCRIMINANT: Int = 5

            public override fun read(reader: ScaleCodecReader): Domain = try {
                Domain(
                    jp.co.soramitsu.iroha2.generated.datamodel.domain.Domain.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: Domain) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.domain.Domain.write(writer, instance.domain)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Account' variant
     */
    public data class Account(
        public val account: jp.co.soramitsu.iroha2.generated.datamodel.account.Account
    ) : IdentifiableBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<Account>, ScaleWriter<Account> {
            public const val DISCRIMINANT: Int = 6

            public override fun read(reader: ScaleCodecReader): Account = try {
                Account(
                    jp.co.soramitsu.iroha2.generated.datamodel.account.Account.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: Account) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.account.Account.write(writer, instance.account)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'AssetDefinition' variant
     */
    public data class AssetDefinition(
        public val assetDefinition: jp.co.soramitsu.iroha2.generated.datamodel.asset.AssetDefinition
    ) : IdentifiableBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<AssetDefinition>, ScaleWriter<AssetDefinition> {
            public const val DISCRIMINANT: Int = 7

            public override fun read(reader: ScaleCodecReader): AssetDefinition = try {
                AssetDefinition(
                    jp.co.soramitsu.iroha2.generated.datamodel.asset.AssetDefinition.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: AssetDefinition) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.asset.AssetDefinition.write(
                    writer,
                    instance.assetDefinition
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Asset' variant
     */
    public data class Asset(
        public val asset: jp.co.soramitsu.iroha2.generated.datamodel.asset.Asset
    ) : IdentifiableBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<Asset>, ScaleWriter<Asset> {
            public const val DISCRIMINANT: Int = 8

            public override fun read(reader: ScaleCodecReader): Asset = try {
                Asset(
                    jp.co.soramitsu.iroha2.generated.datamodel.asset.Asset.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: Asset) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.asset.Asset.write(writer, instance.asset)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Trigger' variant
     */
    public data class Trigger(
        public val trigger: jp.co.soramitsu.iroha2.generated.datamodel.trigger.Trigger<EventsFilterBox>
    ) : IdentifiableBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<Trigger>, ScaleWriter<Trigger> {
            public const val DISCRIMINANT: Int = 9

            public override fun read(reader: ScaleCodecReader): Trigger = try {
                Trigger(
                    jp.co.soramitsu.iroha2.generated.datamodel.trigger.Trigger.read(reader) as
                        jp.co.soramitsu.iroha2.generated.datamodel.trigger.Trigger<EventsFilterBox>,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: Trigger) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.trigger.Trigger.write(writer, instance.trigger)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Role' variant
     */
    public data class Role(
        public val role: jp.co.soramitsu.iroha2.generated.datamodel.role.Role
    ) : IdentifiableBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<Role>, ScaleWriter<Role> {
            public const val DISCRIMINANT: Int = 10

            public override fun read(reader: ScaleCodecReader): Role = try {
                Role(
                    jp.co.soramitsu.iroha2.generated.datamodel.role.Role.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: Role) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.role.Role.write(writer, instance.role)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'PermissionTokenDefinition' variant
     */
    public data class PermissionTokenDefinition(
        public val definition: Definition
    ) : IdentifiableBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<PermissionTokenDefinition>,
            ScaleWriter<PermissionTokenDefinition> {
            public const val DISCRIMINANT: Int = 11

            public override fun read(reader: ScaleCodecReader): PermissionTokenDefinition = try {
                PermissionTokenDefinition(
                    Definition.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: PermissionTokenDefinition) = try {
                Definition.write(writer, instance.definition)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Validator' variant
     */
    public data class Validator(
        public val validator: jp.co.soramitsu.iroha2.generated.datamodel.permission.validator.Validator
    ) : IdentifiableBox() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<Validator>, ScaleWriter<Validator> {
            public const val DISCRIMINANT: Int = 12

            public override fun read(reader: ScaleCodecReader): Validator = try {
                Validator(
                    jp.co.soramitsu.iroha2.generated.datamodel.permission.validator.Validator.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public override fun write(writer: ScaleCodecWriter, instance: Validator) = try {
                jp.co.soramitsu.iroha2.generated.datamodel.permission.validator.Validator.write(
                    writer,
                    instance.validator
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<IdentifiableBox>, ScaleWriter<IdentifiableBox> {
        public override fun read(reader: ScaleCodecReader): IdentifiableBox = when (
            val discriminant =
                reader.readUByte().toInt()
        ) {
            0 -> NewDomain.read(reader)
            1 -> NewAccount.read(reader)
            2 -> NewAssetDefinition.read(reader)
            3 -> NewRole.read(reader)
            4 -> Peer.read(reader)
            5 -> Domain.read(reader)
            6 -> Account.read(reader)
            7 -> AssetDefinition.read(reader)
            8 -> Asset.read(reader)
            9 -> Trigger.read(reader)
            10 -> Role.read(reader)
            11 -> PermissionTokenDefinition.read(reader)
            12 -> Validator.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        public override fun write(writer: ScaleCodecWriter, instance: IdentifiableBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> NewDomain.write(writer, instance as NewDomain)
                1 -> NewAccount.write(writer, instance as NewAccount)
                2 -> NewAssetDefinition.write(writer, instance as NewAssetDefinition)
                3 -> NewRole.write(writer, instance as NewRole)
                4 -> Peer.write(writer, instance as Peer)
                5 -> Domain.write(writer, instance as Domain)
                6 -> Account.write(writer, instance as Account)
                7 -> AssetDefinition.write(writer, instance as AssetDefinition)
                8 -> Asset.write(writer, instance as Asset)
                9 -> Trigger.write(writer, instance as Trigger)
                10 -> Role.write(writer, instance as Role)
                11 -> PermissionTokenDefinition.write(writer, instance as PermissionTokenDefinition)
                12 -> Validator.write(writer, instance as Validator)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
