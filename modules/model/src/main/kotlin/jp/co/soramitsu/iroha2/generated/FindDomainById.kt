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
 * FindDomainById
 *
 * Generated from 'FindDomainById' regular structure
 */
public data class FindDomainById(
    public val id: DomainId,
) {
    public companion object : ScaleReader<FindDomainById>, ScaleWriter<FindDomainById> {
        override fun read(reader: ScaleCodecReader): FindDomainById = try {
            FindDomainById(
                DomainId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: FindDomainById): Unit = try {
            DomainId.write(writer, instance.id)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
