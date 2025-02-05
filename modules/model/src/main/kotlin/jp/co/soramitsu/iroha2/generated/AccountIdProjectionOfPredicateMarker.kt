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
 * AccountIdProjectionOfPredicateMarker
 *
 * Generated from 'AccountIdProjectionOfPredicateMarker' enum
 */
public sealed class AccountIdProjectionOfPredicateMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(
        public val accountIdPredicateAtom: AccountIdPredicateAtom,
    ) : AccountIdProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfPredicateMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfPredicateMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfPredicateMarker.Atom =
                try {
                    Atom(
                        AccountIdPredicateAtom.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfPredicateMarker.Atom,
            ): Unit =
                try {
                    AccountIdPredicateAtom.write(writer, instance.accountIdPredicateAtom)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Domain' variant
     */
    public data class Domain(
        public val domainIdProjectionOfPredicateMarker: DomainIdProjectionOfPredicateMarker,
    ) : AccountIdProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfPredicateMarker.Domain>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfPredicateMarker.Domain> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfPredicateMarker.Domain =
                try {
                    Domain(
                        DomainIdProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfPredicateMarker.Domain,
            ): Unit =
                try {
                    DomainIdProjectionOfPredicateMarker.write(writer, instance.domainIdProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Signatory' variant
     */
    public data class Signatory(
        public val publicKeyProjectionOfPredicateMarker: PublicKeyProjectionOfPredicateMarker,
    ) : AccountIdProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfPredicateMarker.Signatory>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfPredicateMarker.Signatory> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfPredicateMarker.Signatory =
                try {
                    Signatory(
                        PublicKeyProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AccountIdProjectionOfPredicateMarker.Signatory,
            ): Unit =
                try {
                    PublicKeyProjectionOfPredicateMarker.write(writer, instance.publicKeyProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<AccountIdProjectionOfPredicateMarker>,
        ScaleWriter<AccountIdProjectionOfPredicateMarker> {
        override fun read(reader: ScaleCodecReader): AccountIdProjectionOfPredicateMarker =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> Domain.read(reader)
                2 -> Signatory.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: AccountIdProjectionOfPredicateMarker,
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
