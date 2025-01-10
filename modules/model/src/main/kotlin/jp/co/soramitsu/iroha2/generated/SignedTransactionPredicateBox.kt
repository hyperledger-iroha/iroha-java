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
 * SignedTransactionPredicateBox
 *
 * Generated from 'SignedTransactionPredicateBox' enum
 */
public sealed class SignedTransactionPredicateBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Hash' variant
     */
    public data class Hash(
        public val transactionHashPredicateBox: TransactionHashPredicateBox,
    ) : SignedTransactionPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SignedTransactionPredicateBox.Hash>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SignedTransactionPredicateBox.Hash> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SignedTransactionPredicateBox.Hash = try {
                Hash(
                    TransactionHashPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SignedTransactionPredicateBox.Hash,
            ): Unit = try {
                TransactionHashPredicateBox.write(writer, instance.transactionHashPredicateBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Authority' variant
     */
    public data class Authority(
        public val accountIdPredicateBox: AccountIdPredicateBox,
    ) : SignedTransactionPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SignedTransactionPredicateBox.Authority>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SignedTransactionPredicateBox.Authority> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SignedTransactionPredicateBox.Authority = try {
                Authority(
                    AccountIdPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SignedTransactionPredicateBox.Authority,
            ): Unit = try {
                AccountIdPredicateBox.write(writer, instance.accountIdPredicateBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<SignedTransactionPredicateBox>,
        ScaleWriter<SignedTransactionPredicateBox> {
        override fun read(reader: ScaleCodecReader): SignedTransactionPredicateBox = when (
            val
            discriminant = reader.readUByte()
        ) {
            0 -> Hash.read(reader)
            1 -> Authority.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: SignedTransactionPredicateBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Hash.write(writer, instance as Hash)
                1 -> Authority.write(writer, instance as Authority)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
