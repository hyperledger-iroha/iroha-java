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
 * NewAccount
 *
 * Generated from 'NewAccount' regular structure
 */
public data class NewAccount(
    public val id: AccountId,
    public val metadata: Metadata,
) {
    public companion object : ScaleReader<NewAccount>, ScaleWriter<NewAccount> {
        override fun read(reader: ScaleCodecReader): NewAccount = try {
            NewAccount(
                AccountId.read(reader),
                Metadata.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: NewAccount): Unit = try {
            AccountId.write(writer, instance.id)
            Metadata.write(writer, instance.metadata)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
