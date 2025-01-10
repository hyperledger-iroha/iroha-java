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
 * ExecutorEventFilter
 *
 * Generated from 'ExecutorEventFilter' regular structure
 */
public data class ExecutorEventFilter(
    public val eventSet: Long,
) {
    public companion object : ScaleReader<ExecutorEventFilter>, ScaleWriter<ExecutorEventFilter> {
        override fun read(reader: ScaleCodecReader): ExecutorEventFilter = try {
            ExecutorEventFilter(
                reader.readUint32(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: ExecutorEventFilter): Unit = try {
            writer.writeUint32(instance.eventSet)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
