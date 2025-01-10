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
 * QueryWithFilterOfFindTriggersAndTriggerPredicateBox
 *
 * Generated from 'QueryWithFilterOfFindTriggersAndTriggerPredicateBox' regular structure
 */
public data class QueryWithFilterOfFindTriggersAndTriggerPredicateBox(
    public val query: FindTriggers,
    public val predicate: CompoundPredicateOfTriggerPredicateBox,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindTriggersAndTriggerPredicateBox>,
        ScaleWriter<QueryWithFilterOfFindTriggersAndTriggerPredicateBox> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindTriggersAndTriggerPredicateBox = try {
            QueryWithFilterOfFindTriggersAndTriggerPredicateBox(
                FindTriggers.read(reader),
                CompoundPredicateOfTriggerPredicateBox.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindTriggersAndTriggerPredicateBox,
        ): Unit = try {
            FindTriggers.write(writer, instance.query)
            CompoundPredicateOfTriggerPredicateBox.write(writer, instance.predicate)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
