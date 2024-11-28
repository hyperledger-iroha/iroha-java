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
 * QueryWithFilterOfFindBlockHeaders
 *
 * Generated from 'QueryWithFilterOfFindBlockHeaders' regular structure
 */
public data class QueryWithFilterOfFindBlockHeaders(
    public val query: FindBlockHeaders,
    public val predicate: CompoundPredicateOfBlockHeader,
    public val selector: SelectorTupleOfBlockHeader,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindBlockHeaders>,
        ScaleWriter<QueryWithFilterOfFindBlockHeaders> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindBlockHeaders = try {
            QueryWithFilterOfFindBlockHeaders(
                FindBlockHeaders.read(reader),
                CompoundPredicateOfBlockHeader.read(reader),
                SelectorTupleOfBlockHeader.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: QueryWithFilterOfFindBlockHeaders): Unit = try {
            FindBlockHeaders.write(writer, instance.query)
            CompoundPredicateOfBlockHeader.write(writer, instance.predicate)
            SelectorTupleOfBlockHeader.write(writer, instance.selector)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
