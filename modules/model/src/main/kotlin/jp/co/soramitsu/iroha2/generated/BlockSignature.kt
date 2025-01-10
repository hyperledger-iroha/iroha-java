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
 * BlockSignature
 *
 * Generated from 'BlockSignature' tuple structure
 */
public data class BlockSignature(
    public val u64: BigInteger,
    public val signatureOf: SignatureOf<BlockHeader>,
) {
    public companion object : ScaleReader<BlockSignature>, ScaleWriter<BlockSignature> {
        override fun read(reader: ScaleCodecReader): BlockSignature = try {
            BlockSignature(
                reader.readUint64(),
                SignatureOf.read(reader) as SignatureOf<BlockHeader>,
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: BlockSignature): Unit = try {
            writer.writeUint64(instance.u64)
            SignatureOf.write(writer, instance.signatureOf)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
