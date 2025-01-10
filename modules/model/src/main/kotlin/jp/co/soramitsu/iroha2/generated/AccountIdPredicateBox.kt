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
 * AccountIdPredicateBox
 *
 * Generated from 'AccountIdPredicateBox' enum
 */
public sealed class AccountIdPredicateBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Equals' variant
     */
    public data class Equals(
        public val accountId: AccountId,
    ) : AccountIdPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AccountIdPredicateBox.Equals>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AccountIdPredicateBox.Equals> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AccountIdPredicateBox.Equals = try {
                Equals(
                    AccountId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AccountIdPredicateBox.Equals,
            ): Unit = try {
                AccountId.write(writer, instance.accountId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'DomainId' variant
     */
    public data class DomainId(
        public val domainIdPredicateBox: DomainIdPredicateBox,
    ) : AccountIdPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AccountIdPredicateBox.DomainId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AccountIdPredicateBox.DomainId> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AccountIdPredicateBox.DomainId = try {
                DomainId(
                    DomainIdPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AccountIdPredicateBox.DomainId,
            ): Unit = try {
                DomainIdPredicateBox.write(writer, instance.domainIdPredicateBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Signatory' variant
     */
    public data class Signatory(
        public val publicKeyPredicateBox: PublicKeyPredicateBox,
    ) : AccountIdPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AccountIdPredicateBox.Signatory>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AccountIdPredicateBox.Signatory> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AccountIdPredicateBox.Signatory = try {
                Signatory(
                    PublicKeyPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AccountIdPredicateBox.Signatory,
            ): Unit = try {
                PublicKeyPredicateBox.write(writer, instance.publicKeyPredicateBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<AccountIdPredicateBox>, ScaleWriter<AccountIdPredicateBox> {
        override fun read(reader: ScaleCodecReader): AccountIdPredicateBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Equals.read(reader)
            1 -> DomainId.read(reader)
            2 -> Signatory.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: AccountIdPredicateBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Equals.write(writer, instance as Equals)
                1 -> DomainId.write(writer, instance as DomainId)
                2 -> Signatory.write(writer, instance as Signatory)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
