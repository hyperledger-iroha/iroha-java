// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.events.pipeline

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import jp.co.soramitsu.schema.codegen.read
import jp.co.soramitsu.schema.codegen.write
import jp.co.soramitsu.schema.generated.crypto.Hash
import kotlin.Unit

/**
 * Event
 *
 * Generated from 'iroha_data_model::events::pipeline::Event' regular structure
 */
public class Event(
  private val entityType: EntityType,
  private val status: Status,
  private val hash: Hash
) : ScaleReader<Event>, ScaleWriter<Event> {
  public override fun read(reader: ScaleCodecReader): Event =
      Event(jp.co.soramitsu.schema.generated.datamodel.events.pipeline.EntityType.READER.read(reader),jp.co.soramitsu.schema.generated.datamodel.events.pipeline.Status.READER.read(reader),jp.co.soramitsu.schema.generated.crypto.Hash.READER.read(reader))

  public override fun write(writer: ScaleCodecWriter, instance: Event): Unit {
    jp.co.soramitsu.schema.generated.datamodel.events.pipeline.EntityType.READER.read(reader),
    jp.co.soramitsu.schema.generated.datamodel.events.pipeline.Status.READER.read(reader),
    jp.co.soramitsu.schema.generated.crypto.Hash.READER.read(reader)
  }
}
