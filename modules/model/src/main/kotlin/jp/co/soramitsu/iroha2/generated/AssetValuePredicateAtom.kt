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
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Unit

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

    override fun equals(other: Any?): Boolean =
        when (this) {
            is IsNumeric -> IsNumeric.equals(this, other)
            is IsStore -> IsStore.equals(this, other)
            else -> super.equals(other)
        }

    override fun hashCode(): Int =
        when (this) {
            is IsNumeric -> IsNumeric.hashCode()
            is IsStore -> IsStore.hashCode()
            else -> super.hashCode()
        }

    /**
     * 'IsNumeric' variant
     */
    public class IsNumeric : AssetValuePredicateAtom() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetValuePredicateAtom.IsNumeric>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetValuePredicateAtom.IsNumeric> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetValuePredicateAtom.IsNumeric =
                try {
                    IsNumeric()
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetValuePredicateAtom.IsNumeric,
            ): Unit =
                try {
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            public fun equals(
                o1: jp.co.soramitsu.iroha2.generated.AssetValuePredicateAtom.IsNumeric,
                o2: Any?,
            ): Boolean =
                when (o2) {
                    null -> false
                    else -> o2::class == o1::class
                }

            override fun hashCode(): Int = ".AssetValuePredicateAtom.IsNumeric".hashCode()
        }
    }

    /**
     * 'IsStore' variant
     */
    public class IsStore : AssetValuePredicateAtom() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetValuePredicateAtom.IsStore>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetValuePredicateAtom.IsStore> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetValuePredicateAtom.IsStore =
                try {
                    IsStore()
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetValuePredicateAtom.IsStore,
            ): Unit =
                try {
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            public fun equals(
                o1: jp.co.soramitsu.iroha2.generated.AssetValuePredicateAtom.IsStore,
                o2: Any?,
            ): Boolean =
                when (o2) {
                    null -> false
                    else -> o2::class == o1::class
                }

            override fun hashCode(): Int = ".AssetValuePredicateAtom.IsStore".hashCode()
        }
    }

    public companion object :
        ScaleReader<AssetValuePredicateAtom>,
        ScaleWriter<AssetValuePredicateAtom> {
        override fun read(reader: ScaleCodecReader): AssetValuePredicateAtom =
            when (val discriminant = reader.readUByte()) {
                0 -> IsNumeric.read(reader)
                1 -> IsStore.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: AssetValuePredicateAtom,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> IsNumeric.write(writer, instance as IsNumeric)
                1 -> IsStore.write(writer, instance as IsStore)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
