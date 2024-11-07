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
 * CustomInstruction
 *
 * Generated from 'CustomInstruction' regular structure
 */
public data class CustomInstruction(
    public val payload: Json,
) {
    public companion object : ScaleReader<CustomInstruction>, ScaleWriter<CustomInstruction> {
        override fun read(reader: ScaleCodecReader): CustomInstruction = try {
            CustomInstruction(
                Json.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CustomInstruction): Unit = try {
            Json.write(writer, instance.payload)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
