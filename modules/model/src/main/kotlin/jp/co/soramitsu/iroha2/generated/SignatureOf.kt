//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Any
import kotlin.Unit

/**
 * SignatureOf
 *
 * Generated from 'SignatureOf<TransactionPayload>' regular structure
 */
public data class SignatureOf<T0>(public val signature: Signature) {
    public companion object : ScaleReader<SignatureOf<out Any>>, ScaleWriter<SignatureOf<out Any>> {
        override fun read(reader: ScaleCodecReader): SignatureOf<out Any> = try {
            SignatureOf(
                Signature.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: SignatureOf<out Any>): Unit = try {
            Signature.write(writer, instance.signature)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
