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
 * TriggerProjectionOfPredicateMarker
 *
 * Generated from 'TriggerProjectionOfPredicateMarker' enum
 */
public sealed class TriggerProjectionOfPredicateMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(
        public val triggerPredicateAtom: TriggerPredicateAtom,
    ) : TriggerProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TriggerProjectionOfPredicateMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TriggerProjectionOfPredicateMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TriggerProjectionOfPredicateMarker.Atom =
                try {
                    Atom(
                        TriggerPredicateAtom.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TriggerProjectionOfPredicateMarker.Atom,
            ): Unit =
                try {
                    TriggerPredicateAtom.write(writer, instance.triggerPredicateAtom)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Id' variant
     */
    public data class Id(
        public val triggerIdProjectionOfPredicateMarker: TriggerIdProjectionOfPredicateMarker,
    ) : TriggerProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TriggerProjectionOfPredicateMarker.Id>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TriggerProjectionOfPredicateMarker.Id> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TriggerProjectionOfPredicateMarker.Id =
                try {
                    Id(
                        TriggerIdProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TriggerProjectionOfPredicateMarker.Id,
            ): Unit =
                try {
                    TriggerIdProjectionOfPredicateMarker.write(writer, instance.triggerIdProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Action' variant
     */
    public data class Action(
        public val actionProjectionOfPredicateMarker: ActionProjectionOfPredicateMarker,
    ) : TriggerProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.TriggerProjectionOfPredicateMarker.Action>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.TriggerProjectionOfPredicateMarker.Action> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.TriggerProjectionOfPredicateMarker.Action =
                try {
                    Action(
                        ActionProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.TriggerProjectionOfPredicateMarker.Action,
            ): Unit =
                try {
                    ActionProjectionOfPredicateMarker.write(writer, instance.actionProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<TriggerProjectionOfPredicateMarker>,
        ScaleWriter<TriggerProjectionOfPredicateMarker> {
        override fun read(reader: ScaleCodecReader): TriggerProjectionOfPredicateMarker =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> Id.read(reader)
                2 -> Action.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: TriggerProjectionOfPredicateMarker,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Atom.write(writer, instance as Atom)
                1 -> Id.write(writer, instance as Id)
                2 -> Action.write(writer, instance as Action)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
