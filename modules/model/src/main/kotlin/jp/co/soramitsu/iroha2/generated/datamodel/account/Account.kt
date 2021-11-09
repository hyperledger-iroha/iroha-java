//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated.datamodel.account

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.generated.crypto.PublicKey
import jp.co.soramitsu.iroha2.generated.datamodel.asset.Asset
import jp.co.soramitsu.iroha2.generated.datamodel.metadata.Metadata
import jp.co.soramitsu.iroha2.generated.datamodel.permissions.PermissionToken
import jp.co.soramitsu.iroha2.wrapException
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

/**
 * Account
 *
 * Generated from 'iroha_data_model::account::Account' regular structure
 */
public data class Account(
    public val id: Id,
    public val assets: Map<jp.co.soramitsu.iroha2.generated.datamodel.asset.Id, Asset>,
    public val signatories: List<PublicKey>,
    public val permissionTokens: Set<PermissionToken>,
    public val signatureCheckCondition: SignatureCheckCondition,
    public val metadata: Metadata
) {
    public companion object : ScaleReader<Account>, ScaleWriter<Account> {
        public override fun read(reader: ScaleCodecReader): Account = try {
            Account(
                Id.read(reader),
                reader.readMap(
                    reader.readCompactInt(),
                    { jp.co.soramitsu.iroha2.generated.datamodel.asset.Id.read(reader) },
                    { Asset.read(reader) }
                ),
                reader.readVec(reader.readCompactInt()) { PublicKey.read(reader) },
                reader.readSet(reader.readCompactInt()) { PermissionToken.read(reader) },
                SignatureCheckCondition.read(reader),
                Metadata.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        public override fun write(writer: ScaleCodecWriter, instance: Account) = try {
            Id.write(writer, instance.id)
            writer.writeCompact(instance.assets.size)
            instance.assets.forEach { (key, value) ->  
                jp.co.soramitsu.iroha2.generated.datamodel.asset.Id.write(writer, key)
                Asset.write(writer, value)
            }
            writer.writeCompact(instance.signatories.size)
            instance.signatories.forEach { value -> PublicKey.write(writer, value) }
            writer.writeCompact(instance.permissionTokens.size)
            instance.permissionTokens.forEach { value -> PermissionToken.write(writer, value) }
            SignatureCheckCondition.write(writer, instance.signatureCheckCondition)
            Metadata.write(writer, instance.metadata)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
