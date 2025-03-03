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
 * QueryWithFilterOfFindBlocks
 *
 * Generated from 'QueryWithFilterOfFindBlocks' regular structure
 */
public data class QueryWithFilterOfFindBlocks(
    public val query: FindBlocks,
    public val predicate: CompoundPredicateOfSignedBlock,
    public val selector: SelectorTupleOfSignedBlock,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindBlocks>,
        ScaleWriter<QueryWithFilterOfFindBlocks> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindBlocks =
            try {
                QueryWithFilterOfFindBlocks(
                    FindBlocks.read(reader),
                    CompoundPredicateOfSignedBlock.read(reader),
                    SelectorTupleOfSignedBlock.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindBlocks,
        ): Unit =
            try {
                FindBlocks.write(writer, instance.query)
                CompoundPredicateOfSignedBlock.write(writer, instance.predicate)
                SelectorTupleOfSignedBlock.write(writer, instance.selector)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
