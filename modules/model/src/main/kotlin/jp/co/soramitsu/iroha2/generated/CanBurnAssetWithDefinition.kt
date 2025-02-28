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
 * CanBurnAssetWithDefinition
 *
 * Generated from 'CanBurnAssetWithDefinition' regular structure
 */
public data class CanBurnAssetWithDefinition(
    public val assetDefinition: AssetDefinitionId,
) : ModelPermission {
    public companion object :
        ScaleReader<CanBurnAssetWithDefinition>,
        ScaleWriter<CanBurnAssetWithDefinition> {
        override fun read(reader: ScaleCodecReader): CanBurnAssetWithDefinition =
            try {
                CanBurnAssetWithDefinition(
                    AssetDefinitionId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: CanBurnAssetWithDefinition,
        ): Unit =
            try {
                AssetDefinitionId.write(writer, instance.assetDefinition)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
