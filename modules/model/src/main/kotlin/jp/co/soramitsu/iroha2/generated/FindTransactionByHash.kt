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
    public val hash: HashOf<SignedTransaction>,
) {
    public companion object : ScaleReader<FindTransactionByHash>, ScaleWriter<FindTransactionByHash> {
        override fun read(reader: ScaleCodecReader): FindTransactionByHash = try {
            FindTransactionByHash(
                HashOf.read(reader) as HashOf<SignedTransaction>,
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: FindTransactionByHash): Unit = try {
            HashOf.write(writer, instance.hash)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
