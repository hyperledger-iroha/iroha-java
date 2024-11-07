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
 * CanModifyAssetMetadata
 *
 * Generated from 'CanModifyAssetMetadata' regular structure
 */
public data class CanModifyAssetMetadata(
    public val asset: AssetId,
) {
    public companion object : ScaleReader<CanModifyAssetMetadata>, ScaleWriter<CanModifyAssetMetadata> {
        override fun read(reader: ScaleCodecReader): CanModifyAssetMetadata = try {
            CanModifyAssetMetadata(
                AssetId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanModifyAssetMetadata): Unit = try {
            AssetId.write(writer, instance.asset)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
