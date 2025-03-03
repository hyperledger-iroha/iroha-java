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
 * QueryWithFilterOfFindAssets
 *
 * Generated from 'QueryWithFilterOfFindAssets' regular structure
 */
public data class QueryWithFilterOfFindAssets(
    public val query: FindAssets,
    public val predicate: CompoundPredicateOfAsset,
    public val selector: SelectorTupleOfAsset,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindAssets>,
        ScaleWriter<QueryWithFilterOfFindAssets> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindAssets =
            try {
                QueryWithFilterOfFindAssets(
                    FindAssets.read(reader),
                    CompoundPredicateOfAsset.read(reader),
                    SelectorTupleOfAsset.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindAssets,
        ): Unit =
            try {
                FindAssets.write(writer, instance.query)
                CompoundPredicateOfAsset.write(writer, instance.predicate)
                SelectorTupleOfAsset.write(writer, instance.selector)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
