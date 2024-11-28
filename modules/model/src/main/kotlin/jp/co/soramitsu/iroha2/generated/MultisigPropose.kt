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
 * MultisigPropose
 *
 * Generated from 'MultisigPropose' regular structure
 */
public data class MultisigPropose(
    public val account: AccountId,
    public val instructions: List<InstructionBox>,
    public val transactionTtlMs: NonZeroOfu64? = null,
) {
    public companion object : ScaleReader<MultisigPropose>, ScaleWriter<MultisigPropose> {
        override fun read(reader: ScaleCodecReader): MultisigPropose = try {
            MultisigPropose(
                AccountId.read(reader),
                reader.readVec(reader.readCompactInt()) { InstructionBox.read(reader) },
                reader.readNullable(NonZeroOfu64) as NonZeroOfu64?,
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: MultisigPropose): Unit = try {
            AccountId.write(writer, instance.account)
            writer.writeCompact(instance.instructions.size)
            instance.instructions.forEach { value ->
                InstructionBox.write(writer, value)
            }
            writer.writeNullable(NonZeroOfu64, instance.transactionTtlMs)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
