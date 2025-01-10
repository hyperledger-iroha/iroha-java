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
 * FindTotalAssetQuantityByAssetDefinitionId
 *
 * Generated from 'FindTotalAssetQuantityByAssetDefinitionId' regular structure
 */
public data class FindTotalAssetQuantityByAssetDefinitionId(
    public val id: AssetDefinitionId,
) {
    public companion object :
        ScaleReader<FindTotalAssetQuantityByAssetDefinitionId>,
        ScaleWriter<FindTotalAssetQuantityByAssetDefinitionId> {
        override fun read(reader: ScaleCodecReader): FindTotalAssetQuantityByAssetDefinitionId = try {
            FindTotalAssetQuantityByAssetDefinitionId(
                AssetDefinitionId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(
            writer: ScaleCodecWriter,
            instance: FindTotalAssetQuantityByAssetDefinitionId,
        ): Unit = try {
            AssetDefinitionId.write(writer, instance.id)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
