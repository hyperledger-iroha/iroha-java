//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.ModelEnum
import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import kotlin.Int

/**
 * AssetDefinitionPredicateAtom
 *
 * Generated from 'AssetDefinitionPredicateAtom' enum
 */
public sealed class AssetDefinitionPredicateAtom : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    public companion object :
        ScaleReader<AssetDefinitionPredicateAtom>,
        ScaleWriter<AssetDefinitionPredicateAtom> {
        override fun read(reader: ScaleCodecReader): AssetDefinitionPredicateAtom =
            when (val discriminant = reader.readUByte()) {
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: AssetDefinitionPredicateAtom,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
