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
 * NameProjectionOfPredicateMarker
 *
 * Generated from 'NameProjectionOfPredicateMarker' enum
 */
public sealed class NameProjectionOfPredicateMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(public val stringPredicateAtom: StringPredicateAtom) : NameProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.NameProjectionOfPredicateMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.NameProjectionOfPredicateMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.NameProjectionOfPredicateMarker.Atom = try {
                Atom(
                    StringPredicateAtom.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.NameProjectionOfPredicateMarker.Atom,
            ): Unit = try {
                StringPredicateAtom.write(writer, instance.stringPredicateAtom)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<NameProjectionOfPredicateMarker>,
        ScaleWriter<NameProjectionOfPredicateMarker> {
        override fun read(reader: ScaleCodecReader): NameProjectionOfPredicateMarker = when (val discriminant = reader.readUByte()) {
            0 -> Atom.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: NameProjectionOfPredicateMarker) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Atom.write(writer, instance as Atom)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
