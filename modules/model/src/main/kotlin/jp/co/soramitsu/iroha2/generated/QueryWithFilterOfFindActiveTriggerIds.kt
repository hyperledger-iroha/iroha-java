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
 * QueryWithFilterOfFindActiveTriggerIds
 *
 * Generated from 'QueryWithFilterOfFindActiveTriggerIds' regular structure
 */
public data class QueryWithFilterOfFindActiveTriggerIds(
    public val query: FindActiveTriggerIds,
    public val predicate: CompoundPredicateOfTriggerId,
    public val selector: SelectorTupleOfTriggerId,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindActiveTriggerIds>,
        ScaleWriter<QueryWithFilterOfFindActiveTriggerIds> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindActiveTriggerIds = try {
            QueryWithFilterOfFindActiveTriggerIds(
                FindActiveTriggerIds.read(reader),
                CompoundPredicateOfTriggerId.read(reader),
                SelectorTupleOfTriggerId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: QueryWithFilterOfFindActiveTriggerIds): Unit = try {
            FindActiveTriggerIds.write(writer, instance.query)
            CompoundPredicateOfTriggerId.write(writer, instance.predicate)
            SelectorTupleOfTriggerId.write(writer, instance.selector)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
