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
 * FindAssetMetadata
 *
 * Generated from 'FindAssetMetadata' regular structure
 */
public data class FindAssetMetadata(
    public val id: AssetId,
    public val key: Name,
) {
    public companion object : ScaleReader<FindAssetMetadata>, ScaleWriter<FindAssetMetadata> {
        override fun read(reader: ScaleCodecReader): FindAssetMetadata = try {
            FindAssetMetadata(
                AssetId.read(reader),
                Name.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: FindAssetMetadata): Unit = try {
            AssetId.write(writer, instance.id)
            Name.write(writer, instance.key)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
