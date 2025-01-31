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
 * MetadataProjectionOfPredicateMarker
 *
 * Generated from 'MetadataProjectionOfPredicateMarker' enum
 */
public sealed class MetadataProjectionOfPredicateMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(public val metadataPredicateAtom: MetadataPredicateAtom) : MetadataProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.MetadataProjectionOfPredicateMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.MetadataProjectionOfPredicateMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.MetadataProjectionOfPredicateMarker.Atom = try {
                Atom(
                    MetadataPredicateAtom.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.MetadataProjectionOfPredicateMarker.Atom,
            ): Unit = try {
                MetadataPredicateAtom.write(writer, instance.metadataPredicateAtom)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Key' variant
     */
    public data class Key(public val metadataKeyProjectionOfPredicateMarker: MetadataKeyProjectionOfPredicateMarker) :
        MetadataProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.MetadataProjectionOfPredicateMarker.Key>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.MetadataProjectionOfPredicateMarker.Key> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.MetadataProjectionOfPredicateMarker.Key = try {
                Key(
                    MetadataKeyProjectionOfPredicateMarker.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.MetadataProjectionOfPredicateMarker.Key,
            ): Unit = try {
                MetadataKeyProjectionOfPredicateMarker.write(writer, instance.metadataKeyProjectionOfPredicateMarker)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<MetadataProjectionOfPredicateMarker>,
        ScaleWriter<MetadataProjectionOfPredicateMarker> {
        override fun read(reader: ScaleCodecReader): MetadataProjectionOfPredicateMarker = when (val discriminant = reader.readUByte()) {
            0 -> Atom.read(reader)
            1 -> Key.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: MetadataProjectionOfPredicateMarker) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Atom.write(writer, instance as Atom)
                1 -> Key.write(writer, instance as Key)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
