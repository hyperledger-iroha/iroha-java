//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Long
import kotlin.Unit

/**
 * AtIndex
 *
 * Generated from 'AtIndex' regular structure
 */
public data class AtIndex(
    public val index: Long,
    public val predicate: QueryOutputPredicate,
) {
    public companion object : ScaleReader<AtIndex>, ScaleWriter<AtIndex> {
        override fun read(reader: ScaleCodecReader): AtIndex = try {
            AtIndex(
                reader.readUint32(),
                QueryOutputPredicate.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: AtIndex): Unit = try {
            writer.writeUint32(instance.index)
            QueryOutputPredicate.write(writer, instance.predicate)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
