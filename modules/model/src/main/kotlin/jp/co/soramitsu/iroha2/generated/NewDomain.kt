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
 * NewDomain
 *
 * Generated from 'NewDomain' regular structure
 */
public data class NewDomain(
    public val id: DomainId,
    public val logo: IpfsPath? = null,
    public val metadata: Metadata,
) {
    public companion object : ScaleReader<NewDomain>, ScaleWriter<NewDomain> {
        override fun read(reader: ScaleCodecReader): NewDomain =
            try {
                NewDomain(
                    DomainId.read(reader),
                    reader.readNullable(IpfsPath) as IpfsPath?,
                    Metadata.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: NewDomain,
        ): Unit =
            try {
                DomainId.write(writer, instance.id)
                writer.writeNullable(IpfsPath, instance.logo)
                Metadata.write(writer, instance.metadata)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
