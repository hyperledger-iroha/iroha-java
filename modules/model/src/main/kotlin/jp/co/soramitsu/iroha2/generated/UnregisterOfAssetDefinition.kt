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
 * UnregisterOfAssetDefinition
 *
 * Generated from 'UnregisterOfAssetDefinition' regular structure
 */
public data class UnregisterOfAssetDefinition(
    public val `object`: AssetDefinitionId,
) {
    public companion object :
        ScaleReader<UnregisterOfAssetDefinition>,
        ScaleWriter<UnregisterOfAssetDefinition> {
        override fun read(reader: ScaleCodecReader): UnregisterOfAssetDefinition = try {
            UnregisterOfAssetDefinition(
                AssetDefinitionId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: UnregisterOfAssetDefinition): Unit = try {
            AssetDefinitionId.write(writer, instance.`object`)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
