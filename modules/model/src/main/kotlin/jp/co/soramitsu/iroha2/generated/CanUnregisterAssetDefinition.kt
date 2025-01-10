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
 * CanUnregisterAssetDefinition
 *
 * Generated from 'CanUnregisterAssetDefinition' regular structure
 */
public data class CanUnregisterAssetDefinition(
    public val assetDefinition: AssetDefinitionId,
) {
    public companion object :
        ScaleReader<CanUnregisterAssetDefinition>,
        ScaleWriter<CanUnregisterAssetDefinition> {
        override fun read(reader: ScaleCodecReader): CanUnregisterAssetDefinition = try {
            CanUnregisterAssetDefinition(
                AssetDefinitionId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanUnregisterAssetDefinition): Unit = try {
            AssetDefinitionId.write(writer, instance.assetDefinition)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
