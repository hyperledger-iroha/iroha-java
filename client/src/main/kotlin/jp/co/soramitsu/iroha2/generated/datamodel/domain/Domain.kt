//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated.datamodel.domain

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import jp.co.soramitsu.iroha2.generated.datamodel.account.Account
import jp.co.soramitsu.iroha2.generated.datamodel.account.Id
import jp.co.soramitsu.iroha2.generated.datamodel.asset.AssetDefinitionEntry
import jp.co.soramitsu.iroha2.generated.datamodel.asset.DefinitionId
import jp.co.soramitsu.iroha2.utils.hashMapWithSize
import kotlin.String
import kotlin.Unit
import kotlin.collections.MutableMap

/**
 * Domain
 *
 * Generated from 'iroha_data_model::domain::Domain' regular structure
 */
public class Domain(
  public val name: String,
  public val accounts: MutableMap<Id, Account>,
  public val assetDefinitions: MutableMap<DefinitionId, AssetDefinitionEntry>
) {
  public companion object : ScaleReader<Domain>, ScaleWriter<Domain> {
    public override fun read(reader: ScaleCodecReader): Domain = Domain(
      reader.readString(),
      hashMapWithSize(reader.readCompactInt(), {Id.read(reader)}, {Account.read(reader)}),
      hashMapWithSize(reader.readCompactInt(), {DefinitionId.read(reader)},
          {AssetDefinitionEntry.read(reader)}),
    )

    public override fun write(writer: ScaleCodecWriter, instance: Domain): Unit {
        writer.writeAsList(instance.name.toByteArray(Charsets.UTF_8))
        writer.writeCompact(instance.accounts.size)
        instance.accounts.forEach { (key, value) ->  
        	Id.write(writer, key)
        	Account.write(writer, value)
        }
        writer.writeCompact(instance.assetDefinitions.size)
        instance.assetDefinitions.forEach { (key, value) ->  
        	DefinitionId.write(writer, key)
        	AssetDefinitionEntry.write(writer, value)
        }
    }
  }
}
