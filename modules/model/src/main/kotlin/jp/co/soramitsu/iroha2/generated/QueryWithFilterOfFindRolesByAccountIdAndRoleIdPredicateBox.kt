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
 * QueryWithFilterOfFindRolesByAccountIdAndRoleIdPredicateBox
 *
 * Generated from 'QueryWithFilterOfFindRolesByAccountIdAndRoleIdPredicateBox' regular structure
 */
public data class QueryWithFilterOfFindRolesByAccountIdAndRoleIdPredicateBox(
    public val query: FindRolesByAccountId,
    public val predicate: CompoundPredicateOfRoleIdPredicateBox,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindRolesByAccountIdAndRoleIdPredicateBox>,
        ScaleWriter<QueryWithFilterOfFindRolesByAccountIdAndRoleIdPredicateBox> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindRolesByAccountIdAndRoleIdPredicateBox = try {
            QueryWithFilterOfFindRolesByAccountIdAndRoleIdPredicateBox(
                FindRolesByAccountId.read(reader),
                CompoundPredicateOfRoleIdPredicateBox.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindRolesByAccountIdAndRoleIdPredicateBox,
        ): Unit = try {
            FindRolesByAccountId.write(writer, instance.query)
            CompoundPredicateOfRoleIdPredicateBox.write(writer, instance.predicate)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
