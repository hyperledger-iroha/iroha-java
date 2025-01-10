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
import kotlin.collections.List

/**
 * QueryOutputBatchBox
 *
 * Generated from 'QueryOutputBatchBox' enum
 */
public sealed class QueryOutputBatchBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Domain' variant
     */
    public data class Domain(
        public val vec: List<jp.co.soramitsu.iroha2.generated.Domain>,
    ) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Domain>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Domain> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Domain = try {
                Domain(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.Domain.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Domain,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    jp.co.soramitsu.iroha2.generated.Domain.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Account' variant
     */
    public data class Account(
        public val vec: List<jp.co.soramitsu.iroha2.generated.Account>,
    ) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Account>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Account> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Account = try {
                Account(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.Account.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Account,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    jp.co.soramitsu.iroha2.generated.Account.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Asset' variant
     */
    public data class Asset(
        public val vec: List<jp.co.soramitsu.iroha2.generated.Asset>,
    ) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Asset>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Asset> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Asset = try {
                Asset(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.Asset.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Asset,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    jp.co.soramitsu.iroha2.generated.Asset.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'AssetDefinition' variant
     */
    public data class AssetDefinition(
        public val vec: List<jp.co.soramitsu.iroha2.generated.AssetDefinition>,
    ) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.AssetDefinition>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.AssetDefinition> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.AssetDefinition = try {
                AssetDefinition(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.AssetDefinition.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.AssetDefinition,
            ): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        jp.co.soramitsu.iroha2.generated.AssetDefinition.write(writer, value)
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Role' variant
     */
    public data class Role(
        public val vec: List<jp.co.soramitsu.iroha2.generated.Role>,
    ) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Role>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Role> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Role = try {
                Role(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.Role.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Role,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    jp.co.soramitsu.iroha2.generated.Role.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Parameter' variant
     */
    public data class Parameter(
        public val vec: List<jp.co.soramitsu.iroha2.generated.Parameter>,
    ) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Parameter>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Parameter> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Parameter = try {
                Parameter(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.Parameter.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Parameter,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    jp.co.soramitsu.iroha2.generated.Parameter.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Permission' variant
     */
    public data class Permission(
        public val vec: List<jp.co.soramitsu.iroha2.generated.Permission>,
    ) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Permission>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Permission> {
            public const val DISCRIMINANT: Int = 6

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Permission = try {
                Permission(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.Permission.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Permission,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    jp.co.soramitsu.iroha2.generated.Permission.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Transaction' variant
     */
    public data class Transaction(
        public val vec: List<TransactionQueryOutput>,
    ) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Transaction>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Transaction> {
            public const val DISCRIMINANT: Int = 7

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Transaction = try {
                Transaction(
                    reader.readVec(reader.readCompactInt()) { TransactionQueryOutput.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Transaction,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    TransactionQueryOutput.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Peer' variant
     */
    public data class Peer(
        public val vec: List<jp.co.soramitsu.iroha2.generated.Peer>,
    ) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Peer>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Peer> {
            public const val DISCRIMINANT: Int = 8

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Peer = try {
                Peer(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.Peer.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Peer,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    jp.co.soramitsu.iroha2.generated.Peer.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'RoleId' variant
     */
    public data class RoleId(
        public val vec: List<jp.co.soramitsu.iroha2.generated.RoleId>,
    ) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.RoleId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.RoleId> {
            public const val DISCRIMINANT: Int = 9

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.RoleId = try {
                RoleId(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.RoleId.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.RoleId,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    jp.co.soramitsu.iroha2.generated.RoleId.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'TriggerId' variant
     */
    public data class TriggerId(
        public val vec: List<jp.co.soramitsu.iroha2.generated.TriggerId>,
    ) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.TriggerId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.TriggerId> {
            public const val DISCRIMINANT: Int = 10

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.TriggerId = try {
                TriggerId(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.TriggerId.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.TriggerId,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    jp.co.soramitsu.iroha2.generated.TriggerId.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Trigger' variant
     */
    public data class Trigger(
        public val vec: List<jp.co.soramitsu.iroha2.generated.Trigger>,
    ) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Trigger>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Trigger> {
            public const val DISCRIMINANT: Int = 11

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Trigger = try {
                Trigger(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.Trigger.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Trigger,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    jp.co.soramitsu.iroha2.generated.Trigger.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Block' variant
     */
    public data class Block(
        public val vec: List<SignedBlock>,
    ) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Block>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Block> {
            public const val DISCRIMINANT: Int = 12

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Block = try {
                Block(
                    reader.readVec(reader.readCompactInt()) { SignedBlock.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Block,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    SignedBlock.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'BlockHeader' variant
     */
    public data class BlockHeader(
        public val vec: List<jp.co.soramitsu.iroha2.generated.BlockHeader>,
    ) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.BlockHeader>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.BlockHeader> {
            public const val DISCRIMINANT: Int = 13

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.BlockHeader = try {
                BlockHeader(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.BlockHeader.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.BlockHeader,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    jp.co.soramitsu.iroha2.generated.BlockHeader.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<QueryOutputBatchBox>, ScaleWriter<QueryOutputBatchBox> {
        override fun read(reader: ScaleCodecReader): QueryOutputBatchBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Domain.read(reader)
            1 -> Account.read(reader)
            2 -> Asset.read(reader)
            3 -> AssetDefinition.read(reader)
            4 -> Role.read(reader)
            5 -> Parameter.read(reader)
            6 -> Permission.read(reader)
            7 -> Transaction.read(reader)
            8 -> Peer.read(reader)
            9 -> RoleId.read(reader)
            10 -> TriggerId.read(reader)
            11 -> Trigger.read(reader)
            12 -> Block.read(reader)
            13 -> BlockHeader.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: QueryOutputBatchBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Domain.write(writer, instance as Domain)
                1 -> Account.write(writer, instance as Account)
                2 -> Asset.write(writer, instance as Asset)
                3 -> AssetDefinition.write(writer, instance as AssetDefinition)
                4 -> Role.write(writer, instance as Role)
                5 -> Parameter.write(writer, instance as Parameter)
                6 -> Permission.write(writer, instance as Permission)
                7 -> Transaction.write(writer, instance as Transaction)
                8 -> Peer.write(writer, instance as Peer)
                9 -> RoleId.write(writer, instance as RoleId)
                10 -> TriggerId.write(writer, instance as TriggerId)
                11 -> Trigger.write(writer, instance as Trigger)
                12 -> Block.write(writer, instance as Block)
                13 -> BlockHeader.write(writer, instance as BlockHeader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
