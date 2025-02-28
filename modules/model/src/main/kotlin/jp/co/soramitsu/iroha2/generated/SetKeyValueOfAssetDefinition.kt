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
 * SetKeyValueOfAssetDefinition
 *
 * Generated from 'SetKeyValueOfAssetDefinition' regular structure
 */
public data class SetKeyValueOfAssetDefinition(
    public val `object`: AssetDefinitionId,
    public val key: Name,
    public val `value`: Json,
) : Instruction {
    override fun asInstructionBox(): InstructionBox = asInstructionBoxExt()

    public companion object :
        ScaleReader<SetKeyValueOfAssetDefinition>,
        ScaleWriter<SetKeyValueOfAssetDefinition> {
        override fun read(reader: ScaleCodecReader): SetKeyValueOfAssetDefinition =
            try {
                SetKeyValueOfAssetDefinition(
                    AssetDefinitionId.read(reader),
                    Name.read(reader),
                    Json.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: SetKeyValueOfAssetDefinition,
        ): Unit =
            try {
                AssetDefinitionId.write(writer, instance.`object`)
                Name.write(writer, instance.key)
                Json.write(writer, instance.`value`)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
