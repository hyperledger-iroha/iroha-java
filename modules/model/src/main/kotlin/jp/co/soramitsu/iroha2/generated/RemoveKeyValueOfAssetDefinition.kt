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
 * RemoveKeyValueOfAssetDefinition
 *
 * Generated from 'RemoveKeyValueOfAssetDefinition' regular structure
 */
public data class RemoveKeyValueOfAssetDefinition(
    public val `object`: AssetDefinitionId,
    public val key: Name,
) {
    public companion object :
        ScaleReader<RemoveKeyValueOfAssetDefinition>,
        ScaleWriter<RemoveKeyValueOfAssetDefinition> {
        override fun read(reader: ScaleCodecReader): RemoveKeyValueOfAssetDefinition = try {
            RemoveKeyValueOfAssetDefinition(
                AssetDefinitionId.read(reader),
                Name.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: RemoveKeyValueOfAssetDefinition): Unit =
            try {
                AssetDefinitionId.write(writer, instance.`object`)
                Name.write(writer, instance.key)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
