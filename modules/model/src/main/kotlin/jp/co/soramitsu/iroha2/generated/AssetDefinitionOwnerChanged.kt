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
 * AssetDefinitionOwnerChanged
 *
 * Generated from 'AssetDefinitionOwnerChanged' regular structure
 */
public data class AssetDefinitionOwnerChanged(
    public val assetDefinition: AssetDefinitionId,
    public val newOwner: AccountId,
) {
    public companion object :
        ScaleReader<AssetDefinitionOwnerChanged>,
        ScaleWriter<AssetDefinitionOwnerChanged> {
        override fun read(reader: ScaleCodecReader): AssetDefinitionOwnerChanged = try {
            AssetDefinitionOwnerChanged(
                AssetDefinitionId.read(reader),
                AccountId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: AssetDefinitionOwnerChanged): Unit = try {
            AssetDefinitionId.write(writer, instance.assetDefinition)
            AccountId.write(writer, instance.newOwner)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
