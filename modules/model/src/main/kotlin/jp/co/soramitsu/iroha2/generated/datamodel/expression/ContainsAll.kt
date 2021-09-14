//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated.datamodel.expression

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import jp.co.soramitsu.iroha2.generated.datamodel.Value
import jp.co.soramitsu.iroha2.wrapException
import kotlin.collections.MutableList

/**
 * ContainsAll
 *
 * Generated from 'iroha_data_model::expression::ContainsAll' regular structure
 */
public data class ContainsAll(
    public val collection: EvaluatesTo<MutableList<Value>>,
    public val elements: EvaluatesTo<MutableList<Value>>
) {
    public companion object : ScaleReader<ContainsAll>, ScaleWriter<ContainsAll> {
        public override fun read(reader: ScaleCodecReader): ContainsAll = try {
            ContainsAll(
                EvaluatesTo.read(reader) as EvaluatesTo<MutableList<Value>>,
                EvaluatesTo.read(reader) as EvaluatesTo<MutableList<Value>>,
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        public override fun write(writer: ScaleCodecWriter, instance: ContainsAll) = try {
            EvaluatesTo.write(writer, instance.collection)
            EvaluatesTo.write(writer, instance.elements)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
