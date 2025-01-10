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
 * CustomParameterId
 *
 * Generated from 'CustomParameterId' regular structure
 */
public data class CustomParameterId(
    public val name: Name,
) {
    public companion object : ScaleReader<CustomParameterId>, ScaleWriter<CustomParameterId> {
        override fun read(reader: ScaleCodecReader): CustomParameterId = try {
            CustomParameterId(
                Name.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CustomParameterId): Unit = try {
            Name.write(writer, instance.name)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
