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
import kotlin.Unit

/**
 * SocketAddrV4
 *
 * Generated from 'SocketAddrV4' regular structure
 */
public data class SocketAddrV4(
    public val ip: Ipv4Addr,
    public val port: Int,
) {
    public companion object : ScaleReader<SocketAddrV4>, ScaleWriter<SocketAddrV4> {
        override fun read(reader: ScaleCodecReader): SocketAddrV4 =
            try {
                SocketAddrV4(
                    Ipv4Addr.read(reader),
                    reader.readUint16(),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: SocketAddrV4,
        ): Unit =
            try {
                Ipv4Addr.write(writer, instance.ip)
                writer.writeUint16(instance.port)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
