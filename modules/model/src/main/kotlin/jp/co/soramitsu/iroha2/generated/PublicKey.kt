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
 * PublicKey
 *
 * Generated from 'PublicKey' regular structure
 */
public data class PublicKey(
    public val algorithm: Algorithm,
    public val payload: ByteArray,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PublicKey) return false
        if (algorithm != other.algorithm) return false
        if (!payload.contentEquals(other.payload)) return false
        return true
    }

    override fun hashCode(): Int = algorithm.hashCode() * 31 + payload.contentHashCode()

    public companion object : ScaleReader<PublicKey>, ScaleWriter<PublicKey> {
        override fun read(reader: ScaleCodecReader): PublicKey = try {
            PublicKey(
                Algorithm.read(reader),
                reader.readByteArray(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: PublicKey): Unit = try {
            Algorithm.write(writer, instance.algorithm)
            writer.writeAsList(instance.payload)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
