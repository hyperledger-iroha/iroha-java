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
 * Domain
 *
 * Generated from 'Domain' regular structure
 */
public data class Domain(
    public val id: DomainId,
    public val logo: IpfsPath? = null,
    public val metadata: Metadata,
    public val ownedBy: AccountId,
) {
    public companion object : ScaleReader<Domain>, ScaleWriter<Domain> {
        override fun read(reader: ScaleCodecReader): Domain = try {
            Domain(
                DomainId.read(reader),
                reader.readNullable(IpfsPath) as IpfsPath?,
                Metadata.read(reader),
                AccountId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: Domain): Unit = try {
            DomainId.write(writer, instance.id)
            writer.writeNullable(IpfsPath, instance.logo)
            Metadata.write(writer, instance.metadata)
            AccountId.write(writer, instance.ownedBy)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
