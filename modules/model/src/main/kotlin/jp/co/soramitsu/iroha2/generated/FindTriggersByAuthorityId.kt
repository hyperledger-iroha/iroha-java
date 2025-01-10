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
 * FindTriggersByAuthorityId
 *
 * Generated from 'FindTriggersByAuthorityId' regular structure
 */
public data class FindTriggersByAuthorityId(
    public val account: AccountId,
) {
    public companion object :
        ScaleReader<FindTriggersByAuthorityId>,
        ScaleWriter<FindTriggersByAuthorityId> {
        override fun read(reader: ScaleCodecReader): FindTriggersByAuthorityId = try {
            FindTriggersByAuthorityId(
                AccountId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: FindTriggersByAuthorityId): Unit = try {
            AccountId.write(writer, instance.account)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
