//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Long
import kotlin.Unit

/**
 * AccountEventFilter
 *
 * Generated from 'AccountEventFilter' regular structure
 */
public data class AccountEventFilter(
    public val idMatcher: AccountId? = null,
    public val eventSet: Long,
) {
    public companion object : ScaleReader<AccountEventFilter>, ScaleWriter<AccountEventFilter> {
        override fun read(reader: ScaleCodecReader): AccountEventFilter = try {
            AccountEventFilter(
                reader.readNullable(AccountId) as AccountId?,
                reader.readUint32(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: AccountEventFilter): Unit = try {
            writer.writeNullable(AccountId, instance.idMatcher)
            writer.writeUint32(instance.eventSet)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
