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
import kotlin.Long
import kotlin.Unit

/**
 * MintOfu32AndTrigger
 *
 * Generated from 'MintOfu32AndTrigger' regular structure
 */
public data class MintOfu32AndTrigger(
    public val `object`: Long,
    public val destination: TriggerId,
) : Instruction {
    override fun asInstructionBox(): InstructionBox = asInstructionBoxExt()

    public companion object : ScaleReader<MintOfu32AndTrigger>, ScaleWriter<MintOfu32AndTrigger> {
        override fun read(reader: ScaleCodecReader): MintOfu32AndTrigger =
            try {
                MintOfu32AndTrigger(
                    reader.readUint32(),
                    TriggerId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: MintOfu32AndTrigger,
        ): Unit =
            try {
                writer.writeUint32(instance.`object`)
                TriggerId.write(writer, instance.destination)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
