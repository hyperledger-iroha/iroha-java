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
 * WasmExecutionFail
 *
 * Generated from 'WasmExecutionFail' regular structure
 */
public data class WasmExecutionFail(
    public val reason: String,
) {
    public companion object : ScaleReader<WasmExecutionFail>, ScaleWriter<WasmExecutionFail> {
        override fun read(reader: ScaleCodecReader): WasmExecutionFail =
            try {
                WasmExecutionFail(
                    reader.readString(),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: WasmExecutionFail,
        ): Unit =
            try {
                writer.writeAsList(instance.reason.toByteArray(Charsets.UTF_8))
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
