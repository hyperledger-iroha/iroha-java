// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.isi

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo
import kotlin.Unit

/**
 * RemoveKeyValueBox
 *
 * Generated from 'iroha_data_model::isi::RemoveKeyValueBox' regular structure
 */
public class RemoveKeyValueBox(
  private val objectId: EvaluatesTo,
  private val key: EvaluatesTo
) {
  public companion object : ScaleReader<RemoveKeyValueBox>, ScaleWriter<RemoveKeyValueBox> {
    public override fun read(reader: ScaleCodecReader): RemoveKeyValueBox =
        RemoveKeyValueBox(jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.read(reader),
        jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.read(reader))

    public override fun write(writer: ScaleCodecWriter, instance: RemoveKeyValueBox): Unit {
      jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.write(writer,
          instance.`objectId`)
      jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.write(writer,
          instance.`key`)
    }
  }
}
