//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated.core.sumeragi.networktopology

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.generated.core.block.VersionedCommittedBlock
import jp.co.soramitsu.iroha2.generated.crypto.hash.HashOf
import jp.co.soramitsu.iroha2.generated.datamodel.peer.PeerId
import jp.co.soramitsu.iroha2.wrapException
import kotlin.collections.List

/**
 * Topology
 *
 * Generated from 'iroha_core::sumeragi::network_topology::Topology' regular structure
 */
public data class Topology(
    public val sortedPeers: List<PeerId>,
    public val atBlock: HashOf<VersionedCommittedBlock>
) {
    public companion object : ScaleReader<Topology>, ScaleWriter<Topology> {
        public override fun read(reader: ScaleCodecReader): Topology = try {
            Topology(
                reader.readVec(reader.readCompactInt()) { PeerId.read(reader) },
                HashOf.read(reader) as HashOf<VersionedCommittedBlock>,
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        public override fun write(writer: ScaleCodecWriter, instance: Topology) = try {
            writer.writeCompact(instance.sortedPeers.size)
            instance.sortedPeers.forEach { value ->
                PeerId.write(writer, value)
            }
            HashOf.write(writer, instance.atBlock)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
