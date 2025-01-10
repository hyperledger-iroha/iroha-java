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
 * FindTriggersByAuthorityDomainId
 *
 * Generated from 'FindTriggersByAuthorityDomainId' regular structure
 */
public data class FindTriggersByAuthorityDomainId(
    public val domain: DomainId,
) {
    public companion object :
        ScaleReader<FindTriggersByAuthorityDomainId>,
        ScaleWriter<FindTriggersByAuthorityDomainId> {
        override fun read(reader: ScaleCodecReader): FindTriggersByAuthorityDomainId = try {
            FindTriggersByAuthorityDomainId(
                DomainId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: FindTriggersByAuthorityDomainId): Unit =
            try {
                DomainId.write(writer, instance.domain)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
