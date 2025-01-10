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
 * FindDomainMetadata
 *
 * Generated from 'FindDomainMetadata' regular structure
 */
public data class FindDomainMetadata(
    public val id: DomainId,
    public val key: Name,
) {
    public companion object : ScaleReader<FindDomainMetadata>, ScaleWriter<FindDomainMetadata> {
        override fun read(reader: ScaleCodecReader): FindDomainMetadata = try {
            FindDomainMetadata(
                DomainId.read(reader),
                Name.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: FindDomainMetadata): Unit = try {
            DomainId.write(writer, instance.id)
            Name.write(writer, instance.key)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
