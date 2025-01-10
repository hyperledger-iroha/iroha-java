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
 * FindAccountMetadata
 *
 * Generated from 'FindAccountMetadata' regular structure
 */
public data class FindAccountMetadata(
    public val id: AccountId,
    public val key: Name,
) {
    public companion object : ScaleReader<FindAccountMetadata>, ScaleWriter<FindAccountMetadata> {
        override fun read(reader: ScaleCodecReader): FindAccountMetadata = try {
            FindAccountMetadata(
                AccountId.read(reader),
                Name.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: FindAccountMetadata): Unit = try {
            AccountId.write(writer, instance.id)
            Name.write(writer, instance.key)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
