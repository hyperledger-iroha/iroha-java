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
 * ExecutorUpgrade
 *
 * Generated from 'ExecutorUpgrade' regular structure
 */
public data class ExecutorUpgrade(
    public val newDataModel: ExecutorDataModel,
) {
    public companion object : ScaleReader<ExecutorUpgrade>, ScaleWriter<ExecutorUpgrade> {
        override fun read(reader: ScaleCodecReader): ExecutorUpgrade = try {
            ExecutorUpgrade(
                ExecutorDataModel.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: ExecutorUpgrade): Unit = try {
            ExecutorDataModel.write(writer, instance.newDataModel)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
