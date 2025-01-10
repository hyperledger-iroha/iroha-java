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
 * MintOfNumericAndAsset
 *
 * Generated from 'MintOfNumericAndAsset' regular structure
 */
public data class MintOfNumericAndAsset(
    public val `object`: Numeric,
    public val destination: AssetId,
) {
    public companion object : ScaleReader<MintOfNumericAndAsset>, ScaleWriter<MintOfNumericAndAsset> {
        override fun read(reader: ScaleCodecReader): MintOfNumericAndAsset = try {
            MintOfNumericAndAsset(
                Numeric.read(reader),
                AssetId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: MintOfNumericAndAsset): Unit = try {
            Numeric.write(writer, instance.`object`)
            AssetId.write(writer, instance.destination)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
