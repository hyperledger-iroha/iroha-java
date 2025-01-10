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
 * MetadataChangedOfAssetId
 *
 * Generated from 'MetadataChangedOfAssetId' regular structure
 */
public data class MetadataChangedOfAssetId(
    public val target: AssetId,
    public val key: Name,
    public val `value`: String,
) {
    public companion object :
        ScaleReader<MetadataChangedOfAssetId>,
        ScaleWriter<MetadataChangedOfAssetId> {
        override fun read(reader: ScaleCodecReader): MetadataChangedOfAssetId = try {
            MetadataChangedOfAssetId(
                AssetId.read(reader),
                Name.read(reader),
                reader.readString(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: MetadataChangedOfAssetId): Unit = try {
            AssetId.write(writer, instance.target)
            Name.write(writer, instance.key)
            writer.writeAsList(instance.`value`.toByteArray(Charsets.UTF_8))
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
