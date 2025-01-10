//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import java.math.BigInteger
import kotlin.Unit

/**
 * SumeragiParameters
 *
 * Generated from 'SumeragiParameters' regular structure
 */
public data class SumeragiParameters(
    public val blockTimeMs: BigInteger,
    public val commitTimeMs: BigInteger,
    public val maxClockDriftMs: BigInteger,
) {
    public companion object : ScaleReader<SumeragiParameters>, ScaleWriter<SumeragiParameters> {
        override fun read(reader: ScaleCodecReader): SumeragiParameters = try {
            SumeragiParameters(
                reader.readUint64(),
                reader.readUint64(),
                reader.readUint64(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: SumeragiParameters): Unit = try {
            writer.writeUint64(instance.blockTimeMs)
            writer.writeUint64(instance.commitTimeMs)
            writer.writeUint64(instance.maxClockDriftMs)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
