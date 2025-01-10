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
 * CanTransferUserAsset
 *
 * Generated from 'CanTransferUserAsset' regular structure
 */
public data class CanTransferUserAsset(
    public val asset: AssetId,
) {
    public companion object : ScaleReader<CanTransferUserAsset>, ScaleWriter<CanTransferUserAsset> {
        override fun read(reader: ScaleCodecReader): CanTransferUserAsset = try {
            CanTransferUserAsset(
                AssetId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanTransferUserAsset): Unit = try {
            AssetId.write(writer, instance.asset)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
