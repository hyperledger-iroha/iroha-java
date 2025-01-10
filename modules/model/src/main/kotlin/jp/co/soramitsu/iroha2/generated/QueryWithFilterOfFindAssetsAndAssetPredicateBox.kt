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
 * QueryWithFilterOfFindAssetsAndAssetPredicateBox
 *
 * Generated from 'QueryWithFilterOfFindAssetsAndAssetPredicateBox' regular structure
 */
public data class QueryWithFilterOfFindAssetsAndAssetPredicateBox(
    public val query: FindAssets,
    public val predicate: CompoundPredicateOfAssetPredicateBox,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindAssetsAndAssetPredicateBox>,
        ScaleWriter<QueryWithFilterOfFindAssetsAndAssetPredicateBox> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindAssetsAndAssetPredicateBox =
            try {
                QueryWithFilterOfFindAssetsAndAssetPredicateBox(
                    FindAssets.read(reader),
                    CompoundPredicateOfAssetPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindAssetsAndAssetPredicateBox,
        ): Unit = try {
            FindAssets.write(writer, instance.query)
            CompoundPredicateOfAssetPredicateBox.write(writer, instance.predicate)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
