//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.ModelPermission
import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Unit

/**
 * CanRegisterAsset
 *
 * Generated from 'CanRegisterAsset' regular structure
 */
public data class CanRegisterAsset(
    public val owner: AccountId,
) : ModelPermission {
    public companion object : ScaleReader<CanRegisterAsset>, ScaleWriter<CanRegisterAsset> {
        override fun read(reader: ScaleCodecReader): CanRegisterAsset = try {
            CanRegisterAsset(
                AccountId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CanRegisterAsset): Unit = try {
            AccountId.write(writer, instance.owner)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
