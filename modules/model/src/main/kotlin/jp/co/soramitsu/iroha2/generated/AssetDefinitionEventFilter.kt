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
 * AssetDefinitionEventFilter
 *
 * Generated from 'AssetDefinitionEventFilter' regular structure
 */
public data class AssetDefinitionEventFilter(
    public val idMatcher: AssetDefinitionId? = null,
    public val eventSet: Long,
) {
    public companion object :
        ScaleReader<AssetDefinitionEventFilter>,
        ScaleWriter<AssetDefinitionEventFilter> {
        override fun read(reader: ScaleCodecReader): AssetDefinitionEventFilter = try {
            AssetDefinitionEventFilter(
                reader.readNullable(AssetDefinitionId) as AssetDefinitionId?,
                reader.readUint32(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: AssetDefinitionEventFilter): Unit = try {
            writer.writeNullable(AssetDefinitionId, instance.idMatcher)
            writer.writeUint32(instance.eventSet)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
