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
 * QueryWithFilterOfFindAccountsWithAsset
 *
 * Generated from 'QueryWithFilterOfFindAccountsWithAsset' regular structure
 */
public data class QueryWithFilterOfFindAccountsWithAsset(
    public val query: FindAccountsWithAsset,
    public val predicate: CompoundPredicateOfAccount,
    public val selector: SelectorTupleOfAccount,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindAccountsWithAsset>,
        ScaleWriter<QueryWithFilterOfFindAccountsWithAsset> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindAccountsWithAsset =
            try {
                QueryWithFilterOfFindAccountsWithAsset(
                    FindAccountsWithAsset.read(reader),
                    CompoundPredicateOfAccount.read(reader),
                    SelectorTupleOfAccount.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindAccountsWithAsset,
        ): Unit =
            try {
                FindAccountsWithAsset.write(writer, instance.query)
                CompoundPredicateOfAccount.write(writer, instance.predicate)
                SelectorTupleOfAccount.write(writer, instance.selector)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
