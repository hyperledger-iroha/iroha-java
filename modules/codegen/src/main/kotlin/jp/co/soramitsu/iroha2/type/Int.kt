package jp.co.soramitsu.iroha2.type

/**
 * Integer types
 */
abstract class IntType(
    name: String,
) : Type(name)

/**
 * 8-bit integers
 */
object I8Type : IntType("i8")

/**
 * 16-bit integers
 */
object I16Type : IntType("i16")

/**
 * 32-bit integers
 */
object I32Type : IntType("i32")

/**
 * 64-bit integers
 */
object I64Type : IntType("i64")

/**
 * 128-bit integers
 */
object I128Type : IntType("i128")

/**
 * 256-bit integers
 */
object I256Type : IntType("i256")
