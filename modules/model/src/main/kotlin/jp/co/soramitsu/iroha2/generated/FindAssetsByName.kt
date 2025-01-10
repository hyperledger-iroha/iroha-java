//
// Auto-generated file. DO NOT EDIT!
//
package jp.co.soramitsu.iroha2.generated

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleCodecWriter
import jp.co.soramitsu.iroha2.codec.ScaleReader
import jp.co.soramitsu.iroha2.codec.ScaleWriter
import jp.co.soramitsu.iroha2.wrapException
import kotlin.Unit

/**
 * FindAssetsByName
 *
 * Generated from 'FindAssetsByName' regular structure
 */
public data class FindAssetsByName(
    public val name: Name,
) {
    public companion object : ScaleReader<FindAssetsByName>, ScaleWriter<FindAssetsByName> {
        override fun read(reader: ScaleCodecReader): FindAssetsByName = try {
            FindAssetsByName(
                Name.read(reader),
            )
        } catch (ex: Exception) {
            throw wrapException(ex)
        }

        override fun write(writer: ScaleCodecWriter, instance: FindAssetsByName): Unit = try {
            Name.write(writer, instance.name)
        } catch (ex: Exception) {
            throw wrapException(ex)
        }
    }
}
