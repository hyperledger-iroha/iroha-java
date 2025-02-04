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
import kotlin.Unit

/**
 * Mintable
 *
 * Generated from 'Mintable' enum
 */
public sealed class Mintable : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    override fun equals(other: Any?): Boolean =
        when (this) {
            is Infinitely -> Infinitely.equals(this, other)
            is Once -> Once.equals(this, other)
            is Not -> Not.equals(this, other)
            else -> super.equals(other)
        }

    override fun hashCode(): Int =
        when (this) {
            is Infinitely -> Infinitely.hashCode()
            is Once -> Once.hashCode()
            is Not -> Not.hashCode()
            else -> super.hashCode()
        }

    /**
     * 'Infinitely' variant
     */
    public class Infinitely : Mintable() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.Mintable.Infinitely>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.Mintable.Infinitely> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.Mintable.Infinitely =
                try {
                    Infinitely()
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.Mintable.Infinitely,
            ): Unit =
                try {
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            public fun equals(
                o1: jp.co.soramitsu.iroha2.generated.Mintable.Infinitely,
                o2: Any?,
            ): Boolean =
                when (o2) {
                    null -> false
                    else -> o2::class == o1::class
                }

            override fun hashCode(): Int = ".Mintable.Infinitely".hashCode()
        }
    }

    /**
     * 'Once' variant
     */
    public class Once : Mintable() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.Mintable.Once>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.Mintable.Once> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.Mintable.Once =
                try {
                    Once()
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.Mintable.Once,
            ): Unit =
                try {
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            public fun equals(
                o1: jp.co.soramitsu.iroha2.generated.Mintable.Once,
                o2: Any?,
            ): Boolean =
                when (o2) {
                    null -> false
                    else -> o2::class == o1::class
                }

            override fun hashCode(): Int = ".Mintable.Once".hashCode()
        }
    }

    /**
     * 'Not' variant
     */
    public class Not : Mintable() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.Mintable.Not>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.Mintable.Not> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.Mintable.Not =
                try {
                    Not()
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.Mintable.Not,
            ): Unit =
                try {
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            public fun equals(
                o1: jp.co.soramitsu.iroha2.generated.Mintable.Not,
                o2: Any?,
            ): Boolean =
                when (o2) {
                    null -> false
                    else -> o2::class == o1::class
                }

            override fun hashCode(): Int = ".Mintable.Not".hashCode()
        }
    }

    public companion object : ScaleReader<Mintable>, ScaleWriter<Mintable> {
        override fun read(reader: ScaleCodecReader): Mintable =
            when (val discriminant = reader.readUByte()) {
                0 -> Infinitely.read(reader)
                1 -> Once.read(reader)
                2 -> Not.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: Mintable,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Infinitely.write(writer, instance as Infinitely)
                1 -> Once.write(writer, instance as Once)
                2 -> Not.write(writer, instance as Not)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
