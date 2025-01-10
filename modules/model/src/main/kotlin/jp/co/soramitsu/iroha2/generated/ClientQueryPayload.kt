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
 * ClientQueryPayload
 *
 * Generated from 'ClientQueryPayload' regular structure
 */
public data class ClientQueryPayload(
    public val authority: AccountId,
    public val query: QueryBox,
    public val filter: GenericPredicateBox<QueryOutputPredicate>,
    public val sorting: Sorting,
    public val pagination: Pagination,
    public val fetchSize: FetchSize,
) {
    public companion object : ScaleReader<ClientQueryPayload>, ScaleWriter<ClientQueryPayload> {
        override fun read(reader: ScaleCodecReader): ClientQueryPayload = try {
            ClientQueryPayload(
                AccountId.read(reader),
                QueryBox.read(reader),
                GenericPredicateBox.read(reader) as GenericPredicateBox<QueryOutputPredicate>,
                Sorting.read(reader),
                Pagination.read(reader),
                FetchSize.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: ClientQueryPayload): Unit = try {
            AccountId.write(writer, instance.authority)
            QueryBox.write(writer, instance.query)
            GenericPredicateBox.write(writer, instance.filter)
            Sorting.write(writer, instance.sorting)
            Pagination.write(writer, instance.pagination)
            FetchSize.write(writer, instance.fetchSize)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
