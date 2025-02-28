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

/**
 * TransactionEventFilter
 *
 * Generated from 'TransactionEventFilter' regular structure
 */
public data class TransactionEventFilter(
    public val hash: HashOf<SignedTransaction>? = null,
    public val blockHeight: NonZeroOfu64? = null,
    public val status: TransactionStatus? = null,
) {
    public companion object :
        ScaleReader<TransactionEventFilter>,
        ScaleWriter<TransactionEventFilter> {
        override fun read(reader: ScaleCodecReader): TransactionEventFilter =
            try {
                TransactionEventFilter(
                    reader.readNullable(HashOf) as HashOf<SignedTransaction>?,
                    reader.readNullable(NonZeroOfu64) as NonZeroOfu64?,
                    reader.readNullable(TransactionStatus) as TransactionStatus?,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: TransactionEventFilter,
        ): Unit =
            try {
                writer.writeNullable(HashOf, instance.hash)
                writer.writeNullable(NonZeroOfu64, instance.blockHeight)
                writer.writeNullable(TransactionStatus, instance.status)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
