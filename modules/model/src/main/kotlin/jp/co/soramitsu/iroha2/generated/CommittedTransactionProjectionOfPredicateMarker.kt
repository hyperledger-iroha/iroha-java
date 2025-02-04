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
 * CommittedTransactionProjectionOfPredicateMarker
 *
 * Generated from 'CommittedTransactionProjectionOfPredicateMarker' enum
 */
public sealed class CommittedTransactionProjectionOfPredicateMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(
        public val committedTransactionPredicateAtom: CommittedTransactionPredicateAtom,
    ) : CommittedTransactionProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfPredicateMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfPredicateMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(
                reader: ScaleCodecReader,
            ): jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfPredicateMarker.Atom =
                try {
                    Atom(
                        CommittedTransactionPredicateAtom.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfPredicateMarker.Atom,
            ): Unit =
                try {
                    CommittedTransactionPredicateAtom.write(writer, instance.committedTransactionPredicateAtom)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'BlockHash' variant
     */
    public data class BlockHash(
        public val blockHeaderHashProjectionOfPredicateMarker: BlockHeaderHashProjectionOfPredicateMarker,
    ) : CommittedTransactionProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfPredicateMarker.BlockHash>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfPredicateMarker.BlockHash> {
            public const val DISCRIMINANT: Int = 1

            override fun read(
                reader: ScaleCodecReader,
            ): jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfPredicateMarker.BlockHash =
                try {
                    BlockHash(
                        BlockHeaderHashProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfPredicateMarker.BlockHash,
            ): Unit =
                try {
                    BlockHeaderHashProjectionOfPredicateMarker.write(writer, instance.blockHeaderHashProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Value' variant
     */
    public data class Value(
        public val signedTransactionProjectionOfPredicateMarker: SignedTransactionProjectionOfPredicateMarker,
    ) : CommittedTransactionProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfPredicateMarker.Value>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfPredicateMarker.Value> {
            public const val DISCRIMINANT: Int = 2

            override fun read(
                reader: ScaleCodecReader,
            ): jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfPredicateMarker.Value =
                try {
                    Value(
                        SignedTransactionProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfPredicateMarker.Value,
            ): Unit =
                try {
                    SignedTransactionProjectionOfPredicateMarker.write(writer, instance.signedTransactionProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Error' variant
     */
    public data class Error(
        public val transactionErrorProjectionOfPredicateMarker: TransactionErrorProjectionOfPredicateMarker,
    ) : CommittedTransactionProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfPredicateMarker.Error>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfPredicateMarker.Error> {
            public const val DISCRIMINANT: Int = 3

            override fun read(
                reader: ScaleCodecReader,
            ): jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfPredicateMarker.Error =
                try {
                    Error(
                        TransactionErrorProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfPredicateMarker.Error,
            ): Unit =
                try {
                    TransactionErrorProjectionOfPredicateMarker.write(writer, instance.transactionErrorProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<CommittedTransactionProjectionOfPredicateMarker>,
        ScaleWriter<CommittedTransactionProjectionOfPredicateMarker> {
        override fun read(reader: ScaleCodecReader): CommittedTransactionProjectionOfPredicateMarker =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> BlockHash.read(reader)
                2 -> Value.read(reader)
                3 -> Error.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: CommittedTransactionProjectionOfPredicateMarker,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Atom.write(writer, instance as Atom)
                1 -> BlockHash.write(writer, instance as BlockHash)
                2 -> Value.write(writer, instance as Value)
                3 -> Error.write(writer, instance as Error)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
