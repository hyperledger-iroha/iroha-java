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
import kotlin.collections.List

/**
 * SelectorTupleOfCommittedTransaction
 *
 * Generated from 'SelectorTupleOfCommittedTransaction' regular structure
 */
public data class SelectorTupleOfCommittedTransaction(
    public val vecOfCommittedTransactionProjectionOfSelectorMarker: List<CommittedTransactionProjectionOfSelectorMarker>,
) {
    public companion object :
        ScaleReader<SelectorTupleOfCommittedTransaction>,
        ScaleWriter<SelectorTupleOfCommittedTransaction> {
        override fun read(reader: ScaleCodecReader): SelectorTupleOfCommittedTransaction =
            try {
                SelectorTupleOfCommittedTransaction(
                    reader.readVec(reader.readCompactInt()) { CommittedTransactionProjectionOfSelectorMarker.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: SelectorTupleOfCommittedTransaction,
        ): Unit =
            try {
                writer.writeCompact(instance.vecOfCommittedTransactionProjectionOfSelectorMarker.size)
                instance.vecOfCommittedTransactionProjectionOfSelectorMarker.forEach { value ->
                    CommittedTransactionProjectionOfSelectorMarker.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
