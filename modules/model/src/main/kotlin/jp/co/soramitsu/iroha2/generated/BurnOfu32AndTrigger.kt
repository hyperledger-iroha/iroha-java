//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Long
import kotlin.Unit

/**
 * BurnOfu32AndTrigger
 *
 * Generated from 'BurnOfu32AndTrigger' regular structure
 */
public data class BurnOfu32AndTrigger(
    public val `object`: Long,
    public val destination: TriggerId,
) {
    public companion object : ScaleReader<BurnOfu32AndTrigger>, ScaleWriter<BurnOfu32AndTrigger> {
        override fun read(reader: ScaleCodecReader): BurnOfu32AndTrigger = try {
            BurnOfu32AndTrigger(
                reader.readUint32(),
                TriggerId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: BurnOfu32AndTrigger): Unit = try {
            writer.writeUint32(instance.`object`)
            TriggerId.write(writer, instance.destination)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
