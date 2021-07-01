// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.query.account

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo
import kotlin.Unit

/**
 * FindAccountById
 *
 * Generated from 'iroha_data_model::query::account::FindAccountById' regular structure
 */
public class FindAccountById(
  private val id: EvaluatesTo
) {
  public companion object CODEC : ScaleReader<FindAccountById>, ScaleWriter<FindAccountById> {
    public override fun read(reader: ScaleCodecReader): FindAccountById =
        FindAccountById(EvaluatesTo.read(reader))

    public override fun write(writer: ScaleCodecWriter, instance: FindAccountById): Unit {
      EvaluatesTo.write(writer, instance.id)
    }
  }
}
