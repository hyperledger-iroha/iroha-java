// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.expression

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import kotlin.Unit

/**
 * Not
 *
 * Generated from 'iroha_data_model::expression::Not' regular structure
 */
public class Not(
  private val expression: EvaluatesTo
) {
  public companion object CODEC : ScaleReader<Not>, ScaleWriter<Not> {
    public override fun read(reader: ScaleCodecReader): Not =
        Not(jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.read(reader))

    public override fun write(writer: ScaleCodecWriter, instance: Not): Unit {
      jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.write(writer,
          instance.expression)
    }
  }
}
