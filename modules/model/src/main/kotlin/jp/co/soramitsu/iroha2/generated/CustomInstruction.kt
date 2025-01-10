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
 * CustomInstruction
 *
 * Generated from 'CustomInstruction' regular structure
 */
public data class CustomInstruction(
    public val payload: String,
) {
    public companion object : ScaleReader<CustomInstruction>, ScaleWriter<CustomInstruction> {
        override fun read(reader: ScaleCodecReader): CustomInstruction = try {
            CustomInstruction(
                reader.readString(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CustomInstruction): Unit = try {
            writer.writeAsList(instance.payload.toByteArray(Charsets.UTF_8))
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
