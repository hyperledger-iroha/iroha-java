// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.query.asset

import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo

/**
 * FindAssetById
 *
 * Generated from 'iroha_data_model::query::asset::FindAssetById' regular structure
 */
public class FindAssetById(
  private val id: EvaluatesTo
) : ScaleCodecWriter<FindAssetById>()
