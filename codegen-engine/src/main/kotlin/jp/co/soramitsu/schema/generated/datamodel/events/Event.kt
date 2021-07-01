// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.events

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import kotlin.Int
import kotlin.Unit

/**
 * Event
 *
 * Generated from 'iroha_data_model::events::Event' enum
 */
public abstract class Event {
  /**
   * @return Discriminator of variant in enum
   */
  public abstract fun discriminant(): Int

  /**
   * 'Pipeline' variant
   */
  public class Pipeline(
    private val pipeline: jp.co.soramitsu.schema.generated.datamodel.events.pipeline.Event
  ) : Event() {
    public override fun discriminant(): Int = 0

    public companion object CODEC : ScaleReader<Pipeline>, ScaleWriter<Pipeline> {
      public override fun read(reader: ScaleCodecReader): Pipeline {
      }

      public override fun write(writer: ScaleCodecWriter, instance: Pipeline): Unit {
        writer.directWrite(this.discriminant())
        Event.write(writer, instance.pipeline)
      }
    }
  }

  /**
   * 'Data' variant
   */
  public class Data(
    private val `data`: jp.co.soramitsu.schema.generated.datamodel.events.`data`.Event
  ) : Event() {
    public override fun discriminant(): Int = 1

    public companion object CODEC : ScaleReader<Data>, ScaleWriter<Data> {
      public override fun read(reader: ScaleCodecReader): Data {
      }

      public override fun write(writer: ScaleCodecWriter, instance: Data): Unit {
        writer.directWrite(this.discriminant())
        Event.write(writer, instance.data)
      }
    }
  }
}
