package jp.co.soramitsu.iroha2.type

/**
 * Unigned integer types
 */
abstract class UIntType(
    name: String,
) : Type(name)

/**
 * 8-bit unsigned integers
 */
object U8Type : UIntType("u8")

/**
 * 16-bit unsigned integers
 */
object U16Type : UIntType("u16")

/**
 * 32-bit unsigned integers
 */
object U32Type : UIntType("u32")

/**
 * 64-bit unsigned integers
 */
object U64Type : UIntType("u64")

/**
 * 128-bit unsigned integers
 */
object U128Type : UIntType("u128")

/**
 * 256-bit unsigned integers
 */
object U256Type : UIntType("u256")
