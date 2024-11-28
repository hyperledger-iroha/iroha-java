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
 * SelectorTupleOfRoleId
 *
 * Generated from 'SelectorTupleOfRoleId' regular structure
 */
public data class SelectorTupleOfRoleId(public val vecOfRoleIdProjectionOfSelectorMarker: List<RoleIdProjectionOfSelectorMarker>) {
    public companion object : ScaleReader<SelectorTupleOfRoleId>, ScaleWriter<SelectorTupleOfRoleId> {
        override fun read(reader: ScaleCodecReader): SelectorTupleOfRoleId = try {
            SelectorTupleOfRoleId(
                reader.readVec(reader.readCompactInt()) { RoleIdProjectionOfSelectorMarker.read(reader) },
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: SelectorTupleOfRoleId): Unit = try {
            writer.writeCompact(instance.vecOfRoleIdProjectionOfSelectorMarker.size)
            instance.vecOfRoleIdProjectionOfSelectorMarker.forEach { value ->
                RoleIdProjectionOfSelectorMarker.write(writer, value)
            }
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
