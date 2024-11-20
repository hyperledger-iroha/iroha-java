//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import java.math.BigInteger
import kotlin.Unit

/**
 * NonZeroOfu64
 *
 * Generated from 'NonZeroOfu64' regular structure
 */
public data class NonZeroOfu64(public val u64: BigInteger) {
    public companion object : ScaleReader<NonZeroOfu64>, ScaleWriter<NonZeroOfu64> {
        override fun read(reader: ScaleCodecReader): NonZeroOfu64 = try {
            NonZeroOfu64(
                reader.readUint64(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: NonZeroOfu64): Unit = try {
            writer.writeUint64(instance.u64)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
