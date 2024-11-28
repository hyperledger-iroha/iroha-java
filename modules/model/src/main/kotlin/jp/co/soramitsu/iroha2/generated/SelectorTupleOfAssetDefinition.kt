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
import kotlin.collections.List

/**
 * SelectorTupleOfAssetDefinition
 *
 * Generated from 'SelectorTupleOfAssetDefinition' regular structure
 */
public data class SelectorTupleOfAssetDefinition(
    public val vecOfAssetDefinitionProjectionOfSelectorMarker: List<AssetDefinitionProjectionOfSelectorMarker>,
) {
    public companion object :
        ScaleReader<SelectorTupleOfAssetDefinition>,
        ScaleWriter<SelectorTupleOfAssetDefinition> {
        override fun read(reader: ScaleCodecReader): SelectorTupleOfAssetDefinition = try {
            SelectorTupleOfAssetDefinition(
                reader.readVec(reader.readCompactInt()) { AssetDefinitionProjectionOfSelectorMarker.read(reader) },
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: SelectorTupleOfAssetDefinition): Unit = try {
            writer.writeCompact(instance.vecOfAssetDefinitionProjectionOfSelectorMarker.size)
            instance.vecOfAssetDefinitionProjectionOfSelectorMarker.forEach { value ->
                AssetDefinitionProjectionOfSelectorMarker.write(writer, value)
            }
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
