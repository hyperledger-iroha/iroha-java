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
 * BlockMessage
 *
 * Generated from 'BlockMessage' regular structure
 */
public data class BlockMessage(
    public val signedBlock: SignedBlock,
) {
    public companion object : ScaleReader<BlockMessage>, ScaleWriter<BlockMessage> {
        override fun read(reader: ScaleCodecReader): BlockMessage =
            try {
                BlockMessage(
                    SignedBlock.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: BlockMessage,
        ): Unit =
            try {
                SignedBlock.write(writer, instance.signedBlock)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
