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
 * QueryWithFilterOfFindAccountsAndAccountPredicateBox
 *
 * Generated from 'QueryWithFilterOfFindAccountsAndAccountPredicateBox' regular structure
 */
public data class QueryWithFilterOfFindAccountsAndAccountPredicateBox(
    public val query: FindAccounts,
    public val predicate: CompoundPredicateOfAccountPredicateBox,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindAccountsAndAccountPredicateBox>,
        ScaleWriter<QueryWithFilterOfFindAccountsAndAccountPredicateBox> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindAccountsAndAccountPredicateBox = try {
            QueryWithFilterOfFindAccountsAndAccountPredicateBox(
                FindAccounts.read(reader),
                CompoundPredicateOfAccountPredicateBox.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindAccountsAndAccountPredicateBox,
        ): Unit = try {
            FindAccounts.write(writer, instance.query)
            CompoundPredicateOfAccountPredicateBox.write(writer, instance.predicate)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
