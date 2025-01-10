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
 * Ipv4Addr
 *
 * Generated from 'Ipv4Addr' regular structure
 */
public data class Ipv4Addr(
    public val arrayOfU8: ByteArray,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Ipv4Addr) return false
        if (!arrayOfU8.contentEquals(other.arrayOfU8)) return false
        return true
    }

    override fun hashCode(): Int = arrayOfU8.contentHashCode()

    public companion object : ScaleReader<Ipv4Addr>, ScaleWriter<Ipv4Addr> {
        override fun read(reader: ScaleCodecReader): Ipv4Addr = try {
            Ipv4Addr(
                reader.readByteArray(4),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: Ipv4Addr): Unit = try {
            writer.writeByteArray(instance.arrayOfU8)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
