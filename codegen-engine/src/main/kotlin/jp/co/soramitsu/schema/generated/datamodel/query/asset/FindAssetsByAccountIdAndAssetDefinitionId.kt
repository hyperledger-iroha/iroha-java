// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.query.asset

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo
import kotlin.Unit

/**
 * FindAssetsByAccountIdAndAssetDefinitionId
 *
 * Generated from 'iroha_data_model::query::asset::FindAssetsByAccountIdAndAssetDefinitionId'
 * regular structure
 */
public class FindAssetsByAccountIdAndAssetDefinitionId(
  private val accountId: EvaluatesTo,
  private val assetDefinitionId: EvaluatesTo
) {
  public companion object CODEC : ScaleReader<FindAssetsByAccountIdAndAssetDefinitionId>,
      ScaleWriter<FindAssetsByAccountIdAndAssetDefinitionId> {
    public override fun read(reader: ScaleCodecReader): FindAssetsByAccountIdAndAssetDefinitionId =
        FindAssetsByAccountIdAndAssetDefinitionId(EvaluatesTo.read(reader),
        EvaluatesTo.read(reader))

    public override fun write(writer: ScaleCodecWriter,
        instance: FindAssetsByAccountIdAndAssetDefinitionId): Unit {
      EvaluatesTo.write(writer, instance.accountId)
      EvaluatesTo.write(writer, instance.assetDefinitionId)
    }
  }
}
