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
 * SignedTransactionProjectionOfPredicateMarker
 *
 * Generated from 'SignedTransactionProjectionOfPredicateMarker' enum
 */
public sealed class SignedTransactionProjectionOfPredicateMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(
        public val signedTransactionPredicateAtom: SignedTransactionPredicateAtom,
    ) : SignedTransactionProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfPredicateMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfPredicateMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(
                reader: ScaleCodecReader,
            ): jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfPredicateMarker.Atom =
                try {
                    Atom(
                        SignedTransactionPredicateAtom.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfPredicateMarker.Atom,
            ): Unit =
                try {
                    SignedTransactionPredicateAtom.write(writer, instance.signedTransactionPredicateAtom)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Hash' variant
     */
    public data class Hash(
        public val transactionHashProjectionOfPredicateMarker: TransactionHashProjectionOfPredicateMarker,
    ) : SignedTransactionProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfPredicateMarker.Hash>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfPredicateMarker.Hash> {
            public const val DISCRIMINANT: Int = 1

            override fun read(
                reader: ScaleCodecReader,
            ): jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfPredicateMarker.Hash =
                try {
                    Hash(
                        TransactionHashProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfPredicateMarker.Hash,
            ): Unit =
                try {
                    TransactionHashProjectionOfPredicateMarker.write(writer, instance.transactionHashProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Authority' variant
     */
    public data class Authority(
        public val accountIdProjectionOfPredicateMarker: AccountIdProjectionOfPredicateMarker,
    ) : SignedTransactionProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfPredicateMarker.Authority>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfPredicateMarker.Authority> {
            public const val DISCRIMINANT: Int = 2

            override fun read(
                reader: ScaleCodecReader,
            ): jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfPredicateMarker.Authority =
                try {
                    Authority(
                        AccountIdProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SignedTransactionProjectionOfPredicateMarker.Authority,
            ): Unit =
                try {
                    AccountIdProjectionOfPredicateMarker.write(writer, instance.accountIdProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<SignedTransactionProjectionOfPredicateMarker>,
        ScaleWriter<SignedTransactionProjectionOfPredicateMarker> {
        override fun read(reader: ScaleCodecReader): SignedTransactionProjectionOfPredicateMarker =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> Hash.read(reader)
                2 -> Authority.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: SignedTransactionProjectionOfPredicateMarker,
        ) {
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
