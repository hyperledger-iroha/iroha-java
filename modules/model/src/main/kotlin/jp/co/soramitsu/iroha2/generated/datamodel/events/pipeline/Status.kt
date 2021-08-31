//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated.datamodel.events.pipeline

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import kotlin.Int

/**
 * Status
 *
 * Generated from 'iroha_data_model::events::pipeline::Status' enum
 */
public sealed class Status {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Validating' variant
     */
    public class Validating : Status() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<Validating>, ScaleWriter<Validating> {
            public const val DISCRIMINANT: Int = 0

            public override fun read(reader: ScaleCodecReader): Validating = Validating()

            public override fun write(writer: ScaleCodecWriter, instance: Validating) {
            }
        }
    }

    /**
     * 'Rejected' variant
     */
    public data class Rejected(
        public val rejectionReason: RejectionReason
    ) : Status() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<Rejected>, ScaleWriter<Rejected> {
            public const val DISCRIMINANT: Int = 1

            public override fun read(reader: ScaleCodecReader): Rejected = Rejected(
                RejectionReason.read(reader),
            )

            public override fun write(writer: ScaleCodecWriter, instance: Rejected) {
                RejectionReason.write(writer, instance.rejectionReason)
            }
        }
    }

    /**
     * 'Committed' variant
     */
    public class Committed : Status() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<Committed>, ScaleWriter<Committed> {
            public const val DISCRIMINANT: Int = 2

            public override fun read(reader: ScaleCodecReader): Committed = Committed()

            public override fun write(writer: ScaleCodecWriter, instance: Committed) {
            }
        }
    }

    public companion object : ScaleReader<Status>, ScaleWriter<Status> {
        public override fun read(reader: ScaleCodecReader): Status = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Validating.read(reader)
            1 -> Rejected.read(reader)
            2 -> Committed.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        public override fun write(writer: ScaleCodecWriter, instance: Status) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Validating.write(writer, instance as Validating)
                1 -> Rejected.write(writer, instance as Rejected)
                2 -> Committed.write(writer, instance as Committed)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
