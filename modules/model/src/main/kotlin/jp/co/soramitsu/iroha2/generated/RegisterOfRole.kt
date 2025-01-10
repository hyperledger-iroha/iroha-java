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
 * RegisterOfRole
 *
 * Generated from 'RegisterOfRole' regular structure
 */
public data class RegisterOfRole(
    public val `object`: Role,
) {
    public companion object : ScaleReader<RegisterOfRole>, ScaleWriter<RegisterOfRole> {
        override fun read(reader: ScaleCodecReader): RegisterOfRole = try {
            RegisterOfRole(
                Role.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: RegisterOfRole): Unit = try {
            Role.write(writer, instance.`object`)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
