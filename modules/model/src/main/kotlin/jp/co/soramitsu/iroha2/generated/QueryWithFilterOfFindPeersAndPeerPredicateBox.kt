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
 * QueryWithFilterOfFindPeersAndPeerPredicateBox
 *
 * Generated from 'QueryWithFilterOfFindPeersAndPeerPredicateBox' regular structure
 */
public data class QueryWithFilterOfFindPeersAndPeerPredicateBox(
    public val query: FindPeers,
    public val predicate: CompoundPredicateOfPeerPredicateBox,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindPeersAndPeerPredicateBox>,
        ScaleWriter<QueryWithFilterOfFindPeersAndPeerPredicateBox> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindPeersAndPeerPredicateBox = try {
            QueryWithFilterOfFindPeersAndPeerPredicateBox(
                FindPeers.read(reader),
                CompoundPredicateOfPeerPredicateBox.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindPeersAndPeerPredicateBox,
        ): Unit = try {
            FindPeers.write(writer, instance.query)
            CompoundPredicateOfPeerPredicateBox.write(writer, instance.predicate)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
