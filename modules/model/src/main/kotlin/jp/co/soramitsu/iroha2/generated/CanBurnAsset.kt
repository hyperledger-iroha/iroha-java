//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.ModelPermission
import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Unit

/**
 * CanBurnAsset
 *
 * Generated from 'CanBurnAsset' regular structure
 */
public data class CanBurnAsset(public val asset: AssetId) : ModelPermission {
    public companion object : ScaleReader<CanBurnAsset>, ScaleWriter<CanBurnAsset> {
        override fun read(reader: ScaleCodecReader): CanBurnAsset = try {
            CanBurnAsset(
                AssetId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanBurnAsset): Unit = try {
            AssetId.write(writer, instance.asset)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
