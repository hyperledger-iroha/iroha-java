// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.query

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import kotlin.Int
import kotlin.Unit

/**
 * VersionedQueryResult
 *
 * Generated from 'iroha_data_model::query::VersionedQueryResult' enum
 */
public abstract class VersionedQueryResult {
  /**
   * 'V1' variant
   */
  public class V1(
    private val v1: _VersionedQueryResultV1
  ) : VersionedQueryResult(), ScaleReader<V1>, ScaleWriter<V1> {
    public override fun read(reader: ScaleCodecReader): V1 {
    }

    public override fun write(writer: ScaleCodecWriter, instance: V1): Unit {
    }

    public companion object {
      public const val DISCRIMINANT: Int = 1
    }
  }
}
