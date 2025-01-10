//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Long
import kotlin.Unit

/**
 * AssetEventFilter
 *
 * Generated from 'AssetEventFilter' regular structure
 */
public data class AssetEventFilter(
    public val idMatcher: AssetId? = null,
    public val eventSet: Long,
) {
    public companion object : ScaleReader<AssetEventFilter>, ScaleWriter<AssetEventFilter> {
        override fun read(reader: ScaleCodecReader): AssetEventFilter = try {
            AssetEventFilter(
                reader.readNullable(AssetId) as AssetId?,
                reader.readUint32(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: AssetEventFilter): Unit = try {
            writer.writeNullable(AssetId, instance.idMatcher)
            writer.writeUint32(instance.eventSet)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
