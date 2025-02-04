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
 * UnregisterOfAccount
 *
 * Generated from 'UnregisterOfAccount' regular structure
 */
public data class UnregisterOfAccount(
    public val `object`: AccountId,
) : Instruction {
    override fun asInstructionBox(): InstructionBox = asInstructionBoxExt()

    public companion object : ScaleReader<UnregisterOfAccount>, ScaleWriter<UnregisterOfAccount> {
        override fun read(reader: ScaleCodecReader): UnregisterOfAccount =
            try {
                UnregisterOfAccount(
                    AccountId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: UnregisterOfAccount,
        ): Unit =
            try {
                AccountId.write(writer, instance.`object`)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
