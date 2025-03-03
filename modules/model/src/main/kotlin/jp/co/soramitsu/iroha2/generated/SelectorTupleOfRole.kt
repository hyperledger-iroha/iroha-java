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
 * SelectorTupleOfRole
 *
 * Generated from 'SelectorTupleOfRole' regular structure
 */
public data class SelectorTupleOfRole(
    public val vecOfRoleProjectionOfSelectorMarker: List<RoleProjectionOfSelectorMarker>,
) {
    public companion object : ScaleReader<SelectorTupleOfRole>, ScaleWriter<SelectorTupleOfRole> {
        override fun read(reader: ScaleCodecReader): SelectorTupleOfRole =
            try {
                SelectorTupleOfRole(
                    reader.readVec(reader.readCompactInt()) { RoleProjectionOfSelectorMarker.read(reader) },
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: SelectorTupleOfRole,
        ): Unit =
            try {
                writer.writeCompact(instance.vecOfRoleProjectionOfSelectorMarker.size)
                instance.vecOfRoleProjectionOfSelectorMarker.forEach { value ->
                    RoleProjectionOfSelectorMarker.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
