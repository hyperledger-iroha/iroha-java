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
 * MetadataChangedOfAssetDefinitionId
 *
 * Generated from 'MetadataChangedOfAssetDefinitionId' regular structure
 */
public data class MetadataChangedOfAssetDefinitionId(
    public val target: AssetDefinitionId,
    public val key: Name,
    public val `value`: Json,
) {
    public companion object :
        ScaleReader<MetadataChangedOfAssetDefinitionId>,
        ScaleWriter<MetadataChangedOfAssetDefinitionId> {
        override fun read(reader: ScaleCodecReader): MetadataChangedOfAssetDefinitionId =
            try {
                MetadataChangedOfAssetDefinitionId(
                    AssetDefinitionId.read(reader),
                    Name.read(reader),
                    Json.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: MetadataChangedOfAssetDefinitionId,
        ): Unit =
            try {
                AssetDefinitionId.write(writer, instance.target)
                Name.write(writer, instance.key)
                Json.write(writer, instance.`value`)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
