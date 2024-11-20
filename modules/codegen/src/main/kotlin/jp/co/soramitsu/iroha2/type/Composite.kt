package jp.co.soramitsu.iroha2.type

import jp.co.soramitsu.iroha2.parse.TypeNest

/**
 * Basic class for different composite types
 */
abstract class CompositeType(override val name: String, open val generics: List<TypeNest>) : Type(name)

/**
 * `EnumType` composite type
 */
data class EnumType(
    override val name: String,
    override val generics: List<TypeNest>,
    val variants: List<Variant>,
) : CompositeType(name, generics) {

    /**
     * Variant of a enum type
     */
    data class Variant(
        val name: String,
        val discriminant: Int,
        val type: TypeNest?,
    )

    private var resolutionInProgress: Boolean = false

    override fun notResolvedTypes(): Set<String> {
        if (resolutionInProgress) {
            return setOf()
        }
        resolutionInProgress = true
        val result = generics.union(variants.mapNotNull { it.type })
            .flatMap { it.value?.notResolvedTypes() ?: setOf(it.name) }
            .toSet()
        resolutionInProgress = false
        return result
    }
}

/**
 * `TupleStructType` composite type
 */
data class TupleStructType(
    override val name: String,
    override val generics: List<TypeNest>,
    val types: List<TypeNest>,
) : CompositeType(name, generics) {
    override fun notResolvedTypes(): Set<String> = types.union(generics).flatMap {
        it.value?.notResolvedTypes() ?: setOf(it.name)
    }.toSet()
}

/**
 * `StructType` composite type
 */
data class StructType(
    override val name: String,
    override val generics: List<TypeNest>,
    val mapping: Map<String, TypeNest>,
) : CompositeType(name, generics) {
    override fun notResolvedTypes(): Set<String> = mapping.values.union(generics).flatMap {
        it.value?.let { setOf() } ?: setOf(it.name)
    }.toSet()
}
