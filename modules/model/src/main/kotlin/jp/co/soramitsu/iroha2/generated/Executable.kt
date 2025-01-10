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
import kotlin.collections.List

/**
 * Executable
 *
 * Generated from 'Executable' enum
 */
public sealed class Executable : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Instructions' variant
     */
    public data class Instructions(
        public val vec: List<InstructionBox>,
    ) : Executable() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.Executable.Instructions>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.Executable.Instructions> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.Executable.Instructions = try {
                Instructions(
                    reader.readVec(reader.readCompactInt()) { InstructionBox.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.Executable.Instructions,
            ): Unit = try {
                writer.writeCompact(instance.vec.size)
                instance.vec.forEach { value ->
                    InstructionBox.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Wasm' variant
     */
    public data class Wasm(
        public val wasmSmartContract: WasmSmartContract,
    ) : Executable() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.Executable.Wasm>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.Executable.Wasm> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.Executable.Wasm = try {
                Wasm(
                    WasmSmartContract.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.Executable.Wasm,
            ): Unit = try {
                WasmSmartContract.write(writer, instance.wasmSmartContract)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<Executable>, ScaleWriter<Executable> {
        override fun read(reader: ScaleCodecReader): Executable = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Instructions.read(reader)
            1 -> Wasm.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: Executable) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Instructions.write(writer, instance as Instructions)
                1 -> Wasm.write(writer, instance as Wasm)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
