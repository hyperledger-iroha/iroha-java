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
 * CustomParameter
 *
 * Generated from 'CustomParameter' regular structure
 */
public data class CustomParameter(
    public val id: CustomParameterId,
    public val payload: Json,
) {
    public companion object : ScaleReader<CustomParameter>, ScaleWriter<CustomParameter> {
        override fun read(reader: ScaleCodecReader): CustomParameter = try {
            CustomParameter(
                CustomParameterId.read(reader),
                Json.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CustomParameter): Unit = try {
            CustomParameterId.write(writer, instance.id)
            Json.write(writer, instance.payload)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
