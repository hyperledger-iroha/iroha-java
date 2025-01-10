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
 * CanUnregisterUserAsset
 *
 * Generated from 'CanUnregisterUserAsset' regular structure
 */
public data class CanUnregisterUserAsset(
    public val asset: AssetId,
) {
    public companion object : ScaleReader<CanUnregisterUserAsset>, ScaleWriter<CanUnregisterUserAsset> {
        override fun read(reader: ScaleCodecReader): CanUnregisterUserAsset = try {
            CanUnregisterUserAsset(
                AssetId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanUnregisterUserAsset): Unit = try {
            AssetId.write(writer, instance.asset)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
