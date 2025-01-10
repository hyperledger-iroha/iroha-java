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
 * AssetDefinition
 *
 * Generated from 'AssetDefinition' regular structure
 */
public data class AssetDefinition(
    public val id: AssetDefinitionId,
    public val type: AssetType,
    public val mintable: Mintable,
    public val logo: IpfsPath? = null,
    public val metadata: Metadata,
    public val ownedBy: AccountId,
) {
    public companion object : ScaleReader<AssetDefinition>, ScaleWriter<AssetDefinition> {
        override fun read(reader: ScaleCodecReader): AssetDefinition = try {
            AssetDefinition(
                AssetDefinitionId.read(reader),
                AssetType.read(reader),
                Mintable.read(reader),
                reader.readNullable(IpfsPath) as IpfsPath?,
                Metadata.read(reader),
                AccountId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: AssetDefinition): Unit = try {
            AssetDefinitionId.write(writer, instance.id)
            AssetType.write(writer, instance.type)
            Mintable.write(writer, instance.mintable)
            writer.writeNullable(IpfsPath, instance.logo)
            Metadata.write(writer, instance.metadata)
            AccountId.write(writer, instance.ownedBy)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
