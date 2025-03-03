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
 * AccountIdProjectionOfSelectorMarker
 *
 * Generated from 'AccountIdProjectionOfSelectorMarker' enum
 */
public sealed class AccountIdProjectionOfSelectorMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    override fun equals(other: Any?): Boolean =
        when (this) {
            is Atom -> Atom.equals(this, other)
            else -> super.equals(other)
        }

    override fun hashCode(): Int =
        when (this) {
            is Atom -> Atom.hashCode()
            else -> super.hashCode()
        }

    /**
     * 'Atom' variant
     */
    public class Atom : AccountIdProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfSelectorMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfSelectorMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfSelectorMarker.Atom =
                try {
                    Atom()
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfSelectorMarker.Atom,
            ): Unit =
                try {
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            public fun equals(
                o1: jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfSelectorMarker.Atom,
                o2: Any?,
            ): Boolean =
                when (o2) {
                    null -> false
                    else -> o2::class == o1::class
                }

            override fun hashCode(): Int = ".AccountIdProjectionOfSelectorMarker.Atom".hashCode()
        }
    }

    /**
     * 'Domain' variant
     */
    public data class Domain(
        public val domainIdProjectionOfSelectorMarker: DomainIdProjectionOfSelectorMarker,
    ) : AccountIdProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfSelectorMarker.Domain>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfSelectorMarker.Domain> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfSelectorMarker.Domain =
                try {
                    Domain(
                        DomainIdProjectionOfSelectorMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfSelectorMarker.Domain,
            ): Unit =
                try {
                    DomainIdProjectionOfSelectorMarker.write(writer, instance.domainIdProjectionOfSelectorMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Signatory' variant
     */
    public data class Signatory(
        public val publicKeyProjectionOfSelectorMarker: PublicKeyProjectionOfSelectorMarker,
    ) : AccountIdProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfSelectorMarker.Signatory>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfSelectorMarker.Signatory> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfSelectorMarker.Signatory =
                try {
                    Signatory(
                        PublicKeyProjectionOfSelectorMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfSelectorMarker.Signatory,
            ): Unit =
                try {
                    PublicKeyProjectionOfSelectorMarker.write(writer, instance.publicKeyProjectionOfSelectorMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<AccountIdProjectionOfSelectorMarker>,
        ScaleWriter<AccountIdProjectionOfSelectorMarker> {
        override fun read(reader: ScaleCodecReader): AccountIdProjectionOfSelectorMarker =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> Domain.read(reader)
                2 -> Signatory.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: AccountIdProjectionOfSelectorMarker,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Atom.write(writer, instance as Atom)
                1 -> Domain.write(writer, instance as Domain)
                2 -> Signatory.write(writer, instance as Signatory)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
