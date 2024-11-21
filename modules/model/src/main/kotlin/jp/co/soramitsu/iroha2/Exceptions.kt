package jp.co.soramitsu.iroha2

/**
 * Top-level error that can be thrown by the client
 */
open class IrohaSdkException(message: String? = null, cause: Throwable? = null) : Exception(message, cause)

/**
 * Throw if there is an exception during scale encoding/decoding
 */
class ScaleCodecException(message: String? = null, cause: Throwable? = null) : IrohaSdkException(message, cause)

/**
 * Throw if there is an exception during conversion from or into a fixed-point number
 */
class FixedPointConversionException(message: String? = null, cause: Throwable? = null) : IrohaSdkException(message, cause)

/**
 * Throw if there is an issue with deserialization.
 *
 * @param message The explanation of the issue
 */
class DeserializationException(message: String) : RuntimeException(message)

/**
 * Throw if there is an issue with serialization
 *
 * @param message The explanation of the issue
 */
class SerializationException(message: String) : RuntimeException(message)
