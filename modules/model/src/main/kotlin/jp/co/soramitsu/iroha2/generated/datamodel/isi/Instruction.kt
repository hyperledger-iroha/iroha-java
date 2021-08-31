//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated.datamodel.isi

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import io.emeraldpay.polkaj.scale.ScaleReader
import io.emeraldpay.polkaj.scale.ScaleWriter
import kotlin.Int

/**
 * Instruction
 *
 * Generated from 'iroha_data_model::isi::Instruction' enum
 */
public sealed class Instruction {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Register' variant
     */
    public data class Register(
        public val registerBox: RegisterBox
    ) : Instruction() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<Register>, ScaleWriter<Register> {
            public const val DISCRIMINANT: Int = 0

            public override fun read(reader: ScaleCodecReader): Register = Register(
                RegisterBox.read(reader),
            )

            public override fun write(writer: ScaleCodecWriter, instance: Register) {
                RegisterBox.write(writer, instance.registerBox)
            }
        }
    }

    /**
     * 'Unregister' variant
     */
    public data class Unregister(
        public val unregisterBox: UnregisterBox
    ) : Instruction() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<Unregister>, ScaleWriter<Unregister> {
            public const val DISCRIMINANT: Int = 1

            public override fun read(reader: ScaleCodecReader): Unregister = Unregister(
                UnregisterBox.read(reader),
            )

            public override fun write(writer: ScaleCodecWriter, instance: Unregister) {
                UnregisterBox.write(writer, instance.unregisterBox)
            }
        }
    }

    /**
     * 'Mint' variant
     */
    public data class Mint(
        public val mintBox: MintBox
    ) : Instruction() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<Mint>, ScaleWriter<Mint> {
            public const val DISCRIMINANT: Int = 2

            public override fun read(reader: ScaleCodecReader): Mint = Mint(
                MintBox.read(reader),
            )

            public override fun write(writer: ScaleCodecWriter, instance: Mint) {
                MintBox.write(writer, instance.mintBox)
            }
        }
    }

    /**
     * 'Burn' variant
     */
    public data class Burn(
        public val burnBox: BurnBox
    ) : Instruction() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<Burn>, ScaleWriter<Burn> {
            public const val DISCRIMINANT: Int = 3

            public override fun read(reader: ScaleCodecReader): Burn = Burn(
                BurnBox.read(reader),
            )

            public override fun write(writer: ScaleCodecWriter, instance: Burn) {
                BurnBox.write(writer, instance.burnBox)
            }
        }
    }

    /**
     * 'Transfer' variant
     */
    public data class Transfer(
        public val transferBox: TransferBox
    ) : Instruction() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<Transfer>, ScaleWriter<Transfer> {
            public const val DISCRIMINANT: Int = 4

            public override fun read(reader: ScaleCodecReader): Transfer = Transfer(
                TransferBox.read(reader),
            )

            public override fun write(writer: ScaleCodecWriter, instance: Transfer) {
                TransferBox.write(writer, instance.transferBox)
            }
        }
    }

    /**
     * 'If' variant
     */
    public data class If(
        public val `if`: jp.co.soramitsu.iroha2.generated.datamodel.isi.If
    ) : Instruction() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<If>, ScaleWriter<If> {
            public const val DISCRIMINANT: Int = 5

            public override fun read(reader: ScaleCodecReader): If = If(
                jp.co.soramitsu.iroha2.generated.datamodel.isi.If.read(reader),
            )

            public override fun write(writer: ScaleCodecWriter, instance: If) {
                jp.co.soramitsu.iroha2.generated.datamodel.isi.If.write(writer, instance.`if`)
            }
        }
    }

    /**
     * 'Pair' variant
     */
    public data class Pair(
        public val pair: jp.co.soramitsu.iroha2.generated.datamodel.isi.Pair
    ) : Instruction() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<Pair>, ScaleWriter<Pair> {
            public const val DISCRIMINANT: Int = 6

            public override fun read(reader: ScaleCodecReader): Pair = Pair(
                jp.co.soramitsu.iroha2.generated.datamodel.isi.Pair.read(reader),
            )

            public override fun write(writer: ScaleCodecWriter, instance: Pair) {
                jp.co.soramitsu.iroha2.generated.datamodel.isi.Pair.write(writer, instance.pair)
            }
        }
    }

    /**
     * 'Sequence' variant
     */
    public data class Sequence(
        public val sequenceBox: SequenceBox
    ) : Instruction() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<Sequence>, ScaleWriter<Sequence> {
            public const val DISCRIMINANT: Int = 7

            public override fun read(reader: ScaleCodecReader): Sequence = Sequence(
                SequenceBox.read(reader),
            )

            public override fun write(writer: ScaleCodecWriter, instance: Sequence) {
                SequenceBox.write(writer, instance.sequenceBox)
            }
        }
    }

    /**
     * 'Fail' variant
     */
    public data class Fail(
        public val failBox: FailBox
    ) : Instruction() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<Fail>, ScaleWriter<Fail> {
            public const val DISCRIMINANT: Int = 8

            public override fun read(reader: ScaleCodecReader): Fail = Fail(
                FailBox.read(reader),
            )

            public override fun write(writer: ScaleCodecWriter, instance: Fail) {
                FailBox.write(writer, instance.failBox)
            }
        }
    }

    /**
     * 'SetKeyValue' variant
     */
    public data class SetKeyValue(
        public val setKeyValueBox: SetKeyValueBox
    ) : Instruction() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<SetKeyValue>, ScaleWriter<SetKeyValue> {
            public const val DISCRIMINANT: Int = 9

            public override fun read(reader: ScaleCodecReader): SetKeyValue = SetKeyValue(
                SetKeyValueBox.read(reader),
            )

            public override fun write(writer: ScaleCodecWriter, instance: SetKeyValue) {
                SetKeyValueBox.write(writer, instance.setKeyValueBox)
            }
        }
    }

    /**
     * 'RemoveKeyValue' variant
     */
    public data class RemoveKeyValue(
        public val removeKeyValueBox: RemoveKeyValueBox
    ) : Instruction() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<RemoveKeyValue>, ScaleWriter<RemoveKeyValue> {
            public const val DISCRIMINANT: Int = 10

            public override fun read(reader: ScaleCodecReader): RemoveKeyValue = RemoveKeyValue(
                RemoveKeyValueBox.read(reader),
            )

            public override fun write(writer: ScaleCodecWriter, instance: RemoveKeyValue) {
                RemoveKeyValueBox.write(writer, instance.removeKeyValueBox)
            }
        }
    }

    /**
     * 'Grant' variant
     */
    public data class Grant(
        public val grantBox: GrantBox
    ) : Instruction() {
        public override fun discriminant(): Int = DISCRIMINANT

        public companion object : ScaleReader<Grant>, ScaleWriter<Grant> {
            public const val DISCRIMINANT: Int = 11

            public override fun read(reader: ScaleCodecReader): Grant = Grant(
                GrantBox.read(reader),
            )

            public override fun write(writer: ScaleCodecWriter, instance: Grant) {
                GrantBox.write(writer, instance.grantBox)
            }
        }
    }

    public companion object : ScaleReader<Instruction>, ScaleWriter<Instruction> {
        public override fun read(reader: ScaleCodecReader): Instruction = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Register.read(reader)
            1 -> Unregister.read(reader)
            2 -> Mint.read(reader)
            3 -> Burn.read(reader)
            4 -> Transfer.read(reader)
            5 -> If.read(reader)
            6 -> Pair.read(reader)
            7 -> Sequence.read(reader)
            8 -> Fail.read(reader)
            9 -> SetKeyValue.read(reader)
            10 -> RemoveKeyValue.read(reader)
            11 -> Grant.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        public override fun write(writer: ScaleCodecWriter, instance: Instruction) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Register.write(writer, instance as Register)
                1 -> Unregister.write(writer, instance as Unregister)
                2 -> Mint.write(writer, instance as Mint)
                3 -> Burn.write(writer, instance as Burn)
                4 -> Transfer.write(writer, instance as Transfer)
                5 -> If.write(writer, instance as If)
                6 -> Pair.write(writer, instance as Pair)
                7 -> Sequence.write(writer, instance as Sequence)
                8 -> Fail.write(writer, instance as Fail)
                9 -> SetKeyValue.write(writer, instance as SetKeyValue)
                10 -> RemoveKeyValue.write(writer, instance as RemoveKeyValue)
                11 -> Grant.write(writer, instance as Grant)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
