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
 * HashOf
 *
 * Generated from 'HashOf<Vec<InstructionBox>>' regular structure
 */
public data class HashOf<T0>(public val hash: Hash) {
    public companion object : ScaleReader<HashOf<out Any>>, ScaleWriter<HashOf<out Any>> {
        override fun read(reader: ScaleCodecReader): HashOf<out Any> = try {
            HashOf(
                Hash.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: HashOf<out Any>): Unit = try {
            Hash.write(writer, instance.hash)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
