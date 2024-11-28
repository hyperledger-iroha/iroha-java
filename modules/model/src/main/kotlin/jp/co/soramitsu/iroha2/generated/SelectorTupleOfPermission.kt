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
 * SelectorTupleOfPermission
 *
 * Generated from 'SelectorTupleOfPermission' regular structure
 */
public data class SelectorTupleOfPermission(
    public val vecOfPermissionProjectionOfSelectorMarker: List<PermissionProjectionOfSelectorMarker>,
) {
    public companion object :
        ScaleReader<SelectorTupleOfPermission>,
        ScaleWriter<SelectorTupleOfPermission> {
        override fun read(reader: ScaleCodecReader): SelectorTupleOfPermission = try {
            SelectorTupleOfPermission(
                reader.readVec(reader.readCompactInt()) { PermissionProjectionOfSelectorMarker.read(reader) },
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: SelectorTupleOfPermission): Unit = try {
            writer.writeCompact(instance.vecOfPermissionProjectionOfSelectorMarker.size)
            instance.vecOfPermissionProjectionOfSelectorMarker.forEach { value ->
                PermissionProjectionOfSelectorMarker.write(writer, value)
            }
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
