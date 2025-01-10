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
 * DomainOwnerChanged
 *
 * Generated from 'DomainOwnerChanged' regular structure
 */
public data class DomainOwnerChanged(
    public val domain: DomainId,
    public val newOwner: AccountId,
) {
    public companion object : ScaleReader<DomainOwnerChanged>, ScaleWriter<DomainOwnerChanged> {
        override fun read(reader: ScaleCodecReader): DomainOwnerChanged = try {
            DomainOwnerChanged(
                DomainId.read(reader),
                AccountId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: DomainOwnerChanged): Unit = try {
            DomainId.write(writer, instance.domain)
            AccountId.write(writer, instance.newOwner)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
