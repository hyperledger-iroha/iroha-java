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
 * SmartContractParameters
 *
 * Generated from 'SmartContractParameters' regular structure
 */
public data class SmartContractParameters(
    public val fuel: NonZeroOfu64,
    public val memory: NonZeroOfu64,
) {
    public companion object :
        ScaleReader<SmartContractParameters>,
        ScaleWriter<SmartContractParameters> {
        override fun read(reader: ScaleCodecReader): SmartContractParameters = try {
            SmartContractParameters(
                NonZeroOfu64.read(reader),
                NonZeroOfu64.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: SmartContractParameters): Unit = try {
            NonZeroOfu64.write(writer, instance.fuel)
            NonZeroOfu64.write(writer, instance.memory)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
