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
 * RegisterOfPeer
 *
 * Generated from 'RegisterOfPeer' regular structure
 */
public data class RegisterOfPeer(
    public val `object`: PeerId,
) : Instruction {
    override fun asInstructionBox(): InstructionBox = asInstructionBoxExt()

    public companion object : ScaleReader<RegisterOfPeer>, ScaleWriter<RegisterOfPeer> {
        override fun read(reader: ScaleCodecReader): RegisterOfPeer =
            try {
                RegisterOfPeer(
                    PeerId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: RegisterOfPeer,
        ): Unit =
            try {
                PeerId.write(writer, instance.`object`)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
