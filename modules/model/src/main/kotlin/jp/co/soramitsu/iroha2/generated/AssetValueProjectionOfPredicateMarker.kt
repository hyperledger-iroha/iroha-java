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
 * AssetValueProjectionOfPredicateMarker
 *
 * Generated from 'AssetValueProjectionOfPredicateMarker' enum
 */
public sealed class AssetValueProjectionOfPredicateMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(
        public val assetValuePredicateAtom: AssetValuePredicateAtom,
    ) : AssetValueProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfPredicateMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfPredicateMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfPredicateMarker.Atom =
                try {
                    Atom(
                        AssetValuePredicateAtom.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfPredicateMarker.Atom,
            ): Unit =
                try {
                    AssetValuePredicateAtom.write(writer, instance.assetValuePredicateAtom)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Numeric' variant
     */
    public data class Numeric(
        public val numericProjectionOfPredicateMarker: NumericProjectionOfPredicateMarker,
    ) : AssetValueProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfPredicateMarker.Numeric>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfPredicateMarker.Numeric> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfPredicateMarker.Numeric =
                try {
                    Numeric(
                        NumericProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfPredicateMarker.Numeric,
            ): Unit =
                try {
                    NumericProjectionOfPredicateMarker.write(writer, instance.numericProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Store' variant
     */
    public data class Store(
        public val metadataProjectionOfPredicateMarker: MetadataProjectionOfPredicateMarker,
    ) : AssetValueProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfPredicateMarker.Store>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfPredicateMarker.Store> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfPredicateMarker.Store =
                try {
                    Store(
                        MetadataProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetValueProjectionOfPredicateMarker.Store,
            ): Unit =
                try {
                    MetadataProjectionOfPredicateMarker.write(writer, instance.metadataProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<AssetValueProjectionOfPredicateMarker>,
        ScaleWriter<AssetValueProjectionOfPredicateMarker> {
        override fun read(reader: ScaleCodecReader): AssetValueProjectionOfPredicateMarker =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> Numeric.read(reader)
                2 -> Store.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: AssetValueProjectionOfPredicateMarker,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Atom.write(writer, instance as Atom)
                1 -> Numeric.write(writer, instance as Numeric)
                2 -> Store.write(writer, instance as Store)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
