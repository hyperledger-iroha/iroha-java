//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.ModelPermission
import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Unit

/**
 * CanModifyAssetDefinitionMetadata
 *
 * Generated from 'CanModifyAssetDefinitionMetadata' regular structure
 */
public data class CanModifyAssetDefinitionMetadata(
    public val assetDefinition: AssetDefinitionId,
) : ModelPermission {
    public companion object :
        ScaleReader<CanModifyAssetDefinitionMetadata>,
        ScaleWriter<CanModifyAssetDefinitionMetadata> {
        override fun read(reader: ScaleCodecReader): CanModifyAssetDefinitionMetadata =
            try {
                CanModifyAssetDefinitionMetadata(
                    AssetDefinitionId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: CanModifyAssetDefinitionMetadata,
        ): Unit =
            try {
                AssetDefinitionId.write(writer, instance.assetDefinition)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
