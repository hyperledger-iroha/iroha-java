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
 * SelectorTupleOfPeerId
 *
 * Generated from 'SelectorTupleOfPeerId' regular structure
 */
public data class SelectorTupleOfPeerId(public val vecOfPeerIdProjectionOfSelectorMarker: List<PeerIdProjectionOfSelectorMarker>) {
    public companion object : ScaleReader<SelectorTupleOfPeerId>, ScaleWriter<SelectorTupleOfPeerId> {
        override fun read(reader: ScaleCodecReader): SelectorTupleOfPeerId = try {
            SelectorTupleOfPeerId(
                reader.readVec(reader.readCompactInt()) { PeerIdProjectionOfSelectorMarker.read(reader) },
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: SelectorTupleOfPeerId): Unit = try {
            writer.writeCompact(instance.vecOfPeerIdProjectionOfSelectorMarker.size)
            instance.vecOfPeerIdProjectionOfSelectorMarker.forEach { value ->
                PeerIdProjectionOfSelectorMarker.write(writer, value)
            }
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
