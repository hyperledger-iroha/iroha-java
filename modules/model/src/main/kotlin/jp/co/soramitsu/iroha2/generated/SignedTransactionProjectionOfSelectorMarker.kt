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
 * SignedTransactionProjectionOfSelectorMarker
 *
 * Generated from 'SignedTransactionProjectionOfSelectorMarker' enum
 */
public sealed class SignedTransactionProjectionOfSelectorMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    override fun equals(other: Any?): Boolean = when (this) {
        is Atom -> Atom.equals(this, other)
        else -> super.equals(other)
    }

    override fun hashCode(): Int = when (this) {
        is Atom -> Atom.hashCode()
        else -> super.hashCode()
    }

    /**
     * 'Atom' variant
     */
    public class Atom : SignedTransactionProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfSelectorMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfSelectorMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfSelectorMarker.Atom =
                try {
                    Atom()
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfSelectorMarker.Atom,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfSelectorMarker.Atom, o2: Any?): Boolean =
                when (o2) {
                    null -> false
                    else -> o2::class == o1::class
                }

            override fun hashCode(): Int = ".SignedTransactionProjectionOfSelectorMarker.Atom".hashCode()
        }
    }

    /**
     * 'Hash' variant
     */
    public data class Hash(public val transactionHashProjectionOfSelectorMarker: TransactionHashProjectionOfSelectorMarker) :
        SignedTransactionProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfSelectorMarker.Hash>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfSelectorMarker.Hash> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfSelectorMarker.Hash =
                try {
                    Hash(
                        TransactionHashProjectionOfSelectorMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfSelectorMarker.Hash,
            ): Unit = try {
                TransactionHashProjectionOfSelectorMarker.write(writer, instance.transactionHashProjectionOfSelectorMarker)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Authority' variant
     */
    public data class Authority(public val accountIdProjectionOfSelectorMarker: AccountIdProjectionOfSelectorMarker) :
        SignedTransactionProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfSelectorMarker.Authority>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfSelectorMarker.Authority> {
            public const val DISCRIMINANT: Int = 2

            override fun read(
                reader: ScaleCodecReader,
            ): jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfSelectorMarker.Authority = try {
                Authority(
                    AccountIdProjectionOfSelectorMarker.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfSelectorMarker.Authority,
            ): Unit = try {
                AccountIdProjectionOfSelectorMarker.write(writer, instance.accountIdProjectionOfSelectorMarker)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<SignedTransactionProjectionOfSelectorMarker>,
        ScaleWriter<SignedTransactionProjectionOfSelectorMarker> {
        override fun read(reader: ScaleCodecReader): SignedTransactionProjectionOfSelectorMarker =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> Hash.read(reader)
                2 -> Authority.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(writer: ScaleCodecWriter, instance: SignedTransactionProjectionOfSelectorMarker) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Atom.write(writer, instance as Atom)
                1 -> Hash.write(writer, instance as Hash)
                2 -> Authority.write(writer, instance as Authority)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
