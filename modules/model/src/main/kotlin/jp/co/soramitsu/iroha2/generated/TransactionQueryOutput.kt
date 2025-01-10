//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Unit

/**
 * TransactionQueryOutput
 *
 * Generated from 'TransactionQueryOutput' regular structure
 */
public data class TransactionQueryOutput(
    public val blockHash: HashOf<BlockHeader>,
    public val transaction: CommittedTransaction,
) {
    public companion object : ScaleReader<TransactionQueryOutput>, ScaleWriter<TransactionQueryOutput> {
        override fun read(reader: ScaleCodecReader): TransactionQueryOutput = try {
            TransactionQueryOutput(
                HashOf.read(reader) as HashOf<BlockHeader>,
                CommittedTransaction.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: TransactionQueryOutput): Unit = try {
            HashOf.write(writer, instance.blockHash)
            CommittedTransaction.write(writer, instance.transaction)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
