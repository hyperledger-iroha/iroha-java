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
 * RoleEventFilter
 *
 * Generated from 'RoleEventFilter' regular structure
 */
public data class RoleEventFilter(
    public val idMatcher: RoleId? = null,
    public val eventSet: Long,
) {
    public companion object : ScaleReader<RoleEventFilter>, ScaleWriter<RoleEventFilter> {
        override fun read(reader: ScaleCodecReader): RoleEventFilter = try {
            RoleEventFilter(
                reader.readNullable(RoleId) as RoleId?,
                reader.readUint32(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: RoleEventFilter): Unit = try {
            writer.writeNullable(RoleId, instance.idMatcher)
            writer.writeUint32(instance.eventSet)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
