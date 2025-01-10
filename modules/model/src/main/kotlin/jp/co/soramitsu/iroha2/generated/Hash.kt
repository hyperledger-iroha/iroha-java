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
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit

/**
 * Hash
 *
 * Generated from 'Hash' regular structure
 */
public data class Hash(
    public val arrayOfU8: ByteArray,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Hash) return false
        if (!arrayOfU8.contentEquals(other.arrayOfU8)) return false
        return true
    }

    override fun hashCode(): Int = arrayOfU8.contentHashCode()

    public companion object : ScaleReader<Hash>, ScaleWriter<Hash> {
        override fun read(reader: ScaleCodecReader): Hash = try {
            Hash(
                reader.readByteArray(32),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: Hash): Unit = try {
            writer.writeByteArray(instance.arrayOfU8)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
