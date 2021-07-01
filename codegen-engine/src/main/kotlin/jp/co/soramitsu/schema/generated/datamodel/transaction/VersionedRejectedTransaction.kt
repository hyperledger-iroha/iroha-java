// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.transaction

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import kotlin.Int
import kotlin.Unit

/**
 * VersionedRejectedTransaction
 *
 * Generated from 'iroha_data_model::transaction::VersionedRejectedTransaction' enum
 */
public sealed class VersionedRejectedTransaction {
  /**
   * @return Discriminator of variant in enum
   */
  public abstract fun discriminant(): Int

  /**
   * 'V1' variant
   */
  public class V1(
    private val v1: _VersionedRejectedTransactionV1
  ) : VersionedRejectedTransaction() {
    public override fun discriminant(): Int = 1

    public companion object CODEC : ScaleReader<V1>, ScaleWriter<V1> {
      public override fun read(reader: ScaleCodecReader): V1 =
          jp.co.soramitsu.schema.generated.datamodel.transaction.VersionedRejectedTransaction.V1(jp.co.soramitsu.schema.generated.datamodel.transaction._VersionedRejectedTransactionV1.read(reader))

      public override fun write(writer: ScaleCodecWriter, instance: V1): Unit {
        jp.co.soramitsu.schema.generated.datamodel.transaction._VersionedRejectedTransactionV1.write(writer,
            instance.v1)
      }
    }
  }

  public companion object CODEC : ScaleReader<VersionedRejectedTransaction>,
      ScaleWriter<VersionedRejectedTransaction> {
    public override fun read(reader: ScaleCodecReader): VersionedRejectedTransaction =
        when(reader.readUByte()) {
    	1 -> V1.read(reader)
    	else -> throw RuntimeException("Unresolved discriminant of the enum variant")
    }

    public override fun write(writer: ScaleCodecWriter, instance: VersionedRejectedTransaction):
        Unit {
      when(instance.discriminant()) {
      	1 -> V1.write(writer, instance as V1)
      	else -> throw RuntimeException("Unresolved discriminant of the enum variant")
      }
    }
  }
}
