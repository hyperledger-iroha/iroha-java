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
 * QueryWithFilterOfFindActiveTriggerIdsAndTriggerIdPredicateBox
 *
 * Generated from 'QueryWithFilterOfFindActiveTriggerIdsAndTriggerIdPredicateBox' regular structure
 */
public data class QueryWithFilterOfFindActiveTriggerIdsAndTriggerIdPredicateBox(
    public val query: FindActiveTriggerIds,
    public val predicate: CompoundPredicateOfTriggerIdPredicateBox,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindActiveTriggerIdsAndTriggerIdPredicateBox>,
        ScaleWriter<QueryWithFilterOfFindActiveTriggerIdsAndTriggerIdPredicateBox> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindActiveTriggerIdsAndTriggerIdPredicateBox = try {
            QueryWithFilterOfFindActiveTriggerIdsAndTriggerIdPredicateBox(
                FindActiveTriggerIds.read(reader),
                CompoundPredicateOfTriggerIdPredicateBox.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindActiveTriggerIdsAndTriggerIdPredicateBox,
        ): Unit = try {
            FindActiveTriggerIds.write(writer, instance.query)
            CompoundPredicateOfTriggerIdPredicateBox.write(writer, instance.predicate)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
