//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.comparator
import jp.co.soramitsu.iroha2.wrapException
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map

/**
 * ExecutorDataModel
 *
 * Generated from 'ExecutorDataModel' regular structure
 */
public data class ExecutorDataModel(
    public val parameters: Map<CustomParameterId, CustomParameter>,
    public val instructions: List<String>,
    public val permissions: List<String>,
    public val schema: String,
) {
    public companion object : ScaleReader<ExecutorDataModel>, ScaleWriter<ExecutorDataModel> {
        override fun read(reader: ScaleCodecReader): ExecutorDataModel = try {
            ExecutorDataModel(
                reader.readMap(
                    reader.readCompactInt(),
                    { CustomParameterId.read(reader) },
                    { CustomParameter.read(reader) },
                ),
                reader.readVec(reader.readCompactInt()) { reader.readString() },
                reader.readVec(reader.readCompactInt()) { reader.readString() },
                reader.readString(),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: ExecutorDataModel): Unit = try {
            writer.writeCompact(instance.parameters.size)
            instance.parameters.toSortedMap(
                CustomParameterId.comparator(),
            ).forEach { (key, value) ->
                CustomParameterId.write(writer, key)
                CustomParameter.write(writer, value)
            }
            writer.writeCompact(instance.instructions.size)
            instance.instructions.sortedWith(
                String.comparator(),
            ).forEach { value ->
                writer.writeAsList(value.toByteArray(Charsets.UTF_8))
            }
            writer.writeCompact(instance.permissions.size)
            instance.permissions.sortedWith(
                String.comparator(),
            ).forEach { value ->
                writer.writeAsList(value.toByteArray(Charsets.UTF_8))
            }
            writer.writeAsList(instance.schema.toByteArray(Charsets.UTF_8))
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
