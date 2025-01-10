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
 * UnregisterOfDomain
 *
 * Generated from 'UnregisterOfDomain' regular structure
 */
public data class UnregisterOfDomain(
    public val `object`: DomainId,
) {
    public companion object : ScaleReader<UnregisterOfDomain>, ScaleWriter<UnregisterOfDomain> {
        override fun read(reader: ScaleCodecReader): UnregisterOfDomain = try {
            UnregisterOfDomain(
                DomainId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: UnregisterOfDomain): Unit = try {
            DomainId.write(writer, instance.`object`)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
