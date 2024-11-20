//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.String
import kotlin.Unit

/**
 * TransactionLimitError
 *
 * Generated from 'TransactionLimitError' regular structure
 */
public data class TransactionLimitError(public val reason: String) {
    public companion object : ScaleReader<TransactionLimitError>, ScaleWriter<TransactionLimitError> {
        override fun read(reader: ScaleCodecReader): TransactionLimitError = try {
            TransactionLimitError(
                reader.readString(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: TransactionLimitError): Unit = try {
            writer.writeAsList(instance.reason.toByteArray(Charsets.UTF_8))
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
