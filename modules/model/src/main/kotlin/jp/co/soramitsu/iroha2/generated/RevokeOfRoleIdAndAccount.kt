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
 * RevokeOfRoleIdAndAccount
 *
 * Generated from 'RevokeOfRoleIdAndAccount' regular structure
 */
public data class RevokeOfRoleIdAndAccount(
    public val `object`: RoleId,
    public val destination: AccountId,
) : Instruction {
    override fun asInstructionBox(): InstructionBox = asInstructionBoxExt()

    public companion object :
        ScaleReader<RevokeOfRoleIdAndAccount>,
        ScaleWriter<RevokeOfRoleIdAndAccount> {
        override fun read(reader: ScaleCodecReader): RevokeOfRoleIdAndAccount =
            try {
                RevokeOfRoleIdAndAccount(
                    RoleId.read(reader),
                    AccountId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: RevokeOfRoleIdAndAccount,
        ): Unit =
            try {
                RoleId.write(writer, instance.`object`)
                AccountId.write(writer, instance.destination)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
