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
import kotlin.Unit

/**
 * Mismatch
 *
 * Generated from 'Mismatch<AssetType>' regular structure
 */
public data class Mismatch<T0>(
    public val expected: AssetType,
    public val `actual`: AssetType,
) {
    public companion object : ScaleReader<Mismatch<out Any>>, ScaleWriter<Mismatch<out Any>> {
        override fun read(reader: ScaleCodecReader): Mismatch<out Any> = try {
            Mismatch(
                AssetType.read(reader),
                AssetType.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: Mismatch<out Any>): Unit = try {
            AssetType.write(writer, instance.expected)
            AssetType.write(writer, instance.`actual`)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
