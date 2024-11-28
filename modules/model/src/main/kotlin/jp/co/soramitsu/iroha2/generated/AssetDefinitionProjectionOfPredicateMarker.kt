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
 * AssetDefinitionProjectionOfPredicateMarker
 *
 * Generated from 'AssetDefinitionProjectionOfPredicateMarker' enum
 */
public sealed class AssetDefinitionProjectionOfPredicateMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(public val assetDefinitionPredicateAtom: AssetDefinitionPredicateAtom) :
        AssetDefinitionProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionProjectionOfPredicateMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionProjectionOfPredicateMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetDefinitionProjectionOfPredicateMarker.Atom =
                try {
                    Atom(
                        AssetDefinitionPredicateAtom.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionProjectionOfPredicateMarker.Atom,
            ): Unit = try {
                AssetDefinitionPredicateAtom.write(writer, instance.assetDefinitionPredicateAtom)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Id' variant
     */
    public data class Id(public val assetDefinitionIdProjectionOfPredicateMarker: AssetDefinitionIdProjectionOfPredicateMarker) :
        AssetDefinitionProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionProjectionOfPredicateMarker.Id>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionProjectionOfPredicateMarker.Id> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetDefinitionProjectionOfPredicateMarker.Id =
                try {
                    Id(
                        AssetDefinitionIdProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionProjectionOfPredicateMarker.Id,
            ): Unit = try {
                AssetDefinitionIdProjectionOfPredicateMarker.write(writer, instance.assetDefinitionIdProjectionOfPredicateMarker)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Metadata' variant
     */
    public data class Metadata(public val metadataProjectionOfPredicateMarker: MetadataProjectionOfPredicateMarker) :
        AssetDefinitionProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionProjectionOfPredicateMarker.Metadata>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionProjectionOfPredicateMarker.Metadata> {
            public const val DISCRIMINANT: Int = 2

            override fun read(
                reader: ScaleCodecReader,
            ): jp.co.soramitsu.iroha2.generated.AssetDefinitionProjectionOfPredicateMarker.Metadata = try {
                Metadata(
                    MetadataProjectionOfPredicateMarker.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionProjectionOfPredicateMarker.Metadata,
            ): Unit = try {
                MetadataProjectionOfPredicateMarker.write(writer, instance.metadataProjectionOfPredicateMarker)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<AssetDefinitionProjectionOfPredicateMarker>,
        ScaleWriter<AssetDefinitionProjectionOfPredicateMarker> {
        override fun read(reader: ScaleCodecReader): AssetDefinitionProjectionOfPredicateMarker =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> Id.read(reader)
                2 -> Metadata.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(writer: ScaleCodecWriter, instance: AssetDefinitionProjectionOfPredicateMarker) {
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
