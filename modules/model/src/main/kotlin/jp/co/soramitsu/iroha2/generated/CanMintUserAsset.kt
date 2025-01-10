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
 * CanMintUserAsset
 *
 * Generated from 'CanMintUserAsset' regular structure
 */
public data class CanMintUserAsset(
    public val asset: AssetId,
) {
    public companion object : ScaleReader<CanMintUserAsset>, ScaleWriter<CanMintUserAsset> {
        override fun read(reader: ScaleCodecReader): CanMintUserAsset = try {
            CanMintUserAsset(
                AssetId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanMintUserAsset): Unit = try {
            AssetId.write(writer, instance.asset)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
