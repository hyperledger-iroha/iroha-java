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
import kotlin.Int
import kotlin.Unit

/**
 * GenericPredicateBox
 *
 * Generated from 'GenericPredicateBox<QueryOutputPredicate>' enum
 */
public sealed class GenericPredicateBox<T0> : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'And' variant
     */
    public data class And(
        public val nonTrivial: NonTrivial<GenericPredicateBox<QueryOutputPredicate>>,
    ) : GenericPredicateBox<QueryOutputPredicate>() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.GenericPredicateBox.And>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.GenericPredicateBox.And> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.GenericPredicateBox.And = try {
                And(
                    NonTrivial.read(reader) as NonTrivial<GenericPredicateBox<QueryOutputPredicate>>,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.GenericPredicateBox.And,
            ): Unit = try {
                NonTrivial.write(writer, instance.nonTrivial)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Or' variant
     */
    public data class Or(
        public val nonTrivial: NonTrivial<GenericPredicateBox<QueryOutputPredicate>>,
    ) : GenericPredicateBox<QueryOutputPredicate>() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.GenericPredicateBox.Or>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.GenericPredicateBox.Or> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.GenericPredicateBox.Or = try {
                Or(
                    NonTrivial.read(reader) as NonTrivial<GenericPredicateBox<QueryOutputPredicate>>,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.GenericPredicateBox.Or,
            ): Unit = try {
                NonTrivial.write(writer, instance.nonTrivial)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Not' variant
     */
    public data class Not(
        public val genericPredicateBox: GenericPredicateBox<QueryOutputPredicate>,
    ) : GenericPredicateBox<QueryOutputPredicate>() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.GenericPredicateBox.Not>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.GenericPredicateBox.Not> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.GenericPredicateBox.Not = try {
                Not(
                    GenericPredicateBox.read(reader) as GenericPredicateBox<QueryOutputPredicate>,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.GenericPredicateBox.Not,
            ): Unit = try {
                GenericPredicateBox.write(writer, instance.genericPredicateBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Raw' variant
     */
    public data class Raw(
        public val queryOutputPredicate: QueryOutputPredicate,
    ) : GenericPredicateBox<QueryOutputPredicate>() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.GenericPredicateBox.Raw>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.GenericPredicateBox.Raw> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.GenericPredicateBox.Raw = try {
                Raw(
                    QueryOutputPredicate.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.GenericPredicateBox.Raw,
            ): Unit = try {
                QueryOutputPredicate.write(writer, instance.queryOutputPredicate)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<GenericPredicateBox<out Any>>,
        ScaleWriter<GenericPredicateBox<out Any>> {
        override fun read(reader: ScaleCodecReader): GenericPredicateBox<out Any> = when (
            val
            discriminant = reader.readUByte()
        ) {
            0 -> And.read(reader)
            1 -> Or.read(reader)
            2 -> Not.read(reader)
            3 -> Raw.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: GenericPredicateBox<out Any>) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> And.write(writer, instance as And)
                1 -> Or.write(writer, instance as Or)
                2 -> Not.write(writer, instance as Not)
                3 -> Raw.write(writer, instance as Raw)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
