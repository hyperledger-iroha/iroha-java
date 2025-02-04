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
 * CanUnregisterAssetWithDefinition
 *
 * Generated from 'CanUnregisterAssetWithDefinition' regular structure
 */
public data class CanUnregisterAssetWithDefinition(
    public val assetDefinition: AssetDefinitionId,
) : ModelPermission {
    public companion object :
        ScaleReader<CanUnregisterAssetWithDefinition>,
        ScaleWriter<CanUnregisterAssetWithDefinition> {
        override fun read(reader: ScaleCodecReader): CanUnregisterAssetWithDefinition =
            try {
                CanUnregisterAssetWithDefinition(
                    AssetDefinitionId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: CanUnregisterAssetWithDefinition,
        ): Unit =
            try {
                AssetDefinitionId.write(writer, instance.assetDefinition)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
