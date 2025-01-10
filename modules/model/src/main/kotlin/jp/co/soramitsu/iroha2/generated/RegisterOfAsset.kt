//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Unit

/**
 * RegisterOfAsset
 *
 * Generated from 'RegisterOfAsset' regular structure
 */
public data class RegisterOfAsset(
    public val `object`: Asset,
) {
    public companion object : ScaleReader<RegisterOfAsset>, ScaleWriter<RegisterOfAsset> {
        override fun read(reader: ScaleCodecReader): RegisterOfAsset = try {
            RegisterOfAsset(
                Asset.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: RegisterOfAsset): Unit = try {
            Asset.write(writer, instance.`object`)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
