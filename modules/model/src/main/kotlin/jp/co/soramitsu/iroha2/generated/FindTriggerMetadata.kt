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
 * FindTriggerMetadata
 *
 * Generated from 'FindTriggerMetadata' regular structure
 */
public data class FindTriggerMetadata(
    public val id: TriggerId,
    public val key: Name,
) {
    public companion object : ScaleReader<FindTriggerMetadata>, ScaleWriter<FindTriggerMetadata> {
        override fun read(reader: ScaleCodecReader): FindTriggerMetadata = try {
            FindTriggerMetadata(
                TriggerId.read(reader),
                Name.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: FindTriggerMetadata): Unit = try {
            TriggerId.write(writer, instance.id)
            Name.write(writer, instance.key)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
