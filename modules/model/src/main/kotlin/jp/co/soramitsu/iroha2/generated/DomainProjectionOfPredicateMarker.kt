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
 * DomainProjectionOfPredicateMarker
 *
 * Generated from 'DomainProjectionOfPredicateMarker' enum
 */
public sealed class DomainProjectionOfPredicateMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(public val domainPredicateAtom: DomainPredicateAtom) : DomainProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DomainProjectionOfPredicateMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DomainProjectionOfPredicateMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DomainProjectionOfPredicateMarker.Atom = try {
                Atom(
                    DomainPredicateAtom.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DomainProjectionOfPredicateMarker.Atom,
            ): Unit = try {
                DomainPredicateAtom.write(writer, instance.domainPredicateAtom)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Id' variant
     */
    public data class Id(public val domainIdProjectionOfPredicateMarker: DomainIdProjectionOfPredicateMarker) :
        DomainProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DomainProjectionOfPredicateMarker.Id>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DomainProjectionOfPredicateMarker.Id> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DomainProjectionOfPredicateMarker.Id = try {
                Id(
                    DomainIdProjectionOfPredicateMarker.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DomainProjectionOfPredicateMarker.Id,
            ): Unit = try {
                DomainIdProjectionOfPredicateMarker.write(writer, instance.domainIdProjectionOfPredicateMarker)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Metadata' variant
     */
    public data class Metadata(public val metadataProjectionOfPredicateMarker: MetadataProjectionOfPredicateMarker) :
        DomainProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DomainProjectionOfPredicateMarker.Metadata>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DomainProjectionOfPredicateMarker.Metadata> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DomainProjectionOfPredicateMarker.Metadata = try {
                Metadata(
                    MetadataProjectionOfPredicateMarker.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DomainProjectionOfPredicateMarker.Metadata,
            ): Unit = try {
                MetadataProjectionOfPredicateMarker.write(writer, instance.metadataProjectionOfPredicateMarker)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<DomainProjectionOfPredicateMarker>,
        ScaleWriter<DomainProjectionOfPredicateMarker> {
        override fun read(reader: ScaleCodecReader): DomainProjectionOfPredicateMarker = when (val discriminant = reader.readUByte()) {
            0 -> Atom.read(reader)
            1 -> Id.read(reader)
            2 -> Metadata.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: DomainProjectionOfPredicateMarker) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Atom.write(writer, instance as Atom)
                1 -> Id.write(writer, instance as Id)
                2 -> Metadata.write(writer, instance as Metadata)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
