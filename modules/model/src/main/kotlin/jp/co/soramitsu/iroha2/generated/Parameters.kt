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
import kotlin.Unit
import kotlin.collections.Map

/**
 * Parameters
 *
 * Generated from 'Parameters' regular structure
 */
public data class Parameters(
    public val sumeragi: SumeragiParameters,
    public val block: BlockParameters,
    public val transaction: TransactionParameters,
    public val executor: SmartContractParameters,
    public val smartContract: SmartContractParameters,
    public val custom: Map<CustomParameterId, CustomParameter>,
) {
    public companion object : ScaleReader<Parameters>, ScaleWriter<Parameters> {
        override fun read(reader: ScaleCodecReader): Parameters = try {
            Parameters(
                SumeragiParameters.read(reader),
                BlockParameters.read(reader),
                TransactionParameters.read(reader),
                SmartContractParameters.read(reader),
                SmartContractParameters.read(reader),
                reader.readMap(
                    reader.readCompactInt(),
                    { CustomParameterId.read(reader) },
                    { CustomParameter.read(reader) },
                ),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: Parameters): Unit = try {
            SumeragiParameters.write(writer, instance.sumeragi)
            BlockParameters.write(writer, instance.block)
            TransactionParameters.write(writer, instance.transaction)
            SmartContractParameters.write(writer, instance.executor)
            SmartContractParameters.write(writer, instance.smartContract)
            writer.writeCompact(instance.custom.size)
            instance.custom.toSortedMap(
                CustomParameterId.comparator(),
            ).forEach { (key, value) ->
                CustomParameterId.write(writer, key)
                CustomParameter.write(writer, value)
            }
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
