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
 * Executor
 *
 * Generated from 'Executor' regular structure
 */
public data class Executor(
    public val wasm: WasmSmartContract,
) {
    public companion object : ScaleReader<Executor>, ScaleWriter<Executor> {
        override fun read(reader: ScaleCodecReader): Executor =
            try {
                Executor(
                    WasmSmartContract.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: Executor,
        ): Unit =
            try {
                WasmSmartContract.write(writer, instance.wasm)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
