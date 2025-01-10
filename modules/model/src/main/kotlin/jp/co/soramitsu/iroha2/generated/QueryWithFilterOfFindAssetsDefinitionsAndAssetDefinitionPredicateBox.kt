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
 * QueryWithFilterOfFindAssetsDefinitionsAndAssetDefinitionPredicateBox
 *
 * Generated from 'QueryWithFilterOfFindAssetsDefinitionsAndAssetDefinitionPredicateBox' regular
 * structure
 */
public data class QueryWithFilterOfFindAssetsDefinitionsAndAssetDefinitionPredicateBox(
    public val query: FindAssetsDefinitions,
    public val predicate: CompoundPredicateOfAssetDefinitionPredicateBox,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindAssetsDefinitionsAndAssetDefinitionPredicateBox>,
        ScaleWriter<QueryWithFilterOfFindAssetsDefinitionsAndAssetDefinitionPredicateBox> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindAssetsDefinitionsAndAssetDefinitionPredicateBox = try {
            QueryWithFilterOfFindAssetsDefinitionsAndAssetDefinitionPredicateBox(
                FindAssetsDefinitions.read(reader),
                CompoundPredicateOfAssetDefinitionPredicateBox.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindAssetsDefinitionsAndAssetDefinitionPredicateBox,
        ): Unit = try {
            FindAssetsDefinitions.write(writer, instance.query)
            CompoundPredicateOfAssetDefinitionPredicateBox.write(writer, instance.predicate)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
