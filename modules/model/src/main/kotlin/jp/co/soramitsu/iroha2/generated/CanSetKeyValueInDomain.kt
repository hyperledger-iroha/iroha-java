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
 * CanSetKeyValueInDomain
 *
 * Generated from 'CanSetKeyValueInDomain' regular structure
 */
public data class CanSetKeyValueInDomain(
    public val domain: DomainId,
) {
    public companion object : ScaleReader<CanSetKeyValueInDomain>, ScaleWriter<CanSetKeyValueInDomain> {
        override fun read(reader: ScaleCodecReader): CanSetKeyValueInDomain = try {
            CanSetKeyValueInDomain(
                DomainId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanSetKeyValueInDomain): Unit = try {
            DomainId.write(writer, instance.domain)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
