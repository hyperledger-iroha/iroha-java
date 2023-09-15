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
 * FindTransactionByHash
 *
 * Generated from 'FindTransactionByHash' regular structure
 */
public data class FindTransactionByHash(
    public val hash: EvaluatesTo<HashOf<VersionedSignedTransaction>>,
) {
    public companion object : ScaleReader<FindTransactionByHash>, ScaleWriter<FindTransactionByHash> {
        override fun read(reader: ScaleCodecReader): FindTransactionByHash = try {
            FindTransactionByHash(
                EvaluatesTo.read(reader) as EvaluatesTo<HashOf<VersionedSignedTransaction>>,
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: FindTransactionByHash): Unit = try {
            EvaluatesTo.write(writer, instance.hash)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
