package jp.co.soramitsu.iroha2.codec

import java.util.Objects

/**
 * `UnionValue` type is [enumeration][index] with assigned [value]
 */
class UnionValue<T>(index: Int, value: T) {
    val index: Int
    val value: T
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o !is UnionValue<*>) return false
        if (!o.canEquals(this)) return false
        val that = o
        return index == that.index &&
            value == that.value
    }

    fun canEquals(o: Any?): Boolean = o is UnionValue<*>

    override fun hashCode(): Int = Objects.hash(index, value)

    override fun toString(): String = "UnionValue{" +
        "index=" + index +
        ", value=" + value +
        '}'

    init {
        require(index >= 0) { "Index cannot be negative number: $index" }
        require(index <= 255) { "Union can have max 255 values. Index: $index" }
        this.index = index
        this.value = value
    }
}
