// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.expression

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

/**
 * Where
 *
 * Generated from 'iroha_data_model::expression::Where' regular structure
 */
public class Where(
  private val expression: EvaluatesTo,
  private val values: Map<String, EvaluatesTo>
) {
  public companion object : ScaleReader<Where>, ScaleWriter<Where> {
    public override fun read(reader: ScaleCodecReader): Where =
        Where(jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.read(reader),
        reader.read(jp.co.soramitsu.schema.codegen.MapReader(kotlin.String,
        jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo)))

    public override fun write(writer: ScaleCodecWriter, instance: Where): Unit {
      jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.write(writer,
          instance.`expression`)
      writer.write(jp.co.soramitsu.schema.codegen.MapWriter(kotlin.String,
          jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo), instance.`values`)
    }
  }
}
