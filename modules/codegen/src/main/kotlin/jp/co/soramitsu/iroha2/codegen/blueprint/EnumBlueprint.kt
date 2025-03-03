package jp.co.soramitsu.iroha2.codegen.blueprint

import jp.co.soramitsu.iroha2.type.EnumType

/**
 * Blueprint for [EnumType]
 */
class EnumBlueprint(
    type: EnumType,
) : TypeBasedBlueprint<EnumType>(type) {
    val variants = resolveVariants()

    private fun resolveVariants(): List<EnumVariantBlueprint> =
        source.variants.map {
            EnumVariantBlueprint(it.discriminant, this, it)
        }
}
