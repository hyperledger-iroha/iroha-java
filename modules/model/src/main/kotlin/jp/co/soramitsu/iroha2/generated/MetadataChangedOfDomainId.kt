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
 * MetadataChangedOfDomainId
 *
 * Generated from 'MetadataChangedOfDomainId' regular structure
 */
public data class MetadataChangedOfDomainId(
    public val target: DomainId,
    public val key: Name,
    public val `value`: String,
) {
    public companion object :
        ScaleReader<MetadataChangedOfDomainId>,
        ScaleWriter<MetadataChangedOfDomainId> {
        override fun read(reader: ScaleCodecReader): MetadataChangedOfDomainId = try {
            MetadataChangedOfDomainId(
                DomainId.read(reader),
                Name.read(reader),
                reader.readString(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: MetadataChangedOfDomainId): Unit = try {
            DomainId.write(writer, instance.target)
            Name.write(writer, instance.key)
            writer.writeAsList(instance.`value`.toByteArray(Charsets.UTF_8))
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
