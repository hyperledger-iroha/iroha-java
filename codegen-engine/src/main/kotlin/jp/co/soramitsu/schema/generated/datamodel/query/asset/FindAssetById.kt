// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.query.asset

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo
import kotlin.Unit

/**
 * FindAssetById
 *
 * Generated from 'iroha_data_model::query::asset::FindAssetById' regular structure
 */
public class FindAssetById(
  private val id: EvaluatesTo
) {
  public companion object CODEC : ScaleReader<FindAssetById>, ScaleWriter<FindAssetById> {
    public override fun read(reader: ScaleCodecReader): FindAssetById =
        FindAssetById(jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.read(reader))

    public override fun write(writer: ScaleCodecWriter, instance: FindAssetById): Unit {
      jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.write(writer, instance.id)
    }
  }
}
