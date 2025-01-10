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
 * RemoveKeyValueOfDomain
 *
 * Generated from 'RemoveKeyValueOfDomain' regular structure
 */
public data class RemoveKeyValueOfDomain(
    public val `object`: DomainId,
    public val key: Name,
) {
    public companion object : ScaleReader<RemoveKeyValueOfDomain>, ScaleWriter<RemoveKeyValueOfDomain> {
        override fun read(reader: ScaleCodecReader): RemoveKeyValueOfDomain = try {
            RemoveKeyValueOfDomain(
                DomainId.read(reader),
                Name.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: RemoveKeyValueOfDomain): Unit = try {
            DomainId.write(writer, instance.`object`)
            Name.write(writer, instance.key)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
