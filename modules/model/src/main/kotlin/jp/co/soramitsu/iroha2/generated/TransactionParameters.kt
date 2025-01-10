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
 * TransactionParameters
 *
 * Generated from 'TransactionParameters' regular structure
 */
public data class TransactionParameters(
    public val maxInstructions: NonZeroOfu64,
    public val smartContractSize: NonZeroOfu64,
) {
    public companion object : ScaleReader<TransactionParameters>, ScaleWriter<TransactionParameters> {
        override fun read(reader: ScaleCodecReader): TransactionParameters = try {
            TransactionParameters(
                NonZeroOfu64.read(reader),
                NonZeroOfu64.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: TransactionParameters): Unit = try {
            NonZeroOfu64.write(writer, instance.maxInstructions)
            NonZeroOfu64.write(writer, instance.smartContractSize)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
