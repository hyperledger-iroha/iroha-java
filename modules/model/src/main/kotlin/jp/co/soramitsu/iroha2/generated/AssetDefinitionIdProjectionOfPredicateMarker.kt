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
 * AssetDefinitionIdProjectionOfPredicateMarker
 *
 * Generated from 'AssetDefinitionIdProjectionOfPredicateMarker' enum
 */
public sealed class AssetDefinitionIdProjectionOfPredicateMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(
        public val assetDefinitionIdPredicateAtom: AssetDefinitionIdPredicateAtom,
    ) : AssetDefinitionIdProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfPredicateMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfPredicateMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(
                reader: ScaleCodecReader,
            ): jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfPredicateMarker.Atom =
                try {
                    Atom(
                        AssetDefinitionIdPredicateAtom.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfPredicateMarker.Atom,
            ): Unit =
                try {
                    AssetDefinitionIdPredicateAtom.write(writer, instance.assetDefinitionIdPredicateAtom)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Domain' variant
     */
    public data class Domain(
        public val domainIdProjectionOfPredicateMarker: DomainIdProjectionOfPredicateMarker,
    ) : AssetDefinitionIdProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfPredicateMarker.Domain>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfPredicateMarker.Domain> {
            public const val DISCRIMINANT: Int = 1

            override fun read(
                reader: ScaleCodecReader,
            ): jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfPredicateMarker.Domain =
                try {
                    Domain(
                        DomainIdProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfPredicateMarker.Domain,
            ): Unit =
                try {
                    DomainIdProjectionOfPredicateMarker.write(writer, instance.domainIdProjectionOfPredicateMarker)
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
    ) : AssetDefinitionIdProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfPredicateMarker.Name>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfPredicateMarker.Name> {
            public const val DISCRIMINANT: Int = 2

            override fun read(
                reader: ScaleCodecReader,
            ): jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfPredicateMarker.Name =
                try {
                    Name(
                        NameProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionIdProjectionOfPredicateMarker.Name,
            ): Unit =
                try {
                    NameProjectionOfPredicateMarker.write(writer, instance.nameProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<AssetDefinitionIdProjectionOfPredicateMarker>,
        ScaleWriter<AssetDefinitionIdProjectionOfPredicateMarker> {
        override fun read(reader: ScaleCodecReader): AssetDefinitionIdProjectionOfPredicateMarker =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> Domain.read(reader)
                2 -> Name.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: AssetDefinitionIdProjectionOfPredicateMarker,
        ) {
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
