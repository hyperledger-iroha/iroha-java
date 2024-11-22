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
 * Level
 *
 * Generated from 'Level' enum
 */
public sealed class Level : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    override fun equals(other: Any?): Boolean = when (this) {
        is TRACE -> TRACE.equals(this, other)
        is DEBUG -> DEBUG.equals(this, other)
        is INFO -> INFO.equals(this, other)
        is WARN -> WARN.equals(this, other)
        is ERROR -> ERROR.equals(this, other)
        else -> super.equals(other)
    }

    override fun hashCode(): Int = when (this) {
        is TRACE -> TRACE.hashCode()
        is DEBUG -> DEBUG.hashCode()
        is INFO -> INFO.hashCode()
        is WARN -> WARN.hashCode()
        is ERROR -> ERROR.hashCode()
        else -> super.hashCode()
    }

    /**
     * 'TRACE' variant
     */
    public class TRACE : Level() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.Level.TRACE>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.Level.TRACE> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.Level.TRACE = try {
                TRACE()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.Level.TRACE): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.Level.TRACE, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".Level.TRACE".hashCode()
        }
    }

    /**
     * 'DEBUG' variant
     */
    public class DEBUG : Level() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.Level.DEBUG>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.Level.DEBUG> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.Level.DEBUG = try {
                DEBUG()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.Level.DEBUG): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.Level.DEBUG, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".Level.DEBUG".hashCode()
        }
    }

    /**
     * 'INFO' variant
     */
    public class INFO : Level() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.Level.INFO>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.Level.INFO> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.Level.INFO = try {
                INFO()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.Level.INFO): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.Level.INFO, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".Level.INFO".hashCode()
        }
    }

    /**
     * 'WARN' variant
     */
    public class WARN : Level() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.Level.WARN>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.Level.WARN> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.Level.WARN = try {
                WARN()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.Level.WARN): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.Level.WARN, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".Level.WARN".hashCode()
        }
    }

    /**
     * 'ERROR' variant
     */
    public class ERROR : Level() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.Level.ERROR>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.Level.ERROR> {
            public const val DISCRIMINANT: Int = 4

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.Level.ERROR = try {
                ERROR()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.Level.ERROR): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.Level.ERROR, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".Level.ERROR".hashCode()
        }
    }

    public companion object : ScaleReader<Level>, ScaleWriter<Level> {
        override fun read(reader: ScaleCodecReader): Level = when (val discriminant = reader.readUByte()) {
            0 -> TRACE.read(reader)
            1 -> DEBUG.read(reader)
            2 -> INFO.read(reader)
            3 -> WARN.read(reader)
            4 -> ERROR.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: Level) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> TRACE.write(writer, instance as TRACE)
                1 -> DEBUG.write(writer, instance as DEBUG)
                2 -> INFO.write(writer, instance as INFO)
                3 -> WARN.write(writer, instance as WARN)
                4 -> ERROR.write(writer, instance as ERROR)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
