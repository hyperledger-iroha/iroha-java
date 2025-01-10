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
import kotlin.Int
import kotlin.Unit

/**
 * QueryResponse
 *
 * Generated from 'QueryResponse' enum
 */
public sealed class QueryResponse : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Singular' variant
     */
    public data class Singular(
        public val singularQueryOutputBox: SingularQueryOutputBox,
    ) : QueryResponse() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryResponse.Singular>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryResponse.Singular> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryResponse.Singular = try {
                Singular(
                    SingularQueryOutputBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryResponse.Singular,
            ): Unit = try {
                SingularQueryOutputBox.write(writer, instance.singularQueryOutputBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Iterable' variant
     */
    public data class Iterable(
        public val queryOutput: QueryOutput,
    ) : QueryResponse() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryResponse.Iterable>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryResponse.Iterable> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryResponse.Iterable = try {
                Iterable(
                    QueryOutput.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryResponse.Iterable,
            ): Unit = try {
                QueryOutput.write(writer, instance.queryOutput)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<QueryResponse>, ScaleWriter<QueryResponse> {
        override fun read(reader: ScaleCodecReader): QueryResponse = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Singular.read(reader)
            1 -> Iterable.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: QueryResponse) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Singular.write(writer, instance as Singular)
                1 -> Iterable.write(writer, instance as Iterable)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
