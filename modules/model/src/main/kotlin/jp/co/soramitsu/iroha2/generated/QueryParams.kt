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
 * QueryParams
 *
 * Generated from 'QueryParams' regular structure
 */
public data class QueryParams(
    public val pagination: Pagination,
    public val sorting: Sorting,
    public val fetchSize: FetchSize,
) {
    public companion object : ScaleReader<QueryParams>, ScaleWriter<QueryParams> {
        override fun read(reader: ScaleCodecReader): QueryParams = try {
            QueryParams(
                Pagination.read(reader),
                Sorting.read(reader),
                FetchSize.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: QueryParams): Unit = try {
            Pagination.write(writer, instance.pagination)
            Sorting.write(writer, instance.sorting)
            FetchSize.write(writer, instance.fetchSize)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
