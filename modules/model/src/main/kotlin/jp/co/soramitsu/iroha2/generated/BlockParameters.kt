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
 * BlockParameters
 *
 * Generated from 'BlockParameters' regular structure
 */
public data class BlockParameters(
    public val maxTransactions: NonZeroOfu64,
) {
    public companion object : ScaleReader<BlockParameters>, ScaleWriter<BlockParameters> {
        override fun read(reader: ScaleCodecReader): BlockParameters = try {
            BlockParameters(
                NonZeroOfu64.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: BlockParameters): Unit = try {
            NonZeroOfu64.write(writer, instance.maxTransactions)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
