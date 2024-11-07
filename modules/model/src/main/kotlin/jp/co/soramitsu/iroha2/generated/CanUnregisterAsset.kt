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
 * CanUnregisterAsset
 *
 * Generated from 'CanUnregisterAsset' regular structure
 */
public data class CanUnregisterAsset(
    public val asset: AssetId,
) {
    public companion object : ScaleReader<CanUnregisterAsset>, ScaleWriter<CanUnregisterAsset> {
        override fun read(reader: ScaleCodecReader): CanUnregisterAsset = try {
            CanUnregisterAsset(
                AssetId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanUnregisterAsset): Unit = try {
            AssetId.write(writer, instance.asset)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
