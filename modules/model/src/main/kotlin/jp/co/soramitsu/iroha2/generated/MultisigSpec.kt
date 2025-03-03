//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.comparator
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Short
import kotlin.Unit
import kotlin.collections.Map

/**
 * MultisigSpec
 *
 * Generated from 'MultisigSpec' regular structure
 */
public data class MultisigSpec(
    public val signatories: Map<AccountId, Short>,
    public val quorum: NonZeroOfu16,
    public val transactionTtlMs: NonZeroOfu64,
) {
    public companion object : ScaleReader<MultisigSpec>, ScaleWriter<MultisigSpec> {
        override fun read(reader: ScaleCodecReader): MultisigSpec =
            try {
                MultisigSpec(
                    reader.readMap(reader.readCompactInt(), { AccountId.read(reader) }, { reader.readUByte().toShort() }),
                    NonZeroOfu16.read(reader),
                    NonZeroOfu64.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: MultisigSpec,
        ): Unit =
            try {
                writer.writeCompact(instance.signatories.size)
                instance.signatories
                    .toSortedMap(
                        AccountId.comparator(),
                    ).forEach { (key, value) ->
                        AccountId.write(writer, key)
                        writer.writeUByte(value)
                    }
                NonZeroOfu16.write(writer, instance.quorum)
                NonZeroOfu64.write(writer, instance.transactionTtlMs)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
