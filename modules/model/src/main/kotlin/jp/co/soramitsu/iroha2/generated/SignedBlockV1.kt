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
import kotlin.collections.List
import kotlin.collections.Map

/**
 * SignedBlockV1
 *
 * Generated from 'SignedBlockV1' regular structure
 */
public data class SignedBlockV1(
    public val signatures: List<BlockSignature>,
    public val payload: BlockPayload,
    public val errors: Map<BigInteger, TransactionRejectionReason>,
) {
    public companion object : ScaleReader<SignedBlockV1>, ScaleWriter<SignedBlockV1> {
        override fun read(reader: ScaleCodecReader): SignedBlockV1 =
            try {
                SignedBlockV1(
                    reader.readVec(reader.readCompactInt()) { BlockSignature.read(reader) },
                    BlockPayload.read(reader),
                    reader.readMap(reader.readCompactInt(), { reader.readUint64() }, { TransactionRejectionReason.read(reader) }),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

        override fun write(
            writer: ScaleCodecWriter,
            instance: SignedBlockV1,
        ): Unit =
            try {
                writer.writeCompact(instance.signatures.size)
                instance.signatures.forEach { value ->
                    BlockSignature.write(writer, value)
                }
                BlockPayload.write(writer, instance.payload)
                writer.writeCompact(instance.errors.size)
                instance.errors.toSortedMap().forEach { (key, value) ->
                    writer.writeUint64(key)
                    TransactionRejectionReason.write(writer, value)
                }
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
    }
}
