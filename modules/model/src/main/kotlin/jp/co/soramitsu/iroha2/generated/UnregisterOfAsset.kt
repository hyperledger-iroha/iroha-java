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
 * UnregisterOfAsset
 *
 * Generated from 'UnregisterOfAsset' regular structure
 */
public data class UnregisterOfAsset(
    public val `object`: AssetId,
) {
    public companion object : ScaleReader<UnregisterOfAsset>, ScaleWriter<UnregisterOfAsset> {
        override fun read(reader: ScaleCodecReader): UnregisterOfAsset = try {
            UnregisterOfAsset(
                AssetId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: UnregisterOfAsset): Unit = try {
            AssetId.write(writer, instance.`object`)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
