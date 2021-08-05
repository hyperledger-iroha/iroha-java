// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.events.pipeline

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import kotlin.Int
import kotlin.Unit

/**
 * EntityType
 *
 * Generated from 'iroha_data_model::events::pipeline::EntityType' enum
 */
public sealed class EntityType {
  /**
   * @return Discriminator of variant in enum
   */
  public abstract fun discriminant(): Int

  /**
   * 'Block' variant
   */
  public class Block : EntityType() {
    public override fun discriminant(): Int = 0

    public companion object : ScaleReader<Block>, ScaleWriter<Block> {
      public override fun read(reader: ScaleCodecReader): Block =
          jp.co.soramitsu.schema.generated.datamodel.events.pipeline.EntityType.Block()

      public override fun write(writer: ScaleCodecWriter, instance: Block): Unit {
        //nothing to write, enum variant do not have properties
      }
    }
  }

  /**
   * 'Transaction' variant
   */
  public class Transaction : EntityType() {
    public override fun discriminant(): Int = 1

    public companion object : ScaleReader<Transaction>, ScaleWriter<Transaction> {
      public override fun read(reader: ScaleCodecReader): Transaction =
          jp.co.soramitsu.schema.generated.datamodel.events.pipeline.EntityType.Transaction()

      public override fun write(writer: ScaleCodecWriter, instance: Transaction): Unit {
        //nothing to write, enum variant do not have properties
      }
    }
  }

  public companion object : ScaleReader<EntityType>, ScaleWriter<EntityType> {
    public override fun read(reader: ScaleCodecReader): EntityType = when(reader.readUByte()) {
    	0 -> Block.read(reader)
    	1 -> Transaction.read(reader)
    	else -> throw RuntimeException("Unresolved discriminant of the enum variant")
    }

    public override fun write(writer: ScaleCodecWriter, instance: EntityType): Unit {
      writer.directWrite(instance.discriminant())
      when(instance.discriminant()) {
      	0 -> Block.write(writer, instance as Block)
      	1 -> Transaction.write(writer, instance as Transaction)
      	else -> throw RuntimeException("Unresolved discriminant of the enum variant")
      }
    }
  }
}
