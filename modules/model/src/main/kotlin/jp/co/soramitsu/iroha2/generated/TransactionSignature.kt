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
 * TransactionSignature
 *
 * Generated from 'TransactionSignature' regular structure
 */
public data class TransactionSignature(
    public val signatureOfOfTransactionPayload: SignatureOf<TransactionPayload>,
) {
    public companion object : ScaleReader<TransactionSignature>, ScaleWriter<TransactionSignature> {
        override fun read(reader: ScaleCodecReader): TransactionSignature = try {
            TransactionSignature(
                SignatureOf.read(reader) as SignatureOf<TransactionPayload>,
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: TransactionSignature): Unit = try {
            SignatureOf.write(writer, instance.signatureOfOfTransactionPayload)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
