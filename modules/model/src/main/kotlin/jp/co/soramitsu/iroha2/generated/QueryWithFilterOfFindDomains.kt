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
 * QueryWithFilterOfFindDomains
 *
 * Generated from 'QueryWithFilterOfFindDomains' regular structure
 */
public data class QueryWithFilterOfFindDomains(
    public val query: FindDomains,
    public val predicate: CompoundPredicateOfDomain,
    public val selector: SelectorTupleOfDomain,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindDomains>,
        ScaleWriter<QueryWithFilterOfFindDomains> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindDomains =
            try {
                QueryWithFilterOfFindDomains(
                    FindDomains.read(reader),
                    CompoundPredicateOfDomain.read(reader),
                    SelectorTupleOfDomain.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindDomains,
        ): Unit =
            try {
                FindDomains.write(writer, instance.query)
                CompoundPredicateOfDomain.write(writer, instance.predicate)
                SelectorTupleOfDomain.write(writer, instance.selector)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
