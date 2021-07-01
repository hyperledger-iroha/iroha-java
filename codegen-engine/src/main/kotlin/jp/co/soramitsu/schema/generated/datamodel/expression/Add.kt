// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.expression

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import kotlin.Unit

/**
 * Add
 *
 * Generated from 'iroha_data_model::expression::Add' regular structure
 */
public class Add(
  private val left: EvaluatesTo,
  private val right: EvaluatesTo
) {
  public companion object CODEC : ScaleReader<Add>, ScaleWriter<Add> {
    public override fun read(reader: ScaleCodecReader): Add = Add(EvaluatesTo.read(reader),
        EvaluatesTo.read(reader))

    public override fun write(writer: ScaleCodecWriter, instance: Add): Unit {
      EvaluatesTo.write(writer, instance.left)
      EvaluatesTo.write(writer, instance.right)
    }
  }
}
