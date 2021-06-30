// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.account

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import jp.co.soramitsu.schema.codegen.read
import jp.co.soramitsu.schema.codegen.write
import jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo
import kotlin.Unit

/**
 * SignatureCheckCondition
 *
 * Generated from 'iroha_data_model::account::SignatureCheckCondition' tuple structure
 */
public class SignatureCheckCondition(
  private val evaluatesTo: EvaluatesTo
) : ScaleReader<SignatureCheckCondition>, ScaleWriter<SignatureCheckCondition> {
  public override fun read(reader: ScaleCodecReader): SignatureCheckCondition =
      SignatureCheckCondition(evaluatesTo.read(reader))

  public override fun write(writer: ScaleCodecWriter, instance: SignatureCheckCondition): Unit {
    evaluatesTo.write(writer, instance.evaluatesTo)
  }
}
