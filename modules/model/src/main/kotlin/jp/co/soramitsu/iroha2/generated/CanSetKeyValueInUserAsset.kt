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
 * CanSetKeyValueInUserAsset
 *
 * Generated from 'CanSetKeyValueInUserAsset' regular structure
 */
public data class CanSetKeyValueInUserAsset(
    public val asset: AssetId,
) {
    public companion object :
        ScaleReader<CanSetKeyValueInUserAsset>,
        ScaleWriter<CanSetKeyValueInUserAsset> {
        override fun read(reader: ScaleCodecReader): CanSetKeyValueInUserAsset = try {
            CanSetKeyValueInUserAsset(
                AssetId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanSetKeyValueInUserAsset): Unit = try {
            AssetId.write(writer, instance.asset)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
