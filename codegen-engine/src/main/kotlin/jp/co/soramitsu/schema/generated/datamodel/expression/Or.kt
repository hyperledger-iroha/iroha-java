// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.expression

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import jp.co.soramitsu.schema.codegen.read
import jp.co.soramitsu.schema.codegen.write
import kotlin.Unit

/**
 * Or
 *
 * Generated from 'iroha_data_model::expression::Or' regular structure
 */
public class Or(
  private val left: EvaluatesTo,
  private val right: EvaluatesTo
) : ScaleReader<Or>, ScaleWriter<Or> {
  public override fun read(reader: ScaleCodecReader): Or =
      Or(jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.READER.read(reader),jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.READER.read(reader))

  public override fun write(writer: ScaleCodecWriter, instance: Or): Unit {
    jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.READER.read(reader),
    jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.READER.read(reader)
  }
}
