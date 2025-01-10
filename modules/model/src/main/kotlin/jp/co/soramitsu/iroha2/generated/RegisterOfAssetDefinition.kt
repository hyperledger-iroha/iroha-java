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
 * RegisterOfAssetDefinition
 *
 * Generated from 'RegisterOfAssetDefinition' regular structure
 */
public data class RegisterOfAssetDefinition(
    public val `object`: NewAssetDefinition,
) {
    public companion object :
        ScaleReader<RegisterOfAssetDefinition>,
        ScaleWriter<RegisterOfAssetDefinition> {
        override fun read(reader: ScaleCodecReader): RegisterOfAssetDefinition = try {
            RegisterOfAssetDefinition(
                NewAssetDefinition.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: RegisterOfAssetDefinition): Unit = try {
            NewAssetDefinition.write(writer, instance.`object`)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
