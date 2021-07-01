// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.transaction

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import kotlin.Int
import kotlin.Unit

/**
 * TransactionValue
 *
 * Generated from 'iroha_data_model::transaction::TransactionValue' enum
 */
public abstract class TransactionValue {
  /**
   * @return Discriminator of variant in enum
   */
  public abstract fun discriminant(): Int

  /**
   * 'Transaction' variant
   */
  public class Transaction(
    private val transaction: VersionedTransaction
  ) : TransactionValue() {
    public override fun discriminant(): Int = 0

    public companion object CODEC : ScaleReader<Transaction>, ScaleWriter<Transaction> {
      public override fun read(reader: ScaleCodecReader): Transaction {
      }

      public override fun write(writer: ScaleCodecWriter, instance: Transaction): Unit {
        writer.directWrite(this.discriminant())
        VersionedTransaction.write(writer, instance.transaction)
      }
    }
  }

  /**
   * 'RejectedTransaction' variant
   */
  public class RejectedTransaction(
    private val rejectedTransaction: VersionedRejectedTransaction
  ) : TransactionValue() {
    public override fun discriminant(): Int = 1

    public companion object CODEC : ScaleReader<RejectedTransaction>,
        ScaleWriter<RejectedTransaction> {
      public override fun read(reader: ScaleCodecReader): RejectedTransaction {
      }

      public override fun write(writer: ScaleCodecWriter, instance: RejectedTransaction): Unit {
        writer.directWrite(this.discriminant())
        VersionedRejectedTransaction.write(writer, instance.rejectedTransaction)
      }
    }
  }
}
