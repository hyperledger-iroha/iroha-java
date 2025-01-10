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
 * CanBurnUserAsset
 *
 * Generated from 'CanBurnUserAsset' regular structure
 */
public data class CanBurnUserAsset(
    public val asset: AssetId,
) {
    public companion object : ScaleReader<CanBurnUserAsset>, ScaleWriter<CanBurnUserAsset> {
        override fun read(reader: ScaleCodecReader): CanBurnUserAsset = try {
            CanBurnUserAsset(
                AssetId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanBurnUserAsset): Unit = try {
            AssetId.write(writer, instance.asset)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
