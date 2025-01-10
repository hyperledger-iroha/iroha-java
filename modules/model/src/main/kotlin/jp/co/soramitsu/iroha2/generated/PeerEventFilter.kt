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
 * PeerEventFilter
 *
 * Generated from 'PeerEventFilter' regular structure
 */
public data class PeerEventFilter(
    public val idMatcher: PeerId? = null,
    public val eventSet: Long,
) {
    public companion object : ScaleReader<PeerEventFilter>, ScaleWriter<PeerEventFilter> {
        override fun read(reader: ScaleCodecReader): PeerEventFilter = try {
            PeerEventFilter(
                reader.readNullable(PeerId) as PeerId?,
                reader.readUint32(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: PeerEventFilter): Unit = try {
            writer.writeNullable(PeerId, instance.idMatcher)
            writer.writeUint32(instance.eventSet)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
