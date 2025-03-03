//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.ModelPermission
import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Unit

/**
 * CanModifyDomainMetadata
 *
 * Generated from 'CanModifyDomainMetadata' regular structure
 */
public data class CanModifyDomainMetadata(
    public val domain: DomainId,
) : ModelPermission {
    public companion object :
        ScaleReader<CanModifyDomainMetadata>,
        ScaleWriter<CanModifyDomainMetadata> {
        override fun read(reader: ScaleCodecReader): CanModifyDomainMetadata =
            try {
                CanModifyDomainMetadata(
                    DomainId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: CanModifyDomainMetadata,
        ): Unit =
            try {
                DomainId.write(writer, instance.domain)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
