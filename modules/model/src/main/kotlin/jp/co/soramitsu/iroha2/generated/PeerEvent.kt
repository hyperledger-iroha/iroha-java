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
 * PeerEvent
 *
 * Generated from 'PeerEvent' enum
 */
public sealed class PeerEvent : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Added' variant
     */
    public data class Added(public val peerId: PeerId) : PeerEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.PeerEvent.Added>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.PeerEvent.Added> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.PeerEvent.Added = try {
                Added(
                    PeerId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.PeerEvent.Added): Unit = try {
                PeerId.write(writer, instance.peerId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Removed' variant
     */
    public data class Removed(public val peerId: PeerId) : PeerEvent() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.PeerEvent.Removed>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.PeerEvent.Removed> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.PeerEvent.Removed = try {
                Removed(
                    PeerId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.PeerEvent.Removed): Unit = try {
                PeerId.write(writer, instance.peerId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<PeerEvent>, ScaleWriter<PeerEvent> {
        override fun read(reader: ScaleCodecReader): PeerEvent = when (val discriminant = reader.readUByte()) {
            0 -> Added.read(reader)
            1 -> Removed.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: PeerEvent) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Added.write(writer, instance as Added)
                1 -> Removed.write(writer, instance as Removed)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
