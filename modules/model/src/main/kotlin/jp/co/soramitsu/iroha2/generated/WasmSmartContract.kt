//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Any
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit

/**
 * WasmSmartContract
 *
 * Generated from 'WasmSmartContract' regular structure
 */
public data class WasmSmartContract(
    public val vecOfU8: ByteArray,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is WasmSmartContract) return false
        if (!vecOfU8.contentEquals(other.vecOfU8)) return false
        return true
    }

    override fun hashCode(): Int = vecOfU8.contentHashCode()

    public companion object : ScaleReader<WasmSmartContract>, ScaleWriter<WasmSmartContract> {
        override fun read(reader: ScaleCodecReader): WasmSmartContract = try {
            WasmSmartContract(
                reader.readByteArray(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: WasmSmartContract): Unit = try {
            writer.writeAsList(instance.vecOfU8)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
