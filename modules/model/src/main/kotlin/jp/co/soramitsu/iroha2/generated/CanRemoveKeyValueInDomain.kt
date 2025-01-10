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
 * CanRemoveKeyValueInDomain
 *
 * Generated from 'CanRemoveKeyValueInDomain' regular structure
 */
public data class CanRemoveKeyValueInDomain(
    public val domain: DomainId,
) {
    public companion object :
        ScaleReader<CanRemoveKeyValueInDomain>,
        ScaleWriter<CanRemoveKeyValueInDomain> {
        override fun read(reader: ScaleCodecReader): CanRemoveKeyValueInDomain = try {
            CanRemoveKeyValueInDomain(
                DomainId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanRemoveKeyValueInDomain): Unit = try {
            DomainId.write(writer, instance.domain)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
