//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.ModelEnum
import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Any
import kotlin.Int
import kotlin.Unit

/**
 * BatchedResponse
 *
 * Generated from 'BatchedResponse<QueryOutputBox>' enum
 */
public sealed class BatchedResponse<T0> : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'V1' variant
     */
    public data class V1(
        public val batchedResponseV1: BatchedResponseV1<QueryOutputBox>,
    ) : BatchedResponse<QueryOutputBox>() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.BatchedResponse.V1>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.BatchedResponse.V1> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.BatchedResponse.V1 = try {
                V1(
                    BatchedResponseV1.read(reader) as BatchedResponseV1<QueryOutputBox>,
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.BatchedResponse.V1,
            ): Unit = try {
                BatchedResponseV1.write(writer, instance.batchedResponseV1)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object :
        ScaleReader<BatchedResponse<out Any>>,
        ScaleWriter<BatchedResponse<out Any>> {
        override fun read(reader: ScaleCodecReader): BatchedResponse<out Any> = when (
            val discriminant =
                reader.readUByte()
        ) {
            1 -> V1.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: BatchedResponse<out Any>) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                1 -> V1.write(writer, instance as V1)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
