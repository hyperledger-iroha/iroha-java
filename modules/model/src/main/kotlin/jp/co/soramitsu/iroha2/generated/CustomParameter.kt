//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.String
import kotlin.Unit

/**
 * CustomParameter
 *
 * Generated from 'CustomParameter' regular structure
 */
public data class CustomParameter(
    public val id: CustomParameterId,
    public val payload: String,
) {
    public companion object : ScaleReader<CustomParameter>, ScaleWriter<CustomParameter> {
        override fun read(reader: ScaleCodecReader): CustomParameter = try {
            CustomParameter(
                CustomParameterId.read(reader),
                reader.readString(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: CustomParameter): Unit = try {
            CustomParameterId.write(writer, instance.id)
            writer.writeAsList(instance.payload.toByteArray(Charsets.UTF_8))
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
