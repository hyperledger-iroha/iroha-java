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
 * QueryExecutionFail
 *
 * Generated from 'QueryExecutionFail' enum
 */
public sealed class QueryExecutionFail : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    override fun equals(other: Any?): Boolean = when (this) {
        is NotFound -> NotFound.equals(this, other)
        is CursorMismatch -> CursorMismatch.equals(this, other)
        is CursorDone -> CursorDone.equals(this, other)
        is FetchSizeTooBig -> FetchSizeTooBig.equals(this, other)
        is InvalidSingularParameters -> InvalidSingularParameters.equals(this, other)
        is CapacityLimit -> CapacityLimit.equals(this, other)
        else -> super.equals(other)
    }

    override fun hashCode(): Int = when (this) {
        is NotFound -> NotFound.hashCode()
        is CursorMismatch -> CursorMismatch.hashCode()
        is CursorDone -> CursorDone.hashCode()
        is FetchSizeTooBig -> FetchSizeTooBig.hashCode()
        is InvalidSingularParameters -> InvalidSingularParameters.hashCode()
        is CapacityLimit -> CapacityLimit.hashCode()
        else -> super.hashCode()
    }

    /**
     * 'Find' variant
     */
    public data class Find(public val findError: FindError) : QueryExecutionFail() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryExecutionFail.Find>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryExecutionFail.Find> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryExecutionFail.Find = try {
                Find(
                    FindError.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryExecutionFail.Find): Unit = try {
                FindError.write(writer, instance.findError)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Conversion' variant
     */
    public data class Conversion(public val string: String) : QueryExecutionFail() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryExecutionFail.Conversion>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryExecutionFail.Conversion> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryExecutionFail.Conversion = try {
                Conversion(
                    reader.readString(),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryExecutionFail.Conversion): Unit =
                try {
                    writer.writeAsList(instance.string.toByteArray(Charsets.UTF_8))
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'NotFound' variant
     */
    public class NotFound : QueryExecutionFail() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryExecutionFail.NotFound>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryExecutionFail.NotFound> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryExecutionFail.NotFound = try {
                NotFound()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryExecutionFail.NotFound): Unit =
                try {
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.QueryExecutionFail.NotFound, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".QueryExecutionFail.NotFound".hashCode()
        }
    }

    /**
     * 'CursorMismatch' variant
     */
    public class CursorMismatch : QueryExecutionFail() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryExecutionFail.CursorMismatch>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryExecutionFail.CursorMismatch> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryExecutionFail.CursorMismatch = try {
                CursorMismatch()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryExecutionFail.CursorMismatch,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.QueryExecutionFail.CursorMismatch, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".QueryExecutionFail.CursorMismatch".hashCode()
        }
    }

    /**
     * 'CursorDone' variant
     */
    public class CursorDone : QueryExecutionFail() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryExecutionFail.CursorDone>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryExecutionFail.CursorDone> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryExecutionFail.CursorDone = try {
                CursorDone()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.QueryExecutionFail.CursorDone): Unit =
                try {
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.QueryExecutionFail.CursorDone, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".QueryExecutionFail.CursorDone".hashCode()
        }
    }

    /**
     * 'FetchSizeTooBig' variant
     */
    public class FetchSizeTooBig : QueryExecutionFail() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryExecutionFail.FetchSizeTooBig>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryExecutionFail.FetchSizeTooBig> {
            public const val DISCRIMINANT: Int = 5

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryExecutionFail.FetchSizeTooBig = try {
                FetchSizeTooBig()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryExecutionFail.FetchSizeTooBig,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.QueryExecutionFail.FetchSizeTooBig, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".QueryExecutionFail.FetchSizeTooBig".hashCode()
        }
    }

    /**
     * 'InvalidSingularParameters' variant
     */
    public class InvalidSingularParameters : QueryExecutionFail() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryExecutionFail.InvalidSingularParameters>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryExecutionFail.InvalidSingularParameters> {
            public const val DISCRIMINANT: Int = 6

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryExecutionFail.InvalidSingularParameters =
                try {
                    InvalidSingularParameters()
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryExecutionFail.InvalidSingularParameters,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.QueryExecutionFail.InvalidSingularParameters, o2: Any?): Boolean =
                when (o2) {
                    null -> false
                    else -> o2::class == o1::class
                }

            override fun hashCode(): Int = ".QueryExecutionFail.InvalidSingularParameters".hashCode()
        }
    }

    /**
     * 'CapacityLimit' variant
     */
    public class CapacityLimit : QueryExecutionFail() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryExecutionFail.CapacityLimit>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryExecutionFail.CapacityLimit> {
            public const val DISCRIMINANT: Int = 7

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryExecutionFail.CapacityLimit = try {
                CapacityLimit()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryExecutionFail.CapacityLimit,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.QueryExecutionFail.CapacityLimit, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".QueryExecutionFail.CapacityLimit".hashCode()
        }
    }

    public companion object : ScaleReader<QueryExecutionFail>, ScaleWriter<QueryExecutionFail> {
        override fun read(reader: ScaleCodecReader): QueryExecutionFail = when (val discriminant = reader.readUByte()) {
            0 -> Find.read(reader)
            1 -> Conversion.read(reader)
            2 -> NotFound.read(reader)
            3 -> CursorMismatch.read(reader)
            4 -> CursorDone.read(reader)
            5 -> FetchSizeTooBig.read(reader)
            6 -> InvalidSingularParameters.read(reader)
            7 -> CapacityLimit.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: QueryExecutionFail) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Find.write(writer, instance as Find)
                1 -> Conversion.write(writer, instance as Conversion)
                2 -> NotFound.write(writer, instance as NotFound)
                3 -> CursorMismatch.write(writer, instance as CursorMismatch)
                4 -> CursorDone.write(writer, instance as CursorDone)
                5 -> FetchSizeTooBig.write(writer, instance as FetchSizeTooBig)
                6 -> InvalidSingularParameters.write(writer, instance as InvalidSingularParameters)
                7 -> CapacityLimit.write(writer, instance as CapacityLimit)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
