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
 * SetParameter
 *
 * Generated from 'SetParameter' regular structure
 */
public data class SetParameter(
    public val parameter: Parameter,
) {
    public companion object : ScaleReader<SetParameter>, ScaleWriter<SetParameter> {
        override fun read(reader: ScaleCodecReader): SetParameter = try {
            SetParameter(
                Parameter.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: SetParameter): Unit = try {
            Parameter.write(writer, instance.parameter)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
