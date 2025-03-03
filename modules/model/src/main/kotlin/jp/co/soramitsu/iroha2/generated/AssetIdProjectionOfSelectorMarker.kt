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
 * AssetIdProjectionOfSelectorMarker
 *
 * Generated from 'AssetIdProjectionOfSelectorMarker' enum
 */
public sealed class AssetIdProjectionOfSelectorMarker : ModelEnum {
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
    public class Atom : AssetIdProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfSelectorMarker.Atom>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfSelectorMarker.Atom> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfSelectorMarker.Atom =
                try {
                    Atom()
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfSelectorMarker.Atom,
            ): Unit =
                try {
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            public fun equals(
                o1: jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfSelectorMarker.Atom,
                o2: Any?,
            ): Boolean =
                when (o2) {
                    null -> false
                    else -> o2::class == o1::class
                }

            override fun hashCode(): Int = ".AssetIdProjectionOfSelectorMarker.Atom".hashCode()
        }
    }

    /**
     * 'Account' variant
     */
    public data class Account(
        public val accountIdProjectionOfSelectorMarker: AccountIdProjectionOfSelectorMarker,
    ) : AssetIdProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfSelectorMarker.Account>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfSelectorMarker.Account> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfSelectorMarker.Account =
                try {
                    Account(
                        AccountIdProjectionOfSelectorMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfSelectorMarker.Account,
            ): Unit =
                try {
                    AccountIdProjectionOfSelectorMarker.write(writer, instance.accountIdProjectionOfSelectorMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    /**
     * 'Definition' variant
     */
    public data class Definition(
        public val assetDefinitionIdProjectionOfSelectorMarker: AssetDefinitionIdProjectionOfSelectorMarker,
    ) : AssetIdProjectionOfSelectorMarker() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfSelectorMarker.Definition>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfSelectorMarker.Definition> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfSelectorMarker.Definition =
                try {
                    Definition(
                        AssetDefinitionIdProjectionOfSelectorMarker.read(reader),
                    )
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetIdProjectionOfSelectorMarker.Definition,
            ): Unit =
                try {
                    AssetDefinitionIdProjectionOfSelectorMarker.write(writer, instance.assetDefinitionIdProjectionOfSelectorMarker)
                } catch (ex: Exception) {
                    throw wrapException(ex)
                }
        }
    }

    public companion object :
        ScaleReader<AssetIdProjectionOfSelectorMarker>,
        ScaleWriter<AssetIdProjectionOfSelectorMarker> {
        override fun read(reader: ScaleCodecReader): AssetIdProjectionOfSelectorMarker =
            when (val discriminant = reader.readUByte()) {
                0 -> Atom.read(reader)
                1 -> Account.read(reader)
                2 -> Definition.read(reader)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant")
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: AssetIdProjectionOfSelectorMarker,
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
