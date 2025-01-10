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
import kotlin.Int
import kotlin.Unit

/**
 * FindAssetsDefinitions
 *
 * Generated from 'FindAssetsDefinitions' regular structure
 */
public class FindAssetsDefinitions {
    public companion object : ScaleReader<FindAssetsDefinitions>, ScaleWriter<FindAssetsDefinitions> {
        override fun read(reader: ScaleCodecReader): FindAssetsDefinitions = try {
            FindAssetsDefinitions()
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: FindAssetsDefinitions): Unit = try {
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        public fun equals(o1: FindAssetsDefinitions, o2: Any?): Boolean = when (o2) {
            null -> false
            else -> o2::class == o1::class
        }

        override fun hashCode(): Int = ".FindAssetsDefinitions".hashCode()
    }
}
