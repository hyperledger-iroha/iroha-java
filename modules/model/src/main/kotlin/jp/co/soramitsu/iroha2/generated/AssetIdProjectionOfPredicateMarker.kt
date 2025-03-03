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
 * AssetIdProjectionOfPredicateMarker
 *
 * Generated from 'AssetIdProjectionOfPredicateMarker' enum
 */
public sealed class AssetIdProjectionOfPredicateMarker : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Atom' variant
     */
    public data class Atom(
        public val assetIdPredicateAtom: AssetIdPredicateAtom,
    ) : AssetIdProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfPredicateMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfPredicateMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfPredicateMarker.Atom =
                try {
                    Atom(
                        AssetIdPredicateAtom.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfPredicateMarker.Atom,
            ): Unit =
                try {
                    AssetIdPredicateAtom.write(writer, instance.assetIdPredicateAtom)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Account' variant
     */
    public data class Account(
        public val accountIdProjectionOfPredicateMarker: AccountIdProjectionOfPredicateMarker,
    ) : AssetIdProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfPredicateMarker.Account>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfPredicateMarker.Account> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfPredicateMarker.Account =
                try {
                    Account(
                        AccountIdProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfPredicateMarker.Account,
            ): Unit =
                try {
                    AccountIdProjectionOfPredicateMarker.write(writer, instance.accountIdProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Definition' variant
     */
    public data class Definition(
        public val assetDefinitionIdProjectionOfPredicateMarker: AssetDefinitionIdProjectionOfPredicateMarker,
    ) : AssetIdProjectionOfPredicateMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfPredicateMarker.Definition>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfPredicateMarker.Definition> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfPredicateMarker.Definition =
                try {
                    Definition(
                        AssetDefinitionIdProjectionOfPredicateMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfPredicateMarker.Definition,
            ): Unit =
                try {
                    AssetDefinitionIdProjectionOfPredicateMarker.write(writer, instance.assetDefinitionIdProjectionOfPredicateMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<AssetIdProjectionOfPredicateMarker>,
        ScaleWriter<AssetIdProjectionOfPredicateMarker> {
        override fun read(reader: ScaleCodecReader): AssetIdProjectionOfPredicateMarker =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> Account.read(reader)
                2 -> Definition.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: AssetIdProjectionOfPredicateMarker,
        ) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Atom.write(writer, instance as Atom)
                1 -> Account.write(writer, instance as Account)
                2 -> Definition.write(writer, instance as Definition)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }
        }
    }
}
