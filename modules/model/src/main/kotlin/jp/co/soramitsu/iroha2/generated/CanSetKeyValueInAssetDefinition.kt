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
 * CanSetKeyValueInAssetDefinition
 *
 * Generated from 'CanSetKeyValueInAssetDefinition' regular structure
 */
public data class CanSetKeyValueInAssetDefinition(
    public val assetDefinition: AssetDefinitionId,
) {
    public companion object :
        ScaleReader<CanSetKeyValueInAssetDefinition>,
        ScaleWriter<CanSetKeyValueInAssetDefinition> {
        override fun read(reader: ScaleCodecReader): CanSetKeyValueInAssetDefinition = try {
            CanSetKeyValueInAssetDefinition(
                AssetDefinitionId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanSetKeyValueInAssetDefinition): Unit =
            try {
                AssetDefinitionId.write(writer, instance.assetDefinition)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
