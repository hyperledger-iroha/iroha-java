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
 * RemoveKeyValueOfAsset
 *
 * Generated from 'RemoveKeyValueOfAsset' regular structure
 */
public data class RemoveKeyValueOfAsset(
    public val `object`: AssetId,
    public val key: Name,
) {
    public companion object : ScaleReader<RemoveKeyValueOfAsset>, ScaleWriter<RemoveKeyValueOfAsset> {
        override fun read(reader: ScaleCodecReader): RemoveKeyValueOfAsset = try {
            RemoveKeyValueOfAsset(
                AssetId.read(reader),
                Name.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: RemoveKeyValueOfAsset): Unit = try {
            AssetId.write(writer, instance.`object`)
            Name.write(writer, instance.key)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
