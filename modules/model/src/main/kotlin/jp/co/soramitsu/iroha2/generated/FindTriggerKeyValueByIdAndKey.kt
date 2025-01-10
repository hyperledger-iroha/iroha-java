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
 * FindTriggerKeyValueByIdAndKey
 *
 * Generated from 'FindTriggerKeyValueByIdAndKey' regular structure
 */
public data class FindTriggerKeyValueByIdAndKey(
    public val id: TriggerId,
    public val key: Name,
) {
    public companion object :
        ScaleReader<FindTriggerKeyValueByIdAndKey>,
        ScaleWriter<FindTriggerKeyValueByIdAndKey> {
        override fun read(reader: ScaleCodecReader): FindTriggerKeyValueByIdAndKey = try {
            FindTriggerKeyValueByIdAndKey(
                TriggerId.read(reader),
                Name.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: FindTriggerKeyValueByIdAndKey): Unit =
            try {
                TriggerId.write(writer, instance.id)
                Name.write(writer, instance.key)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
