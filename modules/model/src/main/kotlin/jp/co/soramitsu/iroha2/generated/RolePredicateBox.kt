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
 * RolePredicateBox
 *
 * Generated from 'RolePredicateBox' enum
 */
public sealed class RolePredicateBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Id' variant
     */
    public data class Id(
        public val roleIdPredicateBox: RoleIdPredicateBox,
    ) : RolePredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.RolePredicateBox.Id>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.RolePredicateBox.Id> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.RolePredicateBox.Id = try {
                Id(
                    RoleIdPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.RolePredicateBox.Id,
            ): Unit = try {
                RoleIdPredicateBox.write(writer, instance.roleIdPredicateBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<RolePredicateBox>, ScaleWriter<RolePredicateBox> {
        override fun read(reader: ScaleCodecReader): RolePredicateBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Id.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: RolePredicateBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Id.write(writer, instance as Id)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
