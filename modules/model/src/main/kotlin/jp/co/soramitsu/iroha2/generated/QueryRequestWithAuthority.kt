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
 * QueryRequestWithAuthority
 *
 * Generated from 'QueryRequestWithAuthority' regular structure
 */
public data class QueryRequestWithAuthority(
    public val authority: AccountId,
    public val request: QueryRequest,
) {
    public companion object :
        ScaleReader<QueryRequestWithAuthority>,
        ScaleWriter<QueryRequestWithAuthority> {
        override fun read(reader: ScaleCodecReader): QueryRequestWithAuthority = try {
            QueryRequestWithAuthority(
                AccountId.read(reader),
                QueryRequest.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: QueryRequestWithAuthority): Unit = try {
            AccountId.write(writer, instance.authority)
            QueryRequest.write(writer, instance.request)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
