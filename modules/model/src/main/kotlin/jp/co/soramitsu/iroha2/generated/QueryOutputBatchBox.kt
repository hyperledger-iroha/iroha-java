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
     * 'PublicKey' variant
     */
    public data class PublicKey(public val vec: List<jp.co.soramitsu.iroha2.generated.PublicKey>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.PublicKey>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.PublicKey> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.PublicKey = try {
                PublicKey(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.PublicKey.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.PublicKey): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        jp.co.soramitsu.iroha2.generated.PublicKey.write(writer, value)
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'String' variant
     */
    public data class String(public val vec: List<kotlin.String>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.String>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.String> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.String = try {
                String(
                    reader.readVec(reader.readCompactInt()) { reader.readString() },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.String): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        writer.writeAsList(value.toByteArray(Charsets.UTF_8))
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Metadata' variant
     */
    public data class Metadata(public val vec: List<jp.co.soramitsu.iroha2.generated.Metadata>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Metadata>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Metadata> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Metadata = try {
                Metadata(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.Metadata.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Metadata): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        jp.co.soramitsu.iroha2.generated.Metadata.write(writer, value)
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Name' variant
     */
    public data class Name(public val vec: List<jp.co.soramitsu.iroha2.generated.Name>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Name>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Name> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Name = try {
                Name(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.Name.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Name): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    jp.co.soramitsu.iroha2.generated.Name.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'DomainId' variant
     */
    public data class DomainId(public val vec: List<jp.co.soramitsu.iroha2.generated.DomainId>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.DomainId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.DomainId> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.DomainId = try {
                DomainId(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.DomainId.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.DomainId): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        jp.co.soramitsu.iroha2.generated.DomainId.write(writer, value)
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Domain' variant
     */
    public data class Domain(public val vec: List<jp.co.soramitsu.iroha2.generated.Domain>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Domain>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Domain> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Domain = try {
                Domain(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.Domain.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Domain): Unit =
                try {
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
     * 'AccountId' variant
     */
    public data class AccountId(public val vec: List<jp.co.soramitsu.iroha2.generated.AccountId>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.AccountId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.AccountId> {
            public const val DISCRIMINANT: Int = 6

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.AccountId = try {
                AccountId(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.AccountId.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.AccountId): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        jp.co.soramitsu.iroha2.generated.AccountId.write(writer, value)
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Account' variant
     */
    public data class Account(public val vec: List<jp.co.soramitsu.iroha2.generated.Account>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Account>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Account> {
            public const val DISCRIMINANT: Int = 7

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Account = try {
                Account(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.Account.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Account): Unit =
                try {
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
     * 'AssetId' variant
     */
    public data class AssetId(public val vec: List<jp.co.soramitsu.iroha2.generated.AssetId>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.AssetId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.AssetId> {
            public const val DISCRIMINANT: Int = 8

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.AssetId = try {
                AssetId(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.AssetId.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.AssetId): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        jp.co.soramitsu.iroha2.generated.AssetId.write(writer, value)
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Asset' variant
     */
    public data class Asset(public val vec: List<jp.co.soramitsu.iroha2.generated.Asset>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Asset>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Asset> {
            public const val DISCRIMINANT: Int = 9

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Asset = try {
                Asset(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.Asset.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Asset): Unit = try {
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
     * 'AssetValue' variant
     */
    public data class AssetValue(public val vec: List<jp.co.soramitsu.iroha2.generated.AssetValue>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.AssetValue>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.AssetValue> {
            public const val DISCRIMINANT: Int = 10

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.AssetValue = try {
                AssetValue(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.AssetValue.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.AssetValue): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        jp.co.soramitsu.iroha2.generated.AssetValue.write(writer, value)
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'AssetDefinitionId' variant
     */
    public data class AssetDefinitionId(public val vec: List<jp.co.soramitsu.iroha2.generated.AssetDefinitionId>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.AssetDefinitionId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.AssetDefinitionId> {
            public const val DISCRIMINANT: Int = 11

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.AssetDefinitionId = try {
                AssetDefinitionId(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.AssetDefinitionId.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.AssetDefinitionId,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    jp.co.soramitsu.iroha2.generated.AssetDefinitionId.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'AssetDefinition' variant
     */
    public data class AssetDefinition(public val vec: List<jp.co.soramitsu.iroha2.generated.AssetDefinition>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.AssetDefinition>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.AssetDefinition> {
            public const val DISCRIMINANT: Int = 12

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
            ): Unit = try {
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
    public data class Role(public val vec: List<jp.co.soramitsu.iroha2.generated.Role>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Role>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Role> {
            public const val DISCRIMINANT: Int = 13

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Role = try {
                Role(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.Role.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Role): Unit = try {
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
    public data class Parameter(public val vec: List<jp.co.soramitsu.iroha2.generated.Parameter>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Parameter>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Parameter> {
            public const val DISCRIMINANT: Int = 14

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Parameter = try {
                Parameter(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.Parameter.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Parameter): Unit =
                try {
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
    public data class Permission(public val vec: List<jp.co.soramitsu.iroha2.generated.Permission>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Permission>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Permission> {
            public const val DISCRIMINANT: Int = 15

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Permission = try {
                Permission(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.Permission.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Permission): Unit =
                try {
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
     * 'CommittedTransaction' variant
     */
    public data class CommittedTransaction(public val vec: List<jp.co.soramitsu.iroha2.generated.CommittedTransaction>) :
        QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.CommittedTransaction>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.CommittedTransaction> {
            public const val DISCRIMINANT: Int = 16

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.CommittedTransaction = try {
                CommittedTransaction(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.CommittedTransaction.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.CommittedTransaction,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    jp.co.soramitsu.iroha2.generated.CommittedTransaction.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'SignedTransaction' variant
     */
    public data class SignedTransaction(public val vec: List<jp.co.soramitsu.iroha2.generated.SignedTransaction>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.SignedTransaction>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.SignedTransaction> {
            public const val DISCRIMINANT: Int = 17

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.SignedTransaction = try {
                SignedTransaction(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.SignedTransaction.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.SignedTransaction,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    jp.co.soramitsu.iroha2.generated.SignedTransaction.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'TransactionHash' variant
     */
    public data class TransactionHash(public val vec: List<HashOf<jp.co.soramitsu.iroha2.generated.SignedTransaction>>) :
        QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.TransactionHash>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.TransactionHash> {
            public const val DISCRIMINANT: Int = 18

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.TransactionHash = try {
                TransactionHash(
                    reader.readVec(
                        reader.readCompactInt(),
                    ) { HashOf.read(reader) as HashOf<jp.co.soramitsu.iroha2.generated.SignedTransaction> },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.TransactionHash,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    HashOf.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'TransactionRejectionReason' variant
     */
    public data class TransactionRejectionReason(public val vec: List<jp.co.soramitsu.iroha2.generated.TransactionRejectionReason?>) :
        QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.TransactionRejectionReason>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.TransactionRejectionReason> {
            public const val DISCRIMINANT: Int = 19

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.TransactionRejectionReason =
                try {
                    TransactionRejectionReason(
                        reader.readVec(reader.readCompactInt()) {
                            reader.readNullable(
                                jp.co.soramitsu.iroha2.generated.TransactionRejectionReason,
                            ) as jp.co.soramitsu.iroha2.generated.TransactionRejectionReason?
                        },
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.TransactionRejectionReason,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    writer.writeNullable(jp.co.soramitsu.iroha2.generated.TransactionRejectionReason, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Peer' variant
     */
    public data class Peer(public val vec: List<PeerId>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Peer>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Peer> {
            public const val DISCRIMINANT: Int = 20

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Peer = try {
                Peer(
                    reader.readVec(reader.readCompactInt()) { PeerId.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Peer): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    PeerId.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'RoleId' variant
     */
    public data class RoleId(public val vec: List<jp.co.soramitsu.iroha2.generated.RoleId>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.RoleId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.RoleId> {
            public const val DISCRIMINANT: Int = 21

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.RoleId = try {
                RoleId(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.RoleId.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.RoleId): Unit =
                try {
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
    public data class TriggerId(public val vec: List<jp.co.soramitsu.iroha2.generated.TriggerId>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.TriggerId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.TriggerId> {
            public const val DISCRIMINANT: Int = 22

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.TriggerId = try {
                TriggerId(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.TriggerId.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.TriggerId): Unit =
                try {
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
    public data class Trigger(public val vec: List<jp.co.soramitsu.iroha2.generated.Trigger>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Trigger>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Trigger> {
            public const val DISCRIMINANT: Int = 23

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Trigger = try {
                Trigger(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.Trigger.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Trigger): Unit =
                try {
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
    public data class Block(public val vec: List<SignedBlock>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Block>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Block> {
            public const val DISCRIMINANT: Int = 24

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Block = try {
                Block(
                    reader.readVec(reader.readCompactInt()) { SignedBlock.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.Block): Unit = try {
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
    public data class BlockHeader(public val vec: List<jp.co.soramitsu.iroha2.generated.BlockHeader>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.BlockHeader>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.BlockHeader> {
            public const val DISCRIMINANT: Int = 25

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.BlockHeader = try {
                BlockHeader(
                    reader.readVec(reader.readCompactInt()) { jp.co.soramitsu.iroha2.generated.BlockHeader.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.BlockHeader): Unit =
                try {
                    writer.writeCompact(instance.vec.size)
                    instance.vec.forEach { value ->
                        jp.co.soramitsu.iroha2.generated.BlockHeader.write(writer, value)
                    }
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'BlockHeaderHash' variant
     */
    public data class BlockHeaderHash(public val vec: List<HashOf<jp.co.soramitsu.iroha2.generated.BlockHeader>>) : QueryOutputBatchBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.BlockHeaderHash>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.BlockHeaderHash> {
            public const val DISCRIMINANT: Int = 26

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.BlockHeaderHash = try {
                BlockHeaderHash(
                    reader.readVec(reader.readCompactInt()) { HashOf.read(reader) as HashOf<jp.co.soramitsu.iroha2.generated.BlockHeader> },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBatchBox.BlockHeaderHash,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    HashOf.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<QueryOutputBatchBox>, ScaleWriter<QueryOutputBatchBox> {
        override fun read(reader: ScaleCodecReader): QueryOutputBatchBox = when (val discriminant = reader.readUByte()) {
            0 -> PublicKey.read(reader)
            1 -> String.read(reader)
            2 -> Metadata.read(reader)
            3 -> Name.read(reader)
            4 -> DomainId.read(reader)
            5 -> Domain.read(reader)
            6 -> AccountId.read(reader)
            7 -> Account.read(reader)
            8 -> AssetId.read(reader)
            9 -> Asset.read(reader)
            10 -> AssetValue.read(reader)
            11 -> AssetDefinitionId.read(reader)
            12 -> AssetDefinition.read(reader)
            13 -> Role.read(reader)
            14 -> Parameter.read(reader)
            15 -> Permission.read(reader)
            16 -> CommittedTransaction.read(reader)
            17 -> SignedTransaction.read(reader)
            18 -> TransactionHash.read(reader)
            19 -> TransactionRejectionReason.read(reader)
            20 -> Peer.read(reader)
            21 -> RoleId.read(reader)
            22 -> TriggerId.read(reader)
            23 -> Trigger.read(reader)
            24 -> Block.read(reader)
            25 -> BlockHeader.read(reader)
            26 -> BlockHeaderHash.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: QueryOutputBatchBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> PublicKey.write(writer, instance as PublicKey)
                1 -> String.write(writer, instance as String)
                2 -> Metadata.write(writer, instance as Metadata)
                3 -> Name.write(writer, instance as Name)
                4 -> DomainId.write(writer, instance as DomainId)
                5 -> Domain.write(writer, instance as Domain)
                6 -> AccountId.write(writer, instance as AccountId)
                7 -> Account.write(writer, instance as Account)
                8 -> AssetId.write(writer, instance as AssetId)
                9 -> Asset.write(writer, instance as Asset)
                10 -> AssetValue.write(writer, instance as AssetValue)
                11 -> AssetDefinitionId.write(writer, instance as AssetDefinitionId)
                12 -> AssetDefinition.write(writer, instance as AssetDefinition)
                13 -> Role.write(writer, instance as Role)
                14 -> Parameter.write(writer, instance as Parameter)
                15 -> Permission.write(writer, instance as Permission)
                16 -> CommittedTransaction.write(writer, instance as CommittedTransaction)
                17 -> SignedTransaction.write(writer, instance as SignedTransaction)
                18 -> TransactionHash.write(writer, instance as TransactionHash)
                19 -> TransactionRejectionReason.write(writer, instance as TransactionRejectionReason)
                20 -> Peer.write(writer, instance as Peer)
                21 -> RoleId.write(writer, instance as RoleId)
                22 -> TriggerId.write(writer, instance as TriggerId)
                23 -> Trigger.write(writer, instance as Trigger)
                24 -> Block.write(writer, instance as Block)
                25 -> BlockHeader.write(writer, instance as BlockHeader)
                26 -> BlockHeaderHash.write(writer, instance as BlockHeaderHash)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
