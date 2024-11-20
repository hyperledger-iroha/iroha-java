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
 * Algorithm
 *
 * Generated from 'Algorithm' enum
 */
public sealed class Algorithm : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    override fun equals(other: Any?): Boolean = when (this) {
        is Ed25519 -> Ed25519.equals(this, other)
        is Secp256k1 -> Secp256k1.equals(this, other)
        is BlsNormal -> BlsNormal.equals(this, other)
        is BlsSmall -> BlsSmall.equals(this, other)
        else -> super.equals(other)
    }

    override fun hashCode(): Int = when (this) {
        is Ed25519 -> Ed25519.hashCode()
        is Secp256k1 -> Secp256k1.hashCode()
        is BlsNormal -> BlsNormal.hashCode()
        is BlsSmall -> BlsSmall.hashCode()
        else -> super.hashCode()
    }

    /**
     * 'Ed25519' variant
     */
    public class Ed25519 : Algorithm() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.Algorithm.Ed25519>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.Algorithm.Ed25519> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.Algorithm.Ed25519 = try {
                Ed25519()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.Algorithm.Ed25519): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.Algorithm.Ed25519, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".Algorithm.Ed25519".hashCode()
        }
    }

    /**
     * 'Secp256k1' variant
     */
    public class Secp256k1 : Algorithm() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.Algorithm.Secp256k1>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.Algorithm.Secp256k1> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.Algorithm.Secp256k1 = try {
                Secp256k1()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.Algorithm.Secp256k1): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.Algorithm.Secp256k1, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".Algorithm.Secp256k1".hashCode()
        }
    }

    /**
     * 'BlsNormal' variant
     */
    public class BlsNormal : Algorithm() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.Algorithm.BlsNormal>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.Algorithm.BlsNormal> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.Algorithm.BlsNormal = try {
                BlsNormal()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.Algorithm.BlsNormal): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.Algorithm.BlsNormal, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".Algorithm.BlsNormal".hashCode()
        }
    }

    /**
     * 'BlsSmall' variant
     */
    public class BlsSmall : Algorithm() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.Algorithm.BlsSmall>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.Algorithm.BlsSmall> {
            public const val DISCRIMINANT: Int = 3

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.Algorithm.BlsSmall = try {
                BlsSmall()
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(writer: ScaleCodecWriter, instance: jp.co.soramitsu.iroha2.generated.Algorithm.BlsSmall): Unit = try {
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            public fun equals(o1: jp.co.soramitsu.iroha2.generated.Algorithm.BlsSmall, o2: Any?): Boolean = when (o2) {
                null -> false
                else -> o2::class == o1::class
            }

            override fun hashCode(): Int = ".Algorithm.BlsSmall".hashCode()
        }
    }

    public companion object : ScaleReader<Algorithm>, ScaleWriter<Algorithm> {
        override fun read(reader: ScaleCodecReader): Algorithm = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Ed25519.read(reader)
            1 -> Secp256k1.read(reader)
            2 -> BlsNormal.read(reader)
            3 -> BlsSmall.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
        }

        override fun write(writer: ScaleCodecWriter, instance: Algorithm) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Ed25519.write(writer, instance as Ed25519)
                1 -> Secp256k1.write(writer, instance as Secp256k1)
                2 -> BlsNormal.write(writer, instance as BlsNormal)
                3 -> BlsSmall.write(writer, instance as BlsSmall)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
