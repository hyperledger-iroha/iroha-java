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
 * TransactionErrorPredicateBox
 *
 * Generated from 'TransactionErrorPredicateBox' enum
 */
public sealed class TransactionErrorPredicateBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    override fun equals(other: Any?): Boolean = when (this) {
        is IsSome -> IsSome.equals(this, other)
        else -> super.equals(other) }

    override fun hashCode(): Int = when (this) {
        is IsSome -> IsSome.hashCode()
        else -> super.hashCode() }

    /**
     * 'IsSome' variant
     */
    public class IsSome : TransactionErrorPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TransactionErrorPredicateBox.IsSome>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TransactionErrorPredicateBox.IsSome> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TransactionErrorPredicateBox.IsSome = try {
                IsSome()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TransactionErrorPredicateBox.IsSome,
            ): Unit =
                try {
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            public fun equals(
                o1: jp.co.soramitsu.iroha2.generated.TransactionErrorPredicateBox.IsSome,
                o2: Any?,
            ): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".TransactionErrorPredicateBox.IsSome".hashCode()
        }
    }

    public companion object :
        ScaleReader<TransactionErrorPredicateBox>,
        ScaleWriter<TransactionErrorPredicateBox> {
        override fun read(reader: ScaleCodecReader): TransactionErrorPredicateBox = when (
            val
            discriminant = reader.readUByte()
        ) {
            0 -> IsSome.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: TransactionErrorPredicateBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> IsSome.write(writer, instance as IsSome)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
