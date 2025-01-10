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
 * QueryWithFilterOfFindBlocksAndSignedBlockPredicateBox
 *
 * Generated from 'QueryWithFilterOfFindBlocksAndSignedBlockPredicateBox' regular structure
 */
public data class QueryWithFilterOfFindBlocksAndSignedBlockPredicateBox(
    public val query: FindBlocks,
    public val predicate: CompoundPredicateOfSignedBlockPredicateBox,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindBlocksAndSignedBlockPredicateBox>,
        ScaleWriter<QueryWithFilterOfFindBlocksAndSignedBlockPredicateBox> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindBlocksAndSignedBlockPredicateBox = try {
            QueryWithFilterOfFindBlocksAndSignedBlockPredicateBox(
                FindBlocks.read(reader),
                CompoundPredicateOfSignedBlockPredicateBox.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindBlocksAndSignedBlockPredicateBox,
        ): Unit = try {
            FindBlocks.write(writer, instance.query)
            CompoundPredicateOfSignedBlockPredicateBox.write(writer, instance.predicate)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
