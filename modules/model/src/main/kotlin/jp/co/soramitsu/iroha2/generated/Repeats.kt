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
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Unit

/**
 * Repeats
 *
 * Generated from 'Repeats' enum
 */
public sealed class Repeats : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    override fun equals(other: Any?): Boolean =
        when (this) {
            is Indefinitely -> Indefinitely.equals(this, other)
            else -> super.equals(other)
        }

    override fun hashCode(): Int =
        when (this) {
            is Indefinitely -> Indefinitely.hashCode()
            else -> super.hashCode()
        }

    /**
     * 'Indefinitely' variant
     */
    public class Indefinitely : Repeats() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.Repeats.Indefinitely>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.Repeats.Indefinitely> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.Repeats.Indefinitely =
                try {
                    Indefinitely()
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.Repeats.Indefinitely,
            ): Unit =
                try {
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            public fun equals(
                o1: jp.co.soramitsu.iroha2.generated.Repeats.Indefinitely,
                o2: Any?,
            ): Boolean =
                when (o2) {
                    null -> false
                    else -> o2::class == o1::class
                }

            override fun hashCode(): Int = ".Repeats.Indefinitely".hashCode()
        }
    }

    /**
     * 'Exactly' variant
     */
    public data class Exactly(
        public val u32: Long,
    ) : Repeats() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.Repeats.Exactly>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.Repeats.Exactly> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.Repeats.Exactly =
                try {
                    Exactly(
                        reader.readUint32(),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.Repeats.Exactly,
            ): Unit =
                try {
                    writer.writeUint32(instance.u32)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object : ScaleReader<Repeats>, ScaleWriter<Repeats> {
        override fun read(reader: ScaleCodecReader): Repeats =
            when (val discriminant = reader.readUByte()) {
                0 -> Indefinitely.read(reader)
                1 -> Exactly.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: Repeats,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Indefinitely.write(writer, instance as Indefinitely)
                1 -> Exactly.write(writer, instance as Exactly)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
