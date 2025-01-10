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
 * RemoveKeyValueOfTrigger
 *
 * Generated from 'RemoveKeyValueOfTrigger' regular structure
 */
public data class RemoveKeyValueOfTrigger(
    public val `object`: TriggerId,
    public val key: Name,
) {
    public companion object :
        ScaleReader<RemoveKeyValueOfTrigger>,
        ScaleWriter<RemoveKeyValueOfTrigger> {
        override fun read(reader: ScaleCodecReader): RemoveKeyValueOfTrigger = try {
            RemoveKeyValueOfTrigger(
                TriggerId.read(reader),
                Name.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: RemoveKeyValueOfTrigger): Unit = try {
            TriggerId.write(writer, instance.`object`)
            Name.write(writer, instance.key)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
