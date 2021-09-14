//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated.datamodel.isi

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.collections.MutableList

/**
 * SequenceBox
 *
 * Generated from 'iroha_data_model::isi::SequenceBox' regular structure
 */
public data class SequenceBox(
    public val instructions: MutableList<Instruction>
) {
    public companion object : ScaleReader<SequenceBox>, ScaleWriter<SequenceBox> {
        public override fun read(reader: ScaleCodecReader): SequenceBox = try {
            SequenceBox(
                MutableList(reader.readCompactInt()) { Instruction.read(reader) },
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        public override fun write(writer: ScaleCodecWriter, instance: SequenceBox) = try {
            writer.writeCompact(instance.instructions.size)
            instance.instructions.forEach { value -> Instruction.write(writer, value) }
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
