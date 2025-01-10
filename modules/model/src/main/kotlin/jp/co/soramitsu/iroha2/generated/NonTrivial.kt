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
import kotlin.collections.List

/**
 * NonTrivial
 *
 * Generated from 'NonTrivial<GenericPredicateBox<QueryOutputPredicate>>' regular structure
 */
public data class NonTrivial<T0>(
    public val vecOfQueryOutputPredicate: List<GenericPredicateBox<QueryOutputPredicate>>,
) {
    public companion object : ScaleReader<NonTrivial<out Any>>, ScaleWriter<NonTrivial<out Any>> {
        override fun read(reader: ScaleCodecReader): NonTrivial<out Any> = try {
            NonTrivial(
                reader.readVec(reader.readCompactInt()) {
                    GenericPredicateBox.read(reader) as
                        GenericPredicateBox<QueryOutputPredicate>
                },
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: NonTrivial<out Any>): Unit = try {
            writer.writeCompact(instance.vecOfQueryOutputPredicate.size)
            instance.vecOfQueryOutputPredicate.forEach { value ->
                GenericPredicateBox.write(writer, value)
            }
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
