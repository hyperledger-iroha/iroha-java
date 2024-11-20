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
 * BlockSubscriptionRequest
 *
 * Generated from 'BlockSubscriptionRequest' regular structure
 */
public data class BlockSubscriptionRequest(public val nonZeroOfu64: NonZeroOfu64) {
    public companion object :
        ScaleReader<BlockSubscriptionRequest>,
        ScaleWriter<BlockSubscriptionRequest> {
        override fun read(reader: ScaleCodecReader): BlockSubscriptionRequest = try {
            BlockSubscriptionRequest(
                NonZeroOfu64.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: BlockSubscriptionRequest): Unit = try {
            NonZeroOfu64.write(writer, instance.nonZeroOfu64)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
