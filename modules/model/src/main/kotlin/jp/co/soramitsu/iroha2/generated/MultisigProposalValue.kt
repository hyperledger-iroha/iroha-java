//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.codec.reader.BoolReader
import jp.co.soramitsu.iroha2.codec.writer.BoolWriter
import jp.co.soramitsu.iroha2.comparator
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Boolean
import kotlin.Unit
import kotlin.collections.List

/**
 * MultisigProposalValue
 *
 * Generated from 'MultisigProposalValue' regular structure
 */
public data class MultisigProposalValue(
    public val instructions: List<InstructionBox>,
    public val proposedAtMs: NonZeroOfu64,
    public val expiresAtMs: NonZeroOfu64,
    public val approvals: List<AccountId>,
    public val isRelayed: Boolean? = null,
) {
    public companion object : ScaleReader<MultisigProposalValue>, ScaleWriter<MultisigProposalValue> {
        override fun read(reader: ScaleCodecReader): MultisigProposalValue =
            try {
                MultisigProposalValue(
                    reader.readVec(reader.readCompactInt()) { InstructionBox.read(reader) },
                    NonZeroOfu64.read(reader),
                    NonZeroOfu64.read(reader),
                    reader.readVec(reader.readCompactInt()) { AccountId.read(reader) },
                    reader.readNullable(BoolReader()),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: MultisigProposalValue,
        ): Unit =
            try {
                writer.writeCompact(instance.instructions.size)
                instance.instructions.forEach { value ->
                    InstructionBox.write(writer, value)
                }
                NonZeroOfu64.write(writer, instance.proposedAtMs)
                NonZeroOfu64.write(writer, instance.expiresAtMs)
                writer.writeCompact(instance.approvals.size)
                instance.approvals
                    .sortedWith(
                        AccountId.comparator(),
                    ).forEach { value ->
                        AccountId.write(writer, value)
                    }
                writer.writeNullable(BoolWriter(), instance.isRelayed)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
