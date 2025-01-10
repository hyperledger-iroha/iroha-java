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
 * SignedBlockPredicateBox
 *
 * Generated from 'SignedBlockPredicateBox' enum
 */
public sealed class SignedBlockPredicateBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Header' variant
     */
    public data class Header(
        public val blockHeaderPredicateBox: BlockHeaderPredicateBox,
    ) : SignedBlockPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.SignedBlockPredicateBox.Header>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.SignedBlockPredicateBox.Header> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.SignedBlockPredicateBox.Header = try {
                Header(
                    BlockHeaderPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.SignedBlockPredicateBox.Header,
            ): Unit = try {
                BlockHeaderPredicateBox.write(writer, instance.blockHeaderPredicateBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<SignedBlockPredicateBox>,
        ScaleWriter<SignedBlockPredicateBox> {
        override fun read(reader: ScaleCodecReader): SignedBlockPredicateBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Header.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: SignedBlockPredicateBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Header.write(writer, instance as Header)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
