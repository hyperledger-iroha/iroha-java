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
 * CanMintAssetWithDefinition
 *
 * Generated from 'CanMintAssetWithDefinition' regular structure
 */
public data class CanMintAssetWithDefinition(
    public val assetDefinition: AssetDefinitionId,
) {
    public companion object :
        ScaleReader<CanMintAssetWithDefinition>,
        ScaleWriter<CanMintAssetWithDefinition> {
        override fun read(reader: ScaleCodecReader): CanMintAssetWithDefinition = try {
            CanMintAssetWithDefinition(
                AssetDefinitionId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanMintAssetWithDefinition): Unit = try {
            AssetDefinitionId.write(writer, instance.assetDefinition)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
