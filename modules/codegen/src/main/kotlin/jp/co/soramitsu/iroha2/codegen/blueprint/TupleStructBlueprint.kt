package jp.co.soramitsu.iroha2.codegen.blueprint

import jp.co.soramitsu.iroha2.codegen.defineClassName
import jp.co.soramitsu.iroha2.codegen.resolveKotlinType
import jp.co.soramitsu.iroha2.type.ArrayType
import jp.co.soramitsu.iroha2.type.TupleStructType
import jp.co.soramitsu.iroha2.type.Type

/**
 * Blueprint for [TupleStructType]
 */
class TupleStructBlueprint(
    type: TupleStructType,
) : TypeBasedBlueprint<TupleStructType>(type) {
    override fun resolveProperties(type: TupleStructType): List<Property> {
        val unique =
            type.types
                .map { it.name }
                .distinct()
                .size == type.types.size
        var propertyCount = 1

        return type.types
            .map {
                it.requireValue()
            }.map {
                Property(createPropName(it, unique, propertyCount++), resolveKotlinType(it), it)
            }
    }

    private fun createPropName(
        type: Type,
        unique: Boolean = true,
        propertyCount: Int? = null,
    ): String =
        when (type) {
            is ArrayType -> "array"
            else ->
                defineClassName(type.name).let { name ->
                    when (unique) {
                        true -> name.replaceFirstChar { it.lowercase() }
                        else -> "p${propertyCount}${name.replaceFirstChar { it.uppercase() }}"
                    }
                }
        }
}
