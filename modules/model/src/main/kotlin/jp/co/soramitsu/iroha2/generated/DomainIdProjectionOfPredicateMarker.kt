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
 * DomainIdProjectionOfPredicateMarker
 *
 * Generated from 'DomainIdProjectionOfPredicateMarker' enum
 */
public sealed class DomainIdProjectionOfPredicateMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(public val domainIdPredicateAtom: DomainIdPredicateAtom) : DomainIdProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DomainIdProjectionOfPredicateMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DomainIdProjectionOfPredicateMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DomainIdProjectionOfPredicateMarker.Atom = try {
                Atom(
                    DomainIdPredicateAtom.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DomainIdProjectionOfPredicateMarker.Atom,
            ): Unit = try {
                DomainIdPredicateAtom.write(writer, instance.domainIdPredicateAtom)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Name' variant
     */
    public data class Name(public val nameProjectionOfPredicateMarker: NameProjectionOfPredicateMarker) :
        DomainIdProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DomainIdProjectionOfPredicateMarker.Name>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DomainIdProjectionOfPredicateMarker.Name> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DomainIdProjectionOfPredicateMarker.Name = try {
                Name(
                    NameProjectionOfPredicateMarker.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DomainIdProjectionOfPredicateMarker.Name,
            ): Unit = try {
                NameProjectionOfPredicateMarker.write(writer, instance.nameProjectionOfPredicateMarker)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<DomainIdProjectionOfPredicateMarker>,
        ScaleWriter<DomainIdProjectionOfPredicateMarker> {
        override fun read(reader: ScaleCodecReader): DomainIdProjectionOfPredicateMarker = when (val discriminant = reader.readUByte()) {
            0 -> Atom.read(reader)
            1 -> Name.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: DomainIdProjectionOfPredicateMarker) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Atom.write(writer, instance as Atom)
                1 -> Name.write(writer, instance as Name)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
