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
 * TriggerIdProjectionOfPredicateMarker
 *
 * Generated from 'TriggerIdProjectionOfPredicateMarker' enum
 */
public sealed class TriggerIdProjectionOfPredicateMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(
        public val triggerIdPredicateAtom: TriggerIdPredicateAtom,
    ) : TriggerIdProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TriggerIdProjectionOfPredicateMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TriggerIdProjectionOfPredicateMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TriggerIdProjectionOfPredicateMarker.Atom =
                try {
                    Atom(
                        TriggerIdPredicateAtom.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TriggerIdProjectionOfPredicateMarker.Atom,
            ): Unit =
                try {
                    TriggerIdPredicateAtom.write(writer, instance.triggerIdPredicateAtom)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Name' variant
     */
    public data class Name(
        public val nameProjectionOfPredicateMarker: NameProjectionOfPredicateMarker,
    ) : TriggerIdProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TriggerIdProjectionOfPredicateMarker.Name>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TriggerIdProjectionOfPredicateMarker.Name> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TriggerIdProjectionOfPredicateMarker.Name =
                try {
                    Name(
                        NameProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TriggerIdProjectionOfPredicateMarker.Name,
            ): Unit =
                try {
                    NameProjectionOfPredicateMarker.write(writer, instance.nameProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<TriggerIdProjectionOfPredicateMarker>,
        ScaleWriter<TriggerIdProjectionOfPredicateMarker> {
        override fun read(reader: ScaleCodecReader): TriggerIdProjectionOfPredicateMarker =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> Name.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: TriggerIdProjectionOfPredicateMarker,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Atom.write(writer, instance as Atom)
                1 -> Name.write(writer, instance as Name)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
