//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated.datamodel

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import java.math.BigInteger
import kotlin.Int
import kotlin.UInt
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
    public val u32: UInt
  ) : Parameter() {
    public override fun discriminant(): Int = DISCRIMINANT

    public companion object : ScaleReader<MaximumFaultyPeersAmount>,
        ScaleWriter<MaximumFaultyPeersAmount> {
      public const val DISCRIMINANT: Int = 0

      public override fun read(reader: ScaleCodecReader): MaximumFaultyPeersAmount =
          MaximumFaultyPeersAmount(
        reader.readUint32().toUInt(),
      )

      public override fun write(writer: ScaleCodecWriter, instance: MaximumFaultyPeersAmount):
          Unit {
          writer.writeUint32(instance.u32.toInt())
      }
    }
  }

  /**
   * 'BlockTime' variant
   */
  public class BlockTime(
    public val u128: BigInteger
  ) : Parameter() {
    public override fun discriminant(): Int = DISCRIMINANT

    public companion object : ScaleReader<BlockTime>, ScaleWriter<BlockTime> {
      public const val DISCRIMINANT: Int = 1

      public override fun read(reader: ScaleCodecReader): BlockTime = BlockTime(
        reader.readUint128(),
      )

      public override fun write(writer: ScaleCodecWriter, instance: BlockTime): Unit {
          writer.writeUint128(instance.u128)
      }
    }
  }

  /**
   * 'CommitTime' variant
   */
  public class CommitTime(
    public val u128: BigInteger
  ) : Parameter() {
    public override fun discriminant(): Int = DISCRIMINANT

    public companion object : ScaleReader<CommitTime>, ScaleWriter<CommitTime> {
      public const val DISCRIMINANT: Int = 2

      public override fun read(reader: ScaleCodecReader): CommitTime = CommitTime(
        reader.readUint128(),
      )

      public override fun write(writer: ScaleCodecWriter, instance: CommitTime): Unit {
          writer.writeUint128(instance.u128)
      }
    }
  }

  /**
   * 'TransactionReceiptTime' variant
   */
  public class TransactionReceiptTime(
    public val u128: BigInteger
  ) : Parameter() {
    public override fun discriminant(): Int = DISCRIMINANT

    public companion object : ScaleReader<TransactionReceiptTime>,
        ScaleWriter<TransactionReceiptTime> {
      public const val DISCRIMINANT: Int = 3

      public override fun read(reader: ScaleCodecReader): TransactionReceiptTime =
          TransactionReceiptTime(
        reader.readUint128(),
      )

      public override fun write(writer: ScaleCodecWriter, instance: TransactionReceiptTime): Unit {
          writer.writeUint128(instance.u128)
      }
    }
  }

  public companion object : ScaleReader<Parameter>, ScaleWriter<Parameter> {
    public override fun read(reader: ScaleCodecReader): Parameter = when(val discriminant =
        reader.readUByte()) {
    	0 -> MaximumFaultyPeersAmount.read(reader)
    	1 -> BlockTime.read(reader)
    	2 -> CommitTime.read(reader)
    	3 -> TransactionReceiptTime.read(reader)
    	else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")}

    public override fun write(writer: ScaleCodecWriter, instance: Parameter): Unit {
      writer.directWrite(instance.discriminant())
      when(val discriminant = instance.discriminant()) {
      	0 -> MaximumFaultyPeersAmount.write(writer, instance as MaximumFaultyPeersAmount)
      	1 -> BlockTime.write(writer, instance as BlockTime)
      	2 -> CommitTime.write(writer, instance as CommitTime)
      	3 -> TransactionReceiptTime.write(writer, instance as TransactionReceiptTime)
      	else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")}
    }
  }
}
