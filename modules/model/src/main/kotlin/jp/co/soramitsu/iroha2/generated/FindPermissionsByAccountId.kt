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
 * FindPermissionsByAccountId
 *
 * Generated from 'FindPermissionsByAccountId' regular structure
 */
public data class FindPermissionsByAccountId(
    public val id: AccountId,
) {
    public companion object :
        ScaleReader<FindPermissionsByAccountId>,
        ScaleWriter<FindPermissionsByAccountId> {
        override fun read(reader: ScaleCodecReader): FindPermissionsByAccountId = try {
            FindPermissionsByAccountId(
                AccountId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: FindPermissionsByAccountId): Unit = try {
            AccountId.write(writer, instance.id)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
