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
import java.math.BigInteger
import kotlin.Int
import kotlin.Short
import kotlin.Unit
import kotlin.collections.Map

/**
 * MultisigAccountArgs
 *
 * Generated from 'MultisigAccountArgs' regular structure
 */
public data class MultisigAccountArgs(
    public val account: PublicKey,
    public val signatories: Map<AccountId, Short>,
    public val quorum: Int,
    public val transactionTtlMs: BigInteger,
) {
    public companion object : ScaleReader<MultisigAccountArgs>, ScaleWriter<MultisigAccountArgs> {
        override fun read(reader: ScaleCodecReader): MultisigAccountArgs =
            try {
                MultisigAccountArgs(
                    PublicKey.read(reader),
                    reader.readMap(
                        reader.readCompactInt(),
                        { AccountId.read(reader) },
                        { reader.readUByte().toShort() },
                    ),
                    reader.readUint16(),
                    reader.readUint64(),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: MultisigAccountArgs,
        ): Unit =
            try {
                PublicKey.write(writer, instance.account)
                writer.writeCompact(instance.signatories.size)
                instance.signatories
                    .toSortedMap(
                        AccountId.comparator(),
                    ).forEach { (key, value) ->
                        AccountId.write(writer, key)
                        writer.writeUByte(value)
                    }
                writer.writeUint16(instance.quorum)
                writer.writeUint64(instance.transactionTtlMs)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
