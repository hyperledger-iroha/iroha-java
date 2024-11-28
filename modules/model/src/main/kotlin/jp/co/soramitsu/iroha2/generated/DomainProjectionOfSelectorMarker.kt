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
 * DomainProjectionOfSelectorMarker
 *
 * Generated from 'DomainProjectionOfSelectorMarker' enum
 */
public sealed class DomainProjectionOfSelectorMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    override fun equals(other: Any?): Boolean = when (this) {
        is Atom -> Atom.equals(this, other)
        else -> super.equals(other)
    }

    override fun hashCode(): Int = when (this) {
        is Atom -> Atom.hashCode()
        else -> super.hashCode()
    }

    /**
     * 'Atom' variant
     */
    public class Atom : DomainProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DomainProjectionOfSelectorMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DomainProjectionOfSelectorMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DomainProjectionOfSelectorMarker.Atom = try {
                Atom()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DomainProjectionOfSelectorMarker.Atom,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.DomainProjectionOfSelectorMarker.Atom, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".DomainProjectionOfSelectorMarker.Atom".hashCode()
        }
    }

    /**
     * 'Id' variant
     */
    public data class Id(public val domainIdProjectionOfSelectorMarker: DomainIdProjectionOfSelectorMarker) :
        DomainProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DomainProjectionOfSelectorMarker.Id>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DomainProjectionOfSelectorMarker.Id> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DomainProjectionOfSelectorMarker.Id = try {
                Id(
                    DomainIdProjectionOfSelectorMarker.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DomainProjectionOfSelectorMarker.Id,
            ): Unit = try {
                DomainIdProjectionOfSelectorMarker.write(writer, instance.domainIdProjectionOfSelectorMarker)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Metadata' variant
     */
    public data class Metadata(public val metadataProjectionOfSelectorMarker: MetadataProjectionOfSelectorMarker) :
        DomainProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DomainProjectionOfSelectorMarker.Metadata>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DomainProjectionOfSelectorMarker.Metadata> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DomainProjectionOfSelectorMarker.Metadata = try {
                Metadata(
                    MetadataProjectionOfSelectorMarker.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DomainProjectionOfSelectorMarker.Metadata,
            ): Unit = try {
                MetadataProjectionOfSelectorMarker.write(writer, instance.metadataProjectionOfSelectorMarker)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<DomainProjectionOfSelectorMarker>,
        ScaleWriter<DomainProjectionOfSelectorMarker> {
        override fun read(reader: ScaleCodecReader): DomainProjectionOfSelectorMarker = when (val discriminant = reader.readUByte()) {
            0 -> Atom.read(reader)
            1 -> Id.read(reader)
            2 -> Metadata.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: DomainProjectionOfSelectorMarker) {
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
