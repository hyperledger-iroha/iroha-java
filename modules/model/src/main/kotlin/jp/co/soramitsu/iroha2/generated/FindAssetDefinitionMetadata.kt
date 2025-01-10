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
 * FindAssetDefinitionMetadata
 *
 * Generated from 'FindAssetDefinitionMetadata' regular structure
 */
public data class FindAssetDefinitionMetadata(
    public val id: AssetDefinitionId,
    public val key: Name,
) {
    public companion object :
        ScaleReader<FindAssetDefinitionMetadata>,
        ScaleWriter<FindAssetDefinitionMetadata> {
        override fun read(reader: ScaleCodecReader): FindAssetDefinitionMetadata = try {
            FindAssetDefinitionMetadata(
                AssetDefinitionId.read(reader),
                Name.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: FindAssetDefinitionMetadata): Unit = try {
            AssetDefinitionId.write(writer, instance.id)
            Name.write(writer, instance.key)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
