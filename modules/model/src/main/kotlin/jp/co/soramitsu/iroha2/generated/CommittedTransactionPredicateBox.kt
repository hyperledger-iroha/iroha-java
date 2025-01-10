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
import kotlin.Unit

/**
 * CommittedTransactionPredicateBox
 *
 * Generated from 'CommittedTransactionPredicateBox' enum
 */
public sealed class CommittedTransactionPredicateBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Value' variant
     */
    public data class Value(
        public val signedTransactionPredicateBox: SignedTransactionPredicateBox,
    ) : CommittedTransactionPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CommittedTransactionPredicateBox.Value>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CommittedTransactionPredicateBox.Value> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CommittedTransactionPredicateBox.Value = try {
                Value(
                    SignedTransactionPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CommittedTransactionPredicateBox.Value,
            ): Unit =
                try {
                    SignedTransactionPredicateBox.write(writer, instance.signedTransactionPredicateBox)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Error' variant
     */
    public data class Error(
        public val transactionErrorPredicateBox: TransactionErrorPredicateBox,
    ) : CommittedTransactionPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CommittedTransactionPredicateBox.Error>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CommittedTransactionPredicateBox.Error> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.CommittedTransactionPredicateBox.Error = try {
                Error(
                    TransactionErrorPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CommittedTransactionPredicateBox.Error,
            ): Unit =
                try {
                    TransactionErrorPredicateBox.write(writer, instance.transactionErrorPredicateBox)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<CommittedTransactionPredicateBox>,
        ScaleWriter<CommittedTransactionPredicateBox> {
        override fun read(reader: ScaleCodecReader): CommittedTransactionPredicateBox = when (
            val
            discriminant = reader.readUByte()
        ) {
            0 -> Value.read(reader)
            1 -> Error.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: CommittedTransactionPredicateBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Value.write(writer, instance as Value)
                1 -> Error.write(writer, instance as Error)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
