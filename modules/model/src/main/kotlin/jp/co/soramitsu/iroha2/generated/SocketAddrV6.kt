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
 * SocketAddrV6
 *
 * Generated from 'SocketAddrV6' regular structure
 */
public data class SocketAddrV6(
    public val ip: Ipv6Addr,
    public val port: Int,
) {
    public companion object : ScaleReader<SocketAddrV6>, ScaleWriter<SocketAddrV6> {
        override fun read(reader: ScaleCodecReader): SocketAddrV6 =
            try {
                SocketAddrV6(
                    Ipv6Addr.read(reader),
                    reader.readUint16(),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: SocketAddrV6,
        ): Unit =
            try {
                Ipv6Addr.write(writer, instance.ip)
                writer.writeUint16(instance.port)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
