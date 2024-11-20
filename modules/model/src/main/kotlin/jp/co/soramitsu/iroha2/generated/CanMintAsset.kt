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
 * CanMintAsset
 *
 * Generated from 'CanMintAsset' regular structure
 */
public data class CanMintAsset(
    public val asset: AssetId,
) : ModelPermission {
    public companion object : ScaleReader<CanMintAsset>, ScaleWriter<CanMintAsset> {
        override fun read(reader: ScaleCodecReader): CanMintAsset = try {
            CanMintAsset(
                AssetId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanMintAsset): Unit = try {
            AssetId.write(writer, instance.asset)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
