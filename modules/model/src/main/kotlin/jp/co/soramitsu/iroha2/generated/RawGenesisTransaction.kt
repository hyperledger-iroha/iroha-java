//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

/**
 * RawGenesisTransaction
 *
 * Generated from 'RawGenesisTransaction' regular structure
 */
public data class RawGenesisTransaction(
    public val chain: ChainId,
    public val executor: String,
    public val parameters: List<Parameter>,
    public val instructions: List<InstructionBox>,
    public val topology: List<PeerId>,
) {
    public companion object : ScaleReader<RawGenesisTransaction>, ScaleWriter<RawGenesisTransaction> {
        override fun read(reader: ScaleCodecReader): RawGenesisTransaction = try {
            RawGenesisTransaction(
                ChainId.read(reader),
                reader.readString(),
                reader.readVec(reader.readCompactInt()) { Parameter.read(reader) },
                reader.readVec(reader.readCompactInt()) { InstructionBox.read(reader) },
                reader.readVec(reader.readCompactInt()) { PeerId.read(reader) },
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: RawGenesisTransaction): Unit = try {
            ChainId.write(writer, instance.chain)
            writer.writeAsList(instance.executor.toByteArray(Charsets.UTF_8))
            writer.writeCompact(instance.parameters.size)
            instance.parameters.forEach { value ->
                Parameter.write(writer, value)
            }
            writer.writeCompact(instance.instructions.size)
            instance.instructions.forEach { value ->
                InstructionBox.write(writer, value)
            }
            writer.writeCompact(instance.topology.size)
            instance.topology.forEach { value ->
                PeerId.write(writer, value)
            }
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
