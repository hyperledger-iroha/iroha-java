// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.isi

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo
import kotlin.Unit

/**
 * RegisterBox
 *
 * Generated from 'iroha_data_model::isi::RegisterBox' regular structure
 */
public class RegisterBox(
  private val `object`: EvaluatesTo
) {
  public companion object CODEC : ScaleReader<RegisterBox>, ScaleWriter<RegisterBox> {
    public override fun read(reader: ScaleCodecReader): RegisterBox =
        RegisterBox(jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.read(reader))

    public override fun write(writer: ScaleCodecWriter, instance: RegisterBox): Unit {
      jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.write(writer,
          instance.object)
    }
  }
}
