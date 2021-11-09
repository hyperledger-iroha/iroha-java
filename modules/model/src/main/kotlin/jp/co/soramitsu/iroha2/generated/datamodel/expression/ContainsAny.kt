//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated.datamodel.expression

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.generated.datamodel.Value
import jp.co.soramitsu.iroha2.wrapException
import kotlin.collections.List

/**
 * ContainsAny
 *
 * Generated from 'iroha_data_model::expression::ContainsAny' regular structure
 */
public data class ContainsAny(
    public val collection: EvaluatesTo<List<Value>>,
    public val elements: EvaluatesTo<List<Value>>
) {
    public companion object : ScaleReader<ContainsAny>, ScaleWriter<ContainsAny> {
        public override fun read(reader: ScaleCodecReader): ContainsAny = try {
            ContainsAny(
                EvaluatesTo.read(reader) as EvaluatesTo<List<Value>>,
                EvaluatesTo.read(reader) as EvaluatesTo<List<Value>>,
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        public override fun write(writer: ScaleCodecWriter, instance: ContainsAny) = try {
            EvaluatesTo.write(writer, instance.collection)
            EvaluatesTo.write(writer, instance.elements)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
