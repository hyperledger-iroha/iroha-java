// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.asset

import io.emeraldpay.polkaj.scale.ScaleCodecWriter

/**
 * AssetDefinition
 *
 * Generated from 'iroha_data_model::asset::AssetDefinition' regular structure
 */
public class AssetDefinition(
  private val valueType: AssetValueType,
  private val id: DefinitionId
) : ScaleCodecWriter<AssetDefinition>()
