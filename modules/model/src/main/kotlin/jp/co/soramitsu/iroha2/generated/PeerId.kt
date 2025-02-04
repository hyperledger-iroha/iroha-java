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
 * PeerId
 *
 * Generated from 'PeerId' regular structure
 */
public data class PeerId(
    public val publicKey: PublicKey,
) {
    public companion object : ScaleReader<PeerId>, ScaleWriter<PeerId> {
        override fun read(reader: ScaleCodecReader): PeerId =
            try {
                PeerId(
                    PublicKey.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: PeerId,
        ): Unit =
            try {
                PublicKey.write(writer, instance.publicKey)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
