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
 * FindBlockHeaderByHash
 *
 * Generated from 'FindBlockHeaderByHash' regular structure
 */
public data class FindBlockHeaderByHash(
    public val hash: HashOf<BlockHeader>,
) {
    public companion object : ScaleReader<FindBlockHeaderByHash>, ScaleWriter<FindBlockHeaderByHash> {
        override fun read(reader: ScaleCodecReader): FindBlockHeaderByHash = try {
            FindBlockHeaderByHash(
                HashOf.read(reader) as HashOf<BlockHeader>,
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: FindBlockHeaderByHash): Unit = try {
            HashOf.write(writer, instance.hash)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
