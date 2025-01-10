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
 * QueryWithFilterOfFindBlockHeadersAndBlockHeaderPredicateBox
 *
 * Generated from 'QueryWithFilterOfFindBlockHeadersAndBlockHeaderPredicateBox' regular structure
 */
public data class QueryWithFilterOfFindBlockHeadersAndBlockHeaderPredicateBox(
    public val query: FindBlockHeaders,
    public val predicate: CompoundPredicateOfBlockHeaderPredicateBox,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindBlockHeadersAndBlockHeaderPredicateBox>,
        ScaleWriter<QueryWithFilterOfFindBlockHeadersAndBlockHeaderPredicateBox> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindBlockHeadersAndBlockHeaderPredicateBox = try {
            QueryWithFilterOfFindBlockHeadersAndBlockHeaderPredicateBox(
                FindBlockHeaders.read(reader),
                CompoundPredicateOfBlockHeaderPredicateBox.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindBlockHeadersAndBlockHeaderPredicateBox,
        ): Unit = try {
            FindBlockHeaders.write(writer, instance.query)
            CompoundPredicateOfBlockHeaderPredicateBox.write(writer, instance.predicate)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
