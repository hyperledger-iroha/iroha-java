//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated.datamodel.events.`data`.filters

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.generated.datamodel.account.AccountId
import jp.co.soramitsu.iroha2.wrapException

/**
 * IdFilterAccountId
 *
 * Generated from 'iroha_data_model::events::data::filters::IdFilterAccountId' tuple structure
 */
public data class IdFilterAccountId(
    public val accountId: AccountId
) {
    public companion object : ScaleReader<IdFilterAccountId>, ScaleWriter<IdFilterAccountId> {
        public override fun read(reader: ScaleCodecReader): IdFilterAccountId = try {
            IdFilterAccountId(
                AccountId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        public override fun write(writer: ScaleCodecWriter, instance: IdFilterAccountId) = try {
            AccountId.write(writer, instance.accountId)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
