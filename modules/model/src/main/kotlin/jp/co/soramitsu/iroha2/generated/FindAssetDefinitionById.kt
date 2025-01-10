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
 * FindAssetDefinitionById
 *
 * Generated from 'FindAssetDefinitionById' regular structure
 */
public data class FindAssetDefinitionById(
    public val id: AssetDefinitionId,
) {
    public companion object :
        ScaleReader<FindAssetDefinitionById>,
        ScaleWriter<FindAssetDefinitionById> {
        override fun read(reader: ScaleCodecReader): FindAssetDefinitionById = try {
            FindAssetDefinitionById(
                AssetDefinitionId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: FindAssetDefinitionById): Unit = try {
            AssetDefinitionId.write(writer, instance.id)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
