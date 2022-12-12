//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated.datamodel.isi

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.generated.datamodel.expression.EvaluatesTo
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Boolean

/**
 * If
 *
 * Generated from 'iroha_data_model::isi::If' regular structure
 */
public data class If(
    public val condition: EvaluatesTo<Boolean>,
    public val then: Instruction,
    public val otherwise: Instruction? = null
) {
    public companion object : ScaleReader<If>, ScaleWriter<If> {
        public override fun read(reader: ScaleCodecReader): If = try {
            If(
                EvaluatesTo.read(reader) as EvaluatesTo<Boolean>,
                Instruction.read(reader),
                reader.readNullable(Instruction),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        public override fun write(writer: ScaleCodecWriter, instance: If) = try {
            EvaluatesTo.write(writer, instance.condition)
            Instruction.write(writer, instance.then)
            writer.writeNullable(Instruction, instance.otherwise)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
