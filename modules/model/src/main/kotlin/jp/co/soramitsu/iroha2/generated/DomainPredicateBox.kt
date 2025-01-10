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
 * DomainPredicateBox
 *
 * Generated from 'DomainPredicateBox' enum
 */
public sealed class DomainPredicateBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Id' variant
     */
    public data class Id(
        public val domainIdPredicateBox: DomainIdPredicateBox,
    ) : DomainPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DomainPredicateBox.Id>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DomainPredicateBox.Id> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DomainPredicateBox.Id = try {
                Id(
                    DomainIdPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DomainPredicateBox.Id,
            ): Unit = try {
                DomainIdPredicateBox.write(writer, instance.domainIdPredicateBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Metadata' variant
     */
    public data class Metadata(
        public val metadataPredicateBox: MetadataPredicateBox,
    ) : DomainPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.DomainPredicateBox.Metadata>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.DomainPredicateBox.Metadata> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.DomainPredicateBox.Metadata = try {
                Metadata(
                    MetadataPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.DomainPredicateBox.Metadata,
            ): Unit = try {
                MetadataPredicateBox.write(writer, instance.metadataPredicateBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<DomainPredicateBox>, ScaleWriter<DomainPredicateBox> {
        override fun read(reader: ScaleCodecReader): DomainPredicateBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Id.read(reader)
            1 -> Metadata.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: DomainPredicateBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Id.write(writer, instance as Id)
                1 -> Metadata.write(writer, instance as Metadata)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
