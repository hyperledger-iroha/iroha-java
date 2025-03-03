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
 * MetadataChangedOfAccountId
 *
 * Generated from 'MetadataChangedOfAccountId' regular structure
 */
public data class MetadataChangedOfAccountId(
    public val target: AccountId,
    public val key: Name,
    public val `value`: Json,
) {
    public companion object :
        ScaleReader<MetadataChangedOfAccountId>,
        ScaleWriter<MetadataChangedOfAccountId> {
        override fun read(reader: ScaleCodecReader): MetadataChangedOfAccountId =
            try {
                MetadataChangedOfAccountId(
                    AccountId.read(reader),
                    Name.read(reader),
                    Json.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: MetadataChangedOfAccountId,
        ): Unit =
            try {
                AccountId.write(writer, instance.target)
                Name.write(writer, instance.key)
                Json.write(writer, instance.`value`)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
