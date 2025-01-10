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
 * UnregisterOfRole
 *
 * Generated from 'UnregisterOfRole' regular structure
 */
public data class UnregisterOfRole(
    public val `object`: RoleId,
) {
    public companion object : ScaleReader<UnregisterOfRole>, ScaleWriter<UnregisterOfRole> {
        override fun read(reader: ScaleCodecReader): UnregisterOfRole = try {
            UnregisterOfRole(
                RoleId.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: UnregisterOfRole): Unit = try {
            RoleId.write(writer, instance.`object`)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
