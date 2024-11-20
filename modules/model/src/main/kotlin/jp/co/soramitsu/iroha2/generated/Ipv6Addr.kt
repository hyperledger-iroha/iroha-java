//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Array
import kotlin.Int
import kotlin.Unit

/**
 * Ipv6Addr
 *
 * Generated from 'Ipv6Addr' regular structure
 */
public data class Ipv6Addr(public val arrayOfU16: Array<Int>) {
    public companion object : ScaleReader<Ipv6Addr>, ScaleWriter<Ipv6Addr> {
        override fun read(reader: ScaleCodecReader): Ipv6Addr = try {
            Ipv6Addr(
                reader.readArray(8) { reader.readUint16() },
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: Ipv6Addr): Unit = try {
            instance.arrayOfU16.forEach { value ->
                writer.writeUint16(value)
            }
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
