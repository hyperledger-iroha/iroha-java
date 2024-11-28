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
 * QueryWithFilterOfFindRolesByAccountId
 *
 * Generated from 'QueryWithFilterOfFindRolesByAccountId' regular structure
 */
public data class QueryWithFilterOfFindRolesByAccountId(
    public val query: FindRolesByAccountId,
    public val predicate: CompoundPredicateOfRoleId,
    public val selector: SelectorTupleOfRoleId,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindRolesByAccountId>,
        ScaleWriter<QueryWithFilterOfFindRolesByAccountId> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindRolesByAccountId = try {
            QueryWithFilterOfFindRolesByAccountId(
                FindRolesByAccountId.read(reader),
                CompoundPredicateOfRoleId.read(reader),
                SelectorTupleOfRoleId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: QueryWithFilterOfFindRolesByAccountId): Unit = try {
            FindRolesByAccountId.write(writer, instance.query)
            CompoundPredicateOfRoleId.write(writer, instance.predicate)
            SelectorTupleOfRoleId.write(writer, instance.selector)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
