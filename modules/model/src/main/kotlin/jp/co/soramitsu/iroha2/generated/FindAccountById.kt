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
 * FindAccountById
 *
 * Generated from 'FindAccountById' regular structure
 */
public data class FindAccountById(
    public val id: AccountId,
) {
    public companion object : ScaleReader<FindAccountById>, ScaleWriter<FindAccountById> {
        override fun read(reader: ScaleCodecReader): FindAccountById = try {
            FindAccountById(
                AccountId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: FindAccountById): Unit = try {
            AccountId.write(writer, instance.id)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
