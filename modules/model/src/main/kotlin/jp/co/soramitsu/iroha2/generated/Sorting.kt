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
 * Sorting
 *
 * Generated from 'Sorting' regular structure
 */
public data class Sorting(
    public val sortByMetadataKey: Name? = null,
) {
    public companion object : ScaleReader<Sorting>, ScaleWriter<Sorting> {
        override fun read(reader: ScaleCodecReader): Sorting = try {
            Sorting(
                reader.readNullable(Name) as Name?,
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: Sorting): Unit = try {
            writer.writeNullable(Name, instance.sortByMetadataKey)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
