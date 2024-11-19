//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Int
import kotlin.Unit

/**
 * NonZeroOfu16
 *
 * Generated from 'NonZeroOfu16' regular structure
 */
public data class NonZeroOfu16(
    public val u16: Int,
) {
    public companion object : ScaleReader<NonZeroOfu16>, ScaleWriter<NonZeroOfu16> {
        override fun read(reader: ScaleCodecReader): NonZeroOfu16 = try {
            NonZeroOfu16(
                reader.readUint16(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: NonZeroOfu16): Unit = try {
            writer.writeUint16(instance.u16)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
