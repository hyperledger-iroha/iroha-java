package jp.co.soramitsu.iroha2.type

import jp.co.soramitsu.iroha2.parse.TypeNest

/**
 * Basic class for Iroha2 types.
 *
 * The [type names][name] are resolved with a [TypeResolver].
 */
sealed class Type(open val name: String) {
    open fun notResolvedTypes(): Set<String> = setOf()
}

/**
 * Boolean type
 */
object NullType : Type("null")

/**
 * Boolean type
 */
object BooleanType : Type("bool")

/**
 * `MapType` data type
 */
data class MapType(
    override val name: String,
    val key: TypeNest,
    val value: TypeNest,
    val sortedByKey: Boolean = false,
) : Type(name) {
    override fun notResolvedTypes(): Set<String> {
        val result = mutableSetOf<String>()
        if (key.value == null) {
            result.add(key.name)
        } else if (value.value == null) {
            result.add(value.name)
        }
        return result
    }
}

/**
 * String type
 */
object StringType : Type("String")
