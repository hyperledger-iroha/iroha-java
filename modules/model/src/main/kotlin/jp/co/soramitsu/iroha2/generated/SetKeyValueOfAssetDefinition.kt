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
 * SetKeyValueOfAssetDefinition
 *
 * Generated from 'SetKeyValueOfAssetDefinition' regular structure
 */
public data class SetKeyValueOfAssetDefinition(
    public val `object`: AssetDefinitionId,
    public val key: Name,
    public val `value`: String,
) {
    public companion object :
        ScaleReader<SetKeyValueOfAssetDefinition>,
        ScaleWriter<SetKeyValueOfAssetDefinition> {
        override fun read(reader: ScaleCodecReader): SetKeyValueOfAssetDefinition = try {
            SetKeyValueOfAssetDefinition(
                AssetDefinitionId.read(reader),
                Name.read(reader),
                reader.readString(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: SetKeyValueOfAssetDefinition): Unit = try {
            AssetDefinitionId.write(writer, instance.`object`)
            Name.write(writer, instance.key)
            writer.writeAsList(instance.`value`.toByteArray(Charsets.UTF_8))
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
