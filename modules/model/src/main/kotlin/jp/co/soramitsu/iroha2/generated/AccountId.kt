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
 * AccountId
 *
 * Generated from 'AccountId' regular structure
 */
public data class AccountId(
    public val domain: DomainId,
    public val signatory: PublicKey,
) {
    public companion object : ScaleReader<AccountId>, ScaleWriter<AccountId> {
        override fun read(reader: ScaleCodecReader): AccountId = try {
            AccountId(
                DomainId.read(reader),
                PublicKey.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: AccountId): Unit = try {
            DomainId.write(writer, instance.domain)
            PublicKey.write(writer, instance.signatory)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
