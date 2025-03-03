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
 * AssetProjectionOfPredicateMarker
 *
 * Generated from 'AssetProjectionOfPredicateMarker' enum
 */
public sealed class AssetProjectionOfPredicateMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(
        public val assetPredicateAtom: AssetPredicateAtom,
    ) : AssetProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetProjectionOfPredicateMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetProjectionOfPredicateMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetProjectionOfPredicateMarker.Atom =
                try {
                    Atom(
                        AssetPredicateAtom.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetProjectionOfPredicateMarker.Atom,
            ): Unit =
                try {
                    AssetPredicateAtom.write(writer, instance.assetPredicateAtom)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Id' variant
     */
    public data class Id(
        public val assetIdProjectionOfPredicateMarker: AssetIdProjectionOfPredicateMarker,
    ) : AssetProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetProjectionOfPredicateMarker.Id>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetProjectionOfPredicateMarker.Id> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetProjectionOfPredicateMarker.Id =
                try {
                    Id(
                        AssetIdProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetProjectionOfPredicateMarker.Id,
            ): Unit =
                try {
                    AssetIdProjectionOfPredicateMarker.write(writer, instance.assetIdProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Value' variant
     */
    public data class Value(
        public val assetValueProjectionOfPredicateMarker: AssetValueProjectionOfPredicateMarker,
    ) : AssetProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetProjectionOfPredicateMarker.Value>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetProjectionOfPredicateMarker.Value> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetProjectionOfPredicateMarker.Value =
                try {
                    Value(
                        AssetValueProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetProjectionOfPredicateMarker.Value,
            ): Unit =
                try {
                    AssetValueProjectionOfPredicateMarker.write(writer, instance.assetValueProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<AssetProjectionOfPredicateMarker>,
        ScaleWriter<AssetProjectionOfPredicateMarker> {
        override fun read(reader: ScaleCodecReader): AssetProjectionOfPredicateMarker =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> Id.read(reader)
                2 -> Value.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: AssetProjectionOfPredicateMarker,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Atom.write(writer, instance as Atom)
                1 -> Id.write(writer, instance as Id)
                2 -> Value.write(writer, instance as Value)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
