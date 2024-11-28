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
 * QueryWithFilterOfFindTransactions
 *
 * Generated from 'QueryWithFilterOfFindTransactions' regular structure
 */
public data class QueryWithFilterOfFindTransactions(
    public val query: FindTransactions,
    public val predicate: CompoundPredicateOfCommittedTransaction,
    public val selector: SelectorTupleOfCommittedTransaction,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindTransactions>,
        ScaleWriter<QueryWithFilterOfFindTransactions> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindTransactions = try {
            QueryWithFilterOfFindTransactions(
                FindTransactions.read(reader),
                CompoundPredicateOfCommittedTransaction.read(reader),
                SelectorTupleOfCommittedTransaction.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: QueryWithFilterOfFindTransactions): Unit = try {
            FindTransactions.write(writer, instance.query)
            CompoundPredicateOfCommittedTransaction.write(writer, instance.predicate)
            SelectorTupleOfCommittedTransaction.write(writer, instance.selector)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
