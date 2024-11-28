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
 * AssetValuePredicateAtom
 *
 * Generated from 'AssetValuePredicateAtom' enum
 */
public sealed class AssetValuePredicateAtom : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    public companion object :
        ScaleReader<AssetValuePredicateAtom>,
        ScaleWriter<AssetValuePredicateAtom> {
        override fun read(reader: ScaleCodecReader): AssetValuePredicateAtom = when (val discriminant = reader.readUByte()) {
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: AssetValuePredicateAtom) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
