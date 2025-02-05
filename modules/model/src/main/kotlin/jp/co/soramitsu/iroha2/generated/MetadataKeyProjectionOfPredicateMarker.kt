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
 * MetadataKeyProjectionOfPredicateMarker
 *
 * Generated from 'MetadataKeyProjectionOfPredicateMarker' regular structure
 */
public data class MetadataKeyProjectionOfPredicateMarker(
    public val key: Name,
    public val projection: JsonProjectionOfPredicateMarker,
) {
    public companion object :
        ScaleReader<MetadataKeyProjectionOfPredicateMarker>,
        ScaleWriter<MetadataKeyProjectionOfPredicateMarker> {
        override fun read(reader: ScaleCodecReader): MetadataKeyProjectionOfPredicateMarker =
            try {
                MetadataKeyProjectionOfPredicateMarker(
                    Name.read(reader),
                    JsonProjectionOfPredicateMarker.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: MetadataKeyProjectionOfPredicateMarker,
        ): Unit =
            try {
                Name.write(writer, instance.key)
                JsonProjectionOfPredicateMarker.write(writer, instance.projection)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
