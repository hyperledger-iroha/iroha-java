//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Unit

/**
 * FindActiveTriggerIds
 *
 * Generated from 'FindActiveTriggerIds' regular structure
 */
public class FindActiveTriggerIds {
    public companion object : ScaleReader<FindActiveTriggerIds>, ScaleWriter<FindActiveTriggerIds> {
        override fun read(reader: ScaleCodecReader): FindActiveTriggerIds = try {
            FindActiveTriggerIds()
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: FindActiveTriggerIds): Unit = try {
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        public fun equals(o1: FindActiveTriggerIds, o2: Any?): Boolean = when (o2) {
            null -> false
            else -> o2::class == o1::class
        }

        override fun hashCode(): Int = ".FindActiveTriggerIds".hashCode()
    }
}
