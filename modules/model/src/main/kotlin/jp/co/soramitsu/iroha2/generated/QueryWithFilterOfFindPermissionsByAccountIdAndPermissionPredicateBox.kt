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
 * QueryWithFilterOfFindPermissionsByAccountIdAndPermissionPredicateBox
 *
 * Generated from 'QueryWithFilterOfFindPermissionsByAccountIdAndPermissionPredicateBox' regular
 * structure
 */
public data class QueryWithFilterOfFindPermissionsByAccountIdAndPermissionPredicateBox(
    public val query: FindPermissionsByAccountId,
    public val predicate: CompoundPredicateOfPermissionPredicateBox,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindPermissionsByAccountIdAndPermissionPredicateBox>,
        ScaleWriter<QueryWithFilterOfFindPermissionsByAccountIdAndPermissionPredicateBox> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindPermissionsByAccountIdAndPermissionPredicateBox = try {
            QueryWithFilterOfFindPermissionsByAccountIdAndPermissionPredicateBox(
                FindPermissionsByAccountId.read(reader),
                CompoundPredicateOfPermissionPredicateBox.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindPermissionsByAccountIdAndPermissionPredicateBox,
        ): Unit = try {
            FindPermissionsByAccountId.write(writer, instance.query)
            CompoundPredicateOfPermissionPredicateBox.write(writer, instance.predicate)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
