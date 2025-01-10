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
 * Upgrade
 *
 * Generated from 'Upgrade' regular structure
 */
public data class Upgrade(
    public val executor: Executor,
) {
    public companion object : ScaleReader<Upgrade>, ScaleWriter<Upgrade> {
        override fun read(reader: ScaleCodecReader): Upgrade = try {
            Upgrade(
                Executor.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: Upgrade): Unit = try {
            Executor.write(writer, instance.executor)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
