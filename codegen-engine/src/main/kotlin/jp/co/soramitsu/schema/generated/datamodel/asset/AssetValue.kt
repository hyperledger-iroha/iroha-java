// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.asset

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import jp.co.soramitsu.schema.generated.datamodel.metadata.Metadata
import kotlin.Int
import kotlin.Unit

/**
 * AssetValue
 *
 * Generated from 'iroha_data_model::asset::AssetValue' enum
 */
public abstract class AssetValue {
  /**
   * @return Discriminator of variant in enum
   */
  public abstract fun discriminant(): Int

  /**
   * 'Quantity' variant
   */
  public class Quantity(
    private val quantity: Int
  ) : AssetValue() {
    public override fun discriminant(): Int = 0

    public companion object CODEC : ScaleReader<Quantity>, ScaleWriter<Quantity> {
      public override fun read(reader: ScaleCodecReader): Quantity {
      }

      public override fun write(writer: ScaleCodecWriter, instance: Quantity): Unit {
        writer.directWrite(this.discriminant())
        writer.writeLong(instance.quantity)
      }
    }
  }

  /**
   * 'BigQuantity' variant
   */
  public class BigQuantity(
    private val bigQuantity: Int
  ) : AssetValue() {
    public override fun discriminant(): Int = 1

    public companion object CODEC : ScaleReader<BigQuantity>, ScaleWriter<BigQuantity> {
      public override fun read(reader: ScaleCodecReader): BigQuantity {
      }

      public override fun write(writer: ScaleCodecWriter, instance: BigQuantity): Unit {
        writer.directWrite(this.discriminant())
        writer.writeLong(instance.bigQuantity)
      }
    }
  }

  /**
   * 'Store' variant
   */
  public class Store(
    private val store: Metadata
  ) : AssetValue() {
    public override fun discriminant(): Int = 2

    public companion object CODEC : ScaleReader<Store>, ScaleWriter<Store> {
      public override fun read(reader: ScaleCodecReader): Store {
      }

      public override fun write(writer: ScaleCodecWriter, instance: Store): Unit {
        writer.directWrite(this.discriminant())
        Metadata.write(writer, instance.store)
      }
    }
  }
}
