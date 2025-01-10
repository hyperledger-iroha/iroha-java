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
 * AssetChanged
 *
 * Generated from 'AssetChanged' regular structure
 */
public data class AssetChanged(
    public val asset: AssetId,
    public val amount: AssetValue,
) {
    public companion object : ScaleReader<AssetChanged>, ScaleWriter<AssetChanged> {
        override fun read(reader: ScaleCodecReader): AssetChanged = try {
            AssetChanged(
                AssetId.read(reader),
                AssetValue.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: AssetChanged): Unit = try {
            AssetId.write(writer, instance.asset)
            AssetValue.write(writer, instance.amount)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
