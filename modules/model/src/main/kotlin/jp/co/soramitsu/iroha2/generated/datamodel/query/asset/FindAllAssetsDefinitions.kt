//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated.datamodel.query.asset

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int

/**
 * FindAllAssetsDefinitions
 *
 * Generated from 'iroha_data_model::query::asset::FindAllAssetsDefinitions' tuple structure
 */
public class FindAllAssetsDefinitions {
    public companion object :
        ScaleReader<FindAllAssetsDefinitions>,
        ScaleWriter<FindAllAssetsDefinitions> {
        public override fun read(reader: ScaleCodecReader): FindAllAssetsDefinitions = try {
            FindAllAssetsDefinitions()
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        public override fun write(writer: ScaleCodecWriter, instance: FindAllAssetsDefinitions) = try {
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        public fun equals(o1: FindAllAssetsDefinitions, o2: Any?): Boolean = when (o2) {
            null -> false
            else -> o2::class == o1::class
        }

        public override fun hashCode(): Int = 1
    }
}
