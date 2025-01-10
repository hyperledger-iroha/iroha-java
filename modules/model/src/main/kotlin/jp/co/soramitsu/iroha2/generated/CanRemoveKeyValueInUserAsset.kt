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
 * CanRemoveKeyValueInUserAsset
 *
 * Generated from 'CanRemoveKeyValueInUserAsset' regular structure
 */
public data class CanRemoveKeyValueInUserAsset(
    public val asset: AssetId,
) {
    public companion object :
        ScaleReader<CanRemoveKeyValueInUserAsset>,
        ScaleWriter<CanRemoveKeyValueInUserAsset> {
        override fun read(reader: ScaleCodecReader): CanRemoveKeyValueInUserAsset = try {
            CanRemoveKeyValueInUserAsset(
                AssetId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanRemoveKeyValueInUserAsset): Unit = try {
            AssetId.write(writer, instance.asset)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
