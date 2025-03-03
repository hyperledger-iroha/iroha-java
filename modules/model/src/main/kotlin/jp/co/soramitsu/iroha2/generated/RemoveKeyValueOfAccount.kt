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
 * RemoveKeyValueOfAccount
 *
 * Generated from 'RemoveKeyValueOfAccount' regular structure
 */
public data class RemoveKeyValueOfAccount(
    public val `object`: AccountId,
    public val key: Name,
) : Instruction {
    override fun asInstructionBox(): InstructionBox = asInstructionBoxExt()

    public companion object :
        ScaleReader<RemoveKeyValueOfAccount>,
        ScaleWriter<RemoveKeyValueOfAccount> {
        override fun read(reader: ScaleCodecReader): RemoveKeyValueOfAccount =
            try {
                RemoveKeyValueOfAccount(
                    AccountId.read(reader),
                    Name.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: RemoveKeyValueOfAccount,
        ): Unit =
            try {
                AccountId.write(writer, instance.`object`)
                Name.write(writer, instance.key)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
