//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.comparator
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Unit
import kotlin.collections.Map

/**
 * Metadata
 *
 * Generated from 'Metadata' regular structure
 */
public data class Metadata(public val sortedMapOfName: Map<Name, Json>) {
    public companion object : ScaleReader<Metadata>, ScaleWriter<Metadata> {
        override fun read(reader: ScaleCodecReader): Metadata = try {
            Metadata(
                reader.readMap(reader.readCompactInt(), { Name.read(reader) }, { Json.read(reader) }),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: Metadata): Unit = try {
            writer.writeCompact(instance.sortedMapOfName.size)
            instance.sortedMapOfName.toSortedMap(
                Name.comparator(),
            ).forEach { (key, value) ->
                Name.write(writer, key)
                Json.write(writer, value)
            }
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
