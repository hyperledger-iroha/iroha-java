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
 * QueryWithFilterOfFindTransactionsAndCommittedTransactionPredicateBox
 *
 * Generated from 'QueryWithFilterOfFindTransactionsAndCommittedTransactionPredicateBox' regular
 * structure
 */
public data class QueryWithFilterOfFindTransactionsAndCommittedTransactionPredicateBox(
    public val query: FindTransactions,
    public val predicate: CompoundPredicateOfCommittedTransactionPredicateBox,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindTransactionsAndCommittedTransactionPredicateBox>,
        ScaleWriter<QueryWithFilterOfFindTransactionsAndCommittedTransactionPredicateBox> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindTransactionsAndCommittedTransactionPredicateBox = try {
            QueryWithFilterOfFindTransactionsAndCommittedTransactionPredicateBox(
                FindTransactions.read(reader),
                CompoundPredicateOfCommittedTransactionPredicateBox.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindTransactionsAndCommittedTransactionPredicateBox,
        ): Unit = try {
            FindTransactions.write(writer, instance.query)
            CompoundPredicateOfCommittedTransactionPredicateBox.write(writer, instance.predicate)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
