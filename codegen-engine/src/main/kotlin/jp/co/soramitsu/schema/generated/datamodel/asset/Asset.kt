// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.asset

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import kotlin.Unit

/**
 * Asset
 *
 * Generated from 'iroha_data_model::asset::Asset' regular structure
 */
public class Asset(
  private val id: Id,
  private val `value`: AssetValue
) {
  public companion object CODEC : ScaleReader<Asset>, ScaleWriter<Asset> {
    public override fun read(reader: ScaleCodecReader): Asset =
        Asset(jp.co.soramitsu.schema.generated.datamodel.asset.Id.read(reader),
        jp.co.soramitsu.schema.generated.datamodel.asset.AssetValue.read(reader))

    public override fun write(writer: ScaleCodecWriter, instance: Asset): Unit {
      jp.co.soramitsu.schema.generated.datamodel.asset.Id.write(writer, instance.id)
      jp.co.soramitsu.schema.generated.datamodel.asset.AssetValue.write(writer, instance.value)
    }
  }
}
