// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.query.asset

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo
import kotlin.Unit

/**
 * FindAssetsByDomainNameAndAssetDefinitionId
 *
 * Generated from 'iroha_data_model::query::asset::FindAssetsByDomainNameAndAssetDefinitionId'
 * regular structure
 */
public class FindAssetsByDomainNameAndAssetDefinitionId(
  private val domainName: EvaluatesTo,
  private val assetDefinitionId: EvaluatesTo
) {
  public companion object CODEC : ScaleReader<FindAssetsByDomainNameAndAssetDefinitionId>,
      ScaleWriter<FindAssetsByDomainNameAndAssetDefinitionId> {
    public override fun read(reader: ScaleCodecReader): FindAssetsByDomainNameAndAssetDefinitionId =
        FindAssetsByDomainNameAndAssetDefinitionId(EvaluatesTo.read(reader),
        EvaluatesTo.read(reader))

    public override fun write(writer: ScaleCodecWriter,
        instance: FindAssetsByDomainNameAndAssetDefinitionId): Unit {
      EvaluatesTo.write(writer, instance.domainName)
      EvaluatesTo.write(writer, instance.assetDefinitionId)
    }
  }
}
