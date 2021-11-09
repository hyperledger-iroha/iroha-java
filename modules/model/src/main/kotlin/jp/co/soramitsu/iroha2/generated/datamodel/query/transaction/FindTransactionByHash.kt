//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated.datamodel.query.transaction

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.generated.crypto.hash.Hash
import jp.co.soramitsu.iroha2.generated.datamodel.expression.EvaluatesTo
import jp.co.soramitsu.iroha2.wrapException

/**
 * FindTransactionByHash
 *
 * Generated from 'iroha_data_model::query::transaction::FindTransactionByHash' regular structure
 */
public data class FindTransactionByHash(
    public val hash: EvaluatesTo<Hash>
) {
    public companion object : ScaleReader<FindTransactionByHash>, ScaleWriter<FindTransactionByHash> {
        public override fun read(reader: ScaleCodecReader): FindTransactionByHash = try {
            FindTransactionByHash(
                EvaluatesTo.read(reader) as EvaluatesTo<Hash>,
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        public override fun write(writer: ScaleCodecWriter, instance: FindTransactionByHash) = try {
            EvaluatesTo.write(writer, instance.hash)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
