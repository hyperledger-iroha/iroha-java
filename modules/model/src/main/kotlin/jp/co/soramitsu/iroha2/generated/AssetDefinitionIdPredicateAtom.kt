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
 * AssetDefinitionIdPredicateAtom
 *
 * Generated from 'AssetDefinitionIdPredicateAtom' enum
 */
public sealed class AssetDefinitionIdPredicateAtom : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Equals' variant
     */
    public data class Equals(public val assetDefinitionId: AssetDefinitionId) : AssetDefinitionIdPredicateAtom() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetDefinitionIdPredicateAtom.Equals>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetDefinitionIdPredicateAtom.Equals> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetDefinitionIdPredicateAtom.Equals = try {
                Equals(
                    AssetDefinitionId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetDefinitionIdPredicateAtom.Equals,
            ): Unit = try {
                AssetDefinitionId.write(writer, instance.assetDefinitionId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<AssetDefinitionIdPredicateAtom>,
        ScaleWriter<AssetDefinitionIdPredicateAtom> {
        override fun read(reader: ScaleCodecReader): AssetDefinitionIdPredicateAtom = when (val discriminant = reader.readUByte()) {
            0 -> Equals.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: AssetDefinitionIdPredicateAtom) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Equals.write(writer, instance as Equals)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
