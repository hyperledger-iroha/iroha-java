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
 * Action
 *
 * Generated from 'Action' regular structure
 */
public data class Action(
    public val executable: Executable,
    public val repeats: Repeats,
    public val authority: AccountId,
    public val filter: EventFilterBox,
    public val metadata: Metadata,
) {
    public companion object : ScaleReader<Action>, ScaleWriter<Action> {
        override fun read(reader: ScaleCodecReader): Action = try {
            Action(
                Executable.read(reader),
                Repeats.read(reader),
                AccountId.read(reader),
                EventFilterBox.read(reader),
                Metadata.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: Action): Unit = try {
            Executable.write(writer, instance.executable)
            Repeats.write(writer, instance.repeats)
            AccountId.write(writer, instance.authority)
            EventFilterBox.write(writer, instance.filter)
            Metadata.write(writer, instance.metadata)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
