//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.asInstructionBoxExt
import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.generated.InstructionBox
import jp.co.soramitsu.iroha2.transaction.Instruction
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Unit

/**
 * SetKeyValueOfDomain
 *
 * Generated from 'SetKeyValueOfDomain' regular structure
 */
public data class SetKeyValueOfDomain(
    public val `object`: DomainId,
    public val key: Name,
    public val `value`: Json,
) : Instruction {
    override fun asInstructionBox(): InstructionBox = asInstructionBoxExt()

    public companion object : ScaleReader<SetKeyValueOfDomain>, ScaleWriter<SetKeyValueOfDomain> {
        override fun read(reader: ScaleCodecReader): SetKeyValueOfDomain = try {
            SetKeyValueOfDomain(
                DomainId.read(reader),
                Name.read(reader),
                Json.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: SetKeyValueOfDomain): Unit = try {
            DomainId.write(writer, instance.`object`)
            Name.write(writer, instance.key)
            Json.write(writer, instance.`value`)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
