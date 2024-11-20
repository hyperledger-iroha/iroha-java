//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Long
import kotlin.Unit

/**
 * NonZeroOfu32
 *
 * Generated from 'NonZeroOfu32' regular structure
 */
public data class NonZeroOfu32(public val u32: Long) {
    public companion object : ScaleReader<NonZeroOfu32>, ScaleWriter<NonZeroOfu32> {
        override fun read(reader: ScaleCodecReader): NonZeroOfu32 = try {
            NonZeroOfu32(
                reader.readUint32(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: NonZeroOfu32): Unit = try {
            writer.writeUint32(instance.u32)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
