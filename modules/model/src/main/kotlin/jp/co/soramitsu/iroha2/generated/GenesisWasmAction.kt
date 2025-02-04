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
 * GenesisWasmAction
 *
 * Generated from 'GenesisWasmAction' regular structure
 */
public data class GenesisWasmAction(
    public val executable: String,
    public val repeats: Repeats,
    public val authority: AccountId,
    public val filter: EventFilterBox,
) {
    public companion object : ScaleReader<GenesisWasmAction>, ScaleWriter<GenesisWasmAction> {
        override fun read(reader: ScaleCodecReader): GenesisWasmAction =
            try {
                GenesisWasmAction(
                    reader.readString(),
                    Repeats.read(reader),
                    AccountId.read(reader),
                    EventFilterBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: GenesisWasmAction,
        ): Unit =
            try {
                writer.writeAsList(instance.executable.toByteArray(Charsets.UTF_8))
                Repeats.write(writer, instance.repeats)
                AccountId.write(writer, instance.authority)
                EventFilterBox.write(writer, instance.filter)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
