//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import java.math.BigInteger
import kotlin.Unit

/**
 * Schedule
 *
 * Generated from 'Schedule' regular structure
 */
public data class Schedule(
    public val startMs: BigInteger,
    public val periodMs: BigInteger? = null,
) {
    public companion object : ScaleReader<Schedule>, ScaleWriter<Schedule> {
        override fun read(reader: ScaleCodecReader): Schedule = try {
            Schedule(
                reader.readUint64(),
                reader.readNullable(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: Schedule): Unit = try {
            writer.writeUint64(instance.startMs)
            writer.writeNullable(instance.periodMs)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
