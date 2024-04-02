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
 * MetadataChangedOfTriggerId
 *
 * Generated from 'MetadataChangedOfTriggerId' regular structure
 */
public data class MetadataChangedOfTriggerId(
    public val targetId: TriggerId,
    public val key: Name,
    public val `value`: Value,
) {
    public companion object :
        ScaleReader<MetadataChangedOfTriggerId>,
        ScaleWriter<MetadataChangedOfTriggerId> {
        override fun read(reader: ScaleCodecReader): MetadataChangedOfTriggerId = try {
            MetadataChangedOfTriggerId(
                TriggerId.read(reader),
                Name.read(reader),
                Value.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: MetadataChangedOfTriggerId): Unit = try {
            TriggerId.write(writer, instance.targetId)
            Name.write(writer, instance.key)
            Value.write(writer, instance.`value`)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
