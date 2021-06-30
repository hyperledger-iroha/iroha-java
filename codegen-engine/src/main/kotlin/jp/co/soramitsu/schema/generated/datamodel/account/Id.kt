// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.account

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import jp.co.soramitsu.schema.codegen.read
import jp.co.soramitsu.schema.codegen.write
import kotlin.String
import kotlin.Unit

/**
 * Id
 *
 * Generated from 'iroha_data_model::account::Id' regular structure
 */
public class Id(
  private val name: String,
  private val domainName: String
) : ScaleReader<Id>, ScaleWriter<Id> {
  public override fun read(reader: ScaleCodecReader): Id =
      Id(reader.readString(),reader.readString())

  public override fun write(writer: ScaleCodecWriter, instance: Id): Unit {
    reader.readString(),
    reader.readString()
  }
}
