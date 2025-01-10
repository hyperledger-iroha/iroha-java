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
 * QueryWithFilterOfFindAccountsWithAssetAndAccountPredicateBox
 *
 * Generated from 'QueryWithFilterOfFindAccountsWithAssetAndAccountPredicateBox' regular structure
 */
public data class QueryWithFilterOfFindAccountsWithAssetAndAccountPredicateBox(
    public val query: FindAccountsWithAsset,
    public val predicate: CompoundPredicateOfAccountPredicateBox,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindAccountsWithAssetAndAccountPredicateBox>,
        ScaleWriter<QueryWithFilterOfFindAccountsWithAssetAndAccountPredicateBox> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindAccountsWithAssetAndAccountPredicateBox = try {
            QueryWithFilterOfFindAccountsWithAssetAndAccountPredicateBox(
                FindAccountsWithAsset.read(reader),
                CompoundPredicateOfAccountPredicateBox.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindAccountsWithAssetAndAccountPredicateBox,
        ): Unit = try {
            FindAccountsWithAsset.write(writer, instance.query)
            CompoundPredicateOfAccountPredicateBox.write(writer, instance.predicate)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
