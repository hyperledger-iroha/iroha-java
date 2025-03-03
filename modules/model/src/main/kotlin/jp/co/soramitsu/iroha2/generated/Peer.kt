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
 * Peer
 *
 * Generated from 'Peer' regular structure
 */
public data class Peer(
    public val address: SocketAddr,
    public val id: PeerId,
) {
    public companion object : ScaleReader<Peer>, ScaleWriter<Peer> {
        override fun read(reader: ScaleCodecReader): Peer =
            try {
                Peer(
                    SocketAddr.read(reader),
                    PeerId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: Peer,
        ): Unit =
            try {
                SocketAddr.write(writer, instance.address)
                PeerId.write(writer, instance.id)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
