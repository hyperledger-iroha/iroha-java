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
 * Asset
 *
 * Generated from 'Asset' regular structure
 */
public data class Asset(
    public val id: AssetId,
    public val `value`: AssetValue,
) {
    public companion object : ScaleReader<Asset>, ScaleWriter<Asset> {
        override fun read(reader: ScaleCodecReader): Asset =
            try {
                Asset(
                    AssetId.read(reader),
                    AssetValue.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: Asset,
        ): Unit =
            try {
                AssetId.write(writer, instance.id)
                AssetValue.write(writer, instance.`value`)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
