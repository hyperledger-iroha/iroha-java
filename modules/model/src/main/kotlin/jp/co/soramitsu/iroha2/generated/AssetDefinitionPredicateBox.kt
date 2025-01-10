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
 * AssetDefinitionPredicateBox
 *
 * Generated from 'AssetDefinitionPredicateBox' enum
 */
public sealed class AssetDefinitionPredicateBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Id' variant
     */
    public data class Id(
        public val assetDefinitionIdPredicateBox: AssetDefinitionIdPredicateBox,
    ) : AssetDefinitionPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionPredicateBox.Id>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionPredicateBox.Id> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetDefinitionPredicateBox.Id = try {
                Id(
                    AssetDefinitionIdPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionPredicateBox.Id,
            ): Unit = try {
                AssetDefinitionIdPredicateBox.write(writer, instance.assetDefinitionIdPredicateBox)
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
    ) : AssetDefinitionPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionPredicateBox.Metadata>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionPredicateBox.Metadata> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetDefinitionPredicateBox.Metadata = try {
                Metadata(
                    MetadataPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionPredicateBox.Metadata,
            ): Unit =
                try {
                    MetadataPredicateBox.write(writer, instance.metadataPredicateBox)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'OwnedBy' variant
     */
    public data class OwnedBy(
        public val accountIdPredicateBox: AccountIdPredicateBox,
    ) : AssetDefinitionPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionPredicateBox.OwnedBy>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionPredicateBox.OwnedBy> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetDefinitionPredicateBox.OwnedBy = try {
                OwnedBy(
                    AccountIdPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionPredicateBox.OwnedBy,
            ): Unit =
                try {
                    AccountIdPredicateBox.write(writer, instance.accountIdPredicateBox)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<AssetDefinitionPredicateBox>,
        ScaleWriter<AssetDefinitionPredicateBox> {
        override fun read(reader: ScaleCodecReader): AssetDefinitionPredicateBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Id.read(reader)
            1 -> Metadata.read(reader)
            2 -> OwnedBy.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: AssetDefinitionPredicateBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Id.write(writer, instance as Id)
                1 -> Metadata.write(writer, instance as Metadata)
                2 -> OwnedBy.write(writer, instance as OwnedBy)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
