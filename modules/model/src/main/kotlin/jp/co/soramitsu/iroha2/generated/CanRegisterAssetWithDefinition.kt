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
 * CanRegisterAssetWithDefinition
 *
 * Generated from 'CanRegisterAssetWithDefinition' regular structure
 */
public data class CanRegisterAssetWithDefinition(
    public val assetDefinition: AssetDefinitionId,
) {
    public companion object :
        ScaleReader<CanRegisterAssetWithDefinition>,
        ScaleWriter<CanRegisterAssetWithDefinition> {
        override fun read(reader: ScaleCodecReader): CanRegisterAssetWithDefinition = try {
            CanRegisterAssetWithDefinition(
                AssetDefinitionId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanRegisterAssetWithDefinition): Unit =
            try {
                AssetDefinitionId.write(writer, instance.assetDefinition)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
