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
 * QueryWithFilterOfFindPeers
 *
 * Generated from 'QueryWithFilterOfFindPeers' regular structure
 */
public data class QueryWithFilterOfFindPeers(
    public val query: FindPeers,
    public val predicate: CompoundPredicateOfPeerId,
    public val selector: SelectorTupleOfPeerId,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindPeers>,
        ScaleWriter<QueryWithFilterOfFindPeers> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindPeers = try {
            QueryWithFilterOfFindPeers(
                FindPeers.read(reader),
                CompoundPredicateOfPeerId.read(reader),
                SelectorTupleOfPeerId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: QueryWithFilterOfFindPeers): Unit = try {
            FindPeers.write(writer, instance.query)
            CompoundPredicateOfPeerId.write(writer, instance.predicate)
            SelectorTupleOfPeerId.write(writer, instance.selector)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
