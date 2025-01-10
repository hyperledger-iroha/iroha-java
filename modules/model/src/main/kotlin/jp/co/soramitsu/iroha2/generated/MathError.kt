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
import kotlin.String
import kotlin.Unit

/**
 * MathError
 *
 * Generated from 'MathError' enum
 */
public sealed class MathError : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    override fun equals(other: Any?): Boolean = when (this) {
        is Overflow -> Overflow.equals(this, other)
        is NotEnoughQuantity -> NotEnoughQuantity.equals(this, other)
        is DivideByZero -> DivideByZero.equals(this, other)
        is NegativeValue -> NegativeValue.equals(this, other)
        is DomainViolation -> DomainViolation.equals(this, other)
        is Unknown -> Unknown.equals(this, other)
        else -> super.equals(other) }

    override fun hashCode(): Int = when (this) {
        is Overflow -> Overflow.hashCode()
        is NotEnoughQuantity -> NotEnoughQuantity.hashCode()
        is DivideByZero -> DivideByZero.hashCode()
        is NegativeValue -> NegativeValue.hashCode()
        is DomainViolation -> DomainViolation.hashCode()
        is Unknown -> Unknown.hashCode()
        else -> super.hashCode() }

    /**
     * 'Overflow' variant
     */
    public class Overflow : MathError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.MathError.Overflow>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.MathError.Overflow> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.MathError.Overflow = try {
                Overflow()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.MathError.Overflow,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.MathError.Overflow, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".MathError.Overflow".hashCode()
        }
    }

    /**
     * 'NotEnoughQuantity' variant
     */
    public class NotEnoughQuantity : MathError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.MathError.NotEnoughQuantity>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.MathError.NotEnoughQuantity> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.MathError.NotEnoughQuantity = try {
                NotEnoughQuantity()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.MathError.NotEnoughQuantity,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.MathError.NotEnoughQuantity, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".MathError.NotEnoughQuantity".hashCode()
        }
    }

    /**
     * 'DivideByZero' variant
     */
    public class DivideByZero : MathError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.MathError.DivideByZero>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.MathError.DivideByZero> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.MathError.DivideByZero = try {
                DivideByZero()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.MathError.DivideByZero,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.MathError.DivideByZero, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".MathError.DivideByZero".hashCode()
        }
    }

    /**
     * 'NegativeValue' variant
     */
    public class NegativeValue : MathError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.MathError.NegativeValue>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.MathError.NegativeValue> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.MathError.NegativeValue = try {
                NegativeValue()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.MathError.NegativeValue,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.MathError.NegativeValue, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".MathError.NegativeValue".hashCode()
        }
    }

    /**
     * 'DomainViolation' variant
     */
    public class DomainViolation : MathError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.MathError.DomainViolation>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.MathError.DomainViolation> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.MathError.DomainViolation = try {
                DomainViolation()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.MathError.DomainViolation,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.MathError.DomainViolation, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".MathError.DomainViolation".hashCode()
        }
    }

    /**
     * 'Unknown' variant
     */
    public class Unknown : MathError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.MathError.Unknown>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.MathError.Unknown> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.MathError.Unknown = try {
                Unknown()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.MathError.Unknown,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.MathError.Unknown, o2: Any?): Boolean =
                when (o2) {
                    null -> false
                    else -> o2::class == o1::class
                }

            override fun hashCode(): Int = ".MathError.Unknown".hashCode()
        }
    }

    /**
     * 'FixedPointConversion' variant
     */
    public data class FixedPointConversion(
        public val string: String,
    ) : MathError() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.MathError.FixedPointConversion>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.MathError.FixedPointConversion> {
            public const val DISCRIMINANT: Int = 6

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.MathError.FixedPointConversion = try {
                FixedPointConversion(
                    reader.readString(),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.MathError.FixedPointConversion,
            ): Unit = try {
                writer.writeAsList(instance.string.toByteArray(Charsets.UTF_8))
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<MathError>, ScaleWriter<MathError> {
        override fun read(reader: ScaleCodecReader): MathError = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Overflow.read(reader)
            1 -> NotEnoughQuantity.read(reader)
            2 -> DivideByZero.read(reader)
            3 -> NegativeValue.read(reader)
            4 -> DomainViolation.read(reader)
            5 -> Unknown.read(reader)
            6 -> FixedPointConversion.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: MathError) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Overflow.write(writer, instance as Overflow)
                1 -> NotEnoughQuantity.write(writer, instance as NotEnoughQuantity)
                2 -> DivideByZero.write(writer, instance as DivideByZero)
                3 -> NegativeValue.write(writer, instance as NegativeValue)
                4 -> DomainViolation.write(writer, instance as DomainViolation)
                5 -> Unknown.write(writer, instance as Unknown)
                6 -> FixedPointConversion.write(writer, instance as FixedPointConversion)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
