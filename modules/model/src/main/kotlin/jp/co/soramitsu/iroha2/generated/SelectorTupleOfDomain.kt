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
import kotlin.collections.List

/**
 * SelectorTupleOfDomain
 *
 * Generated from 'SelectorTupleOfDomain' regular structure
 */
public data class SelectorTupleOfDomain(
    public val vecOfDomainProjectionOfSelectorMarker: List<DomainProjectionOfSelectorMarker>,
) {
    public companion object : ScaleReader<SelectorTupleOfDomain>, ScaleWriter<SelectorTupleOfDomain> {
        override fun read(reader: ScaleCodecReader): SelectorTupleOfDomain =
            try {
                SelectorTupleOfDomain(
                    reader.readVec(reader.readCompactInt()) { DomainProjectionOfSelectorMarker.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: SelectorTupleOfDomain,
        ): Unit =
            try {
                writer.writeCompact(instance.vecOfDomainProjectionOfSelectorMarker.size)
                instance.vecOfDomainProjectionOfSelectorMarker.forEach { value ->
                    DomainProjectionOfSelectorMarker.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
