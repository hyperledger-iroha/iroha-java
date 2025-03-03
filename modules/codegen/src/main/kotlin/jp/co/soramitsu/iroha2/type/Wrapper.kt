package jp.co.soramitsu.iroha2.type

import jp.co.soramitsu.iroha2.parse.TypeNest

/**
 * Basic class for wrapper types. The `WrapperType` data type wraps [another type][innerType].
 */
abstract class WrapperType(
    override val name: String,
    open val innerType: TypeNest,
) : Type(name) {
    override fun notResolvedTypes() =
        if (innerType.value == null) {
            setOf(innerType.name)
        } else {
            setOf()
        }
}

/**
 * Basic class for iterable types.
 */
abstract class IterableType(
    override val name: String,
    override val innerType: TypeNest,
    open var sorted: Boolean,
) : WrapperType(name, innerType)

/**
 * `OptionType` wrapper type.
 */
data class OptionType(
    override val name: String,
    override val innerType: TypeNest,
) : WrapperType(name, innerType)

/**
 * `VecType` iterable type.
 */
data class VecType(
    override val name: String,
    override val innerType: TypeNest,
    override var sorted: Boolean = false,
) : IterableType(name, innerType, sorted)

/**
 * `ArrayType` iterable type.
 */
data class ArrayType(
    override val name: String,
    override val innerType: TypeNest,
    val size: Int,
    override var sorted: Boolean = false,
) : IterableType(name, innerType, sorted)

/**
 * `CompactType` wrapper type.
 */
data class CompactType(
    override val name: String,
    override val innerType: TypeNest,
) : WrapperType(name, innerType)
