//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated.datamodel.expression

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import jp.co.soramitsu.iroha2.generated.datamodel.Value
import jp.co.soramitsu.iroha2.utils.hashMapWithSize
import kotlin.String
import kotlin.Unit
import kotlin.collections.MutableMap

/**
 * Where
 *
 * Generated from 'iroha_data_model::expression::Where' regular structure
 */
public class Where(
  public val expression: EvaluatesTo<Value>,
  public val values: MutableMap<String, EvaluatesTo<Value>>
) {
  public companion object : ScaleReader<Where>, ScaleWriter<Where> {
    public override fun read(reader: ScaleCodecReader): Where = Where(
      EvaluatesTo<Value>.read(reader),
      hashMapWithSize(reader.readCompactInt(), {reader.readString()},
          {EvaluatesTo<Value>.read(reader)}),
    )

    public override fun write(writer: ScaleCodecWriter, instance: Where): Unit {


    }
  }
}
