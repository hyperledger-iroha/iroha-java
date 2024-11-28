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
 * QueryWithFilterOfFindPermissionsByAccountId
 *
 * Generated from 'QueryWithFilterOfFindPermissionsByAccountId' regular structure
 */
public data class QueryWithFilterOfFindPermissionsByAccountId(
    public val query: FindPermissionsByAccountId,
    public val predicate: CompoundPredicateOfPermission,
    public val selector: SelectorTupleOfPermission,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindPermissionsByAccountId>,
        ScaleWriter<QueryWithFilterOfFindPermissionsByAccountId> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindPermissionsByAccountId = try {
            QueryWithFilterOfFindPermissionsByAccountId(
                FindPermissionsByAccountId.read(reader),
                CompoundPredicateOfPermission.read(reader),
                SelectorTupleOfPermission.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: QueryWithFilterOfFindPermissionsByAccountId): Unit = try {
            FindPermissionsByAccountId.write(writer, instance.query)
            CompoundPredicateOfPermission.write(writer, instance.predicate)
            SelectorTupleOfPermission.write(writer, instance.selector)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
