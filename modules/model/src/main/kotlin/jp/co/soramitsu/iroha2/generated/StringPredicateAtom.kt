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
import kotlin.String
import kotlin.Unit

/**
 * StringPredicateAtom
 *
 * Generated from 'StringPredicateAtom' enum
 */
public sealed class StringPredicateAtom : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Equals' variant
     */
    public data class Equals(
        public val string: String,
    ) : StringPredicateAtom() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.StringPredicateAtom.Equals>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.StringPredicateAtom.Equals> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.StringPredicateAtom.Equals =
                try {
                    Equals(
                        reader.readString(),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.StringPredicateAtom.Equals,
            ): Unit =
                try {
                    writer.writeAsList(instance.string.toByteArray(Charsets.UTF_8))
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Contains' variant
     */
    public data class Contains(
        public val string: String,
    ) : StringPredicateAtom() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.StringPredicateAtom.Contains>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.StringPredicateAtom.Contains> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.StringPredicateAtom.Contains =
                try {
                    Contains(
                        reader.readString(),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.StringPredicateAtom.Contains,
            ): Unit =
                try {
                    writer.writeAsList(instance.string.toByteArray(Charsets.UTF_8))
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'StartsWith' variant
     */
    public data class StartsWith(
        public val string: String,
    ) : StringPredicateAtom() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.StringPredicateAtom.StartsWith>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.StringPredicateAtom.StartsWith> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.StringPredicateAtom.StartsWith =
                try {
                    StartsWith(
                        reader.readString(),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.StringPredicateAtom.StartsWith,
            ): Unit =
                try {
                    writer.writeAsList(instance.string.toByteArray(Charsets.UTF_8))
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'EndsWith' variant
     */
    public data class EndsWith(
        public val string: String,
    ) : StringPredicateAtom() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.StringPredicateAtom.EndsWith>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.StringPredicateAtom.EndsWith> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.StringPredicateAtom.EndsWith =
                try {
                    EndsWith(
                        reader.readString(),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.StringPredicateAtom.EndsWith,
            ): Unit =
                try {
                    writer.writeAsList(instance.string.toByteArray(Charsets.UTF_8))
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object : ScaleReader<StringPredicateAtom>, ScaleWriter<StringPredicateAtom> {
        override fun read(reader: ScaleCodecReader): StringPredicateAtom =
            when (val discriminant = reader.readUByte()) {
                0 -> Equals.read(reader)
                1 -> Contains.read(reader)
                2 -> StartsWith.read(reader)
                3 -> EndsWith.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: StringPredicateAtom,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Equals.write(writer, instance as Equals)
                1 -> Contains.write(writer, instance as Contains)
                2 -> StartsWith.write(writer, instance as StartsWith)
                3 -> EndsWith.write(writer, instance as EndsWith)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
