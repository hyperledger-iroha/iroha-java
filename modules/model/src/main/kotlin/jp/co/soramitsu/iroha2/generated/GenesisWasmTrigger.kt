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
 * GenesisWasmTrigger
 *
 * Generated from 'GenesisWasmTrigger' regular structure
 */
public data class GenesisWasmTrigger(
    public val id: TriggerId,
    public val action: GenesisWasmAction,
) {
    public companion object : ScaleReader<GenesisWasmTrigger>, ScaleWriter<GenesisWasmTrigger> {
        override fun read(reader: ScaleCodecReader): GenesisWasmTrigger =
            try {
                GenesisWasmTrigger(
                    TriggerId.read(reader),
                    GenesisWasmAction.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: GenesisWasmTrigger,
        ): Unit =
            try {
                TriggerId.write(writer, instance.id)
                GenesisWasmAction.write(writer, instance.action)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
