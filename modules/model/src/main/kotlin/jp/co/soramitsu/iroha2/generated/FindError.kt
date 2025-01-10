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
 * FindError
 *
 * Generated from 'FindError' enum
 */
public sealed class FindError : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Asset' variant
     */
    public data class Asset(
        public val assetId: AssetId,
    ) : FindError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.FindError.Asset>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.FindError.Asset> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.FindError.Asset = try {
                Asset(
                    AssetId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.FindError.Asset,
            ): Unit = try {
                AssetId.write(writer, instance.assetId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'AssetDefinition' variant
     */
    public data class AssetDefinition(
        public val assetDefinitionId: AssetDefinitionId,
    ) : FindError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.FindError.AssetDefinition>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.FindError.AssetDefinition> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.FindError.AssetDefinition = try {
                AssetDefinition(
                    AssetDefinitionId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.FindError.AssetDefinition,
            ): Unit = try {
                AssetDefinitionId.write(writer, instance.assetDefinitionId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Account' variant
     */
    public data class Account(
        public val accountId: AccountId,
    ) : FindError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.FindError.Account>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.FindError.Account> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.FindError.Account = try {
                Account(
                    AccountId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.FindError.Account,
            ): Unit = try {
                AccountId.write(writer, instance.accountId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Domain' variant
     */
    public data class Domain(
        public val domainId: DomainId,
    ) : FindError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.FindError.Domain>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.FindError.Domain> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.FindError.Domain = try {
                Domain(
                    DomainId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.FindError.Domain,
            ): Unit = try {
                DomainId.write(writer, instance.domainId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'MetadataKey' variant
     */
    public data class MetadataKey(
        public val name: Name,
    ) : FindError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.FindError.MetadataKey>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.FindError.MetadataKey> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.FindError.MetadataKey = try {
                MetadataKey(
                    Name.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.FindError.MetadataKey,
            ): Unit = try {
                Name.write(writer, instance.name)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Block' variant
     */
    public data class Block(
        public val hashOf: HashOf<BlockHeader>,
    ) : FindError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.FindError.Block>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.FindError.Block> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.FindError.Block = try {
                Block(
                    HashOf.read(reader) as HashOf<BlockHeader>,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.FindError.Block,
            ): Unit = try {
                HashOf.write(writer, instance.hashOf)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Transaction' variant
     */
    public data class Transaction(
        public val hashOf: HashOf<SignedTransaction>,
    ) : FindError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.FindError.Transaction>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.FindError.Transaction> {
            public const val DISCRIMINANT: Int = 6

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.FindError.Transaction = try {
                Transaction(
                    HashOf.read(reader) as HashOf<SignedTransaction>,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.FindError.Transaction,
            ): Unit = try {
                HashOf.write(writer, instance.hashOf)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Peer' variant
     */
    public data class Peer(
        public val peerId: PeerId,
    ) : FindError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.FindError.Peer>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.FindError.Peer> {
            public const val DISCRIMINANT: Int = 7

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.FindError.Peer =
                try {
                    Peer(
                        PeerId.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.FindError.Peer,
            ): Unit = try {
                PeerId.write(writer, instance.peerId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Trigger' variant
     */
    public data class Trigger(
        public val triggerId: TriggerId,
    ) : FindError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.FindError.Trigger>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.FindError.Trigger> {
            public const val DISCRIMINANT: Int = 8

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.FindError.Trigger = try {
                Trigger(
                    TriggerId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.FindError.Trigger,
            ): Unit = try {
                TriggerId.write(writer, instance.triggerId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Role' variant
     */
    public data class Role(
        public val roleId: RoleId,
    ) : FindError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.FindError.Role>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.FindError.Role> {
            public const val DISCRIMINANT: Int = 9

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.FindError.Role =
                try {
                    Role(
                        RoleId.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.FindError.Role,
            ): Unit = try {
                RoleId.write(writer, instance.roleId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Permission' variant
     */
    public data class Permission(
        public val permission: jp.co.soramitsu.iroha2.generated.Permission,
    ) : FindError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.FindError.Permission>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.FindError.Permission> {
            public const val DISCRIMINANT: Int = 10

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.FindError.Permission = try {
                Permission(
                    jp.co.soramitsu.iroha2.generated.Permission.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.FindError.Permission,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.Permission.write(writer, instance.permission)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'PublicKey' variant
     */
    public data class PublicKey(
        public val publicKey: jp.co.soramitsu.iroha2.generated.PublicKey,
    ) : FindError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.FindError.PublicKey>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.FindError.PublicKey> {
            public const val DISCRIMINANT: Int = 11

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.FindError.PublicKey = try {
                PublicKey(
                    jp.co.soramitsu.iroha2.generated.PublicKey.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.FindError.PublicKey,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.PublicKey.write(writer, instance.publicKey)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<FindError>, ScaleWriter<FindError> {
        override fun read(reader: ScaleCodecReader): FindError = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Asset.read(reader)
            1 -> AssetDefinition.read(reader)
            2 -> Account.read(reader)
            3 -> Domain.read(reader)
            4 -> MetadataKey.read(reader)
            5 -> Block.read(reader)
            6 -> Transaction.read(reader)
            7 -> Peer.read(reader)
            8 -> Trigger.read(reader)
            9 -> Role.read(reader)
            10 -> Permission.read(reader)
            11 -> PublicKey.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: FindError) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Asset.write(writer, instance as Asset)
                1 -> AssetDefinition.write(writer, instance as AssetDefinition)
                2 -> Account.write(writer, instance as Account)
                3 -> Domain.write(writer, instance as Domain)
                4 -> MetadataKey.write(writer, instance as MetadataKey)
                5 -> Block.write(writer, instance as Block)
                6 -> Transaction.write(writer, instance as Transaction)
                7 -> Peer.write(writer, instance as Peer)
                8 -> Trigger.write(writer, instance as Trigger)
                9 -> Role.write(writer, instance as Role)
                10 -> Permission.write(writer, instance as Permission)
                11 -> PublicKey.write(writer, instance as PublicKey)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
