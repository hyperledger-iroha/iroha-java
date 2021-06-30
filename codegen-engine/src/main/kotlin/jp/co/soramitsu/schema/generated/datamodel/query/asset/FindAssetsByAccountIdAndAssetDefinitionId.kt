// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.query.asset

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import jp.co.soramitsu.schema.codegen.read
import jp.co.soramitsu.schema.codegen.write
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
) : ScaleReader<FindAssetsByAccountIdAndAssetDefinitionId>,
    ScaleWriter<FindAssetsByAccountIdAndAssetDefinitionId> {
  public override fun read(reader: ScaleCodecReader): FindAssetsByAccountIdAndAssetDefinitionId =
      FindAssetsByAccountIdAndAssetDefinitionId(jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.READER.read(reader),jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.READER.read(reader))

  public override fun write(writer: ScaleCodecWriter,
      instance: FindAssetsByAccountIdAndAssetDefinitionId): Unit {
    jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.READER.read(reader),
    jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo.READER.read(reader)
  }
}
