// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.expression

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import kotlin.Unit

/**
 * ContainsAll
 *
 * Generated from 'iroha_data_model::expression::ContainsAll' regular structure
 */
public class ContainsAll(
  private val collection: EvaluatesTo,
  private val elements: EvaluatesTo
) : ScaleReader<ContainsAll>, ScaleWriter<ContainsAll> {
  public override fun read(reader: ScaleCodecReader): ContainsAll {
  }

  public override fun write(writer: ScaleCodecWriter, instance: ContainsAll): Unit {
  }
}
