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
 * QueryRequest
 *
 * Generated from 'QueryRequest' enum
 */
public sealed class QueryRequest : ModelEnum {
    /**
     * @return Discriminator of variant in enum
     */
    public abstract fun discriminant(): Int

    /**
     * 'Singular' variant
     */
    public data class Singular(
        public val singularQueryBox: SingularQueryBox,
    ) : QueryRequest() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryRequest.Singular>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryRequest.Singular> {
            public const val DISCRIMINANT: Int = 0

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryRequest.Singular = try {
                Singular(
                    SingularQueryBox.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryRequest.Singular,
            ): Unit = try {
                SingularQueryBox.write(writer, instance.singularQueryBox)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Start' variant
     */
    public data class Start(
        public val queryWithParams: QueryWithParams,
    ) : QueryRequest() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryRequest.Start>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryRequest.Start> {
            public const val DISCRIMINANT: Int = 1

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryRequest.Start = try {
                Start(
                    QueryWithParams.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryRequest.Start,
            ): Unit = try {
                QueryWithParams.write(writer, instance.queryWithParams)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    /**
     * 'Continue' variant
     */
    public data class Continue(
        public val forwardCursor: ForwardCursor,
    ) : QueryRequest() {
        override fun discriminant(): Int = DISCRIMINANT

        public companion object :
            ScaleReader<jp.co.soramitsu.iroha2.generated.QueryRequest.Continue>,
            ScaleWriter<jp.co.soramitsu.iroha2.generated.QueryRequest.Continue> {
            public const val DISCRIMINANT: Int = 2

            override fun read(reader: ScaleCodecReader): jp.co.soramitsu.iroha2.generated.QueryRequest.Continue = try {
                Continue(
                    ForwardCursor.read(reader),
                )
            } catch (ex: Exception) {
                throw wrapException(ex)
            }

            override fun write(
                writer: ScaleCodecWriter,
                instance: jp.co.soramitsu.iroha2.generated.QueryRequest.Continue,
            ): Unit = try {
                ForwardCursor.write(writer, instance.forwardCursor)
            } catch (ex: Exception) {
                throw wrapException(ex)
            }
        }
    }

    public companion object : ScaleReader<QueryRequest>, ScaleWriter<QueryRequest> {
        override fun read(reader: ScaleCodecReader): QueryRequest = when (
            val discriminant =
                reader.readUByte()
        ) {
            0 -> Singular.read(reader)
            1 -> Start.read(reader)
            2 -> Continue.read(reader)
            else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }

        override fun write(writer: ScaleCodecWriter, instance: QueryRequest) {
            writer.directWrite(instance.discriminant())
            when (val discriminant = instance.discriminant()) {
                0 -> Singular.write(writer, instance as Singular)
                1 -> Start.write(writer, instance as Start)
                2 -> Continue.write(writer, instance as Continue)
                else -> throw RuntimeException("Unresolved discriminant of the enum variant: $discriminant") }
        }
    }
}
