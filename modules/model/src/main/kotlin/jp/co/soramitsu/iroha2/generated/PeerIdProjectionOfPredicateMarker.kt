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
 * PeerIdProjectionOfPredicateMarker
 *
 * Generated from 'PeerIdProjectionOfPredicateMarker' enum
 */
public sealed class PeerIdProjectionOfPredicateMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(
        public val peerIdPredicateAtom: PeerIdPredicateAtom,
    ) : PeerIdProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.PeerIdProjectionOfPredicateMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.PeerIdProjectionOfPredicateMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.PeerIdProjectionOfPredicateMarker.Atom =
                try {
                    Atom(
                        PeerIdPredicateAtom.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.PeerIdProjectionOfPredicateMarker.Atom,
            ): Unit =
                try {
                    PeerIdPredicateAtom.write(writer, instance.peerIdPredicateAtom)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'PublicKey' variant
     */
    public data class PublicKey(
        public val publicKeyProjectionOfPredicateMarker: PublicKeyProjectionOfPredicateMarker,
    ) : PeerIdProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.PeerIdProjectionOfPredicateMarker.PublicKey>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.PeerIdProjectionOfPredicateMarker.PublicKey> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.PeerIdProjectionOfPredicateMarker.PublicKey =
                try {
                    PublicKey(
                        PublicKeyProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.PeerIdProjectionOfPredicateMarker.PublicKey,
            ): Unit =
                try {
                    PublicKeyProjectionOfPredicateMarker.write(writer, instance.publicKeyProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<PeerIdProjectionOfPredicateMarker>,
        ScaleWriter<PeerIdProjectionOfPredicateMarker> {
        override fun read(reader: ScaleCodecReader): PeerIdProjectionOfPredicateMarker =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> PublicKey.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: PeerIdProjectionOfPredicateMarker,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Atom.write(writer, instance as Atom)
                1 -> PublicKey.write(writer, instance as PublicKey)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
