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
 * ActionPredicateAtom
 *
 * Generated from 'ActionPredicateAtom' enum
 */
public sealed class ActionPredicateAtom : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    public companion object : ScaleReader<ActionPredicateAtom>, ScaleWriter<ActionPredicateAtom> {
        override fun read(reader: ScaleCodecReader): ActionPredicateAtom =
            when (val discriminant = reader.readUByte()) {
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: ActionPredicateAtom,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
