//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.String
import kotlin.Unit

/**
 * MetadataChangedOfAccountId
 *
 * Generated from 'MetadataChangedOfAccountId' regular structure
 */
public data class MetadataChangedOfAccountId(
    public val target: AccountId,
    public val key: Name,
    public val `value`: String,
) {
    public companion object :
        ScaleReader<MetadataChangedOfAccountId>,
        ScaleWriter<MetadataChangedOfAccountId> {
        override fun read(reader: ScaleCodecReader): MetadataChangedOfAccountId = try {
            MetadataChangedOfAccountId(
                AccountId.read(reader),
                Name.read(reader),
                reader.readString(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: MetadataChangedOfAccountId): Unit = try {
            AccountId.write(writer, instance.target)
            Name.write(writer, instance.key)
            writer.writeAsList(instance.`value`.toByteArray(Charsets.UTF_8))
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
