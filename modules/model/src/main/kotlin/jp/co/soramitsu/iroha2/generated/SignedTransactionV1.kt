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
 * SignedTransactionV1
 *
 * Generated from 'SignedTransactionV1' regular structure
 */
public data class SignedTransactionV1(
    public val signature: TransactionSignature,
    public val payload: TransactionPayload,
) {
    public companion object : ScaleReader<SignedTransactionV1>, ScaleWriter<SignedTransactionV1> {
        override fun read(reader: ScaleCodecReader): SignedTransactionV1 = try {
            SignedTransactionV1(
                TransactionSignature.read(reader),
                TransactionPayload.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: SignedTransactionV1): Unit = try {
            TransactionSignature.write(writer, instance.signature)
            TransactionPayload.write(writer, instance.payload)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
