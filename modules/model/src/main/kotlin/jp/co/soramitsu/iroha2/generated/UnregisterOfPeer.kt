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
 * UnregisterOfPeer
 *
 * Generated from 'UnregisterOfPeer' regular structure
 */
public data class UnregisterOfPeer(
    public val `object`: PeerId,
) {
    public companion object : ScaleReader<UnregisterOfPeer>, ScaleWriter<UnregisterOfPeer> {
        override fun read(reader: ScaleCodecReader): UnregisterOfPeer = try {
            UnregisterOfPeer(
                PeerId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: UnregisterOfPeer): Unit = try {
            PeerId.write(writer, instance.`object`)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
