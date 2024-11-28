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
import kotlin.collections.List

/**
 * QueryOutputBatchBoxTuple
 *
 * Generated from 'QueryOutputBatchBoxTuple' regular structure
 */
public data class QueryOutputBatchBoxTuple(public val tuple: List<QueryOutputBatchBox>) {
    public companion object :
        ScaleReader<QueryOutputBatchBoxTuple>,
        ScaleWriter<QueryOutputBatchBoxTuple> {
        override fun read(reader: ScaleCodecReader): QueryOutputBatchBoxTuple = try {
            QueryOutputBatchBoxTuple(
                reader.readVec(reader.readCompactInt()) { QueryOutputBatchBox.read(reader) },
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: QueryOutputBatchBoxTuple): Unit = try {
            writer.writeCompact(instance.tuple.size)
            instance.tuple.forEach { value ->
                QueryOutputBatchBox.write(writer, value)
            }
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
