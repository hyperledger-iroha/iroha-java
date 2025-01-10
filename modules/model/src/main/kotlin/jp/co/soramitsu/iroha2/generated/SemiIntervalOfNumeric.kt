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
 * SemiIntervalOfNumeric
 *
 * Generated from 'SemiIntervalOfNumeric' regular structure
 */
public data class SemiIntervalOfNumeric(
    public val start: Numeric,
    public val limit: Numeric,
) {
    public companion object : ScaleReader<SemiIntervalOfNumeric>, ScaleWriter<SemiIntervalOfNumeric> {
        override fun read(reader: ScaleCodecReader): SemiIntervalOfNumeric = try {
            SemiIntervalOfNumeric(
                Numeric.read(reader),
                Numeric.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: SemiIntervalOfNumeric): Unit = try {
            Numeric.write(writer, instance.start)
            Numeric.write(writer, instance.limit)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
