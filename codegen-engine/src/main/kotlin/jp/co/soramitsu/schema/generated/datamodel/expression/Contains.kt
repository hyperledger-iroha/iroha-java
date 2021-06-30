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
 * Contains
 *
 * Generated from 'iroha_data_model::expression::Contains' regular structure
 */
public class Contains(
  private val collection: EvaluatesTo,
  private val element: EvaluatesTo
) : ScaleReader<Contains>, ScaleWriter<Contains> {
  public override fun read(reader: ScaleCodecReader): Contains =
      Contains(jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.READER.read(reader),jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.READER.read(reader))

  public override fun write(writer: ScaleCodecWriter, instance: Contains): Unit {
    jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.READER.read(reader),
    jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.READER.read(reader)
  }
}
