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
 * CanRegisterAssetDefinitionInDomain
 *
 * Generated from 'CanRegisterAssetDefinitionInDomain' regular structure
 */
public data class CanRegisterAssetDefinitionInDomain(
    public val domain: DomainId,
) {
    public companion object :
        ScaleReader<CanRegisterAssetDefinitionInDomain>,
        ScaleWriter<CanRegisterAssetDefinitionInDomain> {
        override fun read(reader: ScaleCodecReader): CanRegisterAssetDefinitionInDomain = try {
            CanRegisterAssetDefinitionInDomain(
                DomainId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanRegisterAssetDefinitionInDomain): Unit = try {
            DomainId.write(writer, instance.domain)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
