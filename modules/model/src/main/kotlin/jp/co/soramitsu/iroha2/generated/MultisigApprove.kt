//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Unit
import kotlin.collections.List

/**
 * MultisigApprove
 *
 * Generated from 'MultisigApprove' regular structure
 */
public data class MultisigApprove(public val account: AccountId, public val instructionsHash: HashOf<List<InstructionBox>>) {
    public companion object : ScaleReader<MultisigApprove>, ScaleWriter<MultisigApprove> {
        override fun read(reader: ScaleCodecReader): MultisigApprove = try {
            MultisigApprove(
                AccountId.read(reader),
                HashOf.read(reader) as HashOf<List<InstructionBox>>,
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: MultisigApprove): Unit = try {
            AccountId.write(writer, instance.account)
            HashOf.write(writer, instance.instructionsHash)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
