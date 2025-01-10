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
 * QueryWithFilterOfFindRoleIdsAndRoleIdPredicateBox
 *
 * Generated from 'QueryWithFilterOfFindRoleIdsAndRoleIdPredicateBox' regular structure
 */
public data class QueryWithFilterOfFindRoleIdsAndRoleIdPredicateBox(
    public val query: FindRoleIds,
    public val predicate: CompoundPredicateOfRoleIdPredicateBox,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindRoleIdsAndRoleIdPredicateBox>,
        ScaleWriter<QueryWithFilterOfFindRoleIdsAndRoleIdPredicateBox> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindRoleIdsAndRoleIdPredicateBox =
            try {
                QueryWithFilterOfFindRoleIdsAndRoleIdPredicateBox(
                    FindRoleIds.read(reader),
                    CompoundPredicateOfRoleIdPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindRoleIdsAndRoleIdPredicateBox,
        ): Unit = try {
            FindRoleIds.write(writer, instance.query)
            CompoundPredicateOfRoleIdPredicateBox.write(writer, instance.predicate)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
