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
 * AssetDefinitionId
 *
 * Generated from 'AssetDefinitionId' regular structure
 */
public data class AssetDefinitionId(
    public val domain: DomainId,
    public val name: Name,
) {
    public companion object : ScaleReader<AssetDefinitionId>, ScaleWriter<AssetDefinitionId> {
        override fun read(reader: ScaleCodecReader): AssetDefinitionId = try {
            AssetDefinitionId(
                DomainId.read(reader),
                Name.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: AssetDefinitionId): Unit = try {
            DomainId.write(writer, instance.domain)
            Name.write(writer, instance.name)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
