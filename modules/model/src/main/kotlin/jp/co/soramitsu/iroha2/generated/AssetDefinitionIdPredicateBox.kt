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
 * AssetDefinitionIdPredicateBox
 *
 * Generated from 'AssetDefinitionIdPredicateBox' enum
 */
public sealed class AssetDefinitionIdPredicateBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Equals' variant
     */
    public data class Equals(
        public val assetDefinitionId: AssetDefinitionId,
    ) : AssetDefinitionIdPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionIdPredicateBox.Equals>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionIdPredicateBox.Equals> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetDefinitionIdPredicateBox.Equals = try {
                Equals(
                    AssetDefinitionId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionIdPredicateBox.Equals,
            ): Unit =
                try {
                    AssetDefinitionId.write(writer, instance.assetDefinitionId)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'DomainId' variant
     */
    public data class DomainId(
        public val domainIdPredicateBox: DomainIdPredicateBox,
    ) : AssetDefinitionIdPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionIdPredicateBox.DomainId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionIdPredicateBox.DomainId> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetDefinitionIdPredicateBox.DomainId = try {
                DomainId(
                    DomainIdPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionIdPredicateBox.DomainId,
            ): Unit =
                try {
                    DomainIdPredicateBox.write(writer, instance.domainIdPredicateBox)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Name' variant
     */
    public data class Name(
        public val stringPredicateBox: StringPredicateBox,
    ) : AssetDefinitionIdPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionIdPredicateBox.Name>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionIdPredicateBox.Name> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetDefinitionIdPredicateBox.Name = try {
                Name(
                    StringPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionIdPredicateBox.Name,
            ): Unit = try {
                StringPredicateBox.write(writer, instance.stringPredicateBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<AssetDefinitionIdPredicateBox>,
        ScaleWriter<AssetDefinitionIdPredicateBox> {
        override fun read(reader: ScaleCodecReader): AssetDefinitionIdPredicateBox = when (
            val
            discriminant = reader.readUByte()
        ) {
            0 -> Equals.read(reader)
            1 -> DomainId.read(reader)
            2 -> Name.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: AssetDefinitionIdPredicateBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Equals.write(writer, instance as Equals)
                1 -> DomainId.write(writer, instance as DomainId)
                2 -> Name.write(writer, instance as Name)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
