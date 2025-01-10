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
 * FindAssetKeyValueByIdAndKey
 *
 * Generated from 'FindAssetKeyValueByIdAndKey' regular structure
 */
public data class FindAssetKeyValueByIdAndKey(
    public val id: AssetId,
    public val key: Name,
) {
    public companion object :
        ScaleReader<FindAssetKeyValueByIdAndKey>,
        ScaleWriter<FindAssetKeyValueByIdAndKey> {
        override fun read(reader: ScaleCodecReader): FindAssetKeyValueByIdAndKey = try {
            FindAssetKeyValueByIdAndKey(
                AssetId.read(reader),
                Name.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: FindAssetKeyValueByIdAndKey): Unit = try {
            AssetId.write(writer, instance.id)
            Name.write(writer, instance.key)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
