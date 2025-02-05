package jp.co.soramitsu.iroha2.codegen.blueprint

import jp.co.soramitsu.iroha2.codegen.defineClassName
import jp.co.soramitsu.iroha2.codegen.definePackageName
import jp.co.soramitsu.iroha2.type.CompositeType

/**
 * Blueprint for a specific type
 */
@ExperimentalUnsignedTypes
abstract class TypeBasedBlueprint<T : CompositeType>(
    source: T,
) : Blueprint<T>(source) {
    override val className: String = defineClassName(source.name)
    override val packageName: String = definePackageName(className, source)
    override val properties = resolveProperties(source)
}
