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
 * TransferOfAccountAndAssetDefinitionIdAndAccount
 *
 * Generated from 'TransferOfAccountAndAssetDefinitionIdAndAccount' regular structure
 */
public data class TransferOfAccountAndAssetDefinitionIdAndAccount(
    public val source: AccountId,
    public val `object`: AssetDefinitionId,
    public val destination: AccountId,
) {
    public companion object :
        ScaleReader<TransferOfAccountAndAssetDefinitionIdAndAccount>,
        ScaleWriter<TransferOfAccountAndAssetDefinitionIdAndAccount> {
        override fun read(reader: ScaleCodecReader): TransferOfAccountAndAssetDefinitionIdAndAccount =
            try {
                TransferOfAccountAndAssetDefinitionIdAndAccount(
                    AccountId.read(reader),
                    AssetDefinitionId.read(reader),
                    AccountId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: TransferOfAccountAndAssetDefinitionIdAndAccount,
        ): Unit = try {
            AccountId.write(writer, instance.source)
            AssetDefinitionId.write(writer, instance.`object`)
            AccountId.write(writer, instance.destination)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
