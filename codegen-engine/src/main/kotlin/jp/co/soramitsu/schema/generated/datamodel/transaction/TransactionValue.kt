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
   * 'Transaction' variant
   */
  public class Transaction(
    private val transaction: VersionedTransaction
  ) : TransactionValue(), ScaleReader<Transaction>, ScaleWriter<Transaction> {
    public override fun read(reader: ScaleCodecReader): Transaction {
    }

    public override fun write(writer: ScaleCodecWriter, instance: Transaction): Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 0
    }
  }

  /**
   * 'RejectedTransaction' variant
   */
  public class RejectedTransaction(
    private val rejectedTransaction: VersionedRejectedTransaction
  ) : TransactionValue(), ScaleReader<RejectedTransaction>, ScaleWriter<RejectedTransaction> {
    public override fun read(reader: ScaleCodecReader): RejectedTransaction {
    }

    public override fun write(writer: ScaleCodecWriter, instance: RejectedTransaction): Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 1
    }
  }
}
