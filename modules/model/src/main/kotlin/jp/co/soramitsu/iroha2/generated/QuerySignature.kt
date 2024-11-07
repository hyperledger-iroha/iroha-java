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
 * QuerySignature
 *
 * Generated from 'QuerySignature' regular structure
 */
public data class QuerySignature(
    public val signatureOfOfQueryRequestWithAuthority: SignatureOf<QueryRequestWithAuthority>,
) {
    public companion object : ScaleReader<QuerySignature>, ScaleWriter<QuerySignature> {
        override fun read(reader: ScaleCodecReader): QuerySignature = try {
            QuerySignature(
                SignatureOf.read(reader) as SignatureOf<QueryRequestWithAuthority>,
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: QuerySignature): Unit = try {
            SignatureOf.write(writer, instance.signatureOfOfQueryRequestWithAuthority)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
