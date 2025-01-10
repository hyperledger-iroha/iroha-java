//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.String
import kotlin.Unit

/**
 * MetadataChangedOfAssetDefinitionId
 *
 * Generated from 'MetadataChangedOfAssetDefinitionId' regular structure
 */
public data class MetadataChangedOfAssetDefinitionId(
    public val target: AssetDefinitionId,
    public val key: Name,
    public val `value`: String,
) {
    public companion object :
        ScaleReader<MetadataChangedOfAssetDefinitionId>,
        ScaleWriter<MetadataChangedOfAssetDefinitionId> {
        override fun read(reader: ScaleCodecReader): MetadataChangedOfAssetDefinitionId = try {
            MetadataChangedOfAssetDefinitionId(
                AssetDefinitionId.read(reader),
                Name.read(reader),
                reader.readString(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: MetadataChangedOfAssetDefinitionId): Unit = try {
            AssetDefinitionId.write(writer, instance.target)
            Name.write(writer, instance.key)
            writer.writeAsList(instance.`value`.toByteArray(Charsets.UTF_8))
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
