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
 * NewAssetDefinition
 *
 * Generated from 'NewAssetDefinition' regular structure
 */
public data class NewAssetDefinition(
    public val id: AssetDefinitionId,
    public val type: AssetType,
    public val mintable: Mintable,
    public val logo: IpfsPath? = null,
    public val metadata: Metadata,
) {
    public companion object : ScaleReader<NewAssetDefinition>, ScaleWriter<NewAssetDefinition> {
        override fun read(reader: ScaleCodecReader): NewAssetDefinition = try {
            NewAssetDefinition(
                AssetDefinitionId.read(reader),
                AssetType.read(reader),
                Mintable.read(reader),
                reader.readNullable(IpfsPath) as IpfsPath?,
                Metadata.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: NewAssetDefinition): Unit = try {
            AssetDefinitionId.write(writer, instance.id)
            AssetType.write(writer, instance.type)
            Mintable.write(writer, instance.mintable)
            writer.writeNullable(IpfsPath, instance.logo)
            Metadata.write(writer, instance.metadata)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
