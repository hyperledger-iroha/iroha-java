package jp.co.soramitsu.iroha2.codegen.blueprint

import jp.co.soramitsu.iroha2.codegen.defineClassName
import jp.co.soramitsu.iroha2.codegen.resolveKotlinType
import jp.co.soramitsu.iroha2.type.EnumType

/**
 * Blueprint for [enum variant][EnumType.Variant]
 */
class EnumVariantBlueprint(
    val discriminant: Int,
    val parentBlueprint: EnumBlueprint,
    source: EnumType.Variant,
) : Blueprint<EnumType.Variant>(source) {

    override val className = defineClassName(source.name)
    override val packageName = "${parentBlueprint.packageName}.${parentBlueprint.className}"
    override val properties = resolveProperties(source)

    override fun resolveProperties(variant: EnumType.Variant): List<Property> = variant.type?.requireValue()
        ?.let { type ->
            Property(
                defineClassName(type.name).replaceFirstChar(Char::lowercase),
                resolveKotlinType(type),
                type,
            )
        }?.let { property -> listOf(property) } ?: listOf()
}
