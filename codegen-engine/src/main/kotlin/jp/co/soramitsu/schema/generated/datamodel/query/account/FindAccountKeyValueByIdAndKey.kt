// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.query.account

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo
import kotlin.Unit

/**
 * FindAccountKeyValueByIdAndKey
 *
 * Generated from 'iroha_data_model::query::account::FindAccountKeyValueByIdAndKey' regular
 * structure
 */
public class FindAccountKeyValueByIdAndKey(
  private val id: EvaluatesTo,
  private val key: EvaluatesTo
) {
  public companion object CODEC : ScaleReader<FindAccountKeyValueByIdAndKey>,
      ScaleWriter<FindAccountKeyValueByIdAndKey> {
    public override fun read(reader: ScaleCodecReader): FindAccountKeyValueByIdAndKey =
        FindAccountKeyValueByIdAndKey(jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.read(reader),
        jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.read(reader))

    public override fun write(writer: ScaleCodecWriter, instance: FindAccountKeyValueByIdAndKey):
        Unit {
      jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.write(writer, instance.id)
      jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.write(writer, instance.key)
    }
  }
}
