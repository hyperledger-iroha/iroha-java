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
 * SelectorTupleOfAsset
 *
 * Generated from 'SelectorTupleOfAsset' regular structure
 */
public data class SelectorTupleOfAsset(public val vecOfAssetProjectionOfSelectorMarker: List<AssetProjectionOfSelectorMarker>) {
    public companion object : ScaleReader<SelectorTupleOfAsset>, ScaleWriter<SelectorTupleOfAsset> {
        override fun read(reader: ScaleCodecReader): SelectorTupleOfAsset = try {
            SelectorTupleOfAsset(
                reader.readVec(reader.readCompactInt()) { AssetProjectionOfSelectorMarker.read(reader) },
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: SelectorTupleOfAsset): Unit = try {
            writer.writeCompact(instance.vecOfAssetProjectionOfSelectorMarker.size)
            instance.vecOfAssetProjectionOfSelectorMarker.forEach { value ->
                AssetProjectionOfSelectorMarker.write(writer, value)
            }
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
