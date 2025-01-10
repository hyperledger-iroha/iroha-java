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
 * ParameterChanged
 *
 * Generated from 'ParameterChanged' regular structure
 */
public data class ParameterChanged(
    public val oldValue: Parameter,
    public val newValue: Parameter,
) {
    public companion object : ScaleReader<ParameterChanged>, ScaleWriter<ParameterChanged> {
        override fun read(reader: ScaleCodecReader): ParameterChanged = try {
            ParameterChanged(
                Parameter.read(reader),
                Parameter.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: ParameterChanged): Unit = try {
            Parameter.write(writer, instance.oldValue)
            Parameter.write(writer, instance.newValue)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
