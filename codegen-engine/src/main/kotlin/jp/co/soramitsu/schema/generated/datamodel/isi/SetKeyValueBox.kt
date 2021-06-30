// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.isi

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import jp.co.soramitsu.schema.codegen.read
import jp.co.soramitsu.schema.codegen.write
import jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo
import kotlin.Unit

/**
 * SetKeyValueBox
 *
 * Generated from 'iroha_data_model::isi::SetKeyValueBox' regular structure
 */
public class SetKeyValueBox(
  private val objectId: EvaluatesTo,
  private val key: EvaluatesTo,
  private val `value`: EvaluatesTo
) : ScaleReader<SetKeyValueBox>, ScaleWriter<SetKeyValueBox> {
  public override fun read(reader: ScaleCodecReader): SetKeyValueBox =
      SetKeyValueBox(jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.READER.read(reader),jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.READER.read(reader),jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.READER.read(reader))

  public override fun write(writer: ScaleCodecWriter, instance: SetKeyValueBox): Unit {
    jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.READER.read(reader),
    jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.READER.read(reader),
    jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.READER.read(reader)
  }
}
