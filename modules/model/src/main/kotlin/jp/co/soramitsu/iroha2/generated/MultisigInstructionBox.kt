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
 * MultisigInstructionBox
 *
 * Generated from 'MultisigInstructionBox' enum
 */
public sealed class MultisigInstructionBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Register' variant
     */
    public data class Register(
        public val multisigRegister: MultisigRegister,
    ) : MultisigInstructionBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.MultisigInstructionBox.Register>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.MultisigInstructionBox.Register> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.MultisigInstructionBox.Register =
                try {
                    Register(
                        MultisigRegister.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.MultisigInstructionBox.Register,
            ): Unit =
                try {
                    MultisigRegister.write(writer, instance.multisigRegister)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Propose' variant
     */
    public data class Propose(
        public val multisigPropose: MultisigPropose,
    ) : MultisigInstructionBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.MultisigInstructionBox.Propose>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.MultisigInstructionBox.Propose> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.MultisigInstructionBox.Propose =
                try {
                    Propose(
                        MultisigPropose.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.MultisigInstructionBox.Propose,
            ): Unit =
                try {
                    MultisigPropose.write(writer, instance.multisigPropose)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Approve' variant
     */
    public data class Approve(
        public val multisigApprove: MultisigApprove,
    ) : MultisigInstructionBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.MultisigInstructionBox.Approve>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.MultisigInstructionBox.Approve> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.MultisigInstructionBox.Approve =
                try {
                    Approve(
                        MultisigApprove.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.MultisigInstructionBox.Approve,
            ): Unit =
                try {
                    MultisigApprove.write(writer, instance.multisigApprove)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<MultisigInstructionBox>,
        ScaleWriter<MultisigInstructionBox> {
        override fun read(reader: ScaleCodecReader): MultisigInstructionBox =
            when (val discriminant = reader.readUByte()) {
                0 -> Register.read(reader)
                1 -> Propose.read(reader)
                2 -> Approve.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: MultisigInstructionBox,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Register.write(writer, instance as Register)
                1 -> Propose.write(writer, instance as Propose)
                2 -> Approve.write(writer, instance as Approve)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
