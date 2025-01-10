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
 * RegisterOfDomain
 *
 * Generated from 'RegisterOfDomain' regular structure
 */
public data class RegisterOfDomain(
    public val `object`: NewDomain,
) {
    public companion object : ScaleReader<RegisterOfDomain>, ScaleWriter<RegisterOfDomain> {
        override fun read(reader: ScaleCodecReader): RegisterOfDomain = try {
            RegisterOfDomain(
                NewDomain.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: RegisterOfDomain): Unit = try {
            NewDomain.write(writer, instance.`object`)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
