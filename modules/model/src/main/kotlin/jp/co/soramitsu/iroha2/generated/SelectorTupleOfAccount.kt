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
 * SelectorTupleOfAccount
 *
 * Generated from 'SelectorTupleOfAccount' regular structure
 */
public data class SelectorTupleOfAccount(public val vecOfAccountProjectionOfSelectorMarker: List<AccountProjectionOfSelectorMarker>) {
    public companion object :
        ScaleReader<SelectorTupleOfAccount>,
        ScaleWriter<SelectorTupleOfAccount> {
        override fun read(reader: ScaleCodecReader): SelectorTupleOfAccount = try {
            SelectorTupleOfAccount(
                reader.readVec(reader.readCompactInt()) { AccountProjectionOfSelectorMarker.read(reader) },
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: SelectorTupleOfAccount): Unit = try {
            writer.writeCompact(instance.vecOfAccountProjectionOfSelectorMarker.size)
            instance.vecOfAccountProjectionOfSelectorMarker.forEach { value ->
                AccountProjectionOfSelectorMarker.write(writer, value)
            }
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
