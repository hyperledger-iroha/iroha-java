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
 * QueryWithFilterOfFindRoles
 *
 * Generated from 'QueryWithFilterOfFindRoles' regular structure
 */
public data class QueryWithFilterOfFindRoles(
    public val query: FindRoles,
    public val predicate: CompoundPredicateOfRole,
    public val selector: SelectorTupleOfRole,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindRoles>,
        ScaleWriter<QueryWithFilterOfFindRoles> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindRoles = try {
            QueryWithFilterOfFindRoles(
                FindRoles.read(reader),
                CompoundPredicateOfRole.read(reader),
                SelectorTupleOfRole.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: QueryWithFilterOfFindRoles): Unit = try {
            FindRoles.write(writer, instance.query)
            CompoundPredicateOfRole.write(writer, instance.predicate)
            SelectorTupleOfRole.write(writer, instance.selector)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
