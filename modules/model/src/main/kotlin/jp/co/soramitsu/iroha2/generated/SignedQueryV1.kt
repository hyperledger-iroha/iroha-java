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
 * SignedQueryV1
 *
 * Generated from 'SignedQueryV1' regular structure
 */
public data class SignedQueryV1(
    public val signature: QuerySignature,
    public val payload: ClientQueryPayload,
) {
    public companion object : ScaleReader<SignedQueryV1>, ScaleWriter<SignedQueryV1> {
        override fun read(reader: ScaleCodecReader): SignedQueryV1 = try {
            SignedQueryV1(
                QuerySignature.read(reader),
                ClientQueryPayload.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: SignedQueryV1): Unit = try {
            QuerySignature.write(writer, instance.signature)
            ClientQueryPayload.write(writer, instance.payload)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
