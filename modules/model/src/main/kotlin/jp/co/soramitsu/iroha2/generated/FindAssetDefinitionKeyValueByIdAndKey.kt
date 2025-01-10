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
 * FindAssetDefinitionKeyValueByIdAndKey
 *
 * Generated from 'FindAssetDefinitionKeyValueByIdAndKey' regular structure
 */
public data class FindAssetDefinitionKeyValueByIdAndKey(
    public val id: AssetDefinitionId,
    public val key: Name,
) {
    public companion object :
        ScaleReader<FindAssetDefinitionKeyValueByIdAndKey>,
        ScaleWriter<FindAssetDefinitionKeyValueByIdAndKey> {
        override fun read(reader: ScaleCodecReader): FindAssetDefinitionKeyValueByIdAndKey = try {
            FindAssetDefinitionKeyValueByIdAndKey(
                AssetDefinitionId.read(reader),
                Name.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: FindAssetDefinitionKeyValueByIdAndKey): Unit = try {
            AssetDefinitionId.write(writer, instance.id)
            Name.write(writer, instance.key)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
