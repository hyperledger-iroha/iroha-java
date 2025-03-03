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
 * QueryWithFilterOfFindTriggers
 *
 * Generated from 'QueryWithFilterOfFindTriggers' regular structure
 */
public data class QueryWithFilterOfFindTriggers(
    public val query: FindTriggers,
    public val predicate: CompoundPredicateOfTrigger,
    public val selector: SelectorTupleOfTrigger,
) {
    public companion object :
        ScaleReader<QueryWithFilterOfFindTriggers>,
        ScaleWriter<QueryWithFilterOfFindTriggers> {
        override fun read(reader: ScaleCodecReader): QueryWithFilterOfFindTriggers =
            try {
                QueryWithFilterOfFindTriggers(
                    FindTriggers.read(reader),
                    CompoundPredicateOfTrigger.read(reader),
                    SelectorTupleOfTrigger.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: QueryWithFilterOfFindTriggers,
        ): Unit =
            try {
                FindTriggers.write(writer, instance.query)
                CompoundPredicateOfTrigger.write(writer, instance.predicate)
                SelectorTupleOfTrigger.write(writer, instance.selector)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
