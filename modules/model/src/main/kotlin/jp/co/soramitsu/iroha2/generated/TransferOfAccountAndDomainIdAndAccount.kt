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
 * TransferOfAccountAndDomainIdAndAccount
 *
 * Generated from 'TransferOfAccountAndDomainIdAndAccount' regular structure
 */
public data class TransferOfAccountAndDomainIdAndAccount(
    public val source: AccountId,
    public val `object`: DomainId,
    public val destination: AccountId,
) {
    public companion object :
        ScaleReader<TransferOfAccountAndDomainIdAndAccount>,
        ScaleWriter<TransferOfAccountAndDomainIdAndAccount> {
        override fun read(reader: ScaleCodecReader): TransferOfAccountAndDomainIdAndAccount = try {
            TransferOfAccountAndDomainIdAndAccount(
                AccountId.read(reader),
                DomainId.read(reader),
                AccountId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: TransferOfAccountAndDomainIdAndAccount): Unit = try {
            AccountId.write(writer, instance.source)
            DomainId.write(writer, instance.`object`)
            AccountId.write(writer, instance.destination)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
