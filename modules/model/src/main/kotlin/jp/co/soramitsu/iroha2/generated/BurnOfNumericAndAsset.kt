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
 * BurnOfNumericAndAsset
 *
 * Generated from 'BurnOfNumericAndAsset' regular structure
 */
public data class BurnOfNumericAndAsset(
    public val `object`: Numeric,
    public val destination: AssetId,
) {
    public companion object : ScaleReader<BurnOfNumericAndAsset>, ScaleWriter<BurnOfNumericAndAsset> {
        override fun read(reader: ScaleCodecReader): BurnOfNumericAndAsset = try {
            BurnOfNumericAndAsset(
                Numeric.read(reader),
                AssetId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: BurnOfNumericAndAsset): Unit = try {
            Numeric.write(writer, instance.`object`)
            AssetId.write(writer, instance.destination)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
