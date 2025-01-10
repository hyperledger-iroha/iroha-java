//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.String
import kotlin.Unit

/**
 * Log
 *
 * Generated from 'Log' regular structure
 */
public data class Log(
    public val level: Level,
    public val msg: String,
) {
    public companion object : ScaleReader<Log>, ScaleWriter<Log> {
        override fun read(reader: ScaleCodecReader): Log = try {
            Log(
                Level.read(reader),
                reader.readString(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: Log): Unit = try {
            Level.write(writer, instance.level)
            writer.writeAsList(instance.msg.toByteArray(Charsets.UTF_8))
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
