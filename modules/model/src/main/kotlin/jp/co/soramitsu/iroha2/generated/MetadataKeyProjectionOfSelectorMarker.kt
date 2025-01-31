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
 * MetadataKeyProjectionOfSelectorMarker
 *
 * Generated from 'MetadataKeyProjectionOfSelectorMarker' regular structure
 */
public data class MetadataKeyProjectionOfSelectorMarker(public val key: Name, public val projection: JsonProjectionOfSelectorMarker) {
    public companion object :
        ScaleReader<MetadataKeyProjectionOfSelectorMarker>,
        ScaleWriter<MetadataKeyProjectionOfSelectorMarker> {
        override fun read(reader: ScaleCodecReader): MetadataKeyProjectionOfSelectorMarker = try {
            MetadataKeyProjectionOfSelectorMarker(
                Name.read(reader),
                JsonProjectionOfSelectorMarker.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: MetadataKeyProjectionOfSelectorMarker): Unit = try {
            Name.write(writer, instance.key)
            JsonProjectionOfSelectorMarker.write(writer, instance.projection)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
