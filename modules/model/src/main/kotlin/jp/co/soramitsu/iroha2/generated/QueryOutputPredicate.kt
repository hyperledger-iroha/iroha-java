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
 * QueryOutputPredicate
 *
 * Generated from 'QueryOutputPredicate' enum
 */
public sealed class QueryOutputPredicate : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    override fun equals(other: Any?): Boolean = when (this) {
        is Pass -> Pass.equals(this, other)
        else -> super.equals(other) }

    override fun hashCode(): Int = when (this) {
        is Pass -> Pass.hashCode()
        else -> super.hashCode() }

    /**
     * 'Identifiable' variant
     */
    public data class Identifiable(
        public val stringPredicate: StringPredicate,
    ) : QueryOutputPredicate() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.Identifiable>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.Identifiable> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.Identifiable = try {
                Identifiable(
                    StringPredicate.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.Identifiable,
            ): Unit = try {
                StringPredicate.write(writer, instance.stringPredicate)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Container' variant
     */
    public data class Container(
        public val container: jp.co.soramitsu.iroha2.generated.Container,
    ) : QueryOutputPredicate() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.Container>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.Container> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.Container = try {
                Container(
                    jp.co.soramitsu.iroha2.generated.Container.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.Container,
            ): Unit = try {
                jp.co.soramitsu.iroha2.generated.Container.write(writer, instance.container)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Display' variant
     */
    public data class Display(
        public val stringPredicate: StringPredicate,
    ) : QueryOutputPredicate() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.Display>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.Display> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.Display = try {
                Display(
                    StringPredicate.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.Display,
            ): Unit = try {
                StringPredicate.write(writer, instance.stringPredicate)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Numerical' variant
     */
    public data class Numerical(
        public val semiRange: SemiRange,
    ) : QueryOutputPredicate() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.Numerical>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.Numerical> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.Numerical = try {
                Numerical(
                    SemiRange.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.Numerical,
            ): Unit = try {
                SemiRange.write(writer, instance.semiRange)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'TimeStamp' variant
     */
    public data class TimeStamp(
        public val semiIntervalOfu128: SemiIntervalOfu128,
    ) : QueryOutputPredicate() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.TimeStamp>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.TimeStamp> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.TimeStamp = try {
                TimeStamp(
                    SemiIntervalOfu128.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.TimeStamp,
            ): Unit = try {
                SemiIntervalOfu128.write(writer, instance.semiIntervalOfu128)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Pass' variant
     */
    public class Pass : QueryOutputPredicate() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.Pass>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.Pass> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.Pass = try {
                Pass()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.Pass,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.QueryOutputPredicate.Pass, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".QueryOutputPredicate.Pass".hashCode()
        }
    }

    public companion object : ScaleReader<QueryOutputPredicate>, ScaleWriter<QueryOutputPredicate> {
        override fun read(reader: ScaleCodecReader): QueryOutputPredicate = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Identifiable.read(reader)
            1 -> Container.read(reader)
            2 -> Display.read(reader)
            3 -> Numerical.read(reader)
            4 -> TimeStamp.read(reader)
            5 -> Pass.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: QueryOutputPredicate) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Identifiable.write(writer, instance as Identifiable)
                1 -> Container.write(writer, instance as Container)
                2 -> Display.write(writer, instance as Display)
                3 -> Numerical.write(writer, instance as Numerical)
                4 -> TimeStamp.write(writer, instance as TimeStamp)
                5 -> Pass.write(writer, instance as Pass)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
