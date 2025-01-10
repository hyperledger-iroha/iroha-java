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
 * TransferOfAssetAndNumericAndAccount
 *
 * Generated from 'TransferOfAssetAndNumericAndAccount' regular structure
 */
public data class TransferOfAssetAndNumericAndAccount(
    public val source: AssetId,
    public val `object`: Numeric,
    public val destination: AccountId,
) {
    public companion object :
        ScaleReader<TransferOfAssetAndNumericAndAccount>,
        ScaleWriter<TransferOfAssetAndNumericAndAccount> {
        override fun read(reader: ScaleCodecReader): TransferOfAssetAndNumericAndAccount = try {
            TransferOfAssetAndNumericAndAccount(
                AssetId.read(reader),
                Numeric.read(reader),
                AccountId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: TransferOfAssetAndNumericAndAccount): Unit = try {
            AssetId.write(writer, instance.source)
            Numeric.write(writer, instance.`object`)
            AccountId.write(writer, instance.destination)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
