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
 * CanUnregisterDomain
 *
 * Generated from 'CanUnregisterDomain' regular structure
 */
public data class CanUnregisterDomain(
    public val domain: DomainId,
) {
    public companion object : ScaleReader<CanUnregisterDomain>, ScaleWriter<CanUnregisterDomain> {
        override fun read(reader: ScaleCodecReader): CanUnregisterDomain = try {
            CanUnregisterDomain(
                DomainId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanUnregisterDomain): Unit = try {
            DomainId.write(writer, instance.domain)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
