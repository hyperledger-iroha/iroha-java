//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import java.math.BigInteger
import kotlin.Unit

/**
 * QueryOutput
 *
 * Generated from 'QueryOutput' regular structure
 */
public data class QueryOutput(
    public val batch: QueryOutputBatchBox,
    public val remainingItems: BigInteger,
    public val continueCursor: ForwardCursor? = null,
) {
    public companion object : ScaleReader<QueryOutput>, ScaleWriter<QueryOutput> {
        override fun read(reader: ScaleCodecReader): QueryOutput = try {
            QueryOutput(
                QueryOutputBatchBox.read(reader),
                reader.readUint64(),
                reader.readNullable(ForwardCursor) as ForwardCursor?,
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: QueryOutput): Unit = try {
            QueryOutputBatchBox.write(writer, instance.batch)
            writer.writeUint64(instance.remainingItems)
            writer.writeNullable(ForwardCursor, instance.continueCursor)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
