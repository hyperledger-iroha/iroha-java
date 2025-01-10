//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Long
import kotlin.Unit

/**
 * ConfigurationEventFilter
 *
 * Generated from 'ConfigurationEventFilter' regular structure
 */
public data class ConfigurationEventFilter(
    public val eventSet: Long,
) {
    public companion object :
        ScaleReader<ConfigurationEventFilter>,
        ScaleWriter<ConfigurationEventFilter> {
        override fun read(reader: ScaleCodecReader): ConfigurationEventFilter = try {
            ConfigurationEventFilter(
                reader.readUint32(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: ConfigurationEventFilter): Unit = try {
            writer.writeUint32(instance.eventSet)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
