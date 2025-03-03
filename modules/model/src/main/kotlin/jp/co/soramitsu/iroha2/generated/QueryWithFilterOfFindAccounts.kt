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
 * QueryWithFilterOfFindAccounts
 *
 * Generated from 'QueryWithFilterOfFindAccounts' regular structure
 */
public data class QueryWithFilterOfFindAccounts(
    public val query: FindAccounts,
    public val predicate: CompoundPredicateOfAccount,
    public val selector: SelectorTupleOfAccount,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindAccounts>,
        ScaleWriter<QueryWithFilterOfFindAccounts> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindAccounts =
            try {
                QueryWithFilterOfFindAccounts(
                    FindAccounts.read(reader),
                    CompoundPredicateOfAccount.read(reader),
                    SelectorTupleOfAccount.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindAccounts,
        ): Unit =
            try {
                FindAccounts.write(writer, instance.query)
                CompoundPredicateOfAccount.write(writer, instance.predicate)
                SelectorTupleOfAccount.write(writer, instance.selector)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
