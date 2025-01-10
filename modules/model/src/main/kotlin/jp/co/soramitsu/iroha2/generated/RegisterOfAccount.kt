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
 * RegisterOfAccount
 *
 * Generated from 'RegisterOfAccount' regular structure
 */
public data class RegisterOfAccount(
    public val `object`: NewAccount,
) {
    public companion object : ScaleReader<RegisterOfAccount>, ScaleWriter<RegisterOfAccount> {
        override fun read(reader: ScaleCodecReader): RegisterOfAccount = try {
            RegisterOfAccount(
                NewAccount.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: RegisterOfAccount): Unit = try {
            NewAccount.write(writer, instance.`object`)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
