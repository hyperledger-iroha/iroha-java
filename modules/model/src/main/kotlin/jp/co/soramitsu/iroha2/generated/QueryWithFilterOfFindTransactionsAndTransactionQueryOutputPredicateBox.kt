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
 * QueryWithFilterOfFindTransactionsAndTransactionQueryOutputPredicateBox
 *
 * Generated from 'QueryWithFilterOfFindTransactionsAndTransactionQueryOutputPredicateBox' regular
 * structure
 */
public data class QueryWithFilterOfFindTransactionsAndTransactionQueryOutputPredicateBox(
    public val query: FindTransactions,
    public val predicate: CompoundPredicateOfTransactionQueryOutputPredicateBox,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindTransactionsAndTransactionQueryOutputPredicateBox>,
        ScaleWriter<QueryWithFilterOfFindTransactionsAndTransactionQueryOutputPredicateBox> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindTransactionsAndTransactionQueryOutputPredicateBox = try {
            QueryWithFilterOfFindTransactionsAndTransactionQueryOutputPredicateBox(
                FindTransactions.read(reader),
                CompoundPredicateOfTransactionQueryOutputPredicateBox.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindTransactionsAndTransactionQueryOutputPredicateBox,
        ): Unit =
            try {
                FindTransactions.write(writer, instance.query)
                CompoundPredicateOfTransactionQueryOutputPredicateBox.write(writer, instance.predicate)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
