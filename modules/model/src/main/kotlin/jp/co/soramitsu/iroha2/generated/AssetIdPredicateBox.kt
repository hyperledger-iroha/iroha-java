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
 * AssetIdPredicateBox
 *
 * Generated from 'AssetIdPredicateBox' enum
 */
public sealed class AssetIdPredicateBox : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Equals' variant
     */
    public data class Equals(
        public val assetId: AssetId,
    ) : AssetIdPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetIdPredicateBox.Equals>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetIdPredicateBox.Equals> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetIdPredicateBox.Equals = try {
                Equals(
                    AssetId.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetIdPredicateBox.Equals,
            ): Unit = try {
                AssetId.write(writer, instance.assetId)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'DefinitionId' variant
     */
    public data class DefinitionId(
        public val assetDefinitionIdPredicateBox: AssetDefinitionIdPredicateBox,
    ) : AssetIdPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetIdPredicateBox.DefinitionId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetIdPredicateBox.DefinitionId> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetIdPredicateBox.DefinitionId = try {
                DefinitionId(
                    AssetDefinitionIdPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetIdPredicateBox.DefinitionId,
            ): Unit = try {
                AssetDefinitionIdPredicateBox.write(writer, instance.assetDefinitionIdPredicateBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'AccountId' variant
     */
    public data class AccountId(
        public val accountIdPredicateBox: AccountIdPredicateBox,
    ) : AssetIdPredicateBox() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.AssetIdPredicateBox.AccountId>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.AssetIdPredicateBox.AccountId> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.AssetIdPredicateBox.AccountId = try {
                AccountId(
                    AccountIdPredicateBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.AssetIdPredicateBox.AccountId,
            ): Unit = try {
                AccountIdPredicateBox.write(writer, instance.accountIdPredicateBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<AssetIdPredicateBox>, ScaleWriter<AssetIdPredicateBox> {
        override fun read(reader: ScaleCodecReader): AssetIdPredicateBox = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Equals.read(reader)
            1 -> DefinitionId.read(reader)
            2 -> AccountId.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: AssetIdPredicateBox) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Equals.write(writer, instance as Equals)
                1 -> DefinitionId.write(writer, instance as DefinitionId)
                2 -> AccountId.write(writer, instance as AccountId)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
