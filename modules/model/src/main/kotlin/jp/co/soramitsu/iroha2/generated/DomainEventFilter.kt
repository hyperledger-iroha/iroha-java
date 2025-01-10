//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Long
import kotlin.Unit

/**
 * DomainEventFilter
 *
 * Generated from 'DomainEventFilter' regular structure
 */
public data class DomainEventFilter(
    public val idMatcher: DomainId? = null,
    public val eventSet: Long,
) {
    public companion object : ScaleReader<DomainEventFilter>, ScaleWriter<DomainEventFilter> {
        override fun read(reader: ScaleCodecReader): DomainEventFilter = try {
            DomainEventFilter(
                reader.readNullable(DomainId) as DomainId?,
                reader.readUint32(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: DomainEventFilter): Unit = try {
            writer.writeNullable(DomainId, instance.idMatcher)
            writer.writeUint32(instance.eventSet)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
