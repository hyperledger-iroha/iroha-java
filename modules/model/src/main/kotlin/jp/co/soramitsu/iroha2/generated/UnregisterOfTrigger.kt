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
 * UnregisterOfTrigger
 *
 * Generated from 'UnregisterOfTrigger' regular structure
 */
public data class UnregisterOfTrigger(
    public val `object`: TriggerId,
) : Instruction {
    override fun asInstructionBox(): InstructionBox = asInstructionBoxExt()

    public companion object : ScaleReader<UnregisterOfTrigger>, ScaleWriter<UnregisterOfTrigger> {
        override fun read(reader: ScaleCodecReader): UnregisterOfTrigger =
            try {
                UnregisterOfTrigger(
                    TriggerId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: UnregisterOfTrigger,
        ): Unit =
            try {
                TriggerId.write(writer, instance.`object`)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
