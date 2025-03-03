//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.ModelCustomInstruction
import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Unit

/**
 * MultisigRegister
 *
 * Generated from 'MultisigRegister' regular structure
 */
public data class MultisigRegister(
    public val account: AccountId,
    public val spec: MultisigSpec,
) : ModelCustomInstruction {
    public companion object : ScaleReader<MultisigRegister>, ScaleWriter<MultisigRegister> {
        override fun read(reader: ScaleCodecReader): MultisigRegister =
            try {
                MultisigRegister(
                    AccountId.read(reader),
                    MultisigSpec.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: MultisigRegister,
        ): Unit =
            try {
                AccountId.write(writer, instance.account)
                MultisigSpec.write(writer, instance.spec)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
