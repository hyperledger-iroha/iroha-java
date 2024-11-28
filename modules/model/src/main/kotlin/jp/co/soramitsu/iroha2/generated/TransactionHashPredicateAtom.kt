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
 * TransactionHashPredicateAtom
 *
 * Generated from 'TransactionHashPredicateAtom' enum
 */
public sealed class TransactionHashPredicateAtom : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Equals' variant
     */
    public data class Equals(public val hashOf: HashOf<SignedTransaction>) : TransactionHashPredicateAtom() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TransactionHashPredicateAtom.Equals>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TransactionHashPredicateAtom.Equals> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TransactionHashPredicateAtom.Equals = try {
                Equals(
                    HashOf.read(reader) as HashOf<SignedTransaction>,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TransactionHashPredicateAtom.Equals,
            ): Unit = try {
                HashOf.write(writer, instance.hashOf)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<TransactionHashPredicateAtom>,
        ScaleWriter<TransactionHashPredicateAtom> {
        override fun read(reader: ScaleCodecReader): TransactionHashPredicateAtom = when (val discriminant = reader.readUByte()) {
            0 -> Equals.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: TransactionHashPredicateAtom) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Equals.write(writer, instance as Equals)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
