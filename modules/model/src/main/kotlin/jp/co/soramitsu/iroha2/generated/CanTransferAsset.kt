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
 * CanTransferAsset
 *
 * Generated from 'CanTransferAsset' regular structure
 */
public data class CanTransferAsset(
    public val asset: AssetId,
) : ModelPermission {
    public companion object : ScaleReader<CanTransferAsset>, ScaleWriter<CanTransferAsset> {
        override fun read(reader: ScaleCodecReader): CanTransferAsset =
            try {
                CanTransferAsset(
                    AssetId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: CanTransferAsset,
        ): Unit =
            try {
                AssetId.write(writer, instance.asset)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
