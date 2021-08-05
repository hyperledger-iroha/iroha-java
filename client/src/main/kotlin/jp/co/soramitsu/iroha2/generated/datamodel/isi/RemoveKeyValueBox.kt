//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated.datamodel.isi

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import jp.co.soramitsu.iroha2.generated.datamodel.IdBox
import jp.co.soramitsu.iroha2.generated.datamodel.expression.EvaluatesTo
import kotlin.String
import kotlin.Unit

/**
 * RemoveKeyValueBox
 *
 * Generated from 'iroha_data_model::isi::RemoveKeyValueBox' regular structure
 */
public class RemoveKeyValueBox(
  public val objectId: EvaluatesTo<IdBox>,
  public val key: EvaluatesTo<String>
) {
  public companion object : ScaleReader<RemoveKeyValueBox>, ScaleWriter<RemoveKeyValueBox> {
    public override fun read(reader: ScaleCodecReader): RemoveKeyValueBox = RemoveKeyValueBox(
      EvaluatesTo.read(reader) as EvaluatesTo<IdBox>,
      EvaluatesTo.read(reader) as EvaluatesTo<String>,
    )

    public override fun write(writer: ScaleCodecWriter, instance: RemoveKeyValueBox): Unit {
        EvaluatesTo.write(writer, instance.objectId)
        EvaluatesTo.write(writer, instance.key)
    }
  }
}
