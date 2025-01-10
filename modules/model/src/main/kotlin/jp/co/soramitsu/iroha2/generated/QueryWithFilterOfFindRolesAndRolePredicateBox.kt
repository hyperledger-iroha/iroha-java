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
 * QueryWithFilterOfFindRolesAndRolePredicateBox
 *
 * Generated from 'QueryWithFilterOfFindRolesAndRolePredicateBox' regular structure
 */
public data class QueryWithFilterOfFindRolesAndRolePredicateBox(
    public val query: FindRoles,
    public val predicate: CompoundPredicateOfRolePredicateBox,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindRolesAndRolePredicateBox>,
        ScaleWriter<QueryWithFilterOfFindRolesAndRolePredicateBox> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindRolesAndRolePredicateBox = try {
            QueryWithFilterOfFindRolesAndRolePredicateBox(
                FindRoles.read(reader),
                CompoundPredicateOfRolePredicateBox.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindRolesAndRolePredicateBox,
        ): Unit = try {
            FindRoles.write(writer, instance.query)
            CompoundPredicateOfRolePredicateBox.write(writer, instance.predicate)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
