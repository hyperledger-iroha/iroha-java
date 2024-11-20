//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.ModelPermission
import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Unit

/**
 * CanModifyAccountMetadata
 *
 * Generated from 'CanModifyAccountMetadata' regular structure
 */
public data class CanModifyAccountMetadata(
    public val account: AccountId,
) : ModelPermission {
    public companion object :
        ScaleReader<CanModifyAccountMetadata>,
        ScaleWriter<CanModifyAccountMetadata> {
        override fun read(reader: ScaleCodecReader): CanModifyAccountMetadata = try {
            CanModifyAccountMetadata(
                AccountId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanModifyAccountMetadata): Unit = try {
            AccountId.write(writer, instance.account)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
