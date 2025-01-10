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
 * QueryWithParams
 *
 * Generated from 'QueryWithParams' regular structure
 */
public data class QueryWithParams(
    public val query: QueryBox,
    public val params: QueryParams,
) {
    public companion object : ScaleReader<QueryWithParams>, ScaleWriter<QueryWithParams> {
        override fun read(reader: ScaleCodecReader): QueryWithParams = try {
            QueryWithParams(
                QueryBox.read(reader),
                QueryParams.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: QueryWithParams): Unit = try {
            QueryBox.write(writer, instance.query)
            QueryParams.write(writer, instance.params)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
