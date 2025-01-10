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
 * TimeInterval
 *
 * Generated from 'TimeInterval' regular structure
 */
public data class TimeInterval(
    public val sinceMs: BigInteger,
    public val lengthMs: BigInteger,
) {
    public companion object : ScaleReader<TimeInterval>, ScaleWriter<TimeInterval> {
        override fun read(reader: ScaleCodecReader): TimeInterval = try {
            TimeInterval(
                reader.readUint64(),
                reader.readUint64(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: TimeInterval): Unit = try {
            writer.writeUint64(instance.sinceMs)
            writer.writeUint64(instance.lengthMs)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
