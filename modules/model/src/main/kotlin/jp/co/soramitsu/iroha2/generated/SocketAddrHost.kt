//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Int
import kotlin.String
import kotlin.Unit

/**
 * SocketAddrHost
 *
 * Generated from 'SocketAddrHost' regular structure
 */
public data class SocketAddrHost(public val host: String, public val port: Int) {
    public companion object : ScaleReader<SocketAddrHost>, ScaleWriter<SocketAddrHost> {
        override fun read(reader: ScaleCodecReader): SocketAddrHost = try {
            SocketAddrHost(
                reader.readString(),
                reader.readUint16(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: SocketAddrHost): Unit = try {
            writer.writeAsList(instance.host.toByteArray(Charsets.UTF_8))
            writer.writeUint16(instance.port)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
