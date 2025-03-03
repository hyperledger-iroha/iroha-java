//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.asInstructionBoxExt
import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.generated.InstructionBox
import jp.co.soramitsu.iroha2.transaction.Instruction
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Unit

/**
 * ExecuteTrigger
 *
 * Generated from 'ExecuteTrigger' regular structure
 */
public data class ExecuteTrigger(
    public val trigger: TriggerId,
    public val args: Json,
) : Instruction {
    override fun asInstructionBox(): InstructionBox = asInstructionBoxExt()

    public companion object : ScaleReader<ExecuteTrigger>, ScaleWriter<ExecuteTrigger> {
        override fun read(reader: ScaleCodecReader): ExecuteTrigger =
            try {
                ExecuteTrigger(
                    TriggerId.read(reader),
                    Json.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: ExecuteTrigger,
        ): Unit =
            try {
                TriggerId.write(writer, instance.trigger)
                Json.write(writer, instance.args)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
