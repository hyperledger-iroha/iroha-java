//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.ModelEnum
import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Int
import kotlin.Unit

/**
 * ExecutorEvent
 *
 * Generated from 'ExecutorEvent' enum
 */
public sealed class ExecutorEvent : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Upgraded' variant
     */
    public data class Upgraded(
        public val executorUpgrade: ExecutorUpgrade,
    ) : ExecutorEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.ExecutorEvent.Upgraded>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.ExecutorEvent.Upgraded> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.ExecutorEvent.Upgraded = try {
                Upgraded(
                    ExecutorUpgrade.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.ExecutorEvent.Upgraded,
            ): Unit = try {
                ExecutorUpgrade.write(writer, instance.executorUpgrade)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<ExecutorEvent>, ScaleWriter<ExecutorEvent> {
        override fun read(reader: ScaleCodecReader): ExecutorEvent = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Upgraded.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: ExecutorEvent) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Upgraded.write(writer, instance as Upgraded)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
