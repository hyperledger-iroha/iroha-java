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
 * AssetDefinitionIdProjectionOfSelectorMarker
 *
 * Generated from 'AssetDefinitionIdProjectionOfSelectorMarker' enum
 */
public sealed class AssetDefinitionIdProjectionOfSelectorMarker : ModelEnum {
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
    public class Atom : AssetDefinitionIdProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfSelectorMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfSelectorMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfSelectorMarker.Atom =
                try {
                    Atom()
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfSelectorMarker.Atom,
            ): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfSelectorMarker.Atom, o2: Any?): Boolean =
                when (o2) {
                    null -> false
                    else -> o2::class == o1::class
                }

            override fun hashCode(): Int = ".AssetDefinitionIdProjectionOfSelectorMarker.Atom".hashCode()
        }
    }

    /**
     * 'Domain' variant
     */
    public data class Domain(public val domainIdProjectionOfSelectorMarker: DomainIdProjectionOfSelectorMarker) :
        AssetDefinitionIdProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfSelectorMarker.Domain>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfSelectorMarker.Domain> {
            public const val DISCRIMINANT: Int = 1

            override fun read(
                reader: ScaleCodecReader,
            ): jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfSelectorMarker.Domain = try {
                Domain(
                    DomainIdProjectionOfSelectorMarker.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfSelectorMarker.Domain,
            ): Unit = try {
                DomainIdProjectionOfSelectorMarker.write(writer, instance.domainIdProjectionOfSelectorMarker)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Name' variant
     */
    public data class Name(public val nameProjectionOfSelectorMarker: NameProjectionOfSelectorMarker) :
        AssetDefinitionIdProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfSelectorMarker.Name>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfSelectorMarker.Name> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfSelectorMarker.Name =
                try {
                    Name(
                        NameProjectionOfSelectorMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfSelectorMarker.Name,
            ): Unit = try {
                NameProjectionOfSelectorMarker.write(writer, instance.nameProjectionOfSelectorMarker)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<AssetDefinitionIdProjectionOfSelectorMarker>,
        ScaleWriter<AssetDefinitionIdProjectionOfSelectorMarker> {
        override fun read(reader: ScaleCodecReader): AssetDefinitionIdProjectionOfSelectorMarker =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> Domain.read(reader)
                2 -> Name.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(writer: ScaleCodecWriter, instance: AssetDefinitionIdProjectionOfSelectorMarker) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Atom.write(writer, instance as Atom)
                1 -> Domain.write(writer, instance as Domain)
                2 -> Name.write(writer, instance as Name)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
