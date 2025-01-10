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
 * RegisterOfPeer
 *
 * Generated from 'RegisterOfPeer' regular structure
 */
public data class RegisterOfPeer(
    public val `object`: Peer,
) {
    public companion object : ScaleReader<RegisterOfPeer>, ScaleWriter<RegisterOfPeer> {
        override fun read(reader: ScaleCodecReader): RegisterOfPeer = try {
            RegisterOfPeer(
                Peer.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: RegisterOfPeer): Unit = try {
            Peer.write(writer, instance.`object`)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
