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
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

/**
 * QueryOutputBox
 *
 * Generated from 'QueryOutputBox' enum
 */
public sealed class QueryOutputBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Id' variant
     */
    public data class Id(
        public val idBox: IdBox,
    ) : QueryOutputBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBox.Id>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBox.Id> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBox.Id = try {
                Id(
                    IdBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBox.Id,
            ): Unit = try {
                IdBox.write(writer, instance.idBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Identifiable' variant
     */
    public data class Identifiable(
        public val identifiableBox: IdentifiableBox,
    ) : QueryOutputBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBox.Identifiable>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBox.Identifiable> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBox.Identifiable = try {
                Identifiable(
                    IdentifiableBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBox.Identifiable,
            ): Unit = try {
                IdentifiableBox.write(writer, instance.identifiableBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Transaction' variant
     */
    public data class Transaction(
        public val transactionQueryOutput: TransactionQueryOutput,
    ) : QueryOutputBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBox.Transaction>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBox.Transaction> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBox.Transaction = try {
                Transaction(
                    TransactionQueryOutput.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBox.Transaction,
            ): Unit = try {
                TransactionQueryOutput.write(writer, instance.transactionQueryOutput)
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
    ) : QueryOutputBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBox.Permission>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBox.Permission> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBox.Permission = try {
                Permission(
                    jp.co.soramitsu.iroha2.generated.Permission.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBox.Permission,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.Permission.write(writer, instance.permission)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Parameters' variant
     */
    public data class Parameters(
        public val parameters: jp.co.soramitsu.iroha2.generated.Parameters,
    ) : QueryOutputBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBox.Parameters>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBox.Parameters> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBox.Parameters = try {
                Parameters(
                    jp.co.soramitsu.iroha2.generated.Parameters.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBox.Parameters,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.Parameters.write(writer, instance.parameters)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Metadata' variant
     */
    public data class Metadata(
        public val string: String,
    ) : QueryOutputBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBox.Metadata>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBox.Metadata> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBox.Metadata = try {
                Metadata(
                    reader.readString(),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBox.Metadata,
            ): Unit = try {
                writer.writeAsList(instance.string.toByteArray(Charsets.UTF_8))
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Numeric' variant
     */
    public data class Numeric(
        public val numeric: jp.co.soramitsu.iroha2.generated.Numeric,
    ) : QueryOutputBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBox.Numeric>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBox.Numeric> {
            public const val DISCRIMINANT: Int = 6

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBox.Numeric = try {
                Numeric(
                    jp.co.soramitsu.iroha2.generated.Numeric.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBox.Numeric,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.Numeric.write(writer, instance.numeric)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'BlockHeader' variant
     */
    public data class BlockHeader(
        public val blockHeader: jp.co.soramitsu.iroha2.generated.BlockHeader,
    ) : QueryOutputBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBox.BlockHeader>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBox.BlockHeader> {
            public const val DISCRIMINANT: Int = 7

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBox.BlockHeader = try {
                BlockHeader(
                    jp.co.soramitsu.iroha2.generated.BlockHeader.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBox.BlockHeader,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.BlockHeader.write(writer, instance.blockHeader)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Block' variant
     */
    public data class Block(
        public val signedBlock: SignedBlock,
    ) : QueryOutputBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBox.Block>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBox.Block> {
            public const val DISCRIMINANT: Int = 8

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBox.Block = try {
                Block(
                    SignedBlock.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBox.Block,
            ): Unit = try {
                SignedBlock.write(writer, instance.signedBlock)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'ExecutorDataModel' variant
     */
    public data class ExecutorDataModel(
        public val executorDataModel: jp.co.soramitsu.iroha2.generated.ExecutorDataModel,
    ) : QueryOutputBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBox.ExecutorDataModel>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBox.ExecutorDataModel> {
            public const val DISCRIMINANT: Int = 9

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBox.ExecutorDataModel = try {
                ExecutorDataModel(
                    jp.co.soramitsu.iroha2.generated.ExecutorDataModel.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBox.ExecutorDataModel,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.ExecutorDataModel.write(writer, instance.executorDataModel)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Vec' variant
     */
    public data class Vec(
        public val vec: List<QueryOutputBox>,
    ) : QueryOutputBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputBox.Vec>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputBox.Vec> {
            public const val DISCRIMINANT: Int = 10

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputBox.Vec = try {
                Vec(
                    reader.readVec(reader.readCompactInt()) { QueryOutputBox.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputBox.Vec,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    QueryOutputBox.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<QueryOutputBox>, ScaleWriter<QueryOutputBox> {
        override fun read(reader: ScaleCodecReader): QueryOutputBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Id.read(reader)
            1 -> Identifiable.read(reader)
            2 -> Transaction.read(reader)
            3 -> Permission.read(reader)
            4 -> Parameters.read(reader)
            5 -> Metadata.read(reader)
            6 -> Numeric.read(reader)
            7 -> BlockHeader.read(reader)
            8 -> Block.read(reader)
            9 -> ExecutorDataModel.read(reader)
            10 -> Vec.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: QueryOutputBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Id.write(writer, instance as Id)
                1 -> Identifiable.write(writer, instance as Identifiable)
                2 -> Transaction.write(writer, instance as Transaction)
                3 -> Permission.write(writer, instance as Permission)
                4 -> Parameters.write(writer, instance as Parameters)
                5 -> Metadata.write(writer, instance as Metadata)
                6 -> Numeric.write(writer, instance as Numeric)
                7 -> BlockHeader.write(writer, instance as BlockHeader)
                8 -> Block.write(writer, instance as Block)
                9 -> ExecutorDataModel.write(writer, instance as ExecutorDataModel)
                10 -> Vec.write(writer, instance as Vec)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
