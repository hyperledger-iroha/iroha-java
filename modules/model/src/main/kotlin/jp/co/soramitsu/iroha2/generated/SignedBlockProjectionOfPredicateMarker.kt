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
 * SignedBlockProjectionOfPredicateMarker
 *
 * Generated from 'SignedBlockProjectionOfPredicateMarker' enum
 */
public sealed class SignedBlockProjectionOfPredicateMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(
        public val signedBlockPredicateAtom: SignedBlockPredicateAtom,
    ) : SignedBlockProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SignedBlockProjectionOfPredicateMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SignedBlockProjectionOfPredicateMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SignedBlockProjectionOfPredicateMarker.Atom =
                try {
                    Atom(
                        SignedBlockPredicateAtom.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SignedBlockProjectionOfPredicateMarker.Atom,
            ): Unit =
                try {
                    SignedBlockPredicateAtom.write(writer, instance.signedBlockPredicateAtom)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Header' variant
     */
    public data class Header(
        public val blockHeaderProjectionOfPredicateMarker: BlockHeaderProjectionOfPredicateMarker,
    ) : SignedBlockProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SignedBlockProjectionOfPredicateMarker.Header>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SignedBlockProjectionOfPredicateMarker.Header> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SignedBlockProjectionOfPredicateMarker.Header =
                try {
                    Header(
                        BlockHeaderProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SignedBlockProjectionOfPredicateMarker.Header,
            ): Unit =
                try {
                    BlockHeaderProjectionOfPredicateMarker.write(writer, instance.blockHeaderProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<SignedBlockProjectionOfPredicateMarker>,
        ScaleWriter<SignedBlockProjectionOfPredicateMarker> {
        override fun read(reader: ScaleCodecReader): SignedBlockProjectionOfPredicateMarker =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> Header.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: SignedBlockProjectionOfPredicateMarker,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Atom.write(writer, instance as Atom)
                1 -> Header.write(writer, instance as Header)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
