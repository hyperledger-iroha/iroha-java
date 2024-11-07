//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.String
import kotlin.Unit

/**
 * Permission
 *
 * Generated from 'Permission' regular structure
 */
public data class Permission(
    public val name: String,
    public val payload: Json,
) {
    public companion object : ScaleReader<Permission>, ScaleWriter<Permission> {
        override fun read(reader: ScaleCodecReader): Permission = try {
            Permission(
                reader.readString(),
                Json.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: Permission): Unit = try {
            writer.writeAsList(instance.name.toByteArray(Charsets.UTF_8))
            Json.write(writer, instance.payload)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
