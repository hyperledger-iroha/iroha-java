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
 * TransactionQueryOutputPredicateBox
 *
 * Generated from 'TransactionQueryOutputPredicateBox' enum
 */
public sealed class TransactionQueryOutputPredicateBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Transaction' variant
     */
    public data class Transaction(
        public val committedTransactionPredicateBox: CommittedTransactionPredicateBox,
    ) : TransactionQueryOutputPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TransactionQueryOutputPredicateBox.Transaction>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TransactionQueryOutputPredicateBox.Transaction> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TransactionQueryOutputPredicateBox.Transaction = try {
                Transaction(
                    CommittedTransactionPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TransactionQueryOutputPredicateBox.Transaction,
            ): Unit = try {
                CommittedTransactionPredicateBox.write(writer, instance.committedTransactionPredicateBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'BlockHash' variant
     */
    public data class BlockHash(
        public val blockHashPredicateBox: BlockHashPredicateBox,
    ) : TransactionQueryOutputPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TransactionQueryOutputPredicateBox.BlockHash>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TransactionQueryOutputPredicateBox.BlockHash> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TransactionQueryOutputPredicateBox.BlockHash = try {
                BlockHash(
                    BlockHashPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TransactionQueryOutputPredicateBox.BlockHash,
            ): Unit = try {
                BlockHashPredicateBox.write(writer, instance.blockHashPredicateBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<TransactionQueryOutputPredicateBox>,
        ScaleWriter<TransactionQueryOutputPredicateBox> {
        override fun read(reader: ScaleCodecReader): TransactionQueryOutputPredicateBox = when (
            val
            discriminant = reader.readUByte()
        ) {
            0 -> Transaction.read(reader)
            1 -> BlockHash.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: TransactionQueryOutputPredicateBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Transaction.write(writer, instance as Transaction)
                1 -> BlockHash.write(writer, instance as BlockHash)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
