//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated.core.block

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.generated.core.sumeragi.networktopology.Topology
import jp.co.soramitsu.iroha2.generated.crypto.hash.HashOf
import jp.co.soramitsu.iroha2.generated.datamodel.transaction.VersionedSignedTransaction
import jp.co.soramitsu.iroha2.wrapException
import java.math.BigInteger
import kotlin.collections.List

/**
 * BlockHeader
 *
 * Generated from 'iroha_core::block::BlockHeader' regular structure
 */
public data class BlockHeader(
    public val timestamp: BigInteger,
    public val consensusEstimation: BigInteger,
    public val height: BigInteger,
    public val previousBlockHash: HashOf<VersionedCommittedBlock>,
    public val transactionsHash: HashOf<List<VersionedSignedTransaction>>,
    public val rejectedTransactionsHash: HashOf<List<VersionedSignedTransaction>>,
    public val genesisTopology: Topology? = null
) {
    public companion object : ScaleReader<BlockHeader>, ScaleWriter<BlockHeader> {
        public override fun read(reader: ScaleCodecReader): BlockHeader = try {
            BlockHeader(
                reader.readUint128(),
                reader.readUint64(),
                reader.readUint64(),
                HashOf.read(reader) as HashOf<VersionedCommittedBlock>,
                HashOf.read(reader) as HashOf<List<VersionedSignedTransaction>>,
                HashOf.read(reader) as HashOf<List<VersionedSignedTransaction>>,
                reader.readNullable(Topology),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        public override fun write(writer: ScaleCodecWriter, instance: BlockHeader) = try {
            writer.writeUint128(instance.timestamp)
            writer.writeUint64(instance.consensusEstimation)
            writer.writeUint64(instance.height)
            HashOf.write(writer, instance.previousBlockHash)
            HashOf.write(writer, instance.transactionsHash)
            HashOf.write(writer, instance.rejectedTransactionsHash)
            writer.writeNullable(Topology, instance.genesisTopology)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
