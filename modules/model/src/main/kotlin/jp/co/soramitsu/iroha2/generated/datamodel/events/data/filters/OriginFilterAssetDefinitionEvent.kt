//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated.datamodel.events.`data`.filters

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.generated.datamodel.asset.DefinitionId
import jp.co.soramitsu.iroha2.wrapException

/**
 * OriginFilterAssetDefinitionEvent
 *
 * Generated from 'iroha_data_model::events::data::filters::OriginFilterAssetDefinitionEvent' tuple
 * structure
 */
public data class OriginFilterAssetDefinitionEvent(
    public val definitionId: DefinitionId
) {
    public companion object :
        ScaleReader<OriginFilterAssetDefinitionEvent>,
        ScaleWriter<OriginFilterAssetDefinitionEvent> {
        public override fun read(reader: ScaleCodecReader): OriginFilterAssetDefinitionEvent = try {
            OriginFilterAssetDefinitionEvent(
                DefinitionId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        public override fun write(writer: ScaleCodecWriter, instance: OriginFilterAssetDefinitionEvent) =
            try {
                DefinitionId.write(writer, instance.definitionId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
