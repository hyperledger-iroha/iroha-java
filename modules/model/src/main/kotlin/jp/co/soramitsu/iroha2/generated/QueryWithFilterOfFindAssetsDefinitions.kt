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
 * QueryWithFilterOfFindAssetsDefinitions
 *
 * Generated from 'QueryWithFilterOfFindAssetsDefinitions' regular structure
 */
public data class QueryWithFilterOfFindAssetsDefinitions(
    public val query: FindAssetsDefinitions,
    public val predicate: CompoundPredicateOfAssetDefinition,
    public val selector: SelectorTupleOfAssetDefinition,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindAssetsDefinitions>,
        ScaleWriter<QueryWithFilterOfFindAssetsDefinitions> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindAssetsDefinitions =
            try {
                QueryWithFilterOfFindAssetsDefinitions(
                    FindAssetsDefinitions.read(reader),
                    CompoundPredicateOfAssetDefinition.read(reader),
                    SelectorTupleOfAssetDefinition.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindAssetsDefinitions,
        ): Unit =
            try {
                FindAssetsDefinitions.write(writer, instance.query)
                CompoundPredicateOfAssetDefinition.write(writer, instance.predicate)
                SelectorTupleOfAssetDefinition.write(writer, instance.selector)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
