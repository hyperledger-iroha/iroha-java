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
 * CommittedTransactionProjectionOfSelectorMarker
 *
 * Generated from 'CommittedTransactionProjectionOfSelectorMarker' enum
 */
public sealed class CommittedTransactionProjectionOfSelectorMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    override fun equals(other: Any?): Boolean =
        when (this) {
            is Atom -> Atom.equals(this, other)
            else -> super.equals(other)
        }

    override fun hashCode(): Int =
        when (this) {
            is Atom -> Atom.hashCode()
            else -> super.hashCode()
        }

    /**
     * 'Atom' variant
     */
    public class Atom : CommittedTransactionProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfSelectorMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfSelectorMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(
                reader: ScaleCodecReader,
            ): jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfSelectorMarker.Atom =
                try {
                    Atom()
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfSelectorMarker.Atom,
            ): Unit =
                try {
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            public fun equals(
                o1: jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfSelectorMarker.Atom,
                o2: Any?,
            ): Boolean =
                when (o2) {
                    null -> false
                    else -> o2::class == o1::class
                }

            override fun hashCode(): Int = ".CommittedTransactionProjectionOfSelectorMarker.Atom".hashCode()
        }
    }

    /**
     * 'BlockHash' variant
     */
    public data class BlockHash(
        public val blockHeaderHashProjectionOfSelectorMarker: BlockHeaderHashProjectionOfSelectorMarker,
    ) : CommittedTransactionProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfSelectorMarker.BlockHash>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfSelectorMarker.BlockHash> {
            public const val DISCRIMINANT: Int = 1

            override fun read(
                reader: ScaleCodecReader,
            ): jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfSelectorMarker.BlockHash =
                try {
                    BlockHash(
                        BlockHeaderHashProjectionOfSelectorMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfSelectorMarker.BlockHash,
            ): Unit =
                try {
                    BlockHeaderHashProjectionOfSelectorMarker.write(writer, instance.blockHeaderHashProjectionOfSelectorMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Value' variant
     */
    public data class Value(
        public val signedTransactionProjectionOfSelectorMarker: SignedTransactionProjectionOfSelectorMarker,
    ) : CommittedTransactionProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfSelectorMarker.Value>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfSelectorMarker.Value> {
            public const val DISCRIMINANT: Int = 2

            override fun read(
                reader: ScaleCodecReader,
            ): jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfSelectorMarker.Value =
                try {
                    Value(
                        SignedTransactionProjectionOfSelectorMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfSelectorMarker.Value,
            ): Unit =
                try {
                    SignedTransactionProjectionOfSelectorMarker.write(writer, instance.signedTransactionProjectionOfSelectorMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Error' variant
     */
    public data class Error(
        public val transactionErrorProjectionOfSelectorMarker: TransactionErrorProjectionOfSelectorMarker,
    ) : CommittedTransactionProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfSelectorMarker.Error>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfSelectorMarker.Error> {
            public const val DISCRIMINANT: Int = 3

            override fun read(
                reader: ScaleCodecReader,
            ): jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfSelectorMarker.Error =
                try {
                    Error(
                        TransactionErrorProjectionOfSelectorMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.CommittedTransactionProjectionOfSelectorMarker.Error,
            ): Unit =
                try {
                    TransactionErrorProjectionOfSelectorMarker.write(writer, instance.transactionErrorProjectionOfSelectorMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<CommittedTransactionProjectionOfSelectorMarker>,
        ScaleWriter<CommittedTransactionProjectionOfSelectorMarker> {
        override fun read(reader: ScaleCodecReader): CommittedTransactionProjectionOfSelectorMarker =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> BlockHash.read(reader)
                2 -> Value.read(reader)
                3 -> Error.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: CommittedTransactionProjectionOfSelectorMarker,
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
