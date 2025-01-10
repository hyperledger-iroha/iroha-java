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
 * RepetitionError
 *
 * Generated from 'RepetitionError' regular structure
 */
public data class RepetitionError(
    public val instruction: InstructionType,
    public val id: IdBox,
) {
    public companion object : ScaleReader<RepetitionError>, ScaleWriter<RepetitionError> {
        override fun read(reader: ScaleCodecReader): RepetitionError = try {
            RepetitionError(
                InstructionType.read(reader),
                IdBox.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: RepetitionError): Unit = try {
            InstructionType.write(writer, instance.instruction)
            IdBox.write(writer, instance.id)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
