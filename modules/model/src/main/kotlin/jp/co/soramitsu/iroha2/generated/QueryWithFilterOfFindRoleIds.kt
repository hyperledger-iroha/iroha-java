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
 * QueryWithFilterOfFindRoleIds
 *
 * Generated from 'QueryWithFilterOfFindRoleIds' regular structure
 */
public data class QueryWithFilterOfFindRoleIds(
    public val query: FindRoleIds,
    public val predicate: CompoundPredicateOfRoleId,
    public val selector: SelectorTupleOfRoleId,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindRoleIds>,
        ScaleWriter<QueryWithFilterOfFindRoleIds> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindRoleIds = try {
            QueryWithFilterOfFindRoleIds(
                FindRoleIds.read(reader),
                CompoundPredicateOfRoleId.read(reader),
                SelectorTupleOfRoleId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: QueryWithFilterOfFindRoleIds): Unit = try {
            FindRoleIds.write(writer, instance.query)
            CompoundPredicateOfRoleId.write(writer, instance.predicate)
            SelectorTupleOfRoleId.write(writer, instance.selector)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
