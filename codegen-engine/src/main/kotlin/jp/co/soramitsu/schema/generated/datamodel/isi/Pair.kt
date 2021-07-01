// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.isi

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import kotlin.Unit

/**
 * Pair
 *
 * Generated from 'iroha_data_model::isi::Pair' regular structure
 */
public class Pair(
  private val leftInstruction: Instruction,
  private val rightInstruction: Instruction
) {
  public companion object CODEC : ScaleReader<Pair>, ScaleWriter<Pair> {
    public override fun read(reader: ScaleCodecReader): Pair =
        Pair(jp.co.soramitsu.schema.generated.datamodel.isi.Instruction.read(reader),
        jp.co.soramitsu.schema.generated.datamodel.isi.Instruction.read(reader))

    public override fun write(writer: ScaleCodecWriter, instance: Pair): Unit {
      jp.co.soramitsu.schema.generated.datamodel.isi.Instruction.write(writer,
          instance.leftInstruction)
      jp.co.soramitsu.schema.generated.datamodel.isi.Instruction.write(writer,
          instance.rightInstruction)
    }
  }
}
