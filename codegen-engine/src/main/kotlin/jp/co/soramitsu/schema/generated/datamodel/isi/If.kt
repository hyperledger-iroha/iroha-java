// Do not change. Autogenerated code
package jp.co.soramitsu.schema.generated.datamodel.isi

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import java.util.Optional
import jp.co.soramitsu.schema.generated.datamodel.expression.EvaluatesTo
import kotlin.Unit

/**
 * If
 *
 * Generated from 'iroha_data_model::isi::If' regular structure
 */
public class If(
  private val condition: EvaluatesTo,
  private val then: Instruction,
  private val otherwise: Optional<Instruction>
) : ScaleReader<If>, ScaleWriter<If> {
  public override fun read(reader: ScaleCodecReader): If {
  }

  public override fun write(writer: ScaleCodecWriter, instance: If): Unit {
  }
}
