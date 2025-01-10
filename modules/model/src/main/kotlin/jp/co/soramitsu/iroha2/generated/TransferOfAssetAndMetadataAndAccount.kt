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
 * TransferOfAssetAndMetadataAndAccount
 *
 * Generated from 'TransferOfAssetAndMetadataAndAccount' regular structure
 */
public data class TransferOfAssetAndMetadataAndAccount(
    public val source: AssetId,
    public val `object`: Metadata,
    public val destination: AccountId,
) {
    public companion object :
        ScaleReader<TransferOfAssetAndMetadataAndAccount>,
        ScaleWriter<TransferOfAssetAndMetadataAndAccount> {
        override fun read(reader: ScaleCodecReader): TransferOfAssetAndMetadataAndAccount = try {
            TransferOfAssetAndMetadataAndAccount(
                AssetId.read(reader),
                Metadata.read(reader),
                AccountId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: TransferOfAssetAndMetadataAndAccount): Unit = try {
            AssetId.write(writer, instance.source)
            Metadata.write(writer, instance.`object`)
            AccountId.write(writer, instance.destination)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
