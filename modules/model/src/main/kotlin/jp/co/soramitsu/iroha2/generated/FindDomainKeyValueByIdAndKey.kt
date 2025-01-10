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
 * FindDomainKeyValueByIdAndKey
 *
 * Generated from 'FindDomainKeyValueByIdAndKey' regular structure
 */
public data class FindDomainKeyValueByIdAndKey(
    public val id: DomainId,
    public val key: Name,
) {
    public companion object :
        ScaleReader<FindDomainKeyValueByIdAndKey>,
        ScaleWriter<FindDomainKeyValueByIdAndKey> {
        override fun read(reader: ScaleCodecReader): FindDomainKeyValueByIdAndKey = try {
            FindDomainKeyValueByIdAndKey(
                DomainId.read(reader),
                Name.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: FindDomainKeyValueByIdAndKey): Unit = try {
            DomainId.write(writer, instance.id)
            Name.write(writer, instance.key)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
