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
 * FindTriggerById
 *
 * Generated from 'FindTriggerById' regular structure
 */
public data class FindTriggerById(
    public val id: TriggerId,
) {
    public companion object : ScaleReader<FindTriggerById>, ScaleWriter<FindTriggerById> {
        override fun read(reader: ScaleCodecReader): FindTriggerById = try {
            FindTriggerById(
                TriggerId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: FindTriggerById): Unit = try {
            TriggerId.write(writer, instance.id)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
