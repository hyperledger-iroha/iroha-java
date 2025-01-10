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
 * NumericSpec
 *
 * Generated from 'NumericSpec' regular structure
 */
public data class NumericSpec(
    public val scale: Long? = null,
) {
    public companion object : ScaleReader<NumericSpec>, ScaleWriter<NumericSpec> {
        override fun read(reader: ScaleCodecReader): NumericSpec = try {
            NumericSpec(
                reader.readNullable(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: NumericSpec): Unit = try {
            writer.writeNullable(instance.scale)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
