// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.query.asset

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo
import kotlin.Unit

/**
 * FindAssetsByDomainName
 *
 * Generated from 'iroha_data_model::query::asset::FindAssetsByDomainName' regular structure
 */
public class FindAssetsByDomainName(
  private val domainName: EvaluatesTo
) : ScaleReader<FindAssetsByDomainName>, ScaleWriter<FindAssetsByDomainName> {
  public override fun read(reader: ScaleCodecReader): FindAssetsByDomainName {
  }

  public override fun write(writer: ScaleCodecWriter, instance: FindAssetsByDomainName): Unit {
  }
}
