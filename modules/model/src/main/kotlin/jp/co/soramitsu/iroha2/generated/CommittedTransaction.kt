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
 * CommittedTransaction
 *
 * Generated from 'CommittedTransaction' regular structure
 */
public data class CommittedTransaction(
    public val `value`: SignedTransaction,
    public val error: TransactionRejectionReason? = null,
) {
    public companion object : ScaleReader<CommittedTransaction>, ScaleWriter<CommittedTransaction> {
        override fun read(reader: ScaleCodecReader): CommittedTransaction = try {
            CommittedTransaction(
                SignedTransaction.read(reader),
                reader.readNullable(TransactionRejectionReason) as TransactionRejectionReason?,
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CommittedTransaction): Unit = try {
            SignedTransaction.write(writer, instance.`value`)
            writer.writeNullable(TransactionRejectionReason, instance.error)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
