//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.codec.reader.CompactBigIntReader
import jp.co.soramitsu.iroha2.codec.writer.CompactULongWriter
import jp.co.soramitsu.iroha2.wrapException
import java.math.BigInteger
import kotlin.Long
import kotlin.Unit

/**
 * Numeric
 *
 * Generated from 'Numeric' regular structure
 */
public data class Numeric(
    public val mantissa: BigInteger,
    public val scale: Long,
) {
    public companion object : ScaleReader<Numeric>, ScaleWriter<Numeric> {
        override fun read(reader: ScaleCodecReader): Numeric = try {
            Numeric(
                reader.read(CompactBigIntReader()),
                reader.readCompactInt().toLong(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: Numeric): Unit = try {
            writer.write(CompactULongWriter(), instance.mantissa.toLong())
            writer.write(CompactULongWriter(), instance.scale.toLong())
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
