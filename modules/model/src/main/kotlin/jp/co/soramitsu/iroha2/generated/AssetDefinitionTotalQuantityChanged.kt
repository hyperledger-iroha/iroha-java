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
 * AssetDefinitionTotalQuantityChanged
 *
 * Generated from 'AssetDefinitionTotalQuantityChanged' regular structure
 */
public data class AssetDefinitionTotalQuantityChanged(
    public val assetDefinition: AssetDefinitionId,
    public val totalAmount: Numeric,
) {
    public companion object :
        ScaleReader<AssetDefinitionTotalQuantityChanged>,
        ScaleWriter<AssetDefinitionTotalQuantityChanged> {
        override fun read(reader: ScaleCodecReader): AssetDefinitionTotalQuantityChanged = try {
            AssetDefinitionTotalQuantityChanged(
                AssetDefinitionId.read(reader),
                Numeric.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: AssetDefinitionTotalQuantityChanged): Unit = try {
            AssetDefinitionId.write(writer, instance.assetDefinition)
            Numeric.write(writer, instance.totalAmount)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
