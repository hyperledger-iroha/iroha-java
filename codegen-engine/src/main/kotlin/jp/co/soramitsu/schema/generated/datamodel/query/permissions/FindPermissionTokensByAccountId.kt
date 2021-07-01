// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.query.permissions

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo
import kotlin.Unit

/**
 * FindPermissionTokensByAccountId
 *
 * Generated from 'iroha_data_model::query::permissions::FindPermissionTokensByAccountId' regular
 * structure
 */
public class FindPermissionTokensByAccountId(
  private val id: EvaluatesTo
) {
  public companion object CODEC : ScaleReader<FindPermissionTokensByAccountId>,
      ScaleWriter<FindPermissionTokensByAccountId> {
    public override fun read(reader: ScaleCodecReader): FindPermissionTokensByAccountId =
        FindPermissionTokensByAccountId(EvaluatesTo.read(reader))

    public override fun write(writer: ScaleCodecWriter, instance: FindPermissionTokensByAccountId):
        Unit {
      EvaluatesTo.write(writer, instance.id)
    }
  }
}
