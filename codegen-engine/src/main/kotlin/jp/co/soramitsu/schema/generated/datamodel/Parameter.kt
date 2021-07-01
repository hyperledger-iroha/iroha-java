// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import kotlin.Int
import kotlin.Unit

/**
 * Parameter
 *
 * Generated from 'iroha_data_model::Parameter' enum
 */
public sealed class Parameter {
  /**
   * @return Discriminator of variant in enum
   */
  public abstract fun discriminant(): Int

  /**
   * 'MaximumFaultyPeersAmount' variant
   */
  public class MaximumFaultyPeersAmount(
    private val maximumFaultyPeersAmount: Int
  ) : Parameter() {
    public override fun discriminant(): Int = 0

    public companion object CODEC : ScaleReader<MaximumFaultyPeersAmount>,
        ScaleWriter<MaximumFaultyPeersAmount> {
      public override fun read(reader: ScaleCodecReader): MaximumFaultyPeersAmount =
          jp.co.soramitsu.schema.generated.datamodel.Parameter.MaximumFaultyPeersAmount(reader.readLong().toInt())

      public override fun write(writer: ScaleCodecWriter, instance: MaximumFaultyPeersAmount):
          Unit {
        writer.writeLong(instance.maximumFaultyPeersAmount.toLong())
      }
    }
  }

  /**
   * 'BlockTime' variant
   */
  public class BlockTime(
    private val blockTime: Int
  ) : Parameter() {
    public override fun discriminant(): Int = 1

    public companion object CODEC : ScaleReader<BlockTime>, ScaleWriter<BlockTime> {
      public override fun read(reader: ScaleCodecReader): BlockTime =
          jp.co.soramitsu.schema.generated.datamodel.Parameter.BlockTime(reader.readLong().toInt())

      public override fun write(writer: ScaleCodecWriter, instance: BlockTime): Unit {
        writer.writeLong(instance.blockTime.toLong())
      }
    }
  }

  /**
   * 'CommitTime' variant
   */
  public class CommitTime(
    private val commitTime: Int
  ) : Parameter() {
    public override fun discriminant(): Int = 2

    public companion object CODEC : ScaleReader<CommitTime>, ScaleWriter<CommitTime> {
      public override fun read(reader: ScaleCodecReader): CommitTime =
          jp.co.soramitsu.schema.generated.datamodel.Parameter.CommitTime(reader.readLong().toInt())

      public override fun write(writer: ScaleCodecWriter, instance: CommitTime): Unit {
        writer.writeLong(instance.commitTime.toLong())
      }
    }
  }

  /**
   * 'TransactionReceiptTime' variant
   */
  public class TransactionReceiptTime(
    private val transactionReceiptTime: Int
  ) : Parameter() {
    public override fun discriminant(): Int = 3

    public companion object CODEC : ScaleReader<TransactionReceiptTime>,
        ScaleWriter<TransactionReceiptTime> {
      public override fun read(reader: ScaleCodecReader): TransactionReceiptTime =
          jp.co.soramitsu.schema.generated.datamodel.Parameter.TransactionReceiptTime(reader.readLong().toInt())

      public override fun write(writer: ScaleCodecWriter, instance: TransactionReceiptTime): Unit {
        writer.writeLong(instance.transactionReceiptTime.toLong())
      }
    }
  }

  public companion object CODEC : ScaleReader<Parameter>, ScaleWriter<Parameter> {
    public override fun read(reader: ScaleCodecReader): Parameter = when(reader.readUByte()) {
    	0 -> MaximumFaultyPeersAmount.read(reader)
    	1 -> BlockTime.read(reader)
    	2 -> CommitTime.read(reader)
    	3 -> TransactionReceiptTime.read(reader)
    	else -> throw RuntimeException("Unresolved discriminant of the enum variant")
    }

    public override fun write(writer: ScaleCodecWriter, instance: Parameter): Unit {
      when(instance.discriminant()) {
      	0 -> MaximumFaultyPeersAmount.write(writer, instance as MaximumFaultyPeersAmount)
      	1 -> BlockTime.write(writer, instance as BlockTime)
      	2 -> CommitTime.write(writer, instance as CommitTime)
      	3 -> TransactionReceiptTime.write(writer, instance as TransactionReceiptTime)
      	else -> throw RuntimeException("Unresolved discriminant of the enum variant")
      }
    }
  }
}
