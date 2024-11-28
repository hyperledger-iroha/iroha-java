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
 * RoleProjectionOfPredicateMarker
 *
 * Generated from 'RoleProjectionOfPredicateMarker' enum
 */
public sealed class RoleProjectionOfPredicateMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(public val rolePredicateAtom: RolePredicateAtom) : RoleProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.RoleProjectionOfPredicateMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.RoleProjectionOfPredicateMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.RoleProjectionOfPredicateMarker.Atom = try {
                Atom(
                    RolePredicateAtom.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.RoleProjectionOfPredicateMarker.Atom,
            ): Unit = try {
                RolePredicateAtom.write(writer, instance.rolePredicateAtom)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Id' variant
     */
    public data class Id(public val roleIdProjectionOfPredicateMarker: RoleIdProjectionOfPredicateMarker) :
        RoleProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.RoleProjectionOfPredicateMarker.Id>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.RoleProjectionOfPredicateMarker.Id> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.RoleProjectionOfPredicateMarker.Id = try {
                Id(
                    RoleIdProjectionOfPredicateMarker.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.RoleProjectionOfPredicateMarker.Id,
            ): Unit = try {
                RoleIdProjectionOfPredicateMarker.write(writer, instance.roleIdProjectionOfPredicateMarker)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<RoleProjectionOfPredicateMarker>,
        ScaleWriter<RoleProjectionOfPredicateMarker> {
        override fun read(reader: ScaleCodecReader): RoleProjectionOfPredicateMarker = when (val discriminant = reader.readUByte()) {
            0 -> Atom.read(reader)
            1 -> Id.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: RoleProjectionOfPredicateMarker) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Atom.write(writer, instance as Atom)
                1 -> Id.write(writer, instance as Id)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
